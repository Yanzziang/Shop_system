package frame;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.User;
import dao.UserDao;
import java.sql.SQLException;

public class PasswordDialog extends JDialog {
    JPanel panel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JButton btnOK = new JButton();
    JButton btnCancel = new JButton();
    JTextField txtUser = new JTextField();
    JPasswordField txtP1 = new JPasswordField();
    JPasswordField txtP2 = new JPasswordField();
    JPasswordField txtP3 = new JPasswordField();
    
    public PasswordDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            begin();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public PasswordDialog() {
        this(null);
    }

    private void begin() throws Exception {
        panel1.setLayout(null);
        jLabel1.setText("�û���:");
        jLabel1.setBounds(new Rectangle(49, 24, 42, 15));
        jLabel2.setText("ԭ����:");
        jLabel2.setBounds(new Rectangle(49, 54, 42, 15));
        jLabel3.setText("������:");
        jLabel3.setBounds(new Rectangle(49, 86, 42, 15));
        jLabel4.setText("ȷ��������:");
        jLabel4.setBounds(new Rectangle(22, 116, 73, 15));
        btnOK.setBounds(new Rectangle(78, 145, 81, 23));
        btnOK.setText("�޸�");
        btnOK.addActionListener(new PasswordDialog_btnOK_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(175, 144, 81, 23));
        btnCancel.setText("ȡ��");
        btnCancel.addActionListener(new PasswordDialog_btnCancel_actionAdapter(this));
        txtUser.setEditable(false);
        txtUser.setBounds(new Rectangle(99, 22, 158, 20));
        txtP1.setBounds(new Rectangle(98, 52, 159, 20));
        txtP2.setBounds(new Rectangle(99, 83, 158, 20));
        txtP3.setBounds(new Rectangle(99, 114, 158, 20));
        this.setResizable(false);
        this.setTitle("�޸�����");
        
        setContentPane(panel1);
        //getContentPane().add(panel1);//Ҳ�����������ķ�ʽ
        
        panel1.add(jLabel3);
        panel1.add(jLabel4);
        panel1.add(jLabel2);
        panel1.add(jLabel1);
        panel1.add(txtUser);
        panel1.add(txtP1);
        panel1.add(txtP2);
        panel1.add(txtP3);
        panel1.add(btnCancel);
        panel1.add(btnOK);

        this.txtUser.setText(util.UserInfo.getUser().getUsername());
        setSize(new Dimension(300, 228));
        util.FrameSet.showCenter(this);
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnOK_actionPerformed(ActionEvent e) {
        String username = this.txtUser.getText().trim();
        String p1 = String.valueOf(txtP1.getPassword());
        String p2 = String.valueOf(txtP2.getPassword());
        String p3 = String.valueOf(txtP3.getPassword());

        if(username.length() < 1 || p1.length() < 1 || p2.length() < 5 || p3.length() < 1) {
            JOptionPane.showMessageDialog(null,"���벻��Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
        } else if( !util.UserInfo.getUser().getUserpass().equals(p1)) {
            JOptionPane.showMessageDialog(null,"ԭ���벻��ȷ","��ʾ",JOptionPane.WARNING_MESSAGE);
        } else if( !p2.equals(p3)) {
            JOptionPane.showMessageDialog(null,"���������һ��","��ʾ",JOptionPane.WARNING_MESSAGE);
        } else {
            User user = util.UserInfo.getUser();//��õ�ǰ�û���Ҳ���ǵ�ǰ��frame�µ��û���
            user.setUserpass(p2);//����user�����������
            try {
                UserDao.modify(user);//����
                JOptionPane.showMessageDialog(null,"�޸ĳɹ�.","��ʾ",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"�޸�ʧ��","��ʾ",JOptionPane.WARNING_MESSAGE);
            }
        }

    }
}


class PasswordDialog_btnOK_actionAdapter implements ActionListener {
    private PasswordDialog adaptee;
    PasswordDialog_btnOK_actionAdapter(PasswordDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnOK_actionPerformed(e);
    }
}


class PasswordDialog_btnCancel_actionAdapter implements ActionListener {
    private PasswordDialog adaptee;
    PasswordDialog_btnCancel_actionAdapter(PasswordDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

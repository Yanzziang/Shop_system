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
        jLabel1.setText("用户名:");
        jLabel1.setBounds(new Rectangle(49, 24, 42, 15));
        jLabel2.setText("原密码:");
        jLabel2.setBounds(new Rectangle(49, 54, 42, 15));
        jLabel3.setText("新密码:");
        jLabel3.setBounds(new Rectangle(49, 86, 42, 15));
        jLabel4.setText("确认新密码:");
        jLabel4.setBounds(new Rectangle(22, 116, 73, 15));
        btnOK.setBounds(new Rectangle(78, 145, 81, 23));
        btnOK.setText("修改");
        btnOK.addActionListener(new PasswordDialog_btnOK_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(175, 144, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new PasswordDialog_btnCancel_actionAdapter(this));
        txtUser.setEditable(false);
        txtUser.setBounds(new Rectangle(99, 22, 158, 20));
        txtP1.setBounds(new Rectangle(98, 52, 159, 20));
        txtP2.setBounds(new Rectangle(99, 83, 158, 20));
        txtP3.setBounds(new Rectangle(99, 114, 158, 20));
        this.setResizable(false);
        this.setTitle("修改密码");
        
        setContentPane(panel1);
        //getContentPane().add(panel1);//也是种设置面板的方式
        
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
            JOptionPane.showMessageDialog(null,"密码不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else if( !util.UserInfo.getUser().getUserpass().equals(p1)) {
            JOptionPane.showMessageDialog(null,"原密码不正确","提示",JOptionPane.WARNING_MESSAGE);
        } else if( !p2.equals(p3)) {
            JOptionPane.showMessageDialog(null,"新密码必须一致","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            User user = util.UserInfo.getUser();//获得当前用户（也就是当前主frame下的用户）
            user.setUserpass(p2);//调用user类而设置密码
            try {
                UserDao.modify(user);//更新
                JOptionPane.showMessageDialog(null,"修改成功.","提示",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.WARNING_MESSAGE);
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

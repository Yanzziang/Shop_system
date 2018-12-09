package frame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.*;
import dao.*;
import java.sql.*;

public class UserAddDialog extends JDialog {
    public UserAddDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            begin();
            pack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserAddDialog() {
        this(null);
    }

    private void begin() throws Exception {
        this.getContentPane().setLayout(null);
        jLabel1.setText("����Ա��:");
        jLabel1.setBounds(new Rectangle(18, 24, 63, 15));
        txtName.setBounds(new Rectangle(92, 113, 122, 20));
        
        txtPass2.setBounds(new Rectangle(92, 82, 122, 20));
        txtPass1.setBounds(new Rectangle(92, 50, 122, 20));
        txtUserName.setBounds(new Rectangle(92, 22, 122, 20));
        jLabel4.setText("��ʵ����:");
        jLabel4.setBounds(new Rectangle(18, 113, 64, 15));
        jLabel3.setText("ȷ������:");
        jLabel3.setBounds(new Rectangle(19, 86, 61, 15));
        btnAdd.setBounds(new Rectangle(257, 272, 81, 23));
        btnAdd.setText("���");
        btnAdd.addActionListener(new UserAddDialog_btnAdd_actionAdapter(this));
        btnCancel.setBounds(new Rectangle(354, 272, 81, 23));
        btnCancel.setText("ȡ��");
        btnCancel.addActionListener(new UserAddDialog_btnCancel_actionAdapter(this));
        this.setTitle("��ӹ���Ա");
        jLabel5.setText("�Ա�:");
        jLabel5.setBounds(new Rectangle(237, 27, 42, 15));
        txtSex.setText("��");
        txtSex.setBounds(new Rectangle(285, 22, 157, 20));
        jLabel6.setText("����:");
        jLabel6.setBounds(new Rectangle(237, 56, 42, 15));
        txtBirth.setText("1996-03-02");
        txtBirth.setBounds(new Rectangle(285, 50, 156, 20));
        jLabel7.setText("֤����:");
        jLabel7.setBounds(new Rectangle(226, 85, 59, 15));
        txtIdCard.setBounds(new Rectangle(285, 82, 156, 20));
        jLabel8.setText("��ַ:");
        jLabel8.setBounds(new Rectangle(234, 116, 42, 15));
        txtAddr.setBounds(new Rectangle(285, 112, 155, 20));
        jLabel9.setText("�绰:");
        jLabel9.setBounds(new Rectangle(38, 145, 42, 15));
        txtPhone.setBounds(new Rectangle(92, 144, 347, 20));
        jLabel10.setText("��ע:");
        jLabel10.setBounds(new Rectangle(38, 177, 48, 15));
        txtusertype.setBounds(new Rectangle(92, 174, 250, 20));
        cbxp1.setText("ϵͳȨ��");
        cbxp1.setBounds(new Rectangle(92, 209, 85, 23));
        jLabel11.setText("Ȩ��:");
        jLabel11.setBounds(new Rectangle(38, 213, 48, 15));
        cbxp2.setText("�ɹ�����ԱȨ��");
        cbxp2.setBounds(new Rectangle(170, 208, 120, 23));
        cbxp3.setText("������ԱȨ��");
        cbxp3.setBounds(new Rectangle(295, 210, 120, 23));
        cbxp4.setText("����ҵ��ԱȨ��");
        cbxp4.setBounds(new Rectangle(92, 241, 120, 23));
        cbxp5.setText("���¹���ԱȨ��");
        cbxp5.setBounds(new Rectangle(217, 241, 120, 23));
        //cbxp6.setText("�������ԱȨ��");
        //cbxp6.setBounds(new Rectangle(343, 241, 120, 23));
        kk.add(cbxp1);
        kk.add(cbxp2);
        kk.add(cbxp3);
        kk.add(cbxp4);
        kk.add(cbxp5);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtUserName);
        this.getContentPane().add(txtPass1);
        this.getContentPane().add(txtPass2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(txtName);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(txtSex);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(txtBirth);
        this.getContentPane().add(txtIdCard);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(txtAddr);
        this.getContentPane().add(txtPhone);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(txtusertype);
        this.getContentPane().add(jLabel10);
       this.getContentPane().add(cbxp1);
        this.getContentPane().add(jLabel11);
       this.getContentPane().add(cbxp2);
        this.getContentPane().add(cbxp3);
        this.getContentPane().add(cbxp4);
        this.getContentPane().add(cbxp5);

       // this.getContentPane().add(cbxp6);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnAdd);
        jLabel2.setText("����:");
        jLabel2.setBounds(new Rectangle(38, 56, 42, 15));

        setSize(new Dimension(489, 354));
        util.FrameSet.showCenter(this);
    }

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JTextField txtUserName = new JTextField();
    JPasswordField txtPass1 = new JPasswordField();
    JPasswordField txtPass2 = new JPasswordField();
    JTextField txtName = new JTextField();
    JButton btnAdd = new JButton();
    JButton btnCancel = new JButton();
    JLabel jLabel5 = new JLabel();
    JTextField txtSex = new JTextField();
    JLabel jLabel6 = new JLabel();
    JTextField txtBirth = new JTextField();
    JLabel jLabel7 = new JLabel();
    JTextField txtIdCard = new JTextField();
    JLabel jLabel8 = new JLabel();
    JTextField txtAddr = new JTextField();
    JLabel jLabel9 = new JLabel();
    JTextField txtPhone = new JTextField();
    JLabel jLabel10 = new JLabel();
    JTextField txtusertype = new JTextField();
    //JCheckBox cbxp1 = new JCheckBox();
    JLabel jLabel11 = new JLabel();
    /*JCheckBox cbxp2 = new JCheckBox();
    JCheckBox cbxp3 = new JCheckBox();
    JCheckBox cbxp4 = new JCheckBox();
    JCheckBox cbxp5 = new JCheckBox();*/
    JRadioButton cbxp1=new JRadioButton();
    JRadioButton cbxp2=new JRadioButton();
    JRadioButton cbxp3=new JRadioButton();
    JRadioButton cbxp4=new JRadioButton();
    JRadioButton cbxp5=new JRadioButton();
    ButtonGroup kk =new ButtonGroup();
    
    //JCheckBox cbxp6 = new JCheckBox();
    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }
     //��������ķ���
    public void btnAdd_actionPerformed(ActionEvent e) {
        String username = this.txtUserName.getText().trim();
        String pass1 = String.valueOf(txtPass1.getPassword());
        String pass2 = String.valueOf(txtPass2.getPassword());
        String name = this.txtName.getText().trim();

        String sex = this.txtSex.getText().trim();
        String birth = this.txtBirth.getText().trim();
        String idcard = this.txtIdCard.getText().trim();
        String phone = this.txtPhone.getText().trim();
        String remark = this.txtusertype.getText().trim();
        String addr = this.txtAddr.getText().trim();

        boolean p1 = this.cbxp1.isSelected();
        boolean p2 = this.cbxp2.isSelected();
        boolean p3 = this.cbxp3.isSelected();
        boolean p4 = this.cbxp4.isSelected();
        boolean p5 = this.cbxp5.isSelected();
        User user = new User();
        //user.setId(rs.getInt("id"));
        user.setUsername(username);
        user.setUserpass(pass1);
        user.setName(name);
        user.setSex(sex);
        user.setBirth(birth);
        user.setIdcard(idcard);
        user.setAddr(addr);
        user.setPhone(phone);
        user.setRemark(remark);
        user.setP1(p1);
        user.setP2(p2);
        user.setP3(p3);
        user.setP4(p4);
        user.setP5(p5);
        //boolean p6 = this.cbxp6.isSelected();
        if(p1==false&&p2==false&&p3==false&&p4==false&&p5==false){
        	JOptionPane.showMessageDialog(null,"Ȩ�޲���Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
        }
        else{
        if(username.length() < 1 || pass1.length() < 1 || pass2.length() < 1 || name.equals("") ) {
            JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��,��������Ϊ�ա�","��ʾ",JOptionPane.WARNING_MESSAGE);
        }  else if( !pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(null,"�������һ��","��ʾ",JOptionPane.WARNING_MESSAGE);
        } else {
            
            //user.setP6(p6);
            try {
                UserDao.add(user);
                JOptionPane.showMessageDialog(null,"��ӳɹ�.","��ʾ",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"�û��Ѵ��ڻ������ݲ���ȷ�����ʧ��","��ʾ",JOptionPane.WARNING_MESSAGE);
            }
        }
       }
    }
}


class UserAddDialog_btnAdd_actionAdapter implements ActionListener {
    private UserAddDialog adaptee;
    UserAddDialog_btnAdd_actionAdapter(UserAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}


class UserAddDialog_btnCancel_actionAdapter implements ActionListener {
    private UserAddDialog adaptee;
    UserAddDialog_btnCancel_actionAdapter(UserAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

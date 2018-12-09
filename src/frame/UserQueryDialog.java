package frame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.*;
import dao.*;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class UserQueryDialog extends JDialog {
    public UserQueryDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            begin();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public UserQueryDialog() {
        this(null);//构造方法没有参数就什么都不返回
    }

    private void begin() throws Exception {
        this.getContentPane().setLayout(null);//对于要向顶层容器（例如JFrame)上添加其他组件或者容器(如JPanel)，就需要调用这个方法。
        this.setTitle("管理员列表");//一般先创立一个容器类的实例，然后调用此方法 Container c=getContentPane()
        
        jLabel1.setText("用户名:");
        jLabel1.setBounds(new Rectangle(242, 27, 42, 15));
        txtName.setBounds(new Rectangle(303, 116, 122, 20));
        txtPass2.setBounds(new Rectangle(303, 85, 122, 20));
        txtPass1.setBounds(new Rectangle(303, 53, 122, 20));
        txtUserName.setEditable(false);
        txtUserName.setBounds(new Rectangle(303, 25, 122, 20));
        jLabel4.setText("真实姓名:");
        jLabel4.setBounds(new Rectangle(229, 116, 64, 15));
        jLabel3.setText("确认密码:");
        jLabel3.setBounds(new Rectangle(230, 89, 61, 15));
        btnCancel.setBounds(new Rectangle(567, 300, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new UserQueryDialog_btnCancel_actionAdapter(this));
        
        jLabel5.setText("性别:");
        jLabel5.setBounds(new Rectangle(448, 30, 42, 15));
        txtSex.setText("男");
        txtSex.setBounds(new Rectangle(496, 25, 157, 20));
        jLabel6.setText("生日:");
        jLabel6.setBounds(new Rectangle(448, 59, 42, 15));
        txtBirth.setText("1996-03-02");
        txtBirth.setBounds(new Rectangle(496, 53, 156, 20));
        jLabel7.setText("证件号:");
        jLabel7.setBounds(new Rectangle(437, 88, 59, 15));
        txtIdCard.setBounds(new Rectangle(496, 85, 156, 20));
        jLabel8.setText("地址:");
        jLabel8.setBounds(new Rectangle(445, 119, 42, 15));
        txtAddr.setBounds(new Rectangle(496, 115, 155, 20));
        jLabel9.setText("电话:");
        jLabel9.setBounds(new Rectangle(249, 148, 42, 15));
        txtPhone.setBounds(new Rectangle(303, 147, 347, 20));
        jLabel10.setText("备注:");
        jLabel10.setBounds(new Rectangle(249, 180, 48, 15));
        txtRemark.setBounds(new Rectangle(303, 177, 348, 20));
        cbxp1.setText("系统权限");
        cbxp1.setBounds(new Rectangle(303, 212, 85, 23));
        jLabel11.setText("权限:");
        jLabel11.setBounds(new Rectangle(249, 216, 48, 15));
        cbxp2.setText("采购管理员权限");//采购管理员
        cbxp2.setBounds(new Rectangle(400, 211, 130, 23));
        cbxp3.setText("库存管理员权限");//库存管理员
        cbxp3.setBounds(new Rectangle(536, 211, 160, 23));
        cbxp4.setText("业务管理员权限");//业务管理员
        cbxp4.setBounds(new Rectangle(303, 244, 140, 23));
        cbxp5.setText("人事管理员权限");
        cbxp5.setBounds(new Rectangle(446, 244, 160, 23));
        cbxp6.setText("财务管理员权限");
        cbxp6.setBounds(new Rectangle(303, 272, 160, 23));
        lstName.addMouseListener(new UserQueryDialog_lstName_mouseAdapter(this));
        btnUpdate.addActionListener(new UserQueryDialog_btnUpdate_actionAdapter(this));
        
        
        
        this.getContentPane().add(txtAddr);
        btnUpdate.setBounds(new Rectangle(376, 300, 81, 23));
        btnUpdate.setText("修改");
        jLabel12.setText("用户名:");
        jLabel12.setBounds(new Rectangle(26, 23, 48, 15));
        jScrollPane1.setBounds(new Rectangle(21, 50, 178, 247));
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(cbxp1);
        this.getContentPane().add(cbxp4);
        this.getContentPane().add(cbxp5);
        this.getContentPane().add(cbxp2);
        this.getContentPane().add(cbxp3);
        this.getContentPane().add(cbxp6);
        kk.add(cbxp1);
        kk.add(cbxp2);
        kk.add(cbxp3);
        kk.add(cbxp4);
        kk.add(cbxp5);
        kk.add(cbxp6);
        
        this.getContentPane().add(txtRemark);
        this.getContentPane().add(txtPhone);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtPass2);
        this.getContentPane().add(txtPass1);
        this.getContentPane().add(txtUserName);
        this.getContentPane().add(txtSex);
        this.getContentPane().add(txtBirth);
        this.getContentPane().add(txtIdCard);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel12);
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnUpdate);

        
        
        	btnDel.setBounds(new Rectangle(474, 300, 81, 23));
            btnDel.setText("删除");
            btnDel.addActionListener(new UserQueryDialog_btnDel_actionAdapter(this));
        	this.getContentPane().add(btnDel);
        	
        	
        jScrollPane1.getViewport().add(lstName);//把列表加到滚动面板上  //getViewport用来显示组件对象，必须调用
        jLabel2.setText("密码:");
        jLabel2.setBounds(new Rectangle(249, 59, 42, 15));
        
        

        setSize(new Dimension(686, 380));
        freshData();
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
    JTextField txtRemark = new JTextField();
    //JCheckBox cbxp1 = new JCheckBox();
    JLabel jLabel11 = new JLabel();
    /*JCheckBox cbxp2 = new JCheckBox();
    JCheckBox cbxp3 = new JCheckBox();
    JCheckBox cbxp4 = new JCheckBox();
    JCheckBox cbxp5 = new JCheckBox();
    JCheckBox cbxp6 = new JCheckBox();*/
    JRadioButton cbxp1=new JRadioButton();
    JRadioButton cbxp2=new JRadioButton();
    JRadioButton cbxp3=new JRadioButton();
    JRadioButton cbxp4=new JRadioButton();
    JRadioButton cbxp5=new JRadioButton();
    JRadioButton cbxp6=new JRadioButton();
    ButtonGroup kk =new ButtonGroup();
    JScrollPane jScrollPane1 = new JScrollPane();
    JList lstName = new JList();
    JLabel jLabel12 = new JLabel();
    JButton btnUpdate = new JButton();
    JButton btnDel = new JButton();

    
    public void freshData() {

        lstName.clearSelection();//清除选中
        lstName.setListData(UserDao.getUserNames());//把名字的向量（Vector）设置为JList的数据
    }


    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnAdd_actionPerformed(ActionEvent e) {
        String username = this.txtUserName.getText().trim();
        String pass1 = String.valueOf(txtPass1.getPassword());
        String pass2 = String.valueOf(txtPass2.getPassword());
        String name = this.txtName.getText().trim();

        String sex = this.txtSex.getText().trim();
        String birth = this.txtBirth.getText().trim();
        String idcard = this.txtIdCard.getText().trim();
        String phone = this.txtPhone.getText().trim();
        String remark = this.txtRemark.getText().trim();
        String addr = this.txtAddr.getText().trim();

        boolean p1 = this.cbxp1.isSelected();
        boolean p2 = this.cbxp2.isSelected();
        boolean p3 = this.cbxp3.isSelected();
        boolean p4 = this.cbxp4.isSelected();
        boolean p5 = this.cbxp5.isSelected();
       // boolean p6 = this.cbxp6.isSelected();

        if(username.length() < 1 || pass1.length() < 1 || pass2.length() < 1 || name.equals("") ) {
            JOptionPane.showMessageDialog(null,"用户名和密码不能为空,姓名不能为空。","提示",JOptionPane.WARNING_MESSAGE);
        }  else if( !pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(null,"密码必须一致","提示",JOptionPane.WARNING_MESSAGE);
        } else {
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
           // user.setP6(p6);
            try {
                UserDao.add(user);
                JOptionPane.showMessageDialog(null,"添加成功.","提示",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"用户已存在或者数据不正确，添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void lstName_mouseClicked(MouseEvent e) {
        int id = lstName.getSelectedIndex();//获得该名字在jlist中的索引
        if( id >= 0 ) {
            String userName = this.lstName.getSelectedValue().toString().trim();//getSelectedValue()获得选中内容
            //不能gettext(),因为lstname不是text
            User user = dao.UserDao.getUserByName(userName);//根据名字获得数据库中的user
            this.txtAddr.setText(user.getAddr());//设置文本信息
            this.txtBirth.setText(user.getBirth());
            this.txtIdCard.setText(user.getIdcard());
            this.txtName.setText(user.getName());
            this.txtPass1.setText(user.getUserpass());
            this.txtPass2.setText(user.getUserpass());
            this.txtPhone.setText(user.getPhone());
            this.txtRemark.setText(user.getRemark());
            this.txtSex.setText(user.getSex());
            this.txtUserName.setText(user.getUsername());

            this.cbxp1.setSelected(user.isP1());
            this.cbxp2.setSelected(user.isP2());
            this.cbxp3.setSelected(user.isP3());
            this.cbxp4.setSelected(user.isP4());
            this.cbxp5.setSelected(user.isP5());
           // this.cbxp6.setSelected(user.isP6());
        }

    }

    public void btnUpdate_actionPerformed(ActionEvent e) {
        String username = this.txtUserName.getText().trim();
        String pass1 = String.valueOf(txtPass1.getPassword());//把密码转化为string
        String pass2 = String.valueOf(txtPass2.getPassword());
        String name = this.txtName.getText().trim();

        String sex = this.txtSex.getText().trim();
        String birth = this.txtBirth.getText().trim();
        String idcard = this.txtIdCard.getText().trim();
        String phone = this.txtPhone.getText().trim();
        String remark = this.txtRemark.getText().trim();
        String addr = this.txtAddr.getText().trim();

        boolean p1 = this.cbxp1.isSelected();
        boolean p2 = this.cbxp2.isSelected();
        boolean p3 = this.cbxp3.isSelected();
        boolean p4 = this.cbxp4.isSelected();
        boolean p5 = this.cbxp5.isSelected();
        //boolean p6 = this.cbxp6.isSelected();
        if(username.length() < 1 || pass1.length() < 1 || pass2.length() < 1 || name.equals("") ) {
            JOptionPane.showMessageDialog(null,"用户名和密码不能为空,姓名不能为空。","提示",JOptionPane.WARNING_MESSAGE);
        }  else if( !pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(null,"密码必须一致","提示",JOptionPane.WARNING_MESSAGE);
        } else {
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
            //user.setP6(p6);
            try {
                //user.setId(UserDao.getUserByName(user.getUsername()).getId());
                //getUserByName是通过名字查找数据库中的user  getUsername是获得名字
                //通过当前user的名字查找数据库中的USER，把修改后的用户对象的id设置成获得的id
                UserDao.modify(user);
                JOptionPane.showMessageDialog(null,"修改成功.","提示",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"数据不正确，添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public void btnDel_actionPerformed(ActionEvent e) {
        String username = this.txtUserName.getText().trim();

        if(username.length() < 1 ) {
            JOptionPane.showMessageDialog(null,"请选择用户。","提示",JOptionPane.WARNING_MESSAGE);
            return ;
        }  else if(username.equals("admin")) {
            JOptionPane.showMessageDialog(null,"系统默认超级管理员不能删除。","提示",JOptionPane.WARNING_MESSAGE);
            return ;
        }

        UserDao.delete(username);
        this.txtUserName.setText("");
        freshData();
    }
}


class UserQueryDialog_btnDel_actionAdapter implements ActionListener {
    private UserQueryDialog adaptee;
    UserQueryDialog_btnDel_actionAdapter(UserQueryDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnDel_actionPerformed(e);
    }
}


class UserQueryDialog_btnUpdate_actionAdapter implements ActionListener {
    private UserQueryDialog adaptee;
    UserQueryDialog_btnUpdate_actionAdapter(UserQueryDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnUpdate_actionPerformed(e);
    }
}


class UserQueryDialog_btnCancel_actionAdapter implements ActionListener {
    private UserQueryDialog adaptee;
    UserQueryDialog_btnCancel_actionAdapter(UserQueryDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class UserQueryDialog_lstName_mouseAdapter extends MouseAdapter {
    private UserQueryDialog adaptee;
    UserQueryDialog_lstName_mouseAdapter(UserQueryDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.lstName_mouseClicked(e);
    }
}

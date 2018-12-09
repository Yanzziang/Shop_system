package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vo.*;
import util.ClockPanel;
import util.BackgroundPanel;
import dao.*;
import java.awt.Dimension;
import frame.*;
import util.*;


public class LoginFrame extends JFrame {
	private BackgroundPanel contentPane1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField txtUsername;
	private JPasswordField txtUserpass;
	private JButton btnLogin;
	private JButton btnExit;
	//private JTextField mima;
	//private YanZheng yanzheng;

    public LoginFrame() {
        try {
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭动作
        	setResizable(false);
        	setTitle("登录");
        	//this.setBounds(200, 200, 559, 285);
        	setSize(new Dimension(510, 285));//固定的大小
            util.FrameSet.showCenter(this);
        	contentPane1 = getLoginPanel();
        	contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
    		setContentPane(contentPane1);//------------------关键
    		contentPane1.setLayout(null);
        	
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    //我们可以在 JFrame 对象中添加 AWT 或者 Swing 组件。但是，虽然它有 add 方法，却不能直接用于添加组件，否则会抛出异常。
    //造成这个现象的原因只有一个解释：JFrame 不是一个容器，它只是一个框架。那么，应该怎么添加组件呢？
    //JFrame 有一个 Content Pane，窗口能显示的所有组件都是添加在这个 Content Pane 中。
    //JFrame 提供了两个方法：getContentPane 和 setContentPane 就是用于获取和设置其 Content Pane 的
    //http://shuoailin.blog.51cto.com/2262336/1435821

    private BackgroundPanel getLoginPanel() {
		if (contentPane1 == null) {
			contentPane1 = new BackgroundPanel();// 创建登录面板对象		
			contentPane1.setOpaque(false);// 面板透明
			contentPane1.setImage(getToolkit().getImage(
		            this.getClass().getResource("timg2.png")));// 设置面板背景图片   
			contentPane1.setLayout(null);
			JLabel jLabel1 = new JLabel("用户名:");
	        jLabel1.setBounds(57, 90, 42, 15);
	        contentPane1.add(jLabel1);
	        
	        JLabel jLabel2 = new JLabel("密码:");
	        jLabel2.setBounds(57, 139, 42, 15);
	        contentPane1.add(jLabel2);
	        
	        txtUserpass = new JPasswordField("");
	        txtUserpass.setBounds(109, 135, 157, 24);
	        contentPane1.add(txtUserpass);
	        
	        txtUsername = new JTextField("");
	        txtUsername.setBounds(new Rectangle(109, 87, 157, 24));
	        contentPane1.add(txtUsername);
	       
	        btnLogin = new JButton("登录");
	        btnLogin.addActionListener(new LoginFrame_btnLogin_actionAdapter(this));
	        getRootPane().setDefaultButton(btnLogin);
	        btnLogin.setBounds(new Rectangle(93, 177, 81, 23));
	        contentPane1.add(btnLogin);
	        
	        btnExit = new JButton("退出");
	        btnExit.addActionListener(new LoginFrame_btnExit_actionAdapter(this));
	        btnExit.setBounds(new Rectangle(185, 177, 81, 23));
	        contentPane1.add(btnExit);
	        /*---------(xinjia)
	        YanZheng yanzheng = new YanZheng();
	        yanzheng.setBounds(185, 197, 95, 40);
	        contentPane1.add(yanzheng);
	        
	        JTextField mima = new JTextField("");
	        mima.setBounds(130, 199, 60, 30);
	        contentPane1.add(mima);
	       */
	        JPanel panel = new ClockPanel();
			panel.setBounds(320, 54, 151, 142);
			contentPane1.add(panel);
	        }
		
		return contentPane1;
    }
			

    public void btnLogin_actionPerformed(ActionEvent e) {
        //String user = this.txtUsername.getText().trim();
        String username = txtUsername.getText();
        //String pass = String.valueOf(txtUserpass.getPassword());
        String passww = txtUserpass.getText();

        if(username.length() < 5 || passww.length() < 5) {
            JOptionPane.showMessageDialog(null,"用户名或密码不小于六位","提示",JOptionPane.WARNING_MESSAGE);
        } 
        else {
            User u = UserDao.login(username, passww);//如果密码不对u还是等于0
            if( u != null) {
                UserInfo.setUser(u);
                LogDao.add(u,"登录进入系统");//添加user到登录信息
                new MainFrame();//开启主框架
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"用户名或密码错误","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }

    public void btnExit_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}


class LoginFrame_btnExit_actionAdapter implements ActionListener {
    private LoginFrame adaptee;
    LoginFrame_btnExit_actionAdapter(LoginFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnExit_actionPerformed(e);
    }
}


class LoginFrame_btnLogin_actionAdapter implements ActionListener {
    private LoginFrame adaptee;
    LoginFrame_btnLogin_actionAdapter(LoginFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnLogin_actionPerformed(e);
    }
}
//-----------------------

 


/*public LoginFrame() {
try {
    jbInit();
} catch (Exception exception) {
    exception.printStackTrace();
}
}*/		
/*private void jbInit() throws Exception {
getContentPane().setLayout(null);
jLabel1.setText("用户名:");
jLabel1.setBounds(new Rectangle(17, 25, 42, 15));

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("登录");

btnLogin.addActionListener(new LoginFrame_btnLogin_actionAdapter(this));
btnExit.setBounds(new Rectangle(146, 94, 81, 23));
btnExit.setText("退出");
btnExit.addActionListener(new LoginFrame_btnExit_actionAdapter(this));
btnLogin.setBounds(new Rectangle(49, 94, 81, 23));
btnLogin.setText("登录");
txtUserpass.setText("admin");
txtUserpass.setBounds(new Rectangle(69, 50, 157, 24));
txtUsername.setText("admin");
txtUsername.setBounds(new Rectangle(69, 22, 157, 24));
this.getContentPane().add(txtUserpass);
this.getContentPane().add(jLabel1);
this.getContentPane().add(jLabel2);
this.getContentPane().add(txtUsername);
this.getContentPane().add(btnExit);
this.getContentPane().add(btnLogin);
jLabel2.setText("密码:");
jLabel2.setBounds(new Rectangle(17, 53, 42, 15));

getRootPane().setDefaultButton(btnLogin);
setSize(new Dimension(267, 177));
util.FrameSet.showCenter(this);
}*/

/*JLabel jLabel1 = new JLabel();
JLabel jLabel2 = new JLabel();
JTextField txtUsername = new JTextField();
JPasswordField txtUserpass = new JPasswordField();
JButton btnLogin = new JButton();
JButton btnExit = new JButton();*/

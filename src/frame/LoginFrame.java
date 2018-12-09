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
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرն���
        	setResizable(false);
        	setTitle("��¼");
        	//this.setBounds(200, 200, 559, 285);
        	setSize(new Dimension(510, 285));//�̶��Ĵ�С
            util.FrameSet.showCenter(this);
        	contentPane1 = getLoginPanel();
        	contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
    		setContentPane(contentPane1);//------------------�ؼ�
    		contentPane1.setLayout(null);
        	
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    //���ǿ����� JFrame ��������� AWT ���� Swing ��������ǣ���Ȼ���� add ������ȴ����ֱ��������������������׳��쳣��
    //�����������ԭ��ֻ��һ�����ͣ�JFrame ����һ����������ֻ��һ����ܡ���ô��Ӧ����ô�������أ�
    //JFrame ��һ�� Content Pane����������ʾ��������������������� Content Pane �С�
    //JFrame �ṩ������������getContentPane �� setContentPane �������ڻ�ȡ�������� Content Pane ��
    //http://shuoailin.blog.51cto.com/2262336/1435821

    private BackgroundPanel getLoginPanel() {
		if (contentPane1 == null) {
			contentPane1 = new BackgroundPanel();// ������¼������		
			contentPane1.setOpaque(false);// ���͸��
			contentPane1.setImage(getToolkit().getImage(
		            this.getClass().getResource("timg2.png")));// ������屳��ͼƬ   
			contentPane1.setLayout(null);
			JLabel jLabel1 = new JLabel("�û���:");
	        jLabel1.setBounds(57, 90, 42, 15);
	        contentPane1.add(jLabel1);
	        
	        JLabel jLabel2 = new JLabel("����:");
	        jLabel2.setBounds(57, 139, 42, 15);
	        contentPane1.add(jLabel2);
	        
	        txtUserpass = new JPasswordField("");
	        txtUserpass.setBounds(109, 135, 157, 24);
	        contentPane1.add(txtUserpass);
	        
	        txtUsername = new JTextField("");
	        txtUsername.setBounds(new Rectangle(109, 87, 157, 24));
	        contentPane1.add(txtUsername);
	       
	        btnLogin = new JButton("��¼");
	        btnLogin.addActionListener(new LoginFrame_btnLogin_actionAdapter(this));
	        getRootPane().setDefaultButton(btnLogin);
	        btnLogin.setBounds(new Rectangle(93, 177, 81, 23));
	        contentPane1.add(btnLogin);
	        
	        btnExit = new JButton("�˳�");
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
            JOptionPane.showMessageDialog(null,"�û��������벻С����λ","��ʾ",JOptionPane.WARNING_MESSAGE);
        } 
        else {
            User u = UserDao.login(username, passww);//������벻��u���ǵ���0
            if( u != null) {
                UserInfo.setUser(u);
                LogDao.add(u,"��¼����ϵͳ");//���user����¼��Ϣ
                new MainFrame();//���������
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"�û������������","��ʾ",JOptionPane.WARNING_MESSAGE);
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
jLabel1.setText("�û���:");
jLabel1.setBounds(new Rectangle(17, 25, 42, 15));

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("��¼");

btnLogin.addActionListener(new LoginFrame_btnLogin_actionAdapter(this));
btnExit.setBounds(new Rectangle(146, 94, 81, 23));
btnExit.setText("�˳�");
btnExit.addActionListener(new LoginFrame_btnExit_actionAdapter(this));
btnLogin.setBounds(new Rectangle(49, 94, 81, 23));
btnLogin.setText("��¼");
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
jLabel2.setText("����:");
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

package frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.*;
import dao.*;
import java.sql.*;
import java.awt.Rectangle;
import java.awt.Dimension;
import dao.*;
public class PersonAddDialog extends JDialog{

	public PersonAddDialog(Frame owner){
		super(owner,true);
		try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
	}
	
	public PersonAddDialog() {
        this(null);
    }
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JButton btnAdd = new JButton();
    JButton btnCancel = new JButton();
	
    JTextField txtpname = new JTextField();
    JTextField txtage = new JTextField();
    JTextField txtsex = new JTextField();
    JComboBox cbodept = new JComboBox(DeptDao.getAllDeptName());
    /*JTextField  = new JTextField();*/
    
	private void jbInit() throws Exception{
		this.getContentPane().setLayout(null);
        this.setTitle("职员添加");
        jLabel1.setText("姓名:");
        jLabel1.setBounds(new Rectangle(32, 47, 42, 15));
        jLabel2.setText("性别:");
        jLabel2.setBounds(new Rectangle(32, 90, 42, 15));
        jLabel3.setText("部门:");
        jLabel3.setBounds(new Rectangle(243, 90, 42, 15));
        jLabel4.setText("年龄:");
        jLabel4.setBounds(new Rectangle(243, 47, 42, 15));
        /*jLabel5.setText("职务:");
        jLabel5.setBounds(new Rectangle(272, 19, 42, 15));*/
        
        btnAdd.setText("添加");
        btnAdd.setBounds(new Rectangle(282, 157, 81, 23));
        btnCancel.setText("取消");
        btnCancel.setBounds(new Rectangle(379, 157, 81, 23));
        btnCancel.addActionListener(new
                PersonAddDialog_btnCancel_actionAdapter(this));
btnAdd.addActionListener(new PersonAddDialog_btnAdd_actionAdapter(this));
        
        txtpname.setBounds(73, 46, 149, 20);
        txtage.setBounds(282, 46, 150, 20);
        txtsex.setBounds(73, 89, 147, 20);
        cbodept.setBounds(282, 89, 148, 20);
        
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(txtpname);
        this.getContentPane().add(txtage);
        this.getContentPane().add(txtsex);
        this.getContentPane().add(cbodept);
        
        setSize(new Dimension(489, 241));
        util.FrameSet.showCenter(this);
	}
	
	public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }
	
	public void btnAdd_actionPerformed(ActionEvent e){
		String pname = this.txtpname.getText().trim();
		String age = this.txtage.getText().trim();
		String sex = this.txtsex.getText().trim();
		String dept = cbodept.getSelectedItem().toString();
		
		if(pname.equals("")||sex.equals(""))
			{JOptionPane.showMessageDialog(null,"信息不能为空。","提示",JOptionPane.WARNING_MESSAGE);}
		
		else{
			Person person = new Person();
			person.setPname(pname);
			person.setAge(age);
			person.setSex(sex);
			person.setDept(dept);
		
			try{
				PersonDao.add(person);
				JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
			}catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"职员已存在或数据不正确，添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
		}
		
	}
	
}

class PersonAddDialog_btnCancel_actionAdapter implements ActionListener {
    private PersonAddDialog adaptee;
    PersonAddDialog_btnCancel_actionAdapter(PersonAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}    
    class PersonAddDialog_btnAdd_actionAdapter implements ActionListener {
        private PersonAddDialog adaptee;
        PersonAddDialog_btnAdd_actionAdapter(PersonAddDialog adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.btnAdd_actionPerformed(e);
        }
    }

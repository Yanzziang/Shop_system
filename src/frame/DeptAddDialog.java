package frame;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.DeptDao;
import vo.Dept;

import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeptAddDialog extends JDialog{

	public DeptAddDialog(Frame owner){
		super(owner,true);
		try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
	}
	public DeptAddDialog() {
        this(null);
    }
	JButton btnAdd = new JButton();
    JButton btnCancel = new JButton();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextField txtdept = new JTextField();
    JTextField txtmanage = new JTextField();
	
	public void jbInit() throws Exception{
		getContentPane().setLayout(null);
		setTitle("�������");
		jLabel1.setText("����:");
        jLabel1.setBounds(new Rectangle(32, 17, 42, 15));
        jLabel2.setText("������:");
        jLabel2.setBounds(new Rectangle(32, 50, 42, 15));
        
        txtdept.setBounds(73, 16, 149, 20);
        txtmanage.setBounds(73, 50, 150, 20);
        
        btnAdd.setText("���");
        btnAdd.setBounds(new Rectangle(100, 80, 66, 23));
        btnCancel.setText("ȡ��");
        btnCancel.setBounds(new Rectangle(180, 80, 66, 23));
        btnCancel.addActionListener(new
                DeptAddDialog_btnCancel_actionAdapter(this));
btnAdd.addActionListener(new DeptAddDialog_btnAdd_actionAdapter(this));
        
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txtdept);
        this.getContentPane().add(txtmanage);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(btnCancel);
        
        setSize(new Dimension(240, 120));
        util.FrameSet.showCenter(this);
        
	}
	
	public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }
	
	public void btnAdd_actionPerformed(ActionEvent e){
		String dept = this.txtdept.getText().trim();
		String manage = this.txtmanage.getText().trim();
		
		
		if(dept.equals("")||manage.equals(""))
			{JOptionPane.showMessageDialog(null,"��Ϣ����Ϊ�ա�","��ʾ",JOptionPane.WARNING_MESSAGE);}
		else{
			Dept department = new Dept();
			department.setDept(dept);
			department.setManage(manage);
			
			try{
				DeptDao.add(department);
				JOptionPane.showMessageDialog(null,"��ӳɹ�.","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"ְԱ�Ѵ��ڻ����ݲ���ȷ�����ʧ��","��ʾ",JOptionPane.WARNING_MESSAGE);
            }
		}
	}
	
}

class DeptAddDialog_btnCancel_actionAdapter implements ActionListener {
    private DeptAddDialog adaptee;
    DeptAddDialog_btnCancel_actionAdapter(DeptAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}    
    class DeptAddDialog_btnAdd_actionAdapter implements ActionListener {
        private DeptAddDialog adaptee;
        DeptAddDialog_btnAdd_actionAdapter(DeptAddDialog adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            adaptee.btnAdd_actionPerformed(e);
        }
    }

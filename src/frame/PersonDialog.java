package frame;

import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import dao.*;

public class PersonDialog extends JDialog {

	String na,dpt;
    String pname;
	JTable table = new JTable();
	DefaultTableModel dataTable;
	Vector row = new Vector();
	Vector column = new Vector();
	JScrollPane jScrollPane1 = new JScrollPane();
	JButton de = new JButton();
	JButton sear = new JButton();
	JButton cancel = new JButton();
	JLabel name = new JLabel();
	JLabel dept = new JLabel();
	JTextField name1 = new JTextField();
	
	//JComboBox dept1 = new JComboBox(DeptDao.getAllDeptName());
	JTextField dept1 = new JTextField();
	public PersonDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
	
	public void initTable(){
		
		column.add("姓名");
		column.add("年龄");
		column.add("性别");
		column.add("部门");
		
		dataTable = new DefaultTableModel(row,column);
		table = new JTable(dataTable);
		table.setRowHeight(24);
		table.setBackground(Color.LIGHT_GRAY);
		jScrollPane1.getViewport().add(table);
		
		//PersonDao.loadTable(dataTable);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Vector row2 = (Vector)row.elementAt(table.getSelectedRow());
				pname = row2.elementAt(0).toString().trim();
			}
			});
			
		freshTable();
		}
	public void freshTable(){
        dao.PersonDao.loadTable(dataTable);
 }

	
	public void jbInit() throws Exception {
		setTitle("职员列表");
		getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(19, 19, 769, 310));
		
		de.setText("删除");
		de.setBounds(563, 340, 100, 30);
		de.addActionListener(new de_actionAdapter(this));
		cancel.setText("取消");
		cancel.setBounds(683, 340, 100, 30);
		cancel.addActionListener(new cancel_actionAdapter(this));
		name.setText("姓名");
		name.setBounds(20,340, 40, 30);
		name1.setBounds(63, 340, 160, 30);
		
		dept.setText("部门");
		dept.setBounds(230, 340, 40, 30);
		dept1.setBounds(273, 340, 160, 30);
		sear.setText("查询");
		sear.setBounds(443, 340, 100, 30);
		sear.addActionListener(new sear_actionAdapter(this));
		getContentPane().add(jScrollPane1);
		getContentPane().add(de);
		getContentPane().add(name);
		getContentPane().add(name1);
		getContentPane().add(dept);
		getContentPane().add(dept1);
		getContentPane().add(sear);
		getContentPane().add(cancel);
		initTable();
		setSize(new Dimension(820, 428));
        util.FrameSet.showCenter(this);
        
	}
	
	public void de_actionPerformed(ActionEvent e){
		PersonDao.delete(pname);
		freshTable();
	}
	
	public void cancel_actionPerformed(ActionEvent e){
		this.dispose();
	}
	
	public void sear_actionPerformed(ActionEvent e){
		na = this.name1.getText();
		dpt = dept1.getText();
		if(na.equals("")&&dpt.equals("")){
			JOptionPane.showMessageDialog(null,"不能都不填写","提示",JOptionPane.WARNING_MESSAGE);
		}
		else if(!na.equals("")&&dpt.equals("")){
			PersonDao.loadTable(dataTable, na);
		}
		else if(na.equals("")&&!dpt.equals("")){
			PersonDao.loadTable2(dataTable, dpt);
		}
		else{
			PersonDao.loadTable2(dataTable, dpt, na);
		}
	}
}

class de_actionAdapter implements ActionListener{
	private PersonDialog adt;
	de_actionAdapter(PersonDialog adt){
		this.adt = adt;
	}
	
	public void actionPerformed(ActionEvent e) {
        adt.de_actionPerformed(e);
    } 
	
}

class cancel_actionAdapter implements ActionListener{
	private PersonDialog adt;
	cancel_actionAdapter(PersonDialog adt){
		this.adt = adt;
	}
	
	public void actionPerformed(ActionEvent e) {
        adt.cancel_actionPerformed(e);
    } 
	
}

class sear_actionAdapter implements ActionListener{
	private PersonDialog adt;
	sear_actionAdapter(PersonDialog adt){
		this.adt = adt;
	}
	
	public void actionPerformed(ActionEvent e) {
        adt.sear_actionPerformed(e);
    } 
	
}

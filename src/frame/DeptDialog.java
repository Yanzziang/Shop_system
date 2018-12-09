package frame;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import dao.*;

public class DeptDialog extends JDialog {

	JTable table = new JTable();
	DefaultTableModel dataTable;
	Vector row = new Vector();
	Vector column = new Vector();
	JScrollPane jScrollPane1 = new JScrollPane();
	
	public DeptDialog(Frame owner) {
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
		
		column.add("部门");
		column.add("负责人");
		
		
		dataTable = new DefaultTableModel(row,column);
		table = new JTable(dataTable);
		jScrollPane1.getViewport().add(table);
		
		DeptDao.loadTable(dataTable);
		
	}
        
        public void jbInit(){
    		setTitle("部门列表");
    		getContentPane().setLayout(null);
    		jScrollPane1.setBounds(new Rectangle(19, 19, 400, 214));
    		initTable();
    		
    		getContentPane().add(jScrollPane1);
    		
    		setSize(new Dimension(500, 318));
            util.FrameSet.showCenter(this);
            
    	}
}

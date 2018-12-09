package frame;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.*;
import vo.*;
import frame.*;

public class JingZhDialog extends JDialog {

	JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JLabel l = new JLabel();
    JLabel l2 = new JLabel();
    JTextField t2 = new JTextField();
    JTextField t = new JTextField();
    JButton search = new JButton();
    
    JButton de = new JButton();
    JButton update = new JButton();
    JButton search2 = new JButton();
    JLabel date3 = new JLabel();
    JLabel date4 = new JLabel();
    JLabel name1 = new JLabel();
    JLabel provider1 = new JLabel();
    JTextField date1 = new JTextField();
    JTextField date2 = new JTextField();
    JTextField name = new JTextField();
    JTextField provider = new JTextField();
    
	public JingZhDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           begin();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public JingZhDialog() {
        this(null);
    }
    
    public void initTable(){

        columnName.add("进账编号");
        columnName.add("商品名");
        columnName.add("售卖价格");
        columnName.add("数量");
        columnName.add("进账金额");
        columnName.add("盈利金额");
        columnName.add("交付时间");
        columnName.add("供应商");
        columnName.add("操作人");


        dataTable = new DefaultTableModel(rowData,columnName);
        table = new JTable(dataTable);
        table.setRowHeight(26);
       // table.getColumnModel().getColumn(8).setPreferredWidth(110);
        jScrollPane1.getViewport().add(table);
        
        freshTable();
    }

    public void freshTable(){
        dao.CaiWuDao.loadtable(dataTable);
 }
    
    public void begin() throws Exception {
   	 this.setTitle("进账盈利信息");
	        this.getContentPane().setLayout(null);
	        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
	                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
	        jScrollPane1.setBounds(new Rectangle(70, 69, 769, 403));
	        l.setBounds(70, 18, 67, 30);
	        l.setText("进账费用");
	        t.setBounds(140, 18, 150, 30);
	        t.setEditable(false);
	        l2.setText("商品盈利费用");l2.setBounds(300, 18, 90, 30);
	        t2.setBounds(395, 18, 150, 30);
	        t2.setEditable(false);
	        date3.setText("起始日期");
	        date3.setBounds(70, 490, 60, 30);
	        date4.setBounds(270, 490, 60, 30);
	        date4.setText("结束日期");
	        date1.setBounds(135, 490, 130, 30);
	        date2.setBounds(335, 490, 130, 30);
	        search.setText("搜索");
	        search.setBounds(475, 490, 100, 30);
	        search.addActionListener(new JingZhDialog_search_actionAdapter(this));
	        
	        name1.setText("商品名");
	        provider1.setText("供应商");
	        name1.setBounds(70, 530, 60, 30);
	        provider1.setBounds(270, 530, 60, 30);
	        name.setBounds(135, 530,130,30);
	        provider.setBounds(335, 530, 130, 30);
	        search2.setText("搜索");
	        search2.setBounds(475, 530, 100, 30);
	        search2.addActionListener(new JingZhDialog_search2_actionAdapter(this));
	        
	        //update.setText("修改");
	        de.setText("取消");
	        //update.setBounds(600, 490, 100, 70);
	        de.setBounds(600, 490, 220, 70);
	        this.getContentPane().add(jScrollPane1);
	        this.getContentPane().add(t);
	        this.getContentPane().add(l);
	        this.getContentPane().add(t2);
	        this.getContentPane().add(l2);
	        this.getContentPane().add(date1);
	        this.getContentPane().add(date2);
	        this.getContentPane().add(date3);
	        this.getContentPane().add(date4);
	        this.getContentPane().add(name1);
	        this.getContentPane().add(name);
	        this.getContentPane().add(provider);
	        this.getContentPane().add(provider1);
	        this.getContentPane().add(search);
	        this.getContentPane().add(search2);
	        //this.getContentPane().add(update);
	        this.getContentPane().add(de);
	        
	        
	        initTable();
	        setSize(new Dimension(909, 655));
	        util.FrameSet.showCenter(this);
	        
	        
    }
    
    public void search_actionPerformed(ActionEvent e){
   	 String d1 = this.date1.getText().trim();
   	 String d2 = this.date2.getText().trim();
   	float m[];
   	 if(d1.trim().equals("") || d2.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"日期不能为空","提示",JOptionPane.WARNING_MESSAGE);
        }
   	 else{
      try{
            CaiWuDao.loadtable0(dataTable, d1, d2);
            m = CaiWuDao.getMoney(d1, d2);
            t.setText(String.valueOf(m[0]));
            t2.setText(String.valueOf(m[1]));
      }catch(SQLException ex) {
          JOptionPane.showMessageDialog(null,"日期格式不正确","提示",JOptionPane.WARNING_MESSAGE);
      }
    }
    }
    
    public void search2_actionPerformed(ActionEvent e){
   	 String n1 = this.name.getText().trim();
   	 String p1 = this.provider.getText().trim();
   	 float g[] = new float[2];
   	 
   	 if(n1.trim().equals("") && p1.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"不能都为空","提示",JOptionPane.WARNING_MESSAGE);
        }
   	 else if(n1.trim().equals("")||!p1.trim().equals("")){
   		 CaiWuDao.loadtable3(dataTable, p1);
   		 g= CaiWuDao.getMoney1(p1);
   		 t.setText(String.valueOf(g[0]));
   		 t2.setText(String.valueOf(g[1]));
   	 }
   	 
   	 else if(!n1.trim().equals("")||p1.trim().equals("")){
   		 CaiWuDao.loadtable2(dataTable, n1);
   		 g=CaiWuDao.getMoney(n1);
   		 t.setText(String.valueOf(g[0]));
   		 t2.setText(String.valueOf(g[1]));
   	 }
   	 else{
   		 CaiWuDao.loadtable4(dataTable, n1, p1);
   		 g=CaiWuDao.getMoney1(n1, p1);
   		 t.setText(String.valueOf(g[0]));
   		 t2.setText(String.valueOf(g[1]));
   	 }
      
    
    }
    
    
}

class JingZhDialog_search_actionAdapter implements ActionListener {
    private JingZhDialog adaptee;
    JingZhDialog_search_actionAdapter(JingZhDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.search_actionPerformed(e);
    }
}

class JingZhDialog_search2_actionAdapter implements ActionListener {
    private JingZhDialog adaptee;
    JingZhDialog_search2_actionAdapter(JingZhDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.search2_actionPerformed(e);
    }
}

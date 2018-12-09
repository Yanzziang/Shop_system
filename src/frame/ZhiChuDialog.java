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

public class ZhiChuDialog extends JDialog {
	
	JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JLabel l = new JLabel();
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
    
	public ZhiChuDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           begin();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ZhiChuDialog() {
        this(null);
    }
    
    public void initTable(){

        columnName.add("֧�����");
        columnName.add("��Ʒ��");
        columnName.add("�۸�");
        columnName.add("����");
        columnName.add("�ܽ��");
        columnName.add("����ʱ��");
        columnName.add("��Ӧ��");
        columnName.add("������");


        dataTable = new DefaultTableModel(rowData,columnName);
        table = new JTable(dataTable);
        table.setRowHeight(24);
       // table.getColumnModel().getColumn(8).setPreferredWidth(110);
        jScrollPane1.getViewport().add(table);
        
        freshTable();
    }

    public void freshTable(){
        dao.CaiWuDao.loadTable(dataTable);
 }


     public void begin() throws Exception {
    	 this.setTitle("����֧����Ϣ");
	        this.getContentPane().setLayout(null);
	        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
	                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
	        jScrollPane1.setBounds(new Rectangle(70, 69, 769, 403));
	        l.setBounds(70, 18, 67, 30);
	        l.setText("֧������Ϊ");
	        t.setBounds(140, 18, 150, 30);
	        t.setEditable(false);
	        date3.setText("��ʼ����");
	        date3.setBounds(70, 490, 60, 30);
	        date4.setBounds(270, 490, 60, 30);
	        date4.setText("��������");
	        date1.setBounds(135, 490, 130, 30);
	        date2.setBounds(335, 490, 130, 30);
	        search.setText("����");
	        search.setBounds(475, 490, 100, 30);
	        search.addActionListener(new ZhiChuDialog_search_actionAdapter(this));
	        
	        name1.setText("��Ʒ��");
	        provider1.setText("��Ӧ��");
	        name1.setBounds(70, 530, 60, 30);
	        provider1.setBounds(270, 530, 60, 30);
	        name.setBounds(135, 530,130,30);
	        provider.setBounds(335, 530, 130, 30);
	        search2.setText("����");
	        search2.setBounds(475, 530, 100, 30);
	        search2.addActionListener(new ZhiChuDialog_search2_actionAdapter(this));
	        
	        update.setText("�޸�");
	        de.setText("ȡ��");
	        update.setBounds(600, 490, 100, 70);
	        de.setBounds(720, 490, 100, 70);
	        this.getContentPane().add(jScrollPane1);
	        this.getContentPane().add(t);
	        this.getContentPane().add(l);
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
	        this.getContentPane().add(update);
	        this.getContentPane().add(de);
	        
	        
	        initTable();
	        setSize(new Dimension(909, 655));
	        util.FrameSet.showCenter(this);
	        
	        
     }
     
     public void search_actionPerformed(ActionEvent e){
    	 String d1 = this.date1.getText().trim();
    	 String d2 = this.date2.getText().trim();
    	 
    	 if(d1.trim().equals("") || d2.trim().equals("")) {
             JOptionPane.showMessageDialog(null,"���ڲ���Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
         }
    	 else{
       try{
             CaiWuDao.loadTable(dataTable, d1, d2);
             float m = CaiWuDao.getmoney(d1, d2);
             t.setText(String.valueOf(m));
       }catch(SQLException ex) {
           JOptionPane.showMessageDialog(null,"���ڸ�ʽ����ȷ","��ʾ",JOptionPane.WARNING_MESSAGE);
       }
     }
     }
     
     public void search2_actionPerformed(ActionEvent e){
    	 String n1 = this.name.getText().trim();
    	 String p1 = this.provider.getText().trim();
    	 float g = 0;
    	 
    	 if(n1.trim().equals("") && p1.trim().equals("")) {
             JOptionPane.showMessageDialog(null,"���ܶ�Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
         }
    	 else if(n1.trim().equals("")||!p1.trim().equals("")){
    		 CaiWuDao.loadTable3(dataTable, p1);
    		 g= CaiWuDao.getmoney2(p1);
    		 t.setText(String.valueOf(g));
    	 }
    	 
    	 else if(!n1.trim().equals("")||p1.trim().equals("")){
    		 CaiWuDao.loadTable2(dataTable, n1);
    		 g=CaiWuDao.getmoney(n1);
    		 t.setText(String.valueOf(g));
    	 }
    	 else{
    		 CaiWuDao.loadTable4(dataTable, n1, p1);
    		 g=CaiWuDao.getmoney1(n1, p1);
    		t.setText(String.valueOf(g));
    	 }
       
     
     }
}

class ZhiChuDialog_search_actionAdapter implements ActionListener {
    private ZhiChuDialog adaptee;
    ZhiChuDialog_search_actionAdapter(ZhiChuDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.search_actionPerformed(e);
    }
}

class ZhiChuDialog_search2_actionAdapter implements ActionListener {
    private ZhiChuDialog adaptee;
    ZhiChuDialog_search2_actionAdapter(ZhiChuDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.search2_actionPerformed(e);
    }
}

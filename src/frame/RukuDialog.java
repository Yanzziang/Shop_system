package frame;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.CaiDao;
import dao.DrugDao;
import vo.*;

public class RukuDialog extends JDialog{
	
	JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JTextField txtbar = new JTextField();
    String name,price,amount,spec,type1,unit,provider,caitime,username,expiredate,bar ,bb;
    
    
    JButton btnRu = new JButton();
    public RukuDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public RukuDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("���");
            columnName.add("��Ʒ��");
            columnName.add("�۸�");
            columnName.add("����");
            columnName.add("����");
            columnName.add("���");
            columnName.add("��λ");
            //columnName.add("��������");
            columnName.add("����ʱ��");
            columnName.add("������");
            columnName.add("��Ӧ��");
            columnName.add("��Ч����");
            columnName.add("�Ƿ����");

            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            table.setRowHeight(26);
            jScrollPane1.getViewport().add(table);

            table.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    Vector row = (Vector)rowData.elementAt(table.getSelectedRow());
                    name = row.elementAt(1).toString().trim();
                    price = row.elementAt(2).toString().trim();
                    amount = row.elementAt(3).toString().trim();
                    spec = row.elementAt(4).toString().trim();
                    type1 = row.elementAt(5).toString().trim();
                     unit = row.elementAt(6).toString().trim();
                    //producer = row.elementAt(7).toString().trim();
                    caitime = row.elementAt(7).toString().trim();
                    username = row.elementAt(8).toString().trim();
                    provider = row.elementAt(9).toString().trim();
                    expiredate = row.elementAt(10).toString().trim();
                    bb = row.elementAt(11).toString().trim();
                }
            });
            freshTable();
      }

      public void freshTable(){
          dao.CaiDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("��Ʒ���");
        this.getContentPane().setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 403));
        btnCancel.addActionListener(new RukuDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("������Ʒ��:");
        jLabel1.setBounds(new Rectangle(32, 440, 94, 25));
        txtbar.setBounds(new Rectangle(129, 438, 380, 30));
        //btnSearch.setBounds(new Rectangle(515, 436, 81, 23));
        //btnSearch.setText("��ѯ");
        //btnSearch.addActionListener(new MedicineSDialog_btnSearch_actionAdapter(this));
        btnRu.setBounds(new Rectangle(528, 436, 120, 30));
        btnRu.setText("���");
        btnRu.addActionListener(new RukuDialog_btnRu_actionAdapter(this));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtbar);
        this.getContentPane().add(btnRu);
       
        btnCancel.setBounds(new Rectangle(655, 436, 120, 30));
        btnCancel.setText("ȡ��");


        initTable();
        setSize(new Dimension(812, 511));
        util.FrameSet.showCenter(this);

    }
    
    
    
    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    	
   
    }
    
    public void btnRu_actionPerformed(ActionEvent e){
    	bar = txtbar.getText();
    	 ArrayList a1 = new ArrayList();
         ArrayList a2 = new ArrayList();
         a1 = DrugDao.getbarinruku();
         a2 = DrugDao.getgoodinruku();
         System.out.println(a1.contains(bar));
         System.out.println(a2.contains(bar));
         boolean b1 = a1.contains(bar);
         boolean b2 = a2.contains(name);
         
         if(bar.trim().equals("")) {
             JOptionPane.showMessageDialog(null,"������Ϣ����Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
         } else{
        	 
        	 
         try{
         if(b1==true&&b2!=true){
     		JOptionPane.showMessageDialog(null,"��������и���Ʒ�ţ�������Ʒ����ͬ","��ʾ",JOptionPane.WARNING_MESSAGE);
     	}
     	if(b1!=true&&b2==true){
     		JOptionPane.showMessageDialog(null,"��������и���Ʒ��������Ʒ�Ų���ͬ","��ʾ",JOptionPane.WARNING_MESSAGE);
     	}
     	if(b1==false&&b2==false){
         
     		Drug vo = new Drug();
            vo.setAmount(Integer.parseInt(amount));
            vo.setBarcode(bar);
            vo.setDrugname(name);
            vo.setIntime(caitime);
            vo.setExpiredate(Integer.parseInt(expiredate));
            vo.setUnit(unit);
            vo.setPrice(Float.parseFloat(price));
            vo.setProvider(provider);
            vo.setSpec(spec);
            vo.setType(type1);
            vo.setUsername(username);

             dao.DrugDao.add(vo);
             CaiDao.update(name);
             freshTable();
             JOptionPane.showMessageDialog(null,"������Ʒ�����ɹ�","��ʾ",JOptionPane.WARNING_MESSAGE);
     	}
     	
     	if(b1==true&&b2==true){
    		DrugDao.update(bar, name, Integer.valueOf(amount));
    		CaiDao.update(name);
    		 freshTable();
    		JOptionPane.showMessageDialog(null,"��Ʒ�ź���Ʒһ�£����ɹ�","��ʾ",JOptionPane.WARNING_MESSAGE);
    	}
    }catch(Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null,"���ʧ��","��ʾ",JOptionPane.WARNING_MESSAGE);
    }
  }
}
    	/*if(bb.equals("true")){
    		JOptionPane.showMessageDialog(null,"�ô��Ѿ����","��ʾ",JOptionPane.WARNING_MESSAGE);
    	}
    	else{
    	    bar = txtbar.getText();
    	    if(bar.equals("")){
    		     JOptionPane.showMessageDialog(null,"�����벻��Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
    	    }
    	    else{
        
    	
    	Drug vo = new Drug();
        vo.setAmount(Integer.parseInt(amount));
        vo.setBarcode(bar);
        vo.setDrugname(name);
        vo.setIntime(caitime);
        vo.setExpiredate(Integer.parseInt(expiredate));
        vo.setUnit(unit);
        vo.setPrice(Float.parseFloat(price));
        //vo.setProducer(producer);
        vo.setProvider(provider);
        vo.setSpec(spec);
        vo.setType(type1);
        vo.setUsername(username);
        
        DrugDao.getupdate(bar, (Integer.parseInt(amount)), vo);
     
        CaiDao.update(name);
        
        JOptionPane.showMessageDialog(null,"��ӳɹ�","��ʾ",JOptionPane.WARNING_MESSAGE);
        freshTable();
    	}
    }
    }*/
}

class RukuDialog_btnCancel_actionAdapter implements ActionListener {
    private RukuDialog adaptee;
    RukuDialog_btnCancel_actionAdapter(RukuDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

class RukuDialog_btnRu_actionAdapter implements ActionListener {
    private RukuDialog adaptee;
    RukuDialog_btnRu_actionAdapter(RukuDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnRu_actionPerformed(e);
    }
}

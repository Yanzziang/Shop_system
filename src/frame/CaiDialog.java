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

import dao.CaiDao;
import vo.*;
import frame.*;

public class CaiDialog extends JDialog {
	String cid,goodname,price,amount,type1,unit,time,man,provider,expiretime,spec;
	    JTable table = new JTable();
	    DefaultTableModel dataTable;
	    Vector columnName = new Vector();
	    Vector rowData =  new Vector();
	    JScrollPane jScrollPane1 = new JScrollPane();
	    JButton btnCancel = new JButton();
	    JLabel jLabel1 = new JLabel();
	    JTextField txtSearch = new JTextField();
	    JButton btnDe = new JButton();
	    JButton btnUp = new JButton();
	    JButton search = new JButton();
	    
	    JLabel good = new JLabel();
	    JTextField goodt = new JTextField();
	    JLabel code = new JLabel();
	    JTextField codet = new JTextField();
	    
	    public CaiDialog(Frame owner) {
	        super(owner, true);
	        try {
	            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	            jbInit();
	            pack();
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }

	    public CaiDialog() {
	        this(null);
	    }

	    public void initTable(){
	            columnName.add("���");
	            columnName.add("�ɹ����");
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
	            table.setRowHeight(24);
	            table.getColumnModel().getColumn(8).setPreferredWidth(110);
	            jScrollPane1.getViewport().add(table);
	            //JScrollPaneֻ��JViewport��������ǿ���������ʾ�������ģ�
	           //����Ҫ����JScrollPane����ʾ������ӽ�ȥ������ͱ��룬ʹ��getViewport().add(�������)�����������ˡ�
	            
	            table.addMouseListener(new MouseAdapter(){
	                public void mouseClicked(MouseEvent e) {
	                    Vector row = (Vector)rowData.elementAt(table.getSelectedRow());
	                    cid = row.elementAt(1).toString().trim();
	                    goodname = row.elementAt(2).toString().trim();
	                   price = row.elementAt(3).toString().trim();
	                   amount = row.elementAt(4).toString().trim();
	                   type1 = row.elementAt(5).toString().trim();
	                   unit = row.elementAt(6).toString().trim();
	                   spec = row.elementAt(7).toString().trim();
	                   time = row.elementAt(8).toString().trim();
	                   man = row.elementAt(9).toString().trim();
	                   provider =row.elementAt(10).toString().trim();
	                   expiretime = row.elementAt(11).toString().trim();
	                   
	                }
	            });

	            freshTable();
	      }

	      public void freshTable(){
	          dao.CaiDao.loadTable2(dataTable);
	   }

	    private void jbInit() throws Exception {
	        this.setTitle("�ɹ��б�");
	        this.getContentPane().setLayout(null);
	        //jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
	                                                  //HORIZONTAL_SCROLLBAR_ALWAYS);
	        jScrollPane1.setBounds(new Rectangle(19, 19, 840, 423));
	        btnCancel.addActionListener(new CaiDialog_btnCancel_actionAdapter(this));
	        //jLabel1.setText("������/��Ʒ��:");
	        //jLabel1.setBounds(new Rectangle(32, 440, 104, 15));
	        //txtSearch.setBounds(new Rectangle(135, 438, 352, 20));
	        good.setText("��Ʒ��");
	        good.setBounds(20, 460, 48, 32);
	        goodt.setBounds(73, 460, 160, 32);
	        code.setText("�ɹ����");
	        code.setBounds(248, 460, 65, 32);
	        codet.setBounds(318,460,160,32);
	        search.setText("��ѯ");
	        search.setBounds(489,460,81,32);
	        search.addActionListener(new CaiDialog_search_actionAdapter(this));
	        btnDe.setBounds(new Rectangle(585, 460, 81, 32));
	        btnDe.setText("ɾ��");
	        btnDe.addActionListener(new CaiDialog_btnDe_actionAdapter(this));
	        //btnSearch.addActionListener(new MedicineSDialog_btnSearch_actionAdapter(this));
	        btnUp.setBounds(new Rectangle(681, 460, 81, 32));
	        btnUp.setText("�޸�");
	        btnUp.addActionListener(new CaiDialog_btnUp_actionAdapter(this));
	        this.getContentPane().add(jScrollPane1);
	        this.getContentPane().add(btnCancel);
	        this.getContentPane().add(jLabel1);
	        this.getContentPane().add(good);
	        this.getContentPane().add(code);
	        this.getContentPane().add(goodt);
	        this.getContentPane().add(codet);
	        this.getContentPane().add(txtSearch);
	        this.getContentPane().add(btnUp);
	        this.getContentPane().add(search);
	        this.getContentPane().add(btnDe);
	        btnCancel.setBounds(new Rectangle(777, 460, 81, 32));
	        btnCancel.setText("ȡ��");


	        initTable();
	        setSize(new Dimension(895, 552));
	        util.FrameSet.showCenter(this);

	    }

	    public void btnCancel_actionPerformed(ActionEvent e) {
	        this.dispose();
	    }
	    
	    public void btnDe_actionPerformed(ActionEvent e) {
	        CaiDao.delete(cid);
	        freshTable();
	    }
	    
	    public void search_actionPerformed(ActionEvent e) {
	        
	    	String g = goodt.getText();
	    	String c = codet.getText().trim();
	    	//int c1 = Integer.valueOf(c);
	    	
	    	if(g.equals("")&&!c.equals("")){
	    		CaiDao.loadTable2(dataTable, Integer.valueOf(c));
	    	}
	    	if(!g.equals("")&&c.equals("")){
	    		CaiDao.loadTable2(dataTable, g);
	    	}
	    	if(!g.equals("")&&!c.equals("")){
	    		CaiDao.loadTable2(dataTable, g, Integer.valueOf(c));
	    	}
	    	
	    }
	    
	    public void btnUp_actionPerformed(ActionEvent e){
	    	Cai c = new Cai();
	    	c.setCid(Integer.parseInt(cid));
            c.setDrugname(goodname);
            c.setPrice(Float.parseFloat(price));
            c.setAmount(Integer.parseInt(amount));
            c.setType(type1);
            c.setSpec(spec);
            c.setUnit(unit);
            c.setCaitime(time);
            c.setUsername(man);
            c.setProvider(provider);
            c.setExpiredate(Integer.parseInt(expiretime));
             
            CaiUp caiup = new CaiUp(c);
            
            //caiup.getall(c);
            
       
	    	
	    }

	   /* public void btnAll_actionPerformed(ActionEvent e) {
	        dao.DrugDao.loadTable(dataTable);
	    }*/

	   /* public void btnSearch_actionPerformed(ActionEvent e) {
	        String search = this.txtSearch.getText().trim();

	        dao.DrugDao.loadTable(dataTable,search);
	        if (dataTable.getRowCount() == 0) {
	            JOptionPane.showMessageDialog(null,"û���ҵ�","��ʾ",JOptionPane.WARNING_MESSAGE);
	        }

	    }*/
	}


	/*class MedicineSDialog_btnSearch_actionAdapter implements ActionListener {
	    private MedicineSDialog adaptee;
	    MedicineSDialog_btnSearch_actionAdapter(MedicineSDialog adaptee) {
	        this.adaptee = adaptee;
	    }

	    public void actionPerformed(ActionEvent e) {
	        adaptee.btnSearch_actionPerformed(e);
	    }
	}*/


	class CaiDialog_btnCancel_actionAdapter implements ActionListener {
	    private CaiDialog adaptee;
	    CaiDialog_btnCancel_actionAdapter(CaiDialog adaptee) {
	        this.adaptee = adaptee;
	    }

	    public void actionPerformed(ActionEvent e) {
	        adaptee.btnCancel_actionPerformed(e);
	    }
	}

	class CaiDialog_btnUp_actionAdapter implements ActionListener {
	    private CaiDialog adaptee;
	    CaiDialog_btnUp_actionAdapter(CaiDialog adaptee) {
	        this.adaptee = adaptee;
	    }

	    public void actionPerformed(ActionEvent e) {
	        adaptee.btnUp_actionPerformed(e);
	    }
	}
	
	class CaiDialog_btnDe_actionAdapter implements ActionListener {
	    private CaiDialog adaptee;
	    CaiDialog_btnDe_actionAdapter(CaiDialog adaptee) {
	        this.adaptee = adaptee;
	    }

	    public void actionPerformed(ActionEvent e) {
	        adaptee.btnDe_actionPerformed(e);
	    }
	}
	
	class CaiDialog_search_actionAdapter implements ActionListener {
	    private CaiDialog adaptee;
	    CaiDialog_search_actionAdapter(CaiDialog adaptee) {
	        this.adaptee = adaptee;
	    }

	    public void actionPerformed(ActionEvent e) {
	        adaptee.search_actionPerformed(e);
	    }
	}

	/*class MedicineSDialog_btnAll_actionAdapter implements ActionListener {
	    private MedicineSDialog adaptee;
	    MedicineSDialog_btnAll_actionAdapter(MedicineSDialog adaptee) {
	        this.adaptee = adaptee;
	    }

	    public void actionPerformed(ActionEvent e) {
	        adaptee.btnAll_actionPerformed(e);
	    }
	}*/


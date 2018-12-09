package frame;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

import dao.SaleDao;
import dao.SunHuaiDao;

import java.util.Vector;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GuoQiSDialog extends JDialog {
    JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JButton btnSearch = new JButton();
    //JButton btnAll = new JButton();
    JButton btnde = new JButton();
    JButton btnNow = new JButton();
    String[] shtype = new String[]{"����","���","��ҩ"};
    JTextField txtSearch = new JTextField();
    
    String iid , barcode;
    String amount ;
    public GuoQiSDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public GuoQiSDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("���");
            columnName.add("�𻵱��");
            columnName.add("��Ʒ��");
            columnName.add("��Ʒ��");
            //columnName.add("�۸�");
            columnName.add("����");
            columnName.add("����");
            columnName.add("���");
            columnName.add("��λ");
            //columnName.add("�ṩ��");
            columnName.add("������");
            columnName.add("������");
            columnName.add("�Ǽ�ʱ��");

            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            table.setRowHeight(32);
            table.setBackground(Color.yellow);
            jScrollPane1.getViewport().add(table);
            
            table.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    Vector row = (Vector)rowData.elementAt(table.getSelectedRow());
                    iid = row.elementAt(1).toString().trim();
                    barcode = row.elementAt(2).toString().trim();
                    amount = row.elementAt(5).toString().trim();
                   
                }
            });

            freshTable();
      }

      public void freshTable(){
          dao.SunHuaiDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("�����б�");
        this.getContentPane().setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 403));
        jLabel1.setToolTipText("");
        jLabel1.setText("��Ʒ/��Ʒ��/������:");
        jLabel1.setBounds(new Rectangle(12, 435, 178, 15));
        btnSearch.setBounds(new Rectangle(438, 431, 81, 23));
        btnSearch.setText("��ѯ");
        btnSearch.addActionListener(new GuoQiSDialog_btnSearch_actionAdapter(this));
       /* btnAll.setBounds(new Rectangle(618, 430, 81, 23));
        btnAll.setText("ȫ��");
        btnAll.addActionListener(new GuoQiSDialog_btnAll_actionAdapter(this));*/
        
        btnde.setBounds(new Rectangle(618, 430, 81, 23));
        btnde.setText("ɾ��");
        btnde.addActionListener(new GuoQiSDialog_btnde_actionAdapter(this));
        
        btnNow.setBounds(new Rectangle(529, 430, 81, 23));
        btnNow.setText("����");
        btnNow.addActionListener(new GuoQiSDialog_btnNow_actionAdapter(this));
        btnCancel.addActionListener(new GuoQiSDialog_btnCancel_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(184, 432, 242, 20));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(btnNow);
        this.getContentPane().add(btnCancel);
        //this.getContentPane().add(btnAll);
        this.getContentPane().add(btnde);
        btnCancel.setBounds(new Rectangle(710, 430, 81, 23));
        btnCancel.setText("ȡ��");


        initTable();
        setSize(new Dimension(812, 518));
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnNow_actionPerformed(ActionEvent e) {
        String day = util.DateFormat.getDateStr();
        dao.SunHuaiDao.loadTable(dataTable,day);
    }

    public void btnAll_actionPerformed(ActionEvent e) {
        dao.SunHuaiDao.loadTable(dataTable);
    }
    
    //-----------------------------
    public void btnde_actionPerformed(ActionEvent e){
    	SunHuaiDao.delete(iid,barcode,Integer.valueOf(amount));
    	JOptionPane.showMessageDialog(null,"ɾ���ɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
    	SunHuaiDao.loadTable(dataTable);
    }

    public void btnSearch_actionPerformed(ActionEvent e) {
        /*String date1 = null.getText().trim();
        String date2 = null.getText().trim();
        String type = null.getSelectedItem().toString();

        try {
            dao.SunHuaiDao.loadTable(dataTable, date1, date2, type);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"���ڸ�ʽ����ȷ","��ʾ",JOptionPane.WARNING_MESSAGE);
        }*/
        String search = this.txtSearch.getText().trim();
        dao.SunHuaiDao.loadTableBySearch(dataTable, search);
    }
}


class GuoQiSDialog_btnde_actionAdapter implements ActionListener {
    private GuoQiSDialog adaptee;
    GuoQiSDialog_btnde_actionAdapter(GuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnde_actionPerformed(e);
    }
}

class GuoQiSDialog_btnSearch_actionAdapter implements ActionListener {
    private GuoQiSDialog adaptee;
    GuoQiSDialog_btnSearch_actionAdapter(GuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}


class GuoQiSDialog_btnNow_actionAdapter implements ActionListener {
    private GuoQiSDialog adaptee;
    GuoQiSDialog_btnNow_actionAdapter(GuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnNow_actionPerformed(e);
    }
}


class GuoQiSDialog_btnAll_actionAdapter implements ActionListener {
    private GuoQiSDialog adaptee;
    GuoQiSDialog_btnAll_actionAdapter(GuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAll_actionPerformed(e);
    }
}


class GuoQiSDialog_btnCancel_actionAdapter implements ActionListener {
    private GuoQiSDialog adaptee;
    GuoQiSDialog_btnCancel_actionAdapter(GuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

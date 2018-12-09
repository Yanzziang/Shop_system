package frame;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

import dao.SaleDao;

import java.util.Vector;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class SaleSDialog extends JDialog {
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
    JButton btngai = new JButton();
    JButton btnNow = new JButton();
    JTextField txtSearch = new JTextField();
    
    String barcode,sid;
    public SaleSDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SaleSDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("编号");
            columnName.add("销售单号");
            columnName.add("商品号");
            columnName.add("商品");
            columnName.add("价格");
            columnName.add("销售价格");
            columnName.add("数量");
            columnName.add("总金额");
            columnName.add("类型");
            columnName.add("规格");
            columnName.add("单位");
            columnName.add("供应商");
            columnName.add("销售时间");
            columnName.add("操作人");

            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            table.setRowHeight(27);

            jScrollPane1.getViewport().add(table);
            
            table.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    Vector row = (Vector)rowData.elementAt(table.getSelectedRow());
                    barcode = row.elementAt(2).toString().trim();
                    sid = row.elementAt(1).toString().trim();
                }
            });


            freshTable();
      }

      public void freshTable(){
          dao.SaleDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("商品销售查询");
        this.getContentPane().setLayout(null);
        //jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  //HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 403));
        jLabel1.setText("商品/商品号:");
        jLabel1.setBounds(new Rectangle(17, 439, 85, 15));
        btnSearch.setBounds(new Rectangle(310, 434, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new SaleSDialog_btnSearch_actionAdapter(this));
       /* btnAll.setBounds(new Rectangle(406, 434, 81, 23));
        btnAll.setText("全部");
        btnAll.addActionListener(new SaleSDialog_btnAll_actionAdapter(this));*/
        
        btnde.setBounds(new Rectangle(406, 434, 81, 23));
        btnde.setText("删除");
        btnde.addActionListener(new SaleSDialog_btnde_actionAdapter(this));
        btnNow.setBounds(new Rectangle(498, 434, 81, 23));
        btnNow.setText("当天");
        btnNow.addActionListener(new SaleSDialog_btnNow_actionAdapter(this));
        btnCancel.addActionListener(new SaleSDialog_btnCancel_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(102, 437, 188, 20));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(btnde);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnNow);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(btngai);
        btnCancel.setBounds(new Rectangle(596+81+17, 434, 81, 23));
        btnCancel.setText("取消");
        btngai.setBounds(new Rectangle(596, 434, 81, 23));
        btngai.setText("修改");


        initTable();
        setSize(new Dimension(812, 511));
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnNow_actionPerformed(ActionEvent e) {
        String day = util.DateFormat.getDateStr();
        dao.SaleDao.loadTable(dataTable,day);
    }

    public void btnAll_actionPerformed(ActionEvent e) {
        dao.SaleDao.loadTable(dataTable);
    }
    
    public void btnde_actionPerformed(ActionEvent e) {
    	SaleDao.de_lete(sid,barcode);
    	JOptionPane.showMessageDialog(null,"删除成功","成功",JOptionPane.INFORMATION_MESSAGE);
        SaleDao.loadTable(dataTable);
    }

    public void btnSearch_actionPerformed(ActionEvent e) {
        /*String date1 = null.getText().trim();
        String date2 = null.getText().trim();

        if(date1.trim().equals("") || date1.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"日期不能为空","提示",JOptionPane.WARNING_MESSAGE);
        }

        try {
            dao.SaleDao.loadTable(dataTable, date1, date2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"日期格式不正确","提示",JOptionPane.WARNING_MESSAGE);
        }*/
        String search = this.txtSearch.getText().trim();
        dao.SaleDao.loadTableByBarName(dataTable, search);

    }
}


class SaleSDialog_btnSearch_actionAdapter implements ActionListener {
    private SaleSDialog adaptee;
    SaleSDialog_btnSearch_actionAdapter(SaleSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}


class SaleSDialog_btnCancel_actionAdapter implements ActionListener {
    private SaleSDialog adaptee;
    SaleSDialog_btnCancel_actionAdapter(SaleSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class SaleSDialog_btnAll_actionAdapter implements ActionListener {
    private SaleSDialog adaptee;
    SaleSDialog_btnAll_actionAdapter(SaleSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAll_actionPerformed(e);
    }
}

class SaleSDialog_btnde_actionAdapter implements ActionListener {
    private SaleSDialog adaptee;
    SaleSDialog_btnde_actionAdapter(SaleSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnde_actionPerformed(e);
    }
}


class SaleSDialog_btnNow_actionAdapter implements ActionListener {
    private SaleSDialog adaptee;
    SaleSDialog_btnNow_actionAdapter(SaleSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnNow_actionPerformed(e);
    }
}

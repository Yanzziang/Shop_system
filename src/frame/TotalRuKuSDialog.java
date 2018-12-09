package frame;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * <p>Title: 超市销售管理系统</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class TotalRuKuSDialog extends JDialog {
    JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JTextField txtDate1 = new JTextField();
    JButton btnSearch = new JButton();
    JButton btnAll = new JButton();
    JTextField txtDate2 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JButton btnNow = new JButton();
    public TotalRuKuSDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public TotalRuKuSDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("条形码");
            columnName.add("商品名");
            columnName.add("价格");
            columnName.add("数量");
            columnName.add("类型");
            columnName.add("规格");
            columnName.add("单位");
            columnName.add("生产厂家");
            columnName.add("入库时间");
            columnName.add("操作人");
            columnName.add("提供商");
            columnName.add("有效日期");

            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            jScrollPane1.getViewport().add(table);

            freshTable();
      }

      public void freshTable(){
          dao.DrugDao.loadTable(dataTable);
   }


    private void jbInit() throws Exception {
        this.setTitle("入库统计");
        this.getContentPane().setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 403));
        jLabel1.setText("日期:");
        jLabel1.setBounds(new Rectangle(32, 440, 40, 15));
        txtDate1.setText("2010-01-01");
        txtDate1.setBounds(new Rectangle(76, 437, 86, 20));
        btnSearch.setBounds(new Rectangle(310, 434, 81, 23));
        btnSearch.setText("统计");
        btnSearch.addActionListener(new
                                    TotalRuKuSDialog_btnSearch_actionAdapter(this));
        btnAll.setBounds(new Rectangle(406, 434, 81, 23));
        btnAll.setText("全部");
        btnAll.addActionListener(new TotalRuKuSDialog_btnAll_actionAdapter(this));
        txtDate2.setText("2011-01-01");
        txtDate2.setBounds(new Rectangle(203, 436, 92, 20));
        jLabel2.setText("到");
        jLabel2.setBounds(new Rectangle(174, 438, 23, 15));
        btnNow.setBounds(new Rectangle(498, 434, 81, 23));
        btnNow.setText("当天");
        btnNow.addActionListener(new TotalRuKuSDialog_btnNow_actionAdapter(this));
        btnCancel.addActionListener(new
                                    TotalRuKuSDialog_btnCancel_actionAdapter(this));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtDate1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txtDate2);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(btnAll);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnNow);
        btnCancel.setBounds(new Rectangle(596, 434, 81, 23));
        btnCancel.setText("取消");


        initTable();
        setSize(new Dimension(812, 511));
        util.FrameSet.showCenter(this);

    }

    public void btnNow_actionPerformed(ActionEvent e) {
        String day = util.DateFormat.getDateStr();
        try {
            dao.DrugDao.loadTable(dataTable, day, null);
        } catch (SQLException ex) {
        }

    }

    public void btnAll_actionPerformed(ActionEvent e) {
        dao.DrugDao.loadTable(dataTable);
    }

    public void btnSearch_actionPerformed(ActionEvent e) {
        String date1 = this.txtDate1.getText().trim();
        String date2 = this.txtDate2.getText().trim();

        if(date1.trim().equals("") || date1.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"日期不能为空","提示",JOptionPane.WARNING_MESSAGE);
        }

        try {
            dao.DrugDao.loadTable(dataTable, date1, date2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"日期格式不正确","提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}


class TotalRuKuSDialog_btnCancel_actionAdapter implements ActionListener {
    private TotalRuKuSDialog adaptee;
    TotalRuKuSDialog_btnCancel_actionAdapter(TotalRuKuSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class TotalRuKuSDialog_btnSearch_actionAdapter implements ActionListener {
    private TotalRuKuSDialog adaptee;
    TotalRuKuSDialog_btnSearch_actionAdapter(TotalRuKuSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}


class TotalRuKuSDialog_btnAll_actionAdapter implements ActionListener {
    private TotalRuKuSDialog adaptee;
    TotalRuKuSDialog_btnAll_actionAdapter(TotalRuKuSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAll_actionPerformed(e);
    }
}


class TotalRuKuSDialog_btnNow_actionAdapter implements ActionListener {
    private TotalRuKuSDialog adaptee;
    TotalRuKuSDialog_btnNow_actionAdapter(TotalRuKuSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {

        adaptee.btnNow_actionPerformed(e);
    }
}

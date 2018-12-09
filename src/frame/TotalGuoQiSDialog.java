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
public class TotalGuoQiSDialog extends JDialog {
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
    JLabel jLabel3 = new JLabel();
    String[] shtype = new String[]{"过期","因故"};
    JComboBox cboType = new JComboBox(shtype);
    public TotalGuoQiSDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public TotalGuoQiSDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("编号");
            columnName.add("损坏编号");
            columnName.add("条形码");
            columnName.add("商品");
            columnName.add("价格");
            columnName.add("数量");
            columnName.add("类型");
            columnName.add("规格");
            columnName.add("单位");
            columnName.add("提供商");
            columnName.add("操作人");
            columnName.add("损坏类型");
            columnName.add("登记时间");

            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            jScrollPane1.getViewport().add(table);

            freshTable();
      }

      public void freshTable(){
          dao.SunHuaiDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("报损统计");
        this.getContentPane().setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 403));
        jLabel1.setText("日期:");
        jLabel1.setBounds(new Rectangle(21, 437, 40, 15));
        txtDate1.setText("2010-01-01");
        txtDate1.setBounds(new Rectangle(65, 434, 86, 20));
        btnSearch.setBounds(new Rectangle(515, 433, 81, 23));
        btnSearch.setText("统计");
        btnSearch.addActionListener(new
                                    TotalGuoQiSDialog_btnSearch_actionAdapter(this));
        btnAll.setBounds(new Rectangle(705, 433, 81, 23));
        btnAll.setText("全部");
        btnAll.addActionListener(new TotalGuoQiSDialog_btnAll_actionAdapter(this));
        txtDate2.setText("2011-01-01");
        txtDate2.setBounds(new Rectangle(192, 433, 92, 20));
        jLabel2.setText("到");
        jLabel2.setBounds(new Rectangle(163, 435, 23, 15));
        btnNow.setBounds(new Rectangle(611, 433, 81, 23));
        btnNow.setText("当天");
        btnNow.addActionListener(new TotalGuoQiSDialog_btnNow_actionAdapter(this));
        jLabel3.setText("报损类型:");
        jLabel3.setBounds(new Rectangle(302, 436, 71, 15));
        cboType.setBounds(new Rectangle(375, 434, 130, 20));
        btnCancel.addActionListener(new
                                    TotalGuoQiSDialog_btnCancel_actionAdapter(this));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(cboType);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtDate1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txtDate2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnNow);
        this.getContentPane().add(btnAll);
        btnCancel.setBounds(new Rectangle(703, 469, 81, 23));
        btnCancel.setText("取消");


        initTable();
        setSize(new Dimension(812, 558));
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

    public void btnSearch_actionPerformed(ActionEvent e) {
        String date1 = this.txtDate1.getText().trim();
        String date2 = this.txtDate2.getText().trim();
        String type = this.cboType.getSelectedItem().toString();

        try {
            dao.SunHuaiDao.loadTable(dataTable, date1, date2, type);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"日期格式不正确","提示",JOptionPane.WARNING_MESSAGE);
        }
    }
}


class TotalGuoQiSDialog_btnSearch_actionAdapter implements ActionListener {
    private TotalGuoQiSDialog adaptee;
    TotalGuoQiSDialog_btnSearch_actionAdapter(TotalGuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}


class TotalGuoQiSDialog_btnNow_actionAdapter implements ActionListener {
    private TotalGuoQiSDialog adaptee;
    TotalGuoQiSDialog_btnNow_actionAdapter(TotalGuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnNow_actionPerformed(e);
    }
}


class TotalGuoQiSDialog_btnAll_actionAdapter implements ActionListener {
    private TotalGuoQiSDialog adaptee;
    TotalGuoQiSDialog_btnAll_actionAdapter(TotalGuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAll_actionPerformed(e);
    }
}


class TotalGuoQiSDialog_btnCancel_actionAdapter implements ActionListener {
    private TotalGuoQiSDialog adaptee;
    TotalGuoQiSDialog_btnCancel_actionAdapter(TotalGuoQiSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

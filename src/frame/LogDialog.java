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

public class LogDialog extends JDialog {
    JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnClear = new JButton();
    JButton btnCancel = new JButton();

    public LogDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            begin();
            pack();//依据放置的组件设定窗口的大小 使之正好能容纳放置的所有组件
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public LogDialog() {
        this(null);
    }

    public void iTable(){
            columnName.add("编号");//向vector中添加元素
            //columnName.add("用户ID");
            columnName.add("用户名");
            columnName.add("操作内容");
            columnName.add("操作日期");
            //---表格模型使用一个 Vector 来存储单元格的值对象，通过DefaultTableModel可以对表格进行数据的增删改，
          //由表格模型来创建表格
            dataTable = new DefaultTableModel(rowData,columnName);//初始化
            table = new JTable(dataTable);//由表格模型来创建表格
            jScrollPane1.getViewport().add(table);


          /*table.addMouseListener(new MouseAdapter(){
              public void mouseClicked(MouseEvent e) {
                  Vector row = (Vector)rowData.elementAt(table.getSelectedRow());
                  txtID.setText(row.elementAt(0).toString().trim());
                  txtName2.setText(row.elementAt(1).toString().trim());
                  txtUserName.setText(row.elementAt(1).toString().trim());
                  txtPassword.setText(row.elementAt(2).toString().trim());
                  txtPower.setText(row.elementAt(3).toString().trim());
                  txtRemark.setText(row.elementAt(4).toString().trim());
              }
          });*/
          freshTable();
      }

      public void freshTable(){
          dao.LogDao.loadTable(dataTable);
   }

    private void begin() throws Exception {
        this.setTitle("日志信息");
        this.getContentPane().setLayout(null);
        jScrollPane1.setBounds(new Rectangle(19, 19, 628, 214));
        btnCancel.addActionListener(new LogDialog_btnCancel_actionAdapter(this));
        btnClear.addActionListener(new LogDialog_btnClear_actionAdapter(this));
        this.getContentPane().add(jScrollPane1);
        btnCancel.setBounds(new Rectangle(556, 249, 81, 23));
        btnCancel.setText("取消");
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnClear);
        btnClear.setBounds(new Rectangle(467, 251, 81, 23));
        btnClear.setText("清空");

        iTable();
        setSize(new Dimension(673, 318));
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnClear_actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null,"密码必须一致","提示",JOptionPane.WARNING_MESSAGE);
        int result = JOptionPane.showConfirmDialog(null,"清空日志是不可恢复的，是否要清空所有日子？","提示",JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            dao.LogDao.deleteAll();
            freshTable();
        }
    }
}


class LogDialog_btnClear_actionAdapter implements ActionListener {
    private LogDialog adaptee;
    LogDialog_btnClear_actionAdapter(LogDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnClear_actionPerformed(e);
    }
}


class LogDialog_btnCancel_actionAdapter implements ActionListener {
    private LogDialog adaptee;
    LogDialog_btnCancel_actionAdapter(LogDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

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


public class SupplierDialog extends JDialog {
    JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JButton btnDel = new JButton();
    JTextField txtID = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField txtName = new JTextField();
    public SupplierDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SupplierDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("编号");
            columnName.add("供应商编号");
            columnName.add("供应商名称");
            columnName.add("法人");
            columnName.add("联系电话");
            columnName.add("手机");
            columnName.add("用户传真");
            columnName.add("地址");
            columnName.add("备注");



            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            table.setRowHeight(28);
            jScrollPane1.getViewport().add(table);

            table.addMouseListener(new MouseAdapter(){
              public void mouseClicked(MouseEvent e) {
                  Vector row = (Vector)rowData.elementAt(table.getSelectedRow());
                  txtID.setText(row.elementAt(1).toString().trim());
                  txtName.setText(row.elementAt(2).toString().trim());
              }
          });

            freshTable();
      }

      public void freshTable(){
          dao.SupplierDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("供应商信息查询");
        this.getContentPane().setLayout(null);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 214));
        btnCancel.addActionListener(new SupplierDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("供应商编号:");
        jLabel1.setBounds(new Rectangle(26, 250, 88, 15));
        btnDel.setBounds(new Rectangle(608, 246, 81, 23));
        btnDel.setText("删除");
        btnDel.addActionListener(new SupplierDialog_btnDel_actionAdapter(this));
        txtID.setEditable(false);
        txtID.setBounds(new Rectangle(106, 247, 202, 20));
        jLabel2.setText("供应商名称:");
        jLabel2.setBounds(new Rectangle(332, 250, 83, 15));
        txtName.setEditable(false);
        txtName.setBounds(new Rectangle(404, 248, 183, 20));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtID);
        this.getContentPane().add(txtName);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(btnDel);
        this.getContentPane().add(btnCancel);
        btnCancel.setBounds(new Rectangle(705, 245, 81, 23));
        btnCancel.setText("取消");
        initTable();
        setSize(new Dimension(812, 318));
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnDel_actionPerformed(ActionEvent e) {
        String id = this.txtID.getText().trim();
        String name = this.txtName.getText().trim();

        if(id.equals("")) {
            JOptionPane.showMessageDialog(null,"请选中要删除的项","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }

        dao.SupplierDao.delete(id);
        txtID.setText("");
        txtName.setText("");
        freshTable();
    }
}


class SupplierDialog_btnDel_actionAdapter implements ActionListener {
    private SupplierDialog adaptee;
    SupplierDialog_btnDel_actionAdapter(SupplierDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnDel_actionPerformed(e);
    }
}


class SupplierDialog_btnCancel_actionAdapter implements ActionListener {
    private SupplierDialog adaptee;
    SupplierDialog_btnCancel_actionAdapter(SupplierDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

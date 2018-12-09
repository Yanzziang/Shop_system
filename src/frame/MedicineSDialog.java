package frame;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

import dao.DrugDao;

import java.util.Vector;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MedicineSDialog extends JDialog {
    JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JButton btnAll = new JButton();
    String name2;
    public MedicineSDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public MedicineSDialog() {
        this(null);
    }

    public void initTable(){
            columnName.add("��Ʒ��");
            columnName.add("��Ʒ��");
            columnName.add("�۸�");
            columnName.add("����");
            columnName.add("����");
            columnName.add("���");
            columnName.add("��λ");
            //columnName.add("��������");
            columnName.add("�������ʱ��");
            columnName.add("������");
            columnName.add("�ṩ��");
            columnName.add("��Ч����");

            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            table.setRowHeight(27);
            table.getColumnModel().getColumn(7).setPreferredWidth(110);
            jScrollPane1.getViewport().add(table);
            
            freshTable();
      }

      public void freshTable(){
          dao.DrugDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("������");
        this.getContentPane().setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(25, 25, 830, 520));
        btnCancel.addActionListener(new MedicineSDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("��Ʒ/��Ʒ��:");
        jLabel1.setBounds(new Rectangle(35, 575, 100, 30));
        txtSearch.setBounds(new Rectangle(140, 575, 352, 30));
        btnSearch.setBounds(new Rectangle(500, 575, 100, 30));
        btnSearch.setText("��ѯ");
        btnSearch.addActionListener(new MedicineSDialog_btnSearch_actionAdapter(this));
        btnAll.setBounds(new Rectangle(612, 575, 100, 30));
        btnAll.setText("ȫ��");
        btnAll.addActionListener(new MedicineSDialog_btnAll_actionAdapter(this));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnAll);
        this.getContentPane().add(btnSearch);
        btnCancel.setBounds(new Rectangle(724, 575, 100, 30));
        btnCancel.setText("ȡ��");


        initTable();
        setSize(new Dimension(890, 700));
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    	
    }

    public void btnAll_actionPerformed(ActionEvent e) {
        dao.DrugDao.loadTable(dataTable);
    }

    public void btnSearch_actionPerformed(ActionEvent e) {
        String search = this.txtSearch.getText().trim();

        dao.DrugDao.loadTable(dataTable,search);
        if (dataTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,"û���ҵ�","��ʾ",JOptionPane.WARNING_MESSAGE);
        }

    }
}


class MedicineSDialog_btnSearch_actionAdapter implements ActionListener {
    private MedicineSDialog adaptee;
    MedicineSDialog_btnSearch_actionAdapter(MedicineSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}


class MedicineSDialog_btnCancel_actionAdapter implements ActionListener {
    private MedicineSDialog adaptee;
    MedicineSDialog_btnCancel_actionAdapter(MedicineSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class MedicineSDialog_btnAll_actionAdapter implements ActionListener {
    private MedicineSDialog adaptee;
    MedicineSDialog_btnAll_actionAdapter(MedicineSDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAll_actionPerformed(e);
    }
}

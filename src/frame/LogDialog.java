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
            pack();//���ݷ��õ�����趨���ڵĴ�С ʹ֮���������ɷ��õ��������
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public LogDialog() {
        this(null);
    }

    public void iTable(){
            columnName.add("���");//��vector�����Ԫ��
            //columnName.add("�û�ID");
            columnName.add("�û���");
            columnName.add("��������");
            columnName.add("��������");
            //---���ģ��ʹ��һ�� Vector ���洢��Ԫ���ֵ����ͨ��DefaultTableModel���ԶԱ��������ݵ���ɾ�ģ�
          //�ɱ��ģ�����������
            dataTable = new DefaultTableModel(rowData,columnName);//��ʼ��
            table = new JTable(dataTable);//�ɱ��ģ�����������
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
        this.setTitle("��־��Ϣ");
        this.getContentPane().setLayout(null);
        jScrollPane1.setBounds(new Rectangle(19, 19, 628, 214));
        btnCancel.addActionListener(new LogDialog_btnCancel_actionAdapter(this));
        btnClear.addActionListener(new LogDialog_btnClear_actionAdapter(this));
        this.getContentPane().add(jScrollPane1);
        btnCancel.setBounds(new Rectangle(556, 249, 81, 23));
        btnCancel.setText("ȡ��");
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnClear);
        btnClear.setBounds(new Rectangle(467, 251, 81, 23));
        btnClear.setText("���");

        iTable();
        setSize(new Dimension(673, 318));
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnClear_actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null,"�������һ��","��ʾ",JOptionPane.WARNING_MESSAGE);
        int result = JOptionPane.showConfirmDialog(null,"�����־�ǲ��ɻָ��ģ��Ƿ�Ҫ����������ӣ�","��ʾ",JOptionPane.YES_NO_OPTION);
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

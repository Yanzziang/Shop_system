package frame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.*;
import dao.*;
import java.sql.*;
import java.awt.Rectangle;
import java.awt.Dimension;

public class SupplierAddDialog extends JDialog {
    public SupplierAddDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SupplierAddDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setTitle("供应商信息");
        jLabel1.setText("供应商名称:");
        jLabel1.setBounds(new Rectangle(32, 17, 77, 15));
        jLabel7.setText("备注:");
        jLabel7.setBounds(new Rectangle(39, 120, 42, 15));
        jLabel6.setText("地址:");
        jLabel6.setBounds(new Rectangle(273, 85, 42, 15));
        jLabel5.setText("传真:");
        jLabel5.setBounds(new Rectangle(273, 48, 42, 15));
        jLabel4.setText("手机:");
        jLabel4.setBounds(new Rectangle(272, 19, 42, 15));
        jLabel3.setText("联系电话:");
        jLabel3.setBounds(new Rectangle(37, 86, 56, 15));
        btnCancel.addActionListener(new
                                    SupplierAddDialog_btnCancel_actionAdapter(this));
        btnAdd.addActionListener(new SupplierAddDialog_btnAdd_actionAdapter(this));
        this.getContentPane().add(jLabel1);
        btnCancel.setBounds(new Rectangle(379, 157, 81, 23));
        btnCancel.setText("取消");
        btnAdd.setBounds(new Rectangle(282, 157, 81, 23));
        btnAdd.setText("添加");
        txtAddr.setBounds(new Rectangle(314, 84, 147, 20));
        txtTelc.setBounds(new Rectangle(313, 46, 148, 20));
        txtRemark.setText("");
        txtRemark.setBounds(new Rectangle(108, 117, 354, 20));
        txtPhone.setBounds(new Rectangle(108, 83, 147, 20));
        txtPerson.setBounds(new Rectangle(108, 49, 147, 20));
        txtTel.setBounds(new Rectangle(312, 16, 150, 20));
        txtName.setBounds(new Rectangle(106, 16, 149, 20));
        this.getContentPane().add(txtName);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(txtPerson);
        this.getContentPane().add(txtPhone);
        this.getContentPane().add(txtRemark);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txtTel);
        this.getContentPane().add(txtTelc);
        this.getContentPane().add(txtAddr);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnAdd);
        jLabel2.setText("法人:");
        jLabel2.setBounds(new Rectangle(42, 51, 42, 15));

        setSize(new Dimension(489, 241));
        util.FrameSet.showCenter(this);
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnAdd_actionPerformed(ActionEvent e) {
        String addr = this.txtAddr.getText().trim();
        String name = this.txtName.getText().trim();
        String person = this.txtPerson.getText().trim();
        String phone = this.txtPhone.getText().trim();
        String remark = this.txtRemark.getText().trim();
        String tel = this.txtTel.getText().trim();
        String telc = this.txtTelc.getText().trim();

        if(person.length() < 1 || phone.length() < 1 || addr.length() < 1 || name.equals("") ) {
            JOptionPane.showMessageDialog(null,"信息不能为空。","提示",JOptionPane.WARNING_MESSAGE);
        }  else {
            Supplier supp = new Supplier();
            supp.setAddr(addr);
            supp.setName(name);
            supp.setPerson(person);
            supp.setPhone(phone);
            supp.setRemark(remark);
            supp.setTel(tel);
            supp.setTelc(telc);

            try {
                SupplierDao.add(supp);
                JOptionPane.showMessageDialog(null,"添加成功.","提示",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"供应商已存在或数据不正确，添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JTextField txtName = new JTextField();
    JTextField txtTel = new JTextField();
    JTextField txtPerson = new JTextField();
    JTextField txtPhone = new JTextField();
    JTextField txtRemark = new JTextField();
    JTextField txtTelc = new JTextField();
    JTextField txtAddr = new JTextField();
    JButton btnAdd = new JButton();
    JButton btnCancel = new JButton();
}


class SupplierAddDialog_btnAdd_actionAdapter implements ActionListener {
    private SupplierAddDialog adaptee;
    SupplierAddDialog_btnAdd_actionAdapter(SupplierAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}


class SupplierAddDialog_btnCancel_actionAdapter implements ActionListener {
    private SupplierAddDialog adaptee;
    SupplierAddDialog_btnCancel_actionAdapter(SupplierAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

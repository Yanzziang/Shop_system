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

public class GuoQiAddDialog extends JDialog {
    public GuoQiAddDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public GuoQiAddDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setTitle("报废");
        btnCancel.setBounds(new Rectangle(358, 237, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new GuoQiAddDialog_btnCancel_actionAdapter(this));
        jLabel11.setText("商品号:");
        jLabel11.setBounds(new Rectangle(26, 25, 48, 15));
        txtSearch.setBounds(new Rectangle(82, 22, 304, 20));
        btnSearch.setBounds(new Rectangle(397, 20, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new GuoQiAddDialog_btnSearch_actionAdapter(this));
        btnOk.setBounds(new Rectangle(256, 238, 81, 23));
        btnOk.setText("确定");
        btnOk.addActionListener(new GuoQiAddDialog_jButton1_actionAdapter(this));
        txtBarcode.setEditable(false);
        txtBarcode.setBounds(new Rectangle(82, 64, 147, 20));
        txtName.setEditable(false);
        txtName.setBounds(new Rectangle(82, 100, 147, 20));
       /* txtPrice.setEditable(false);
        txtPrice.setBounds(new Rectangle(82, 133, 147, 20));*/
        txtMount.setToolTipText("");
        txtMount.setEditable(false);
        txtMount.setText("1");
        txtMount.setBounds(new Rectangle(82, 133, 147, 20));
        txtType.setEditable(false);
        txtType.setBounds(new Rectangle(316, 133, 169, 20));
        txtSpec.setEditable(false);
        txtSpec.setBounds(new Rectangle(316, 64, 169, 20));
        txtUnit.setEditable(false);
        txtUnit.setBounds(new Rectangle(316, 100, 169, 20));
        //txtProducer.setEditable(false);
        //txtProducer.setBounds(new Rectangle(316, 133, 169, 20));
        txtUsername.setEditable(false);
        txtUsername.setBounds(new Rectangle(316, 166, 169, 20));
        jLabel10.setText("损坏类型:");
        jLabel10.setBounds(new Rectangle(17, 246, 71, 15));
        jLabel9.setText("操作员:");
        jLabel9.setBounds(new Rectangle(258, 170, 42, 15));
        //jLabel8.setText("生产厂家:");
        //jLabel8.setBounds(new Rectangle(251, 135, 70, 15));
        jLabel7.setText("单位:");
        jLabel7.setBounds(new Rectangle(258, 104, 42, 15));
        jLabel6.setText("规格:");
        jLabel6.setBounds(new Rectangle(258, 66, 42, 15));
        jLabel5.setText("类型:");
        jLabel5.setBounds(new Rectangle(251, 135, 70, 15));
        jLabel4.setText("商品名:");
        jLabel4.setBounds(new Rectangle(26, 104, 42, 15));
        jLabel3.setText("数量:");
        jLabel3.setBounds(new Rectangle(21, 135, 68, 15));
        /*jLabel2.setText("进货价格:");
        jLabel2.setBounds(new Rectangle(21, 135, 68, 15));*/
        cboType.setBounds(new Rectangle(82, 241, 147, 20));
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(txtPrice);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(txtMount);
        this.getContentPane().add(txtType);
        this.getContentPane().add(txtSpec);
        this.getContentPane().add(txtUnit);
        //this.getContentPane().add(txtProducer);
        this.getContentPane().add(txtUsername);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel7);
        //this.getContentPane().add(jLabel8);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(cboType);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(btnOk);
        this.getContentPane().add(btnCancel);
        jLabel1.setText("商品号:");
        jLabel1.setBounds(new Rectangle(25, 66, 42, 15));

        setSize(new Dimension(509, 317));
        util.FrameSet.showCenter(this);
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    /*public void btnAdd_actionPerformed(ActionEvent e) {
        String addr = null.getText().trim();
        String name = null.getText().trim();
        String person = null.getText().trim();
        String phone = null.getText().trim();
        String remark = null.getText().trim();
        String tel = null.getText().trim();
        String telc = null.getText().trim();

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
    }*/

    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    //JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JButton btnOk = new JButton();
    JTextField txtBarcode = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextField txtMount = new JTextField();
    JTextField txtType = new JTextField();
    JTextField txtSpec = new JTextField();
    JTextField txtUnit = new JTextField();
    //JTextField txtProducer = new JTextField();
    JTextField txtUsername = new JTextField();
    String[] shtype = new String[]{"过期","因故"};
    JComboBox cboType = new JComboBox(shtype);
    public void btnSearch_actionPerformed(ActionEvent e) {
        String barcode = this.txtSearch.getText().trim();

        if(barcode.equals("")){
            JOptionPane.showMessageDialog(null,"信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            Drug vo = DrugDao.getDrugByBarcode(barcode);

            if(vo == null) {
                JOptionPane.showMessageDialog(null,"没有找到","提示",JOptionPane.WARNING_MESSAGE);
                return;
            }

            this.txtBarcode.setText(vo.getBarcode());
            //this.txtMount.setText(String.valueOf(vo.getAmount()));

            this.txtName.setText(vo.getDrugname());
            //this.txtPrice.setText(String.valueOf(vo.getPrice()));
            //this.txtProducer.setText(vo.getProducer());
            this.txtSpec.setText(vo.getSpec());
            this.txtType.setText(vo.getType());
            this.txtUnit.setText(vo.getUnit());
            this.txtUsername.setText(vo.getUsername());
        }

    }

    public void btnOk_actionPerformed(ActionEvent e) {
        String barcode = this.txtBarcode.getText().trim();
        String shtype = this.cboType.getSelectedItem().toString();

       if(barcode.equals("")) {
           JOptionPane.showMessageDialog(null,"条形码信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
           return ;
       } else {
           String bar = this.txtBarcode.getText().trim();
           String mount = this.txtMount.getText().trim();
           String name = this.txtName.getText().trim();
           //String price = this.txtPrice.getText().trim();
           //String producer = this.txtProducer.getText().trim();
           String spec = this.txtSpec.getText().trim();
           String type = this.txtType.getText().trim();
           String unit = this.txtUnit.getText().trim();
           //String username = this.txtUsername.getText().trim();
           String username = util.UserInfo.getUser().getUsername();

           try{
               Drug vo = new Drug();
               vo.setAmount(Integer.parseInt(mount));
               vo.setBarcode(bar);
               vo.setDrugname(name);
               vo.setUnit(unit);
               //vo.setPrice(Float.parseFloat(price));
               //vo.setProducer(producer);
               vo.setSpec(spec);
               vo.setType(type);
               vo.setUsername(username);

               dao.SunHuaiDao.add(vo,shtype);
               JOptionPane.showMessageDialog(null,"操作成功","提示",JOptionPane.WARNING_MESSAGE);
           } catch(Exception ex) {
               ex.printStackTrace();
               JOptionPane.showMessageDialog(null,"数据错误，操作失败","提示",JOptionPane.WARNING_MESSAGE);
           }

       }

    }

}


class GuoQiAddDialog_jButton1_actionAdapter implements ActionListener {
    private GuoQiAddDialog adaptee;
    GuoQiAddDialog_jButton1_actionAdapter(GuoQiAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnOk_actionPerformed(e);
    }
}


class GuoQiAddDialog_btnCancel_actionAdapter implements ActionListener {
    private GuoQiAddDialog adaptee;
    GuoQiAddDialog_btnCancel_actionAdapter(GuoQiAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class GuoQiAddDialog_btnSearch_actionAdapter implements ActionListener {
    private GuoQiAddDialog adaptee;
    GuoQiAddDialog_btnSearch_actionAdapter(GuoQiAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}

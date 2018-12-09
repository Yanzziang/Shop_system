package frame;

import java.awt.*;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DrugDao;
import vo.Drug;


public class MedicineAddDialog extends JDialog {
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JTextField txtBarcode = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextField txtMount = new JTextField();
    JTextField txtType = new JTextField();
    JTextField txtSpec = new JTextField();
    JTextField txtUnit = new JTextField();
    JTextField txtProducer = new JTextField();
    JTextField txtIntime = new JTextField();
    JTextField txtUserid = new JTextField();
    JTextField txtExpiredate = new JTextField();
    JComboBox cboProvider = new JComboBox(dao.SupplierDao.getAllSupplierName());
    //JComboBox cboProvider = new JComboBox();
    JButton btnAdd = new JButton();
    public MedicineAddDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public MedicineAddDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("商品入库");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(489, 200, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new
                                    MedicineAddDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("条形码:");
        jLabel1.setBounds(new Rectangle(32, 16, 42, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(29, 45, 42, 15));
        jLabel3.setText("进货价格/元:");
        jLabel3.setBounds(new Rectangle(5, 80, 73, 15));
        jLabel4.setText("数量:");
        jLabel4.setBounds(new Rectangle(319, 142, 42, 15));
        jLabel5.setText("类型:");
        jLabel5.setBounds(new Rectangle(29, 112, 42, 15));
        jLabel6.setText("规格:");
        jLabel6.setBounds(new Rectangle(31, 141, 42, 15));
        jLabel7.setText("单位:");
        jLabel7.setBounds(new Rectangle(34, 173, 42, 15));
        jLabel8.setText("生产厂家:");
        jLabel8.setBounds(new Rectangle(306, 16, 66, 15));
        jLabel9.setText("进货时间:");
        jLabel9.setBounds(new Rectangle(306, 48, 64, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(319, 168, 48, 15));
        jLabel11.setText("供应商:");
        jLabel11.setBounds(new Rectangle(311, 74, 48, 15));
        jLabel12.setText("有效日期/年:");
        jLabel12.setBounds(new Rectangle(296, 107, 92, 15));
        txtBarcode.setBounds(new Rectangle(83, 14, 190, 20));
        txtName.setBounds(new Rectangle(83, 46, 190, 20));
        txtPrice.setText("0");
        txtPrice.setBounds(new Rectangle(83, 78, 190, 20));
        txtMount.setText("0");
        txtMount.setBounds(new Rectangle(374, 135, 198, 20));
        txtType.setBounds(new Rectangle(82, 109, 189, 20));
        txtSpec.setBounds(new Rectangle(82, 139, 189, 20));
        txtUnit.setBounds(new Rectangle(82, 170, 189, 20));
        txtProducer.setBounds(new Rectangle(375, 12, 201, 20));
        txtIntime.setText("2010-1-11");
        txtIntime.setEditable(false);
        txtIntime.setBounds(new Rectangle(376, 42, 200, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(372, 163, 200, 20));
        txtExpiredate.setText("0");
        txtExpiredate.setBounds(new Rectangle(376, 104, 199, 20));
        cboProvider.setBounds(new Rectangle(375, 72, 200, 20));
        btnAdd.setBounds(new Rectangle(387, 200, 81, 23));
        btnAdd.setText("入库");
        btnAdd.addActionListener(new MedicineAddDialog_btnAdd_actionAdapter(this));
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txtName);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(txtPrice);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(txtProducer);
        this.getContentPane().add(txtIntime);
        this.getContentPane().add(txtType);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(txtUnit);
        this.getContentPane().add(txtSpec);
        this.getContentPane().add(txtExpiredate);
        this.getContentPane().add(cboProvider);
        this.getContentPane().add(txtMount);
        this.getContentPane().add(txtUserid);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(jLabel12);
        



        setSize(new Dimension(604, 282));
        txtIntime.setText(util.DateFormat.getDateStr());
        txtUserid.setText(util.UserInfo.getUser().getUsername());
        util.FrameSet.showCenter(this);

    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnAdd_actionPerformed(ActionEvent e) {
        String bar = this.txtBarcode.getText().trim();
        String edate = this.txtExpiredate.getText().trim();
        String intime = this.txtIntime.getText().trim();
        String mount = this.txtMount.getText().trim();
        String name = this.txtName.getText().trim();
        String price = this.txtPrice.getText().trim();
        //String producer = this.txtProducer.getText().trim();
        String spec = this.txtSpec.getText().trim();
        String unit = this.txtUnit.getText().trim();
        String type = this.txtType.getText().trim();
        String username = this.txtUserid.getText().trim();
        String provider = cboProvider.getSelectedItem().toString();
        
        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList();
        a1 = DrugDao.getbarinruku();
        a2 = DrugDao.getgoodinruku();
        //boolean b1 = DrugDao.isbar(bar, a1);
        //boolean b2 = DrugDao.isgood(name, a2);
        
        
        if(bar.trim().equals("")|| name.trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"部分信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else {
        	
        	
            try{
                Drug vo = new Drug();
                vo.setAmount(Integer.parseInt(mount));
                vo.setBarcode(bar);
                vo.setDrugname(name);
                vo.setIntime(intime);
                vo.setExpiredate(Integer.parseInt(edate));
                vo.setUnit(unit);
                vo.setPrice(Float.parseFloat(price));
                //vo.setProducer(producer);
                vo.setProvider(provider);
                vo.setSpec(spec);
                vo.setType(type);
                vo.setUsername(username);

                dao.DrugDao.add(vo);
                JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.WARNING_MESSAGE);
            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
            //vo.setRkid();
        }
    }
}


class MedicineAddDialog_btnAdd_actionAdapter implements ActionListener {
    private MedicineAddDialog adaptee;
    MedicineAddDialog_btnAdd_actionAdapter(MedicineAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}


class MedicineAddDialog_btnCancel_actionAdapter implements ActionListener {
    private MedicineAddDialog adaptee;
    MedicineAddDialog_btnCancel_actionAdapter(MedicineAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

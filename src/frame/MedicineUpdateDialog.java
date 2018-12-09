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
import vo.Drug;
import dao.DrugDao;


public class MedicineUpdateDialog extends JDialog {
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
    JButton btnUpdate = new JButton();
    JLabel jLabel13 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JTextField txtProvider = new JTextField();
    JButton btnDel = new JButton();
    public MedicineUpdateDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public MedicineUpdateDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("库存修改");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(488, 233, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new
                MedicineUpdateDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("商品号:");
        jLabel1.setBounds(new Rectangle(31, 49, 42, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(28, 78, 42, 15));
        jLabel3.setText("进货价格/元:");
        jLabel3.setBounds(new Rectangle(4, 113, 73, 15));
        jLabel4.setText("数量:");
        jLabel4.setBounds(new Rectangle(318, 175, 42, 15));
        jLabel5.setText("类型:");
        jLabel5.setBounds(new Rectangle(28, 145, 42, 15));
        jLabel6.setText("规格:");
        jLabel6.setBounds(new Rectangle(30, 174, 42, 15));
        jLabel7.setText("单位:");
        jLabel7.setBounds(new Rectangle(33, 206, 42, 15));
        //jLabel8.setText("生产厂家:");
        //jLabel8.setBounds(new Rectangle(305, 49, 66, 15));
        jLabel9.setText("进货时间:");
        jLabel9.setBounds(new Rectangle(305, 81, 64, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(318, 201, 48, 15));
        jLabel11.setText("供应商:");
        jLabel11.setBounds(new Rectangle(310, 107, 48, 15));
        jLabel12.setText("有效日期/年:");
        jLabel12.setBounds(new Rectangle(295, 140, 92, 15));
        txtBarcode.setEditable(false);
        txtBarcode.setBounds(new Rectangle(82, 47, 190, 20));
        txtName.setBounds(new Rectangle(82, 79, 190, 20));
        txtPrice.setText("0");
        txtPrice.setBounds(new Rectangle(82, 111, 190, 20));
        txtMount.setText("0");
        txtMount.setBounds(new Rectangle(373, 168, 198, 20));
        txtType.setBounds(new Rectangle(81, 142, 189, 20));
        txtSpec.setBounds(new Rectangle(81, 172, 189, 20));
        txtUnit.setBounds(new Rectangle(81, 203, 189, 20));
        //txtProducer.setBounds(new Rectangle(374, 45, 201, 20));
        txtIntime.setText("2017-4-21");
        txtIntime.setEditable(false);
        txtIntime.setBounds(new Rectangle(375, 75, 200, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(371, 196, 200, 20));
        txtExpiredate.setText("0");
        txtExpiredate.setBounds(new Rectangle(375, 137, 199, 20));
        btnUpdate.setBounds(new Rectangle(292, 233, 81, 23));
        btnUpdate.setText("修改");
        btnUpdate.addActionListener(new
                MedicineUpdateDialog_btnUpdate_actionAdapter(this));
        btnSearch.setBounds(new Rectangle(473, 13, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new
                MedicineUpdateDialog_btnSearch_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(84, 15, 368, 20));
        jLabel13.setText("商品号:");
        jLabel13.setBounds(new Rectangle(30, 18, 48, 15));
        txtProvider.setBounds(new Rectangle(375, 107, 198, 20));
        btnDel.setBounds(new Rectangle(393, 233, 81, 23));
        btnDel.setText("删除");
        btnDel.addActionListener(new MedicineUpdateDialog_btnDel_actionAdapter(this));
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtPrice);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel8);
        //this.getContentPane().add(txtProducer);
        this.getContentPane().add(txtIntime);
        this.getContentPane().add(txtType);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(txtUnit);
        this.getContentPane().add(txtSpec);
        this.getContentPane().add(txtExpiredate);
        this.getContentPane().add(txtMount);
        this.getContentPane().add(txtUserid);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(jLabel12);
        this.getContentPane().add(txtProvider);
        this.getContentPane().add(btnUpdate);
        this.getContentPane().add(btnDel);
        setSize(new Dimension(604, 320));
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
        String provider = this.txtProvider.toString();

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
        }
    }

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
            this.txtExpiredate.setText(String.valueOf(vo.getExpiredate()));
            this.txtIntime.setText(vo.getIntime());
            this.txtMount.setText(String.valueOf(vo.getAmount()));
            this.txtName.setText(vo.getDrugname());
            this.txtPrice.setText(String.valueOf(vo.getPrice()));
            //this.txtProducer.setText(vo.getProducer());
            this.txtProvider.setText(vo.getProvider());
            this.txtSpec.setText(vo.getSpec());
            this.txtType.setText(vo.getType());
            this.txtUnit.setText(vo.getUnit());
            this.txtUserid.setText(vo.getUsername());
        }

    }

    public void btnUpdate_actionPerformed(ActionEvent e) {
        String barcode = this.txtBarcode.getText().trim();

        if(barcode.equals("")) {
            JOptionPane.showMessageDialog(null,"条形码信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            String bar = this.txtBarcode.getText().trim();
            String edate = this.txtExpiredate.getText().trim();
            String intime = this.txtIntime.getText().trim();
            String mount = this.txtMount.getText().trim();
            String name = this.txtName.getText().trim();
            String price = this.txtPrice.getText().trim();
            String producer = this.txtProducer.getText().trim();
            String provider = this.txtProvider.getText().trim();
            String spec = this.txtSpec.getText().trim();
            String type = this.txtType.getText().trim();
            String unit = this.txtUnit.getText().trim();
            String username = this.txtUserid.getText().trim();

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

                dao.DrugDao.update(vo);
                JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.WARNING_MESSAGE);
            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"数据错误，修改失败","提示",JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    public void btnDel_actionPerformed(ActionEvent e) {
        String barcode = this.txtBarcode.getText().trim();

        if(barcode.equals("")) {
            JOptionPane.showMessageDialog(null,"条形码信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }

        dao.DrugDao.delete(barcode);
        this.txtBarcode.setText("");
        JOptionPane.showMessageDialog(null,"操作成功","提示",JOptionPane.WARNING_MESSAGE);
    }
}


class MedicineUpdateDialog_btnDel_actionAdapter implements ActionListener {
    private MedicineUpdateDialog adaptee;
    MedicineUpdateDialog_btnDel_actionAdapter(MedicineUpdateDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnDel_actionPerformed(e);
    }
}


class MedicineUpdateDialog_btnCancel_actionAdapter implements ActionListener {
    private MedicineUpdateDialog adaptee;
    MedicineUpdateDialog_btnCancel_actionAdapter(MedicineUpdateDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class MedicineUpdateDialog_btnUpdate_actionAdapter implements ActionListener {
    private MedicineUpdateDialog adaptee;
    MedicineUpdateDialog_btnUpdate_actionAdapter(MedicineUpdateDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnUpdate_actionPerformed(e);
    }
}


class MedicineUpdateDialog_btnSearch_actionAdapter implements ActionListener {
    private MedicineUpdateDialog adaptee;
    MedicineUpdateDialog_btnSearch_actionAdapter(MedicineUpdateDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}

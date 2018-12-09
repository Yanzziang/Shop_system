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
import vo.*;
import dao.DrugDao;
import dao.SaleDao;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.*;


public class SaleAddDialog extends JDialog {
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
    JButton btnAdd = new JButton();
    JLabel jLabel13 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JTextField txtProvider = new JTextField();
    JLabel jLabel14 = new JLabel();
    JTextField txtMount2 = new JTextField();
    JLabel jLabel15 = new JLabel();
    JLabel jLabel16 = new JLabel();
    JTextField txtSum = new JTextField();
    JTextField txtprice = new JTextField();
    JButton btnBank = new JButton();
    public SaleAddDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SaleAddDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("商品销售");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(488, 285, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new SaleAddDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("商品号:");
        jLabel1.setBounds(new Rectangle(29, 60, 42, 15));
        jLabel16.setText("进货价格:");
        jLabel16.setBounds(new Rectangle(303, 60, 64, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(26, 89, 42, 15));
        jLabel3.setText("销售价格:");
        jLabel3.setBounds(new Rectangle(7, 124, 73, 15));
        jLabel4.setText("剩数量:");
        jLabel4.setBounds(new Rectangle(316, 186, 42, 15));
        jLabel5.setText("类型:");
        jLabel5.setBounds(new Rectangle(26, 156, 42, 15));
        jLabel6.setText("规格:");
        jLabel6.setBounds(new Rectangle(28, 185, 42, 15));
        jLabel7.setText("单位:");
        jLabel7.setBounds(new Rectangle(31, 217, 42, 15));
        //jLabel8.setText("生产厂家:");
        //jLabel8.setBounds(new Rectangle(303, 60, 66, 15));
        jLabel9.setText("销售时间:");
        jLabel9.setBounds(new Rectangle(303, 92, 64, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(316, 212, 48, 15));
        jLabel11.setText("供应商:");
        jLabel11.setBounds(new Rectangle(308, 118, 48, 15));
        jLabel12.setText("有效日期/年:");
        jLabel12.setBounds(new Rectangle(293, 151, 92, 15));
        txtBarcode.setEditable(false);
        txtBarcode.setBounds(new Rectangle(80, 58, 190, 20));
        txtprice.setEditable(false);
        txtprice.setBounds(new Rectangle(372, 58, 190, 20));
        txtName.setEditable(false);
        txtName.setBounds(new Rectangle(80, 90, 190, 20));
        
        txtPrice.setEditable(false);
        txtPrice.setText("0.0");
        txtPrice.setBounds(new Rectangle(80, 122, 190, 20));
        txtMount.setEditable(false);
        txtMount.setBounds(new Rectangle(371, 179, 198, 20));
        txtType.setEditable(false);
        txtType.setBounds(new Rectangle(79, 153, 189, 20));
        txtSpec.setEditable(false);
        txtSpec.setBounds(new Rectangle(79, 183, 189, 20));
        txtUnit.setEditable(false);
        txtUnit.setBounds(new Rectangle(79, 214, 189, 20));
        txtProducer.setEditable(false);
        txtProducer.setBounds(new Rectangle(372, 56, 201, 20));
        txtIntime.setEditable(false);
        txtIntime.setBounds(new Rectangle(373, 86, 200, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(369, 207, 200, 20));
        txtExpiredate.setEditable(false);
        txtExpiredate.setBounds(new Rectangle(373, 148, 199, 20));
        btnAdd.setBounds(new Rectangle(384, 286, 81, 23));
        btnAdd.setText("付款");
        btnAdd.addActionListener(new SaleAddDialog_btnAdd_actionAdapter(this));
        btnSearch.setBounds(new Rectangle(487, 20, 81, 23));
        btnSearch.setText("查找");
        btnSearch.addActionListener(new SaleAddDialog_btnSearch_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(79, 21, 393, 20));
        jLabel13.setText("商品号:");
        jLabel13.setBounds(new Rectangle(29, 23, 48, 15));
        txtProvider.setEditable(false);
        txtProvider.setBounds(new Rectangle(373, 120, 195, 20));
        jLabel14.setText("购买数量:");
        jLabel14.setBounds(new Rectangle(265, 251, 62, 15));
        txtMount2.setText("0");
        txtMount2.setBounds(new Rectangle(328, 247, 77, 20));
        txtMount2.addKeyListener(new SaleAddDialog_txtMount2_keyAdapter(this));
        jLabel15.setText("总金额:");
        jLabel15.setBounds(new Rectangle(434, 250, 48, 15));
        txtSum.setEditable(false);
        txtSum.setText("0.0");
        txtSum.setBounds(new Rectangle(493, 247, 77, 20));
        //btnBank.setBounds(new Rectangle(212, 285, 81, 23));
        //btnBank.setText("网银付款");
        //btnBank.addActionListener(new SaleAddDialog_btnBank_actionAdapter(this));
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(txtSpec);
        this.getContentPane().add(txtPrice);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txtName);
        this.getContentPane().add(jLabel3);
       this.getContentPane().add(jLabel16);
        this.getContentPane().add(txtprice);
        this.getContentPane().add(txtIntime);
        this.getContentPane().add(txtType);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(txtUnit);
        this.getContentPane().add(txtExpiredate);
        this.getContentPane().add(txtMount);
        this.getContentPane().add(txtUserid);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(jLabel12);
        this.getContentPane().add(txtProvider);
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(txtSum);
        this.getContentPane().add(jLabel14);
        this.getContentPane().add(txtMount2);
        this.getContentPane().add(jLabel15);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(btnCancel);
        //this.getContentPane().add(btnBank);
        setSize(new Dimension(604, 355));
        //txtIntime.setText(util.DateFormat.getDateStr());
        //txtUserid.setText(util.UserInfo.getUser().getUsername());
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
        String price = this.txtprice.getText().trim();
        //String producer = this.txtProducer.getText().trim();
        String spec = this.txtSpec.getText().trim();
        String unit = this.txtUnit.getText().trim();
        String type = this.txtType.getText().trim();
        String username = this.txtUserid.getText().trim();
        String provider = this.txtProvider.getText().trim();

        String mount2 = this.txtMount2.getText().trim();
        String sum = this.txtSum.getText();
        String sprice = this.txtPrice.getText().trim();

        if(bar.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"请先查询商品","提示",JOptionPane.WARNING_MESSAGE);
        } else if(sprice.equals("0")||sprice.equals("0.0")){
        	JOptionPane.showMessageDialog(null,"请设置销售价格","提示",JOptionPane.WARNING_MESSAGE);
        }
        else if(sum.equals("0.0")){
        	JOptionPane.showMessageDialog(null,"销售数量不能为0","提示",JOptionPane.WARNING_MESSAGE);
        }
        else{
            try{
                //barcode,drugname,saletype,price,amount,allmoney,type,spec,unit,provider,saletime,username
                dao.SaleDao.add(bar,name,price,sprice,mount2,sum,type,spec,unit,provider,util.UserInfo.getUser().getUsername());
                JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.WARNING_MESSAGE);
            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
            btnSearch_actionPerformed(null);
        }
    }

    public void btnSearch_actionPerformed(ActionEvent e) {
        String barcode = this.txtSearch.getText().trim();

        if(barcode.equals("")){
            JOptionPane.showMessageDialog(null,"信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            Drug vo = DrugDao.getDrugByBarcode(barcode);
            float a = SaleDao.getsprice(barcode);
            
               if(vo == null) {
                JOptionPane.showMessageDialog(null,"没有找到","提示",JOptionPane.WARNING_MESSAGE);
                return;
                }

            this.txtBarcode.setText(vo.getBarcode());
            this.txtExpiredate.setText(String.valueOf(vo.getExpiredate()));
            this.txtIntime.setText(vo.getIntime());
            this.txtMount.setText(String.valueOf(vo.getAmount()));
            this.txtName.setText(vo.getDrugname());
            this.txtPrice.setText(String.valueOf(a));
           this.txtprice.setText(String.valueOf(vo.getPrice()));
            this.txtProvider.setText(vo.getProvider());
            this.txtSpec.setText(vo.getSpec());
            this.txtType.setText(vo.getType());
            this.txtUnit.setText(vo.getUnit());
            this.txtUserid.setText(vo.getUsername());
        }


    }

    public void txtMount2_keyPressed(KeyEvent e) {
        /*String mount = this.txtMount2.getText().trim();
        String price = this.txtPrice.getText().trim();
        float sum = 0.0F;
        try{
            float mount2 = Float.parseFloat(mount);
            float price2 = Float.parseFloat(price);
            sum = price2*mount2;
        } catch (Exception ex) {
            this.txtMount2.setText("0");
            this.txtSum.setText("0");
        }
        this.txtSum.setText(String.valueOf(sum));*/
    }

    public void txtMount2_keyReleased(KeyEvent e) {
        String mount = this.txtMount2.getText().trim();
        String price = this.txtPrice.getText().trim();
        float sum = 0.0F;
        try{
            float mount2 = Float.parseFloat(mount);
            float price2 = Float.parseFloat(price);
            sum = price2*mount2;
        } catch (Exception ex) {
            this.txtMount2.setText("0");
            this.txtSum.setText("0.0");
        }
        this.txtSum.setText(String.valueOf(sum));

    }

    public void btnBank_actionPerformed(ActionEvent e) {
        try {
            Runtime.getRuntime().exec("explorer http://localhost/ChinaBank.html");
        } catch (IOException ex) {
        }
    }
}


class SaleAddDialog_btnBank_actionAdapter implements ActionListener {
    private SaleAddDialog adaptee;
    SaleAddDialog_btnBank_actionAdapter(SaleAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnBank_actionPerformed(e);
    }
}


class SaleAddDialog_txtMount2_keyAdapter extends KeyAdapter {
    private SaleAddDialog adaptee;
    SaleAddDialog_txtMount2_keyAdapter(SaleAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.txtMount2_keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        adaptee.txtMount2_keyReleased(e);
    }
}


class SaleAddDialog_btnCancel_actionAdapter implements ActionListener {
    private SaleAddDialog adaptee;
    SaleAddDialog_btnCancel_actionAdapter(SaleAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class SaleAddDialog_btnAdd_actionAdapter implements ActionListener {
    private SaleAddDialog adaptee;
    SaleAddDialog_btnAdd_actionAdapter(SaleAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}


class SaleAddDialog_btnSearch_actionAdapter implements ActionListener {
    private SaleAddDialog adaptee;
    SaleAddDialog_btnSearch_actionAdapter(SaleAddDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}

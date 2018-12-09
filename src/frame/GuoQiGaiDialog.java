package frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.*;
import vo.*;

public class GuoQiGaiDialog extends JDialog {
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
    JTextField txtrea = new JTextField();
    JTextField txtMount = new JTextField();
    JTextField txtType = new JTextField();
    JTextField txtSpec = new JTextField();
    JTextField txtUnit = new JTextField();
    //JTextField txtProducer = new JTextField();
    //JTextField txtIntime = new JTextField();
    JTextField txtUserid = new JTextField();
    JTextField txtretime = new JTextField();
    JButton btnUpdate = new JButton();
    JLabel jLabel13 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    //JTextField txtProvider = new JTextField();
    JButton btnDel = new JButton();
    public GuoQiGaiDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public GuoQiGaiDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("报损修改");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(488, 233, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new
        		GuoQiGaiDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("商品号:");
        jLabel1.setBounds(new Rectangle(31, 49, 42, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(28, 78, 42, 15));
        jLabel3.setText("规格:");
        jLabel3.setBounds(new Rectangle(30, 113, 73, 15));
        jLabel4.setText("数量:");
        jLabel4.setBounds(new Rectangle(318, 175, 42, 15));
        jLabel5.setText("类型:");
        jLabel5.setBounds(new Rectangle(28, 145, 42, 15));
       
       
        jLabel9.setText("报损时间:");
        jLabel9.setBounds(new Rectangle(305, 81, 64, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(30, 174, 42, 15));
        jLabel11.setText("单位:");
        jLabel11.setBounds(new Rectangle(310, 107, 48, 15));
        jLabel12.setText("原因:");
        jLabel12.setBounds(new Rectangle(310, 140, 48, 15));
        txtBarcode.setEditable(false);
        txtBarcode.setBounds(new Rectangle(82, 47, 190, 20));
        txtName.setBounds(new Rectangle(82, 79, 190, 20));
        
        txtMount.setText("0");
        txtMount.setBounds(new Rectangle(375, 168, 198, 20));
        txtType.setBounds(new Rectangle(81, 142, 189, 20));
        txtSpec.setBounds(new Rectangle(82, 111, 190, 20));
        txtUnit.setBounds(new Rectangle(375, 107, 198, 20));
        txtUnit.setEditable(false);
        txtSpec.setEditable(false);
        txtType.setEditable(false);
        txtName.setEditable(false);
        //txtProducer.setBounds(new Rectangle(374, 45, 201, 20));
        //txtIntime.setText("2017-4-21");
        //txtIntime.setEditable(false);
        //txtIntime.setBounds(new Rectangle(375, 75, 200, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(82, 168, 190, 20));
        txtretime.setText("2017-5-09");
        txtretime.setEditable(false);
        txtretime.setBounds(new Rectangle(375, 75, 200, 20));
        txtrea.setBounds(new Rectangle(375, 137, 199, 20));
        btnUpdate.setBounds(new Rectangle(364, 233, 81, 23));
        btnUpdate.setText("修改");
        btnUpdate.addActionListener(new
        		GuoQiGaiDialog_btnUpdate_actionAdapter(this));
        btnSearch.setBounds(new Rectangle(473, 13, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new
        		GuoQiGaiDialog_btnSearch_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(84, 15, 368, 20));
        jLabel13.setText("报损编号:");
        jLabel13.setBounds(new Rectangle(20, 18, 86, 15));
        
        /*btnDel.setBounds(new Rectangle(393, 233, 81, 23));
        btnDel.setText("删除");
        btnDel.addActionListener(new MedicineUpdateDialog_btnDel_actionAdapter(this));*/
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtrea);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel8);
        //this.getContentPane().add(txtProducer);
        //this.getContentPane().add(txtIntime);
        this.getContentPane().add(txtType);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(txtUnit);
        this.getContentPane().add(txtSpec);
        this.getContentPane().add(txtretime);
        this.getContentPane().add(txtMount);
        this.getContentPane().add(txtUserid);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(jLabel12);
       
        this.getContentPane().add(btnUpdate);
        this.getContentPane().add(btnDel);
        setSize(new Dimension(604, 320));
        util.FrameSet.showCenter(this);
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    

    public void btnSearch_actionPerformed(ActionEvent e) {
        String id = this.txtSearch.getText().trim();

        if(id.equals("")){
            JOptionPane.showMessageDialog(null,"信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            SunHuai vo = SunHuaiDao.getall(Integer.valueOf(id));

            if(vo == null) {
                JOptionPane.showMessageDialog(null,"没有找到","提示",JOptionPane.WARNING_MESSAGE);
                return;
            }

            this.txtBarcode.setText(vo.getBarcode());
            
            this.txtretime.setText(vo.getRetime());
            this.txtMount.setText(String.valueOf(vo.getAmount()));
            this.txtName.setText(vo.getDrugname());
            this.txtrea.setText(String.valueOf(vo.getStype()));
            //this.txtProducer.setText(vo.getProducer());
            
            this.txtSpec.setText(vo.getSpec());
            this.txtType.setText(vo.getType());
            this.txtUnit.setText(vo.getUnit());
            this.txtUserid.setText(vo.getUsername());
        }

    }

    public void btnUpdate_actionPerformed(ActionEvent e) {
    	String bar = this.txtBarcode.getText().trim();
    	String mount = this.txtMount.getText().trim();
    	String stype = this.txtrea.getText().trim();
    	String id = this.txtSearch.getText().trim();
        if(bar.equals("")||mount.equals("0")) {
            JOptionPane.showMessageDialog(null,"条形码或数量信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
            return;
        } else {

            try{

                SunHuaiDao.update(Integer.parseInt(mount),stype,bar,Integer.valueOf(id));
                JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.WARNING_MESSAGE);
            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"数据错误，修改失败","提示",JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    





class GuoQiGaiDialog_btnCancel_actionAdapter implements ActionListener {
    private GuoQiGaiDialog adaptee;
    GuoQiGaiDialog_btnCancel_actionAdapter(GuoQiGaiDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class GuoQiGaiDialog_btnUpdate_actionAdapter implements ActionListener {
    private GuoQiGaiDialog adaptee;
    GuoQiGaiDialog_btnUpdate_actionAdapter(GuoQiGaiDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnUpdate_actionPerformed(e);
    }
}


class GuoQiGaiDialog_btnSearch_actionAdapter implements ActionListener {
    private GuoQiGaiDialog adaptee;
    GuoQiGaiDialog_btnSearch_actionAdapter(GuoQiGaiDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}
}

package frame;
import java.awt.*;
import dao.*;
import vo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.Drug;
import dao.DrugDao;
public class CaiTuiDialog extends JDialog{
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
    JTextField txtcode = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextField txtMount = new JTextField();
    JTextField txtType = new JTextField();
    JTextField txtSpec = new JTextField();
    JTextField txtUnit = new JTextField();
    JTextField txtProducer = new JTextField();
    JTextField txtall = new JTextField();
    JTextField txtUserid = new JTextField();
    JTextField txtExpiredate = new JTextField();
    JButton btnTui = new JButton();
    JLabel jLabel13 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JTextField txtProvider = new JTextField();
    JButton btnDel = new JButton();
    public CaiTuiDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public CaiTuiDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("采购退货");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(488, 233, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new
        		CaiTuiDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("采购编号:");
        jLabel1.setBounds(new Rectangle(4, 49, 60, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(28, 78, 42, 15));
        jLabel3.setText("进货价格:");
        jLabel3.setBounds(new Rectangle(4, 113, 73, 15));
        jLabel4.setText("退货数量:");
        jLabel4.setBounds(new Rectangle(295, 175, 62, 15));
        jLabel5.setText("类型:");
        jLabel5.setBounds(new Rectangle(28, 145, 42, 15));
        jLabel6.setText("规格:");
        jLabel6.setBounds(new Rectangle(30, 174, 42, 15));
        jLabel7.setText("单位:");
        jLabel7.setBounds(new Rectangle(33, 206, 42, 15));
        //jLabel8.setText("生产厂家:");
        //jLabel8.setBounds(new Rectangle(305, 49, 66, 15));
        jLabel9.setText("总金钱数");
        jLabel9.setBounds(new Rectangle(305, 81, 64, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(318, 201, 48, 15));
        jLabel11.setText("供应商:");
        jLabel11.setBounds(new Rectangle(310, 107, 48, 15));
        jLabel12.setText("有效日期/年:");
        jLabel12.setBounds(new Rectangle(295, 140, 92, 15));
        txtcode.setEditable(false);
        txtcode.setBounds(new Rectangle(82, 47, 190, 20));
        txtName.setBounds(new Rectangle(82, 79, 190, 20));
        txtPrice.setText("0");
        txtPrice.setBounds(new Rectangle(82, 111, 190, 20));
        txtMount.setText("0");
        txtMount.setBounds(new Rectangle(373, 168, 198, 20));
        txtType.setBounds(new Rectangle(81, 142, 189, 20));
        txtSpec.setBounds(new Rectangle(81, 172, 189, 20));
        txtUnit.setBounds(new Rectangle(81, 203, 189, 20));
        //txtProducer.setBounds(new Rectangle(374, 45, 201, 20));
        txtall.setText("0");
        txtall.setBounds(new Rectangle(375, 81, 198, 20));
        txtName.setEditable(false);
        txtPrice.setEditable(false);
        txtProvider.setEditable(false);
        txtType.setEditable(false);
        txtSpec.setEditable(false);
        txtUnit.setEditable(false);
        txtSpec.setEditable(false);
        txtExpiredate.setEditable(false);
        txtExpiredate.setBounds(new Rectangle(375, 75, 200, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(371, 196, 200, 20));
        txtExpiredate.setText("0");
        txtExpiredate.setBounds(new Rectangle(375, 137, 199, 20));
        /*btnUpdate.setBounds(new Rectangle(292, 233, 81, 23));
        btnUpdate.setText("修改");
        btnUpdate.addActionListener(new
                CaiUpDialog_btnUpdate_actionAdapter(this));*/
        btnSearch.setBounds(new Rectangle(473, 13, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new
                CaiTuiDialog_btnSearch_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(84, 15, 368, 20));
        jLabel13.setText("采购编号:");
        jLabel13.setBounds(new Rectangle(2, 18, 60, 15));
        txtProvider.setBounds(new Rectangle(375, 107, 198, 20));
       btnTui.setBounds(new Rectangle(393, 233, 81, 23));
        btnTui.setText("退货");
        btnTui.addActionListener(new CaiTuiDialog_btnTui_actionAdapter(this));
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(txtName);
        this.getContentPane().add(txtPrice);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel8);
        //this.getContentPane().add(txtProducer);
        this.getContentPane().add(txtall);
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
        //this.getContentPane().add(btnUpdate);
        this.getContentPane().add(btnTui);
        setSize(new Dimension(604, 320));
        util.FrameSet.showCenter(this);
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    

    public void btnSearch_actionPerformed(ActionEvent e) {
        String code = this.txtSearch.getText().trim();

        if(code.equals("")){
            JOptionPane.showMessageDialog(null,"信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            Cai vo = CaiDao.getCaiBycode(code);

            if(vo == null) {
                JOptionPane.showMessageDialog(null,"没有找到","提示",JOptionPane.WARNING_MESSAGE);
                return;
            }
            float g = vo.getPrice() * vo.getAmount();
            this.txtcode.setText(String.valueOf(vo.getCid()));
            this.txtExpiredate.setText(String.valueOf(vo.getExpiredate()));
            this.txtall.setText(String.valueOf(g));
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


  public void btnTui_actionPerformed(ActionEvent e) {
        String code = this.txtcode.getText().trim();

        if(code.equals("")) {
            JOptionPane.showMessageDialog(null,"条形码信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int amount1 = Integer.parseInt(txtMount.getText());
        int amount2 = CaiDao.getamount(code) - amount1;
        CaiDao.update2(code,amount2);
        float a = Float.parseFloat(txtPrice.getText()) * Integer.parseInt(txtMount.getText());
        this.txtall.setText(String.valueOf(a));
        this.txtcode.setText("");
        JOptionPane.showMessageDialog(null,"退货成功","提示",JOptionPane.WARNING_MESSAGE);
    }
}


/*class MedicineUpdateDialog_btnDel_actionAdapter implements ActionListener {
    private MedicineUpdateDialog adaptee;
    MedicineUpdateDialog_btnDel_actionAdapter(MedicineUpdateDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnDel_actionPerformed(e);
    }
}*/


class CaiTuiDialog_btnCancel_actionAdapter implements ActionListener {
    private CaiTuiDialog adaptee;
    CaiTuiDialog_btnCancel_actionAdapter(CaiTuiDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}


class CaiTuiDialog_btnTui_actionAdapter implements ActionListener {
    private CaiTuiDialog adaptee;
    CaiTuiDialog_btnTui_actionAdapter(CaiTuiDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnTui_actionPerformed(e);
    }
}


class CaiTuiDialog_btnSearch_actionAdapter implements ActionListener {
    private CaiTuiDialog adaptee;
    CaiTuiDialog_btnSearch_actionAdapter(CaiTuiDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}


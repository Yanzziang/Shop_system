package frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.*;
import vo.*;


public class YuSheDialog extends JDialog {

	JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    
    JLabel jLabel4 = new JLabel();
    
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JTextField txtBarcode = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtMinMount = new JTextField();
    JTextField txtMount = new JTextField();
   
    JTextField txtUserid = new JTextField();

    JButton btnUpdate = new JButton();
    JLabel jLabel13 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JTextField txtProvider = new JTextField();
    JButton btnAdd = new JButton();
    public YuSheDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public YuSheDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("设置最小库存");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(488, 233, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new
                YuSheDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("商品号:");
        jLabel1.setBounds(new Rectangle(155, 49, 42, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(155, 79, 42, 15));
        jLabel4.setText("数量:");
        jLabel4.setBounds(new Rectangle(155, 139, 42, 15));
        jLabel5.setText("最小库存量");
        jLabel5.setBounds(new Rectangle(130, 169, 68, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(155, 201, 48, 15));
        jLabel11.setText("供应商:");
        jLabel11.setBounds(new Rectangle(155, 109, 48, 15));

        txtBarcode.setEditable(false);
        txtBarcode.setBounds(new Rectangle(215, 49, 190, 20));
        txtName.setBounds(new Rectangle(215, 79, 190, 20));
        txtName.setEditable(false);
 
        txtMount.setText("0");
        txtMount.setEditable(false);
        txtMount.setBounds(new Rectangle(215, 139, 190, 20));
        txtMinMount.setText("0");
        txtMinMount.setBounds(new Rectangle(215, 169, 190, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(215, 201, 200, 20));
        

        /*btnUpdate.setBounds(new Rectangle(292, 233, 81, 23));
        btnUpdate.setText("修改");
        btnUpdate.addActionListener(new
                MedicineUpdateDialog_btnUpdate_actionAdapter(this));*/
        btnSearch.setBounds(new Rectangle(473, 13, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new
                YuSheDialog_btnSearch_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(84, 15, 368, 20));
        jLabel13.setText("商品号:");
        jLabel13.setBounds(new Rectangle(30, 18, 48, 15));
        txtProvider.setBounds(new Rectangle(215, 109, 190, 20));
        txtProvider.setEditable(false);
        btnAdd.setBounds(new Rectangle(320, 233, 160, 23));
        btnAdd.setText("添加   / 修改");
        btnAdd.addActionListener(new YuSheDialog_btnAdd_actionAdapter(this));
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(txtName);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(txtMinMount);
        this.getContentPane().add(txtMount);
        this.getContentPane().add(txtUserid);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(jLabel4);

        this.getContentPane().add(jLabel11);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(jLabel12);
        this.getContentPane().add(txtProvider);
        this.getContentPane().add(btnUpdate);
       
        setSize(new Dimension(604, 320));
        util.FrameSet.showCenter(this);
    }

    public void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void btnAdd_actionPerformed(ActionEvent e) {
        String bar = this.txtBarcode.getText().trim();
        /*Drug vo = DrugDao.getDrugByBarcode(bar);
        int smount = vo.getAmount();*/
        String mount = this.txtMinMount.getText().trim();
        String name = this.txtName.getText().trim();
        String smount = this.txtMount.getText().trim();
        String username = this.txtUserid.getText().trim();
        String provider = this.txtProvider.getText().trim();

        if(bar.trim().equals("")|| name.trim().equals("") ) {
            JOptionPane.showMessageDialog(null,"请先进行查询","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            
        	
        	try{
                Yu yu = new Yu();
                yu.setAmount(Integer.parseInt(mount));
                yu.setSamount(Integer.parseInt(smount));
                yu.setBarcode(bar);
                yu.setDrugname(name);
                yu.setProvider(provider);
                yu.setUsername(username);

                YuDao.getupdate(bar,(Integer.parseInt(mount)),yu);
                JOptionPane.showMessageDialog(null,"添加预警成功","提示",JOptionPane.WARNING_MESSAGE);
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
            
            this.txtMount.setText(String.valueOf(vo.getAmount()));
            this.txtName.setText(vo.getDrugname());

            this.txtProvider.setText(vo.getProvider());

            this.txtUserid.setText(vo.getUsername());
        }

    }

} 


class YuSheDialog_btnSearch_actionAdapter implements ActionListener {
    private YuSheDialog adaptee;
    YuSheDialog_btnSearch_actionAdapter(YuSheDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}

class YuSheDialog_btnCancel_actionAdapter implements ActionListener {
    private YuSheDialog adaptee;
    YuSheDialog_btnCancel_actionAdapter(YuSheDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

class YuSheDialog_btnAdd_actionAdapter implements ActionListener {
    private YuSheDialog adaptee;
    YuSheDialog_btnAdd_actionAdapter(YuSheDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}

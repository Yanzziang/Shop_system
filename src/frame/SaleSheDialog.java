package frame;
import java.awt.*;
import vo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vo.Drug;
import vo.Yu;
import dao.DrugDao;
import dao.SaleDao;

public class SaleSheDialog extends JDialog {

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
    JTextField txtsprice = new JTextField();
    JTextField txtprice = new JTextField();
   
    JTextField txtUserid = new JTextField();

    JButton btnUpdate = new JButton();
    JLabel jLabel13 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton();
    JTextField txtProvider = new JTextField();
    JButton btnAdd = new JButton();
    public SaleSheDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SaleSheDialog() {
        this(null);
    }

    private void jbInit() throws Exception {
        this.setTitle("设置售卖价格");
        this.getContentPane().setLayout(null);
        btnCancel.setBounds(new Rectangle(488, 233, 81, 23));
        btnCancel.setText("取消");
        btnCancel.addActionListener(new
        		SaleSheDialog_btnCancel_actionAdapter(this));
        jLabel1.setText("商品号:");
        jLabel1.setBounds(new Rectangle(155, 49, 42, 15));
        jLabel2.setText("商品名:");
        jLabel2.setBounds(new Rectangle(155, 79, 42, 15));
        jLabel4.setText("进货价格:");
        jLabel4.setBounds(new Rectangle(130, 139, 68, 15));
        jLabel5.setText("售卖价格");
        jLabel5.setBounds(new Rectangle(130, 169, 68, 15));
        jLabel10.setText("操作员:");
        jLabel10.setBounds(new Rectangle(155, 201, 48, 15));
        jLabel11.setText("供应商:");
        jLabel11.setBounds(new Rectangle(155, 109, 48, 15));

        txtBarcode.setEditable(false);
        txtBarcode.setBounds(new Rectangle(215, 49, 190, 20));
        txtName.setBounds(new Rectangle(215, 79, 190, 20));
        txtName.setEditable(false);
 
        txtprice.setText("0.0");
        txtprice.setEditable(false);
        txtprice.setBounds(new Rectangle(215, 139, 190, 20));
        txtsprice.setText("0.0");
        txtsprice.setBounds(new Rectangle(215, 169, 190, 20));
        txtUserid.setEditable(false);
        txtUserid.setBounds(new Rectangle(215, 201, 200, 20));
        

        
        btnSearch.setBounds(new Rectangle(473, 13, 81, 23));
        btnSearch.setText("查询");
        btnSearch.addActionListener(new
                SaleSheDialog_btnSearch_actionAdapter(this));
        txtSearch.setBounds(new Rectangle(84, 15, 368, 20));
        jLabel13.setText("商品号:");
        jLabel13.setBounds(new Rectangle(30, 18, 48, 15));
        txtProvider.setBounds(new Rectangle(215, 109, 190, 20));
        txtProvider.setEditable(false);
        btnAdd.setBounds(new Rectangle(320, 233, 160, 23));
        btnAdd.setText("设   置");
        btnAdd.addActionListener(new SaleSheDialog_btnAdd_actionAdapter(this));
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnSearch);
        this.getContentPane().add(txtName);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtBarcode);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(txtsprice);
        this.getContentPane().add(txtprice);
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
            
            this.txtprice.setText(String.valueOf(vo.getPrice()));
            this.txtName.setText(vo.getDrugname());

            this.txtProvider.setText(vo.getProvider());

            this.txtUserid.setText(vo.getUsername());
        }

    }
    
    public void btnAdd_actionPerformed(ActionEvent e) {
        String bar = this.txtBarcode.getText().trim();
        /*Drug vo = DrugDao.getDrugByBarcode(bar);
        int smount = vo.getAmount();*/
        String sprice = this.txtsprice.getText().trim();
        

        if(bar.trim().equals("")) {
            JOptionPane.showMessageDialog(null,"部分信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
        } else {
            
        	
        	try{
                float sp = Float.parseFloat(sprice);   

                SaleDao.update(bar,sp);
                JOptionPane.showMessageDialog(null,"添加销售价格成功","提示",JOptionPane.WARNING_MESSAGE);
            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"添加失败","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

class SaleSheDialog_btnSearch_actionAdapter implements ActionListener {
    private SaleSheDialog adaptee;
    SaleSheDialog_btnSearch_actionAdapter(SaleSheDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSearch_actionPerformed(e);
    }
}

class SaleSheDialog_btnCancel_actionAdapter implements ActionListener {
    private SaleSheDialog adaptee;
    SaleSheDialog_btnCancel_actionAdapter(SaleSheDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnCancel_actionPerformed(e);
    }
}

class SaleSheDialog_btnAdd_actionAdapter implements ActionListener {
    private SaleSheDialog adaptee;
    SaleSheDialog_btnAdd_actionAdapter(SaleSheDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAdd_actionPerformed(e);
    }
}

package frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vo.Cai;

public class CaiUp extends JDialog{
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
	    
	    //JCheckBox txtisnot = new JCheckBox();
	    JTextField txthao = new JTextField();
	    JTextField txtName = new JTextField();
	    JTextField txtPrice = new JTextField();
	    JTextField txtMount = new JTextField();
	    JTextField txtType = new JTextField();
	    JTextField txtSpec = new JTextField();
	    JTextField txtUnit = new JTextField();
	    //JTextField txtProducer = new JTextField();
	    JTextField txtIntime = new JTextField();
	    JTextField txtUserid = new JTextField();
	    JTextField txtExpiredate = new JTextField();
	    JComboBox cboProvider = new JComboBox(dao.SupplierDao.getAllSupplierName());
	    //JComboBox cboProvider = new JComboBox();
	    JButton btnUp = new JButton();
	    /*public CaiUp(Frame owner) {
	        super(owner, true);
	        try {
	            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	            jbInit();
	            pack();
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }

	    public CaiUp() {
	        this(null);
	    }*/
	    public CaiUp(Cai vo){
	    	try {
	            setDefaultCloseOperation(DISPOSE_ON_CLOSE);	            
	            this.setTitle("采购修改");
		        this.getContentPane().setLayout(null);
		        btnCancel.setBounds(new Rectangle(489, 200, 81, 23));
		        btnCancel.setText("取消");
		        btnCancel.addActionListener(new
		                                    CaiUp_btnCancel_actionAdapter(this));
		        jLabel1.setText("商品名:");
		        jLabel1.setBounds(new Rectangle(32, 16, 42, 15));
		        jLabel2.setText("采购编号:");
		        jLabel2.setBounds(new Rectangle(15, 45, 68, 15));
		        jLabel3.setText("进货价格:");
		        jLabel3.setBounds(new Rectangle(5, 80, 68, 15));
		        jLabel4.setText("数量:");
		        jLabel4.setBounds(new Rectangle(319, 142, 42, 15));
		        jLabel5.setText("类型:");
		        jLabel5.setBounds(new Rectangle(29, 112, 42, 15));
		        jLabel6.setText("规格:");
		        jLabel6.setBounds(new Rectangle(31, 141, 42, 15));
		        jLabel7.setText("单位:");
		        jLabel7.setBounds(new Rectangle(306, 16, 66, 15));
		        //jLabel8.setText("生产厂家:");
		        //jLabel8.setBounds(new Rectangle(306, 16, 66, 15));
		        jLabel9.setText("进货时间:");
		        jLabel9.setBounds(new Rectangle(306, 48, 64, 15));
		        jLabel10.setText("操作员:");
		        jLabel10.setBounds(new Rectangle(319, 168, 48, 15));
		        jLabel11.setText("供应商:");
		        jLabel11.setBounds(new Rectangle(311, 74, 48, 15));
		        jLabel12.setText("有效日期/年:");
		        jLabel12.setBounds(new Rectangle(296, 107, 92, 15));
		        txtName.setBounds(new Rectangle(83, 14, 190, 20));
		        
		        txthao.setBounds(new Rectangle(83, 46, 192, 20));
		        //txtPrice.setText("0");
		        txtPrice.setBounds(new Rectangle(83, 78, 190, 20));
		        //txtMount.setText("0");
		        txtMount.setBounds(new Rectangle(374, 135, 198, 20));
		        txtType.setBounds(new Rectangle(82, 109, 189, 20));
		        txtSpec.setBounds(new Rectangle(82, 139, 189, 20));
		        txtUnit.setBounds(new Rectangle(375, 12, 201, 20));
		        //txtProducer.setBounds(new Rectangle(375, 12, 201, 20));
		        //txtIntime.setText("2017-4-01");
		        txtIntime.setEditable(false);
		        txtIntime.setBounds(new Rectangle(376, 42, 200, 20));
		        txtUserid.setEditable(false);
		        txtUserid.setBounds(new Rectangle(372, 163, 200, 20));
		        //txtExpiredate.setText("0");
		        txtExpiredate.setBounds(new Rectangle(376, 104, 199, 20));
		        cboProvider.setBounds(new Rectangle(375, 72, 200, 20));
		        btnUp.setBounds(new Rectangle(387, 200, 81, 23));
		        btnUp.setText("修改");
		        //btnUp.addActionListener(new CaiUp_btnUp_actionAdapter(this));
		        
		        
		        this.getContentPane().add(jLabel1);
		        this.getContentPane().add(txthao);
		        this.getContentPane().add(jLabel2);
		        this.getContentPane().add(txtName);
		        this.getContentPane().add(jLabel3);
		        this.getContentPane().add(txtPrice);
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
		        this.getContentPane().add(btnUp);
		        this.getContentPane().add(jLabel12);

		        
		        this.txtName.setText(vo.getDrugname());
	            this.txtExpiredate.setText(String.valueOf(vo.getExpiredate()));
	            this.txtIntime.setText(vo.getCaitime());
	            this.txtMount.setText(String.valueOf(vo.getAmount()));
	            this.txtPrice.setText(String.valueOf(vo.getPrice()));
	            this.txtSpec.setText(vo.getSpec());
	            this.txtType.setText(vo.getType());
	            this.txtUnit.setText(vo.getUnit());
	            this.txtUserid.setText(vo.getUsername());
	            this.txthao.setText(String.valueOf(vo.getCid()));

	            //pack();
	            setSize(new Dimension(604, 282));
	            util.FrameSet.showCenter(this);
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }
	    
	    public void btnUp_actionPerformed(ActionEvent e) {
	        this.dispose();
	    }
	    
	    
	    public void btnCancel_actionPerformed(ActionEvent e) {
	        this.dispose();
	    }
	    
	    
	    
class CaiUp_btnUp_actionAdapter implements ActionListener {
  private CaiUp adaptee;
  CaiUp_btnUp_actionAdapter(CaiUp adaptee) {
      this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
      adaptee.btnUp_actionPerformed(e);
  }
}


class CaiUp_btnCancel_actionAdapter implements ActionListener {
  private CaiUp adaptee;
  CaiUp_btnCancel_actionAdapter(CaiUp adaptee) {
      this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
      adaptee.btnCancel_actionPerformed(e);
  }
}
}

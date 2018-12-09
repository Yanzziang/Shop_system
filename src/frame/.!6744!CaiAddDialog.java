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

public class CaiAddDialog  extends JDialog{
	
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
	    
	    JCheckBox txtisnot = new JCheckBox();
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
	    JComboBox cboProvider = new JComboBox(dao.SupplierDao.getSupplierName());
	    //JComboBox cboProvider = new JComboBox();
	    JButton btnAdd = new JButton();
	    public CaiAddDialog(Frame owner) {
	        super(owner, true);
	        try {
	            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	            jbInit();
	            pack();
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }

	    public CaiAddDialog() {
	        this(null);
	    }

	    private void jbInit() throws Exception {

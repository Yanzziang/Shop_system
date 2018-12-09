package frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.SaleDao;
import vo.Best;

public class SaleCDialog extends JDialog {
	JLabel jLabel = new JLabel();
	JTextField total = new JTextField();

	JLabel jLabel3 = new JLabel();
	JTextField win = new JTextField();
	JButton get = new JButton();

	public SaleCDialog(Frame owner) {
		super(owner, true);
		try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
	
	private void jbInit() throws Exception {
		this.setTitle("当天销售统计");
		this.getContentPane().setLayout(null);
		jLabel.setText("销售总金额");
		jLabel.setBounds(40, 25, 80, 25);

		jLabel3.setText("当天盈利");
		jLabel3.setBounds(40, 75, 80, 25);
		total.setBounds(131,25,120,25);

		win.setBounds(131,75,120,25);
		get.setText("销售统计");
		get.setBounds(81, 115, 110, 25);
		get.addActionListener(new getTotal_actionAdapter(this));
		this.getContentPane().add(jLabel);
		this.getContentPane().add(total);

		this.getContentPane().add(jLabel3);
		this.getContentPane().add(win);
		this.getContentPane().add(get);
		setSize(new Dimension(300,220));
		util.FrameSet.showCenter(this);
		
	}
	
	public void getTotal_actionPerformed(ActionEvent e){
		float price = SaleDao.getallprice();
		float win = SaleDao.getallsprice() - price;
		
		
		this.total.setText(String.valueOf(price));
		
		this.win.setText(String.valueOf(win));
	}
}

  class getTotal_actionAdapter implements ActionListener {
	private SaleCDialog adaptee;
	getTotal_actionAdapter(SaleCDialog adaptee){
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e){
		adaptee.getTotal_actionPerformed(e);
	}
}


package frame;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.*;
import vo.*;

public class SaleBest extends JDialog {
	
	JLabel jLabel = new JLabel();
	JTextField best = new JTextField();
	JLabel jLabel2 = new JLabel();
	JTextField code = new JTextField();
	JLabel jLabel3 = new JLabel();
	JTextField amount = new JTextField();
	JButton get = new JButton();

	public SaleBest(Frame owner) {
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
		this.setTitle("当天售卖最佳商品");
		this.getContentPane().setLayout(null);
		jLabel.setText("当天售卖最佳商品");
		jLabel.setBounds(15, 25, 110, 25);
		jLabel2.setText("商品号");
		jLabel2.setBounds(40, 53, 80, 25);
		jLabel3.setText("销售数量");
		jLabel3.setBounds(40, 81, 80, 25);
		best.setBounds(131,25,120,25);
		code.setBounds(131,53,120,25);
		amount.setBounds(131,81,120,25);
		get.setText("最佳商品");
		get.setBounds(81, 123, 110, 25);
		get.addActionListener(new getbest_actionAdapter(this));
		this.getContentPane().add(jLabel);
		this.getContentPane().add(best);
		this.getContentPane().add(jLabel2);
		this.getContentPane().add(code);
		this.getContentPane().add(jLabel3);
		this.getContentPane().add(amount);
		this.getContentPane().add(get);
		setSize(new Dimension(300,220));
		util.FrameSet.showCenter(this);
		
	}
	
	public void getbest_actionPerformed(ActionEvent e){
		ArrayList k = new ArrayList();
		ArrayList t = new ArrayList();
		ArrayList l = new ArrayList();
		k=SaleDao.getallsale();
		t = SaleDao.xiaoqu(k);
		l = SaleDao.amount(t);
		Best best = new Best();
		best = SaleDao.best(t,l);
		
		String code = best.getBarcode();
		int amount = best.getAmount();
		String name = SaleDao.getname(code);
		this.best.setText(name);
		this.code.setText(code);
		this.amount.setText(String.valueOf(amount));
	}
}

  class getbest_actionAdapter implements ActionListener {
	private SaleBest adaptee;
	getbest_actionAdapter(SaleBest adaptee){
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e){
		adaptee.getbest_actionPerformed(e);
	}
}

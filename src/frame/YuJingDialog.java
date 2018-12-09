package frame;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.CaiDao;
import dao.YuDao;
import vo.*;
import frame.*;


public class YuJingDialog extends JDialog {
	
    JTable table = new JTable();
    DefaultTableModel dataTable;
    Vector columnName = new Vector();
    Vector rowData =  new Vector();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton btnCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JTextField txtSearch = new JTextField();
    JButton btnDe = new JButton();
    JButton btnUp = new JButton();
    public YuJingDialog(Frame owner) {
        super(owner, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public YuJingDialog() {
        this(null);
    }

    public void initTable(){
    	columnName.add("编号");
            columnName.add("商品号");
            columnName.add("商品名");
            columnName.add("最低预警数量");
            columnName.add("实际数量");
            columnName.add("操作人");
            columnName.add("供应商");


            dataTable = new DefaultTableModel(rowData,columnName);
            table = new JTable(dataTable);
            table.setRowHeight(31);
            table.setBackground(Color.yellow);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            jScrollPane1.getViewport().add(table);
            
            

            freshTable();
      }

      public void freshTable(){
    	  
    	  ArrayList m = new ArrayList();
    	  ArrayList g = new ArrayList();
    	   m = YuDao.getBar();
    	   g = YuDao.getamountinruku(m);
    	   YuDao.update(g, m);
          dao.YuDao.loadTable(dataTable);
   }

    private void jbInit() throws Exception {
        this.setTitle("库存预警列表");
        this.getContentPane().setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(19, 19, 769, 403));
       /* btnCancel.addActionListener(new CaiDialog_btnCancel_actionAdapter(this));
        //jLabel1.setText("条形码/商品名:");
        //jLabel1.setBounds(new Rectangle(32, 440, 104, 15));
        //txtSearch.setBounds(new Rectangle(135, 438, 352, 20));
        btnDe.setBounds(new Rectangle(515, 436, 81, 23));
        btnDe.setText("删除");
        btnDe.addActionListener(new CaiDialog_btnDe_actionAdapter(this));
        //btnSearch.addActionListener(new MedicineSDialog_btnSearch_actionAdapter(this));
        btnUp.setBounds(new Rectangle(609, 436, 81, 23));
        btnUp.setText("修改");
        btnUp.addActionListener(new CaiDialog_btnUp_actionAdapter(this));*/
        this.getContentPane().add(jScrollPane1);
        /*this.getContentPane().add(btnCancel);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(txtSearch);
        this.getContentPane().add(btnUp);
        this.getContentPane().add(btnDe);
        btnCancel.setBounds(new Rectangle(707, 436, 81, 23));
        btnCancel.setText("取消");*/


        initTable();
        setSize(new Dimension(812, 511));
        util.FrameSet.showCenter(this);

    }
}

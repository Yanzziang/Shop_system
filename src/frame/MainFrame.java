package frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.BorderFactory;


public class MainFrame extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();//东西南北布局类
    JMenuBar jMenuBar1 = new JMenuBar();//菜单条/栏
    JMenu jMenuFile = new JMenu();//菜单
    JMenuItem jMenuFileExit = new JMenuItem();//菜单项
    JMenu jMenuHelp = new JMenu();
    //JMenuItem jMenuHelpAbout = new JMenuItem();
    JToolBar jToolBar = new JToolBar();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    
    
    /*ImageIcon image1 = new ImageIcon(Main.class.getResource(
            "img/openFile.png"));
    ImageIcon image2 = new ImageIcon(Main.class.getResource(
            "img/closeFile.png"));
    ImageIcon image3 = new ImageIcon(Main.class.getResource(
            "img/help.png"));*/
    
    
    ImageIcon image4 = new ImageIcon(Main.class.getResource(
            "img/desktop1.jpg"));
    JLabel lblDesktop = new JLabel(image4);
    JMenuItem mnuUserQuery = new JMenuItem();
    JMenuItem mnuLog = new JMenuItem();
    JMenuItem mnuPass = new JMenuItem();
    JMenuItem mnuItemAddUser = new JMenuItem();
    JMenuItem mnuLogout = new JMenuItem();
    JMenu jMenu1 = new JMenu();
    JMenuItem mnuSaleAdd = new JMenuItem();
    JMenuItem mnuSaleS = new JMenuItem();
    JMenuItem mnuSalePrice = new JMenuItem();
    JMenuItem mnuSaleBest = new JMenuItem();
    JMenuItem mnuSaleC = new JMenuItem();
    JMenu jMenu2 = new JMenu();
    JMenuItem mnuMedicineAdd = new JMenuItem();
    JMenuItem mnuMedicineS = new JMenuItem();
    JMenuItem mnuMedicineU = new JMenuItem();
    JMenuItem mnuYuAdd = new JMenuItem();
    JMenuItem mnuYuJing = new JMenuItem();
    JMenu jMenu3 = new JMenu();
    JMenuItem mnuGuoQi = new JMenuItem();
    JMenuItem mnuGuoQiS = new JMenuItem();
    JMenuItem mnuGuoQiGai = new JMenuItem();
    
    /*JMenu jMenu4 = new JMenu();
    JMenuItem jMenuItem18 = new JMenuItem();
    JMenuItem mnuTotalSale = new JMenuItem();
    JMenuItem mnuTotalKuCun = new JMenuItem();
    JMenuItem mnuTotalBaoSun = new JMenuItem();*/
    
    JMenu jMenu4 = new JMenu();
    JMenuItem mnuzhichu = new JMenuItem();
    JMenuItem mnujin = new JMenuItem();
    
    JMenu jMenu5 = new JMenu();
    JMenuItem mnuSupplier = new JMenuItem();
    JMenuItem mnuSupplierC = new JMenuItem();
    JMenuItem mnuSupplierGai = new JMenuItem();
    
    JMenu jMenu6 = new JMenu();
    JMenuItem mnuPersonAdd = new JMenuItem();
    JMenuItem mnuPerson = new JMenuItem();
    JMenuItem mnuDept = new JMenuItem();
    JMenuItem mnuDeptAdd = new JMenuItem();
    
    JMenu jMenu7 = new JMenu();
    JMenuItem mnuCaiadd = new JMenuItem();
    JMenuItem mnuCaiList = new JMenuItem();
    JMenuItem mnuCaiTui = new JMenuItem();
    JPanel jPanel1 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JLabel lblUser = new JLabel();
    JLabel lblTime = new JLabel();
    //JLabel lblSys = new JLabel();

    public MainFrame() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            begin();
            power();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void power() {
        boolean p1 = util.UserInfo.getUser().isP1();//是登陆的那个
        boolean p2 = util.UserInfo.getUser().isP2();
        boolean p3 = util.UserInfo.getUser().isP3();
        boolean p4 = util.UserInfo.getUser().isP4();
        boolean p5 = util.UserInfo.getUser().isP5();
        boolean p6 = util.UserInfo.getUser().isP6();

        /*if ( p1 != true) {
            this.mnuUserQuery.setVisible(false);
            this.mnuItemAddUser.setVisible(false);
            this.mnuLog.setVisible(false);
        }

        if ( p2 != true) {
           this.jMenu2.setVisible(false);
        }

        if ( p3 != true) {
           this.jMenu1.setVisible(false);
        }

        if ( p4 != true) {
            this.jMenu3.setVisible(false);
        }

        if ( p5 != true) {
            this.jMenu4.setVisible(false);
        }*/
        
        if ( p1 != true) {
            this.mnuUserQuery.setVisible(false);
            this.mnuItemAddUser.setVisible(false);
            this.mnuLog.setVisible(false);
        }
        
        if( p2 == true) {
            this.jMenu1.setVisible(false);//销售
            this.jMenu2.setVisible(false);//库存
            this.jMenu3.setVisible(false);//报损
            this.jMenu6.setVisible(false);//职员
            this.jMenu4.setVisible(false);//财务
         }
        
        if(p3==true){
        	this.jMenu1.setVisible(false);//销售
            this.jMenu7.setVisible(false);//采购
            this.jMenu5.setVisible(false);//供应商
            this.jMenu6.setVisible(false);//职员
            this.jMenu4.setVisible(false);//财务
        }

        if(p4==true){
        	this.jMenu2.setVisible(false);//库存
            this.jMenu7.setVisible(false);//采购
            this.jMenu5.setVisible(false);//供应商
            this.jMenu6.setVisible(false);//职员
            this.jMenu4.setVisible(false);//财务
        }
        
        if(p5==true){
        	this.jMenu2.setVisible(false);//库存
            this.jMenu7.setVisible(false);//采购
            this.jMenu5.setVisible(false);//供应商
            this.jMenu3.setVisible(false);//报损
            this.jMenu1.setVisible(false);//销售
            this.jMenu4.setVisible(false);//财务
        }

        
        if(p6==true){
        	this.jMenu2.setVisible(false);//库存
            this.jMenu7.setVisible(false);//采购
            this.jMenu5.setVisible(false);//供应商
            this.jMenu3.setVisible(false);//报损
            this.jMenu1.setVisible(false);//销售
            this.jMenu6.setVisible(false);//职员
        }


    }

    
    private void begin() throws Exception {
        contentPane = (JPanel) getContentPane();//this就是默认调用所定义类的实例化对象
        contentPane.setLayout(borderLayout1);
        //设置面板有两种方式 一种是setcontentpane 即让frame的对象.setcontentpane（）设置括号内为frame的面板
        //还有一种(JPanel) this.getContentPane()把Container强制类型转换为JPanel
        setTitle("超市管理系统");
        
        //this.addWindowListener(new MainFrame_this_windowAdapter(this));//对窗口函数重写监听
        jMenuBar1.setBackground(Color.white);
        jMenuFile.setMnemonic('S');
        jMenuFile.setText("管理员管理(S)");
        jMenuFile.setBackground(Color.white);
        jMenuFileExit.setMnemonic('X');
        jMenuFileExit.setText("退出(X)");
        jMenuFileExit.setBackground(Color.white);
        jMenuFileExit.addActionListener(new
                                        MainFrame_jMenuFileExit_ActionAdapter(this));
        mnuUserQuery.setMnemonic('C');
        mnuUserQuery.setBackground(Color.white);
        mnuUserQuery.setText("管理员列表(C)");
        mnuUserQuery.addActionListener(new MainFrame_mnuUserQuery_actionAdapter(this));
        mnuLog.setMnemonic('I');
        mnuLog.setText("管理员登陆信息(I)");
        mnuLog.setBackground(Color.white);
        mnuLog.addActionListener(new MainFrame_mnuLog_actionAdapter(this));
        mnuPass.setToolTipText("");
        mnuPass.setMnemonic('P');
        mnuPass.setText("修改密码(P)");
        mnuPass.setBackground(Color.white);
        mnuPass.addActionListener(new MainFrame_mnuPass_actionAdapter(this));
        mnuItemAddUser.setMnemonic('A');
        mnuItemAddUser.setText("添加管理员(A)");
        mnuItemAddUser.setBackground(Color.white);
        mnuItemAddUser.addActionListener(new
                                         MainFrame_mnuItemAddUser_actionAdapter(this));
        mnuLogout.setMnemonic('R');
        mnuLogout.setText("重新登录(R)");
        mnuLogout.setBackground(Color.white);
        mnuLogout.addActionListener(new MainFrame_mnuLogout_actionAdapter(this));
       
        
        jMenu1.setMnemonic('B');
        jMenu1.setText("销售管理(B)");
        mnuSaleC.setText("销售统计");
        mnuSaleC.setBackground(Color.white);
        mnuSaleC.addActionListener(new MainFrame_mnuSaleC_actionAdapter(this));
        
        mnuSalePrice.setText("销售价格设置");
        mnuSalePrice.setBackground(Color.white);
        mnuSalePrice.addActionListener(new MainFrame_mnuSalePrice_actionAdapter(this));
        mnuSaleBest.setText("当天最佳商品");
        mnuSaleBest.setBackground(Color.white);
        mnuSaleBest.addActionListener(new MainFrame_mnuSaleBest_actionAdapter(this));
        mnuSaleAdd.setMnemonic('D');
        mnuSaleAdd.setText("商品销售(D)");
        mnuSaleAdd.setBackground(Color.white);
        mnuSaleAdd.addActionListener(new MainFrame_mnuSaleAdd_actionAdapter(this));
        mnuSaleS.setMnemonic('C');
        mnuSaleS.setText("商品销售列表(C)");
        mnuSaleS.setBackground(Color.white);
        mnuSaleS.addActionListener(new MainFrame_mnuSaleS_actionAdapter(this));
        
        
        
        
        
        jMenu2.setText("库存管理(M)");
        mnuMedicineAdd.setMnemonic('R');
        mnuMedicineAdd.setBackground(Color.white);
        mnuMedicineAdd.setText("商品入库(R)");
        mnuMedicineAdd.addActionListener(new
                                         MainFrame_mnuMedicineAdd_actionAdapter(this));
        mnuMedicineS.setMnemonic('C');
        mnuMedicineS.setText("库存列表(C)");
        mnuMedicineS.setBackground(Color.white);
        mnuMedicineS.addActionListener(new MainFrame_mnuMedicineS_actionAdapter(this));
        mnuMedicineU.setMnemonic('U');
        mnuMedicineU.setBackground(Color.white);
        mnuMedicineU.setText("库存修改(U)");
        mnuMedicineU.addActionListener(new MainFrame_mnuMedicineU_actionAdapter(this));
        mnuYuAdd.setBackground(Color.white);
        mnuYuAdd.setText("预警设置");
        mnuYuAdd.addActionListener(new MainFrame_mnuYuAdd_actionAdapter(this));
        mnuYuJing.setBackground(Color.white);
        mnuYuJing.setText("库存预警列表");
        mnuYuJing.addActionListener(new MainFrame_mnuYuJing_actionAdapter(this));
        
        jMenu3.setMnemonic('H');
        jMenu3.setText("损毁管理(H)");
        mnuGuoQi.setBackground(Color.white);
        mnuGuoQi.setMnemonic('F');
        mnuGuoQi.setText("商品报损(F)");
        mnuGuoQi.addActionListener(new MainFrame_mnuGuoQi_actionAdapter(this));
        mnuGuoQiS.setMnemonic('C');
        mnuGuoQiS.setBackground(Color.white);
        mnuGuoQiS.setText("报损列表(C)");
        mnuGuoQiS.addActionListener(new MainFrame_mnuGuoQiS_actionAdapter(this));
        
        mnuGuoQiGai.setBackground(Color.white);
        mnuGuoQiGai.setText("报损修改");
        mnuGuoQiGai.addActionListener(new MainFrame_mnuGuoQiGai_actionAdapter(this));
        
        
        jMenu7.setText("采购管理");
        mnuCaiadd.setBackground(Color.white);
        mnuCaiadd.setText("采购添加");
        mnuCaiadd.addActionListener(new MainFrame_mnuCaiadd_actionAdapter(this));
        mnuCaiList.setBackground(Color.white);
        mnuCaiList.setText("采购列表");
        mnuCaiList.addActionListener(new MainFrame_mnuCaiList_actionAdapter(this));
        mnuCaiTui.setBackground(Color.white);
        mnuCaiTui.setText("采购退货");
        mnuCaiTui.addActionListener(new MainFrame_mnuCaiTui_actionAdapter(this));
        
      
        jMenu4.setText("财务统计");
        mnuzhichu.setBackground(Color.white);
        mnuzhichu.setText("支出费用信息");
        mnuzhichu.addActionListener(new MainFrame_mnuzhichu_actionAdapter(this));
        mnujin.setBackground(Color.white);
        mnujin.setText("进账盈利信息");
        mnujin.addActionListener(new MainFrame_mnujin_actionAdapter(this));
        /*jMenuItem18.setText("入库统计(R)");
        jMenuItem18.addActionListener(new MainFrame_jMenuItem18_actionAdapter(this));
        mnuTotalSale.setMnemonic('X');
        mnuTotalSale.setText("销售统计(X)");
        mnuTotalSale.addActionListener(new MainFrame_mnuTotalSale_actionAdapter(this));
        mnuTotalKuCun.setMnemonic('K');
        mnuTotalKuCun.setText("库存统计(K)");
        mnuTotalKuCun.addActionListener(new
                                        MainFrame_mnuTotalKuCun_actionAdapter(this));
        mnuTotalBaoSun.setText("报损统计(D)");
        mnuTotalBaoSun.addActionListener(new
                                         MainFrame_mnuTotalBaoSun_actionAdapter(this));*/
        
        
        jMenu5.setMnemonic('G');
        jMenu5.setText("供应商管理(G)");
        mnuSupplier.setMnemonic('P');
        mnuSupplier.setBackground(Color.white);
        mnuSupplier.setText("供应商信息(P)");
        mnuSupplier.addActionListener(new MainFrame_mnuSupplier_actionAdapter(this));
        mnuSupplierC.setMnemonic('Q');
        mnuSupplierC.setBackground(Color.white);
        mnuSupplierC.setText("供应商查询(Q)");
        mnuSupplierC.addActionListener(new MainFrame_mnuSupplierC_actionAdapter(this));
        mnuSupplierGai.setBackground(Color.white);
        mnuSupplierGai.setText("供应商修改");
        
        
        //------
        jMenu6.setText("职员管理");
        mnuPersonAdd.setText("职员添加");
        mnuPersonAdd.setBackground(Color.white);
        mnuPerson.setBackground(Color.white);
        mnuPerson.setText("职员列表");
        mnuPersonAdd.addActionListener(new MainFrame_mnuPersonAdd_actionAdapter(this));
        mnuPerson.addActionListener(new MainFrame_mnuPerson_actionAdapter(this));
        mnuDeptAdd.setText("部门添加");
        mnuDept.setText("部门列表");
        mnuDeptAdd.addActionListener(new MainFrame_mnuDeptAdd_actionAdapter(this));
        mnuDept.addActionListener(new MainFrame_mnuDept_actionAdapter(this));
        
        mnuDeptAdd.setBackground(Color.white);
        mnuDept.setBackground(Color.white);
        //--------
        
        jPanel1.setLayout(borderLayout2);
        lblUser.setBorder(BorderFactory.createLoweredBevelBorder());
        lblUser.setToolTipText("");
        lblUser.setText("           ");
        lblTime.setBorder(BorderFactory.createLoweredBevelBorder());
        //lblSys.setBorder(BorderFactory.createLoweredBevelBorder());
        //lblSys.setText("          ");
        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu7);
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu5);
        jMenuBar1.add(jMenu6);
        jMenuFile.add(mnuUserQuery);
        jMenuFile.add(mnuLog);
        jMenuFile.add(mnuItemAddUser);
        jMenuFile.addSeparator();
        jMenuFile.add(mnuPass);
        jMenuFile.add(mnuLogout);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuFileExit);
  
        //jMenuBar1.add(jMenuHelp);
       // jMenuHelp.add(jMenuHelpAbout);
        setJMenuBar(jMenuBar1);
        /*jButton1.setIcon(image1);
        jButton1.setToolTipText("Open File");
        jButton2.setIcon(image2);
        jButton2.setToolTipText("Close File");
        jButton3.setIcon(image3);
        jButton3.setToolTipText("Help");*/
        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);
        contentPane.add(jPanel1, java.awt.BorderLayout.SOUTH);
        //contentPane.add(jToolBar, BorderLayout.NORTH);
        contentPane.add(lblDesktop, BorderLayout.CENTER);
        jMenu1.add(mnuSalePrice);
        jMenu1.add(mnuSaleAdd);
        jMenu1.add(mnuSaleS);
        jMenu1.addSeparator();
        jMenu1.add(mnuSaleBest);
        jMenu1.add(mnuSaleC);
        jMenu2.add(mnuMedicineAdd);
        jMenu2.add(mnuMedicineS);
        jMenu2.add(mnuMedicineU);
        jMenu2.addSeparator();
        jMenu2.add(mnuYuJing);
        jMenu2.add(mnuYuAdd);
        jMenu3.add(mnuGuoQi);
        jMenu3.add(mnuGuoQiS);
        jMenu3.add(mnuGuoQiGai);
        /*jMenu4.add(jMenuItem18);
        jMenu4.add(mnuTotalSale);
        jMenu4.add(mnuTotalKuCun);
        jMenu4.add(mnuTotalBaoSun);*/
        jMenu4.add(mnuzhichu);
        jMenu4.add(mnujin);
        jMenu5.add(mnuSupplier);
        jMenu5.add(mnuSupplierC);
        jMenu5.add(mnuSupplierGai);
        jMenu6.add(mnuPersonAdd);
        jMenu6.add(mnuPerson);
        jMenu6.addSeparator();
        jMenu6.add(mnuDeptAdd);
        jMenu6.add(mnuDept);
        jMenu7.add(mnuCaiadd);
        jMenu7.add(mnuCaiList);
        jMenu7.addSeparator();
        jMenu7.add(mnuCaiTui);
        //jPanel1.add(lblSys, java.awt.BorderLayout.EAST);
        jPanel1.add(lblUser, java.awt.BorderLayout.WEST);
        jPanel1.add(lblTime, java.awt.BorderLayout.CENTER);
        
        lblUser.setBackground(Color.white);
        lblTime.setBackground(Color.white);

        showStatusBar();
        setSize(new Dimension(750, 500));
        util.FrameSet.showCenter(this);
    }

    public void showStatusBar(){
        final java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
                "yyyy年MM月dd日 E HH:mm:ss");
        javax.swing.Timer time = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String timeText = format.format(new java.util.Date());
                lblTime.setText("  时间: " + timeText + "  ");
                
            }
        });
        time.start();
        lblUser.setText("  欢迎管理员:"+ util.UserInfo.getUser().getUsername());
        //lblSys.setText(util.Globals.NAME);
    }


    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        dao.LogDao.add(util.UserInfo.getUser(),"退出系统");//放入登陆信息中去
        System.exit(0);//退出系统
    }

  
    
    
    public void mnuItemAddUser_actionPerformed(ActionEvent e) {
        UserAddDialog frame = new UserAddDialog(this);//一初始化一个useradddialog类对象，这个user。。就出来了
    }//调用的还是带有参数的useradddialog构造函数

    public void this_windowClosed(WindowEvent e) {
        dao.LogDao.add(util.UserInfo.getUser(),"退出系统");
    }

    public void this_windowClosing(WindowEvent e) {
        dao.LogDao.add(util.UserInfo.getUser(),"退出系统");
    }

    public void mnuLogout_actionPerformed(ActionEvent e) {
        new frame.LoginFrame();
        this.dispose();
    }

    public void mnuGuoQiGai_actionPerformed(ActionEvent e) {
        GuoQiGaiDialog frame = new GuoQiGaiDialog(this);
    }
    
    public void mnuPass_actionPerformed(ActionEvent e) {
        PasswordDialog frame = new PasswordDialog(this);
    }

    public void mnuLog_actionPerformed(ActionEvent e) {
        LogDialog frame = new LogDialog(this);
    }

    public void mnuUserQuery_actionPerformed(ActionEvent e) {
        UserQueryDialog frame = new UserQueryDialog(this);
    }

    public void mnuSupplier_actionPerformed(ActionEvent e) {
        SupplierAddDialog frame = new SupplierAddDialog(this);
    }
    
    

    public void mnuSupplierC_actionPerformed(ActionEvent e) {
        SupplierDialog frame = new SupplierDialog(this);
    }

    public void mnuPerson_actionPerformed(ActionEvent e){
    	PersonDialog frame = new PersonDialog(this);
    }
    
    public void mnuPersonAdd_actionPerformed(ActionEvent e){
    	PersonAddDialog frame = new PersonAddDialog(this);
    }
    
    public void mnuDeptAdd_actionPerformed(ActionEvent e){
    	DeptAddDialog frame = new DeptAddDialog(this);
    }
    
    public void mnuDept_actionPerformed(ActionEvent e){
    	DeptDialog frame = new DeptDialog(this);
    }
    
    public void mnuSalePrice_actionPerformed(ActionEvent e){
    	SaleSheDialog frame = new SaleSheDialog(this);
    }
    
    public void mnuSaleBest_actionPerformed(ActionEvent e) {
        SaleBest frame = new SaleBest(this);
    }
    
    public void mnuMedicineAdd_actionPerformed(ActionEvent e) {
        RukuDialog frame = new RukuDialog(this);
    }

    public void mnuMedicineC_actionPerformed(ActionEvent e) {
        MedicineSDialog frame = new MedicineSDialog(this);
    }

    public void mnuMedicineS_actionPerformed(ActionEvent e) {
        MedicineSDialog frame = new MedicineSDialog(this);
    }

    public void mnuMedicineU_actionPerformed(ActionEvent e) {
        MedicineUpdateDialog frame = new MedicineUpdateDialog(this);
    }

    public void mnuSaleAdd_actionPerformed(ActionEvent e) {
        SaleAddDialog frame = new SaleAddDialog(this);
    }

    public void mnuSaleS_actionPerformed(ActionEvent e) {
        SaleSDialog frame = new SaleSDialog(this);
    }

    public void mnuGuoQi_actionPerformed(ActionEvent e) {
        GuoQiAddDialog frame = new GuoQiAddDialog(this);
    }

    public void mnuGuoQiS_actionPerformed(ActionEvent e) {
        GuoQiSDialog frame = new GuoQiSDialog(this);
    }

    public void jMenuItem18_actionPerformed(ActionEvent e) {
        TotalRuKuSDialog frame = new TotalRuKuSDialog(this);
    }

    public void mnuzhichu_actionPerformed(ActionEvent e) {
        ZhiChuDialog frame = new ZhiChuDialog(this);
    }
    
    public void mnujin_actionPerformed(ActionEvent e) {
        JingZhDialog frame = new JingZhDialog(this);
    }
    
    /*public void mnuTotalSale_actionPerformed(ActionEvent e) {
        TotalSaleSDialog frame = new TotalSaleSDialog(this);
    }*/

    /*public void mnuTotalKuCun_actionPerformed(ActionEvent e) {
        TotalKuCunSDialog frame = new TotalKuCunSDialog(this);
    }

    public void mnuTotalBaoSun_actionPerformed(ActionEvent e) {
        TotalGuoQiSDialog frame = new TotalGuoQiSDialog(this);
    }*/
    
    
    public void mnuSaleC_actionPerformed(ActionEvent e) {
        SaleCDialog frame = new SaleCDialog(this);
    }
    
    public void mnuCaiadd_actionPerformed(ActionEvent e) {
        CaiAddDialog frame = new CaiAddDialog(this);
    }
    
    public void mnuCaiList_actionPerformed(ActionEvent e) {
        CaiDialog frame = new CaiDialog(this);
    }
    
    public void mnuCaiTui_actionPerformed(ActionEvent e) {
        CaiTuiDialog frame = new CaiTuiDialog(this);
    }
    
    public void mnuYuAdd_actionPerformed(ActionEvent e) {
        YuSheDialog frame = new YuSheDialog(this);
    }
    
    public void mnuYuJing_actionPerformed(ActionEvent e) {
        YuJingDialog frame = new YuJingDialog(this);
    }
}

class MainFrame_mnuYuJing_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuYuJing_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuYuJing_actionPerformed(e);
    }
}


class MainFrame_mnuSaleBest_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSaleBest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSaleBest_actionPerformed(e);
    }
}

class MainFrame_mnuYuAdd_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuYuAdd_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuYuAdd_actionPerformed(e);
    }
}

class MainFrame_mnuCaiadd_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuCaiadd_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuCaiadd_actionPerformed(e);
    }
}

class MainFrame_mnuCaiList_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuCaiList_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuCaiList_actionPerformed(e);
    }
}

class MainFrame_mnuCaiTui_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuCaiTui_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuCaiTui_actionPerformed(e);
    }
}

/*class MainFrame_mnuTotalBaoSun_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuTotalBaoSun_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuTotalBaoSun_actionPerformed(e);
    }
}*/


/*class MainFrame_mnuTotalKuCun_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuTotalKuCun_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuTotalKuCun_actionPerformed(e);
    }
}*/

class MainFrame_mnuGuoQiGai_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuGuoQiGai_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuGuoQiGai_actionPerformed(e);
    }
}

/*class MainFrame_mnuTotalSale_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuTotalSale_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuTotalSale_actionPerformed(e);
    }
}*/

class MainFrame_mnuzhichu_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuzhichu_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuzhichu_actionPerformed(e);
    }
}

class MainFrame_mnujin_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnujin_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnujin_actionPerformed(e);
    }
}

class MainFrame_jMenuItem18_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jMenuItem18_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem18_actionPerformed(e);
    }
}


class MainFrame_mnuGuoQiS_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuGuoQiS_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuGuoQiS_actionPerformed(e);
    }
}


class MainFrame_mnuGuoQi_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuGuoQi_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuGuoQi_actionPerformed(e);
    }
}


class MainFrame_mnuSaleS_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSaleS_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSaleS_actionPerformed(e);
    }
}


class MainFrame_mnuSaleAdd_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSaleAdd_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSaleAdd_actionPerformed(e);
    }
}


class MainFrame_mnuMedicineU_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuMedicineU_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuMedicineU_actionPerformed(e);
    }
}


class MainFrame_mnuMedicineS_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuMedicineS_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuMedicineS_actionPerformed(e);
    }
}


class MainFrame_mnuMedicineAdd_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuMedicineAdd_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuMedicineAdd_actionPerformed(e);
    }
}


//--------
class MainFrame_mnuPersonAdd_actionAdapter implements ActionListener{
	private MainFrame adaptee;
	MainFrame_mnuPersonAdd_actionAdapter(MainFrame adaptee){
		this.adaptee = adaptee;
	}
	
	public void actionPerformed(ActionEvent e){
		adaptee.mnuPersonAdd_actionPerformed(e);
	}
}

class MainFrame_mnuPerson_actionAdapter implements ActionListener{
	private MainFrame adaptee;
	MainFrame_mnuPerson_actionAdapter(MainFrame adaptee){
		this.adaptee = adaptee;
	}
	
	public void actionPerformed(ActionEvent e){
		adaptee.mnuPerson_actionPerformed(e);
	}
}

class MainFrame_mnuDeptAdd_actionAdapter implements ActionListener{
	private MainFrame adaptee;
	MainFrame_mnuDeptAdd_actionAdapter(MainFrame adaptee){
		this.adaptee = adaptee;
	}
	
	public void actionPerformed(ActionEvent e){
		adaptee.mnuDeptAdd_actionPerformed(e);
	}
}

class MainFrame_mnuDept_actionAdapter implements ActionListener{
	private MainFrame adaptee;
	MainFrame_mnuDept_actionAdapter(MainFrame adaptee){
		this.adaptee = adaptee;
	}
	
	public void actionPerformed(ActionEvent e){
		adaptee.mnuDept_actionPerformed(e);
	}
}
//---------

class MainFrame_mnuSupplierC_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSupplierC_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSupplierC_actionPerformed(e);
    }
}


class MainFrame_mnuSupplier_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSupplier_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSupplier_actionPerformed(e);
    }
}


class MainFrame_mnuUserQuery_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuUserQuery_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuUserQuery_actionPerformed(e);
    }
}


class MainFrame_mnuLog_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuLog_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuLog_actionPerformed(e);
    }
}

class MainFrame_mnuSalePrice_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSalePrice_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSalePrice_actionPerformed(e);
    }
}

class MainFrame_mnuSaleC_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuSaleC_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuSaleC_actionPerformed(e);
    }
}

class MainFrame_mnuPass_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuPass_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuPass_actionPerformed(e);
    }
}


class MainFrame_mnuLogout_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuLogout_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuLogout_actionPerformed(e);
    }
}

//对窗口函数进行重写
class MainFrame_this_windowAdapter extends WindowAdapter {
    private MainFrame adaptee;
    MainFrame_this_windowAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void windowClosed(WindowEvent e) {
        adaptee.this_windowClosed(e);
    }

    public void windowClosing(WindowEvent e) {
        adaptee.this_windowClosing(e);
    }
}


class MainFrame_mnuItemAddUser_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_mnuItemAddUser_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuItemAddUser_actionPerformed(e);
    }
}


class MainFrame_jMenuFileExit_ActionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_jMenuFileExit_ActionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}




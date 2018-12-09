package util;

import static java.util.Calendar.HOUR;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;





public class ClockPanel extends JPanel implements Runnable {
    // 3个指针的粗细
   private static final BasicStroke HOURS_POINT_WIDTH = new BasicStroke(5);
   private static final BasicStroke MINUETES_POINT_WIDTH = new BasicStroke(3);
   private static final BasicStroke SEC_POINT_WIDTH = new BasicStroke(2);
    private ImageIcon background;
    private int centerX; // 中心坐标
    private int centerY;
    private final static int secLen = 60; // 指针长度
    private final static int minuesLen = 55; // 指针长度
    private final static int hoursLen = 36; // 指针长度
    private Point fp; // 拖曳窗体之前的鼠标位置
    
    /**
     * 构造方法
     */
    public ClockPanel() {
        setOpaque(false);
        background = new ImageIcon(getClass().getResource("Core1.png"));
       int iconWidth = background.getIconWidth();//获得时钟的宽度
        centerX = iconWidth / 2; //x为宽度的中心
        int iconHeight = background.getIconHeight();
        centerY = iconHeight / 2;
        setPreferredSize(new Dimension(532, 286));//设定panel的大小
        new Thread(this).start();//开启runnable里面的线程
        //Thread clock;    clock=new Thread(this); //实例化进程   clock.start(); //开始进程
        
    }
    
    //重载组件的paint方法
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Composite composite = g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        Calendar calendar = Calendar.getInstance();
        drawClock(g2, calendar);// 绘制时钟
        g2.setComposite(composite);
        g2.drawImage(background.getImage(), 0, 0, this);
        g2.dispose();
    }
  //paint(g)函数会重绘图像，要加上super.paint(g)，表示在原来图像的基础上，再画图。
  //如果不加super.paint(g)，重绘时，会将原有的绘制清空，再根据paing(g)函数绘制。
    //paint方法不需要编写代码调用,只需要重写
    
    private void drawClock(Graphics2D g2, Calendar calendar) {
        //int millisecond = calendar.get(MILLISECOND);//微秒
        int sec = calendar.get(SECOND);//得到秒数
        int minutes = calendar.get(MINUTE);//得到分数
        int hours = calendar.get(HOUR);//得到小时数
        //double secAngle = (60 - sec) * 6 - (millisecond / 150); // 秒针角度
        int secAngle = (60 - sec) * 6;// 秒针角度
        int minutesAngle = (60 - minutes) * 6;// 分针角度
        int hoursAngle = (12 - hours) * 360 / 12 - (minutes / 2);// 时针角度//一小时占30度，一分钟占1/2度
        // 计算秒针、分针、时针指向坐标
        int secX = (int) (secLen * Math.sin(Math.toRadians(secAngle)));
        int secY = (int) (secLen * Math.cos(Math.toRadians(secAngle)));
        int minutesX = (int) (minuesLen * Math
                .sin(Math.toRadians(minutesAngle)));
        int minutesY = (int) (minuesLen * Math
                .cos(Math.toRadians(minutesAngle)));
        int hoursX = (int) (hoursLen * Math.sin(Math.toRadians(hoursAngle)));
        int hoursY = (int) (hoursLen * Math.cos(Math.toRadians(hoursAngle)));
        
       /* int secX = (int) (secLen * Math.sin(secAngle));
        int secY = (int) (secLen * Math.cos(secAngle));
        int minutesX = (int) (minuesLen * Math
                .sin(minutesAngle));
        int minutesY = (int) (minuesLen * Math
                .cos(minutesAngle));
        int hoursX = (int) (hoursLen * Math.sin(hoursAngle));
        int hoursY = (int) (hoursLen * Math.cos(hoursAngle));*/
        //Math.toRadians 转换为度大致相等的角度，以弧度为单位的角度。从角度到弧度的转换通常是不精确的。
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // 分别绘制时针、分针、秒针
        g2.setColor(Color.BLACK);
        g2.setStroke(HOURS_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - hoursX, centerY - hoursY);
        g2.setStroke(MINUETES_POINT_WIDTH);
        g2.setColor(Color.RED);
        g2.drawLine(centerX, centerY, centerX - minutesX, centerY - minutesY);
        g2.setColor(Color.GREEN);
        g2.setStroke(SEC_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - secX, centerY - secY);
        // 绘制3个指针的中心园
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
    }
    
    
    public void run() {
        try {
            while (true) {
                if (getRootPane() != null) {
                    JFrame main = (JFrame) getRootPane().getParent();
                    if (main != null && main.isVisible()) {
                        //EventQueue.invokeLater(new Runnable() {
                            //public void run() {
                                ClockPanel.this.repaint();//调用paint方法
                                
                           // }
                        //});
                   }
               }
                Thread.sleep(999);//进程暂0.999秒
            }
        } catch (InterruptedException e) {
            e.printStackTrace();//输出出错信息
        }
    }
    
   /* protected void do_this_mouseDragged(final MouseEvent e) {
        JDialog frame = (JDialog) getRootPane().getParent();
        Point point = e.getLocationOnScreen();
        frame.setLocation(point.x - fp.x, point.y - fp.y);
    }
    
    protected void do_this_mousePressed(final MouseEvent e) {
        fp = e.getPoint();
    }*/
}

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
    // 3��ָ��Ĵ�ϸ
   private static final BasicStroke HOURS_POINT_WIDTH = new BasicStroke(5);
   private static final BasicStroke MINUETES_POINT_WIDTH = new BasicStroke(3);
   private static final BasicStroke SEC_POINT_WIDTH = new BasicStroke(2);
    private ImageIcon background;
    private int centerX; // ��������
    private int centerY;
    private final static int secLen = 60; // ָ�볤��
    private final static int minuesLen = 55; // ָ�볤��
    private final static int hoursLen = 36; // ָ�볤��
    private Point fp; // ��ҷ����֮ǰ�����λ��
    
    /**
     * ���췽��
     */
    public ClockPanel() {
        setOpaque(false);
        background = new ImageIcon(getClass().getResource("Core1.png"));
       int iconWidth = background.getIconWidth();//���ʱ�ӵĿ���
        centerX = iconWidth / 2; //xΪ���ȵ�����
        int iconHeight = background.getIconHeight();
        centerY = iconHeight / 2;
        setPreferredSize(new Dimension(532, 286));//�趨panel�Ĵ�С
        new Thread(this).start();//����runnable������߳�
        //Thread clock;    clock=new Thread(this); //ʵ��������   clock.start(); //��ʼ����
        
    }
    
    //���������paint����
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Composite composite = g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        Calendar calendar = Calendar.getInstance();
        drawClock(g2, calendar);// ����ʱ��
        g2.setComposite(composite);
        g2.drawImage(background.getImage(), 0, 0, this);
        g2.dispose();
    }
  //paint(g)�������ػ�ͼ��Ҫ����super.paint(g)����ʾ��ԭ��ͼ��Ļ����ϣ��ٻ�ͼ��
  //�������super.paint(g)���ػ�ʱ���Ὣԭ�еĻ�����գ��ٸ���paing(g)�������ơ�
    //paint��������Ҫ��д�������,ֻ��Ҫ��д
    
    private void drawClock(Graphics2D g2, Calendar calendar) {
        //int millisecond = calendar.get(MILLISECOND);//΢��
        int sec = calendar.get(SECOND);//�õ�����
        int minutes = calendar.get(MINUTE);//�õ�����
        int hours = calendar.get(HOUR);//�õ�Сʱ��
        //double secAngle = (60 - sec) * 6 - (millisecond / 150); // ����Ƕ�
        int secAngle = (60 - sec) * 6;// ����Ƕ�
        int minutesAngle = (60 - minutes) * 6;// ����Ƕ�
        int hoursAngle = (12 - hours) * 360 / 12 - (minutes / 2);// ʱ��Ƕ�//һСʱռ30�ȣ�һ����ռ1/2��
        // �������롢���롢ʱ��ָ������
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
        //Math.toRadians ת��Ϊ�ȴ�����ȵĽǶȣ��Ի���Ϊ��λ�ĽǶȡ��ӽǶȵ����ȵ�ת��ͨ���ǲ���ȷ�ġ�
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // �ֱ����ʱ�롢���롢����
        g2.setColor(Color.BLACK);
        g2.setStroke(HOURS_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - hoursX, centerY - hoursY);
        g2.setStroke(MINUETES_POINT_WIDTH);
        g2.setColor(Color.RED);
        g2.drawLine(centerX, centerY, centerX - minutesX, centerY - minutesY);
        g2.setColor(Color.GREEN);
        g2.setStroke(SEC_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - secX, centerY - secY);
        // ����3��ָ�������԰
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
                                ClockPanel.this.repaint();//����paint����
                                
                           // }
                        //});
                   }
               }
                Thread.sleep(999);//������0.999��
            }
        } catch (InterruptedException e) {
            e.printStackTrace();//���������Ϣ
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
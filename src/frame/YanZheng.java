package frame;
import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.geom.AffineTransform;  
import java.util.Random;  
import javax.swing.JComponent;

public class YanZheng extends JComponent  {
	/*JPanel �� JComponent��һ�֡�
jpanel����һ��ƽ�壬������壬���ǿ����кܶ��ֲ��ֿ�ѡ��
JComponent������ �� ����һ����ʲô������û�о��嶨������Ӧ����ʲô��ۣ�ֻ��˵�����ܹ�����������swing�����
���� jlist����һ���������Ž�jlist����������б���ʽ��
jtableҲ��һ������������Ǳ��״��ʾ��*/
	private int CLength = 4;
	private Random random = new Random();
	
	private int width = 95,height = 40;
	private String code;

	public YanZheng(){
		setPreferredSize(new Dimension(width,height));
		
		setToolTipText("���������֤��");
	}
	
	public String getcode(){
		return code;
	}
	
	public Color RColor(){
		//int length = this.CLength;
		
		int red = random.nextInt(255);
		int green = random.nextInt(255);
		int blue = random.nextInt(255);
		
		return new Color(red,green,blue);
	}
	
	public String Code(){
		char[] codes = new char[4];
		String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		for (int i = 0;i < 4; i++){
			codes[i] = a.charAt(random.nextInt(a.length()));
		}
		this.code = new String(codes);
		return code;
		
	}
	
    public void paintComponent(Graphics g){
    	//super.paintComponent(g);
    	if(this.code==null||this.code.length()!=4){
    		this.code = Code();
    	}
    	
    	super.setPreferredSize(new Dimension(width, height));  
    	Font mFont = new Font("Arial", Font.BOLD | Font.ITALIC, 25);  
        g.setFont(mFont);
        
        //----����
        Graphics2D g2d = (Graphics2D) g;  
        g2d.setColor(new Color(255,255,255));  
        g2d.fillRect(0, 0, width, height);  
        g2d.setColor(new Color(0,0,0));  
        g2d.drawRect(0, 0, width - 1, height - 1);
        
        //-----------������
        int i = 0, len = 70;  
        for (; i < len; i++) {  
            int x = random.nextInt(width - 1);  
            int y = random.nextInt(height - 1);  
            int x1 = random.nextInt(width - 5) + 5;  
            int y1 = random.nextInt(height - 4) + 4;  
            g2d.setColor(new Color(128,128,128));
            
            g2d.drawLine(x, y, x1, y1);  
        }  
        
        //----��ĸ
        i = 0; len = 4;  
        FontMetrics fm = g2d.getFontMetrics();//��ȡָ������Ĺ��  
        int base = (height - fm.getHeight())/2 + fm.getAscent();  //���ظ������y��
        for(;i<len;i++) {  
            g2d.setColor(RColor());  
           // g2d.drawString(code.charAt(i)+"", 16 * i + 10, base);  
            g2d.drawString(code.charAt(i)+"", 16 * i + 10, base);
        }
    	}
    
        public void begin(){
        	repaint();
        }
        
        public void mouseClicked(MouseEvent e) {
        	begin();  
        } 
        
    	
    }


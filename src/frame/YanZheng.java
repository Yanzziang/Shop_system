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
	/*JPanel 是 JComponent的一种。
jpanel就是一个平板，叫做面板，但是可以有很多种布局可选择。
JComponent叫容器 ， 并不一定是什么东西，没有具体定义容器应该是什么外观，只是说明他能够容纳其他的swing组件。
比如 jlist就是一种容器，放进jlist的组件都是列表形式的
jtable也是一种容器，组件是表格状显示的*/
	private int CLength = 4;
	private Random random = new Random();
	
	private int width = 95,height = 40;
	private String code;

	public YanZheng(){
		setPreferredSize(new Dimension(width,height));
		
		setToolTipText("点击更换验证码");
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
        
        //----背景
        Graphics2D g2d = (Graphics2D) g;  
        g2d.setColor(new Color(255,255,255));  
        g2d.fillRect(0, 0, width, height);  
        g2d.setColor(new Color(0,0,0));  
        g2d.drawRect(0, 0, width - 1, height - 1);
        
        //-----------背景线
        int i = 0, len = 70;  
        for (; i < len; i++) {  
            int x = random.nextInt(width - 1);  
            int y = random.nextInt(height - 1);  
            int x1 = random.nextInt(width - 5) + 5;  
            int y1 = random.nextInt(height - 4) + 4;  
            g2d.setColor(new Color(128,128,128));
            
            g2d.drawLine(x, y, x1, y1);  
        }  
        
        //----字母
        i = 0; len = 4;  
        FontMetrics fm = g2d.getFontMetrics();//获取指定字体的规格  
        int base = (height - fm.getHeight())/2 + fm.getAscent();  //返回该字体的y轴
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


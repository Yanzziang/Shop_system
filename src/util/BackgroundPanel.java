package util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * 背景面板
 * 
 * @author 
 */
public class BackgroundPanel extends JPanel {
    private Image image;// 背景图片    
    public BackgroundPanel() {
        setOpaque(false);
        setLayout(null);// 使用绝对定位布局控件
    }    
    /**
     * 设置背景图片对象的方法
     * 
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }    
    /**
     * 画出背景
     */
    protected void paintComponent(Graphics g) {
        if (image != null) {// 如果图片已经初始化
            // 画出图片
            g.drawImage(image, 0, 0, this);
        }
        super.paintComponent(g);
    }
}
//paint(g)函数会重绘图像，要加上super.paint(g)，表示在原来图像的基础上，再画图。
//如果不加super.paint(g)，重绘时，会将原有的绘制清空，再根据paing(g)函数绘制。

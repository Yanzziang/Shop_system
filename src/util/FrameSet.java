package util;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JDialog;

public class FrameSet {

    static boolean packFrame = false;

    //窗口置中并显示
    public static void showCenter(Frame frame){
        if (packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    public static void showCenter(JDialog frame) {
        if (packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

}

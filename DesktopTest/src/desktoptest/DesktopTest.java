package desktoptest;

import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.UIManager;

public class DesktopTest {
    
    private static int tkWidth;
    private static int tkHeight;

    
    public static void main(String[] args) {
        
        try{
            //Set System l&F
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception exception){
                exception.printStackTrace();
        }
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) toolkit.getScreenSize().getWidth());
        tkHeight = ((int) toolkit.getScreenSize().getHeight());
        
        DesktopFrame desktopFrame = new DesktopFrame();
        desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desktopFrame.setSize(tkWidth, tkHeight);  //set frame size
        desktopFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        desktopFrame.setVisible(true);  //display frame
    }
    
}

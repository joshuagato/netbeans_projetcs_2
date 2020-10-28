package simpletexteditor;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.UIManager.*;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class SimpleTextEditorDemo {

    
    public static void main(String[] args) {
        
        try{
            //Set System l&F
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }// */ /*
        }
        catch(Exception exception){
                exception.printStackTrace();
        }
        
        SimpleTextEditorFrame frame = new SimpleTextEditorFrame();
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        int tkWidth = ((int) toolKit.getScreenSize().getWidth());
        int tkHeight = ((int) toolKit.getScreenSize().getHeight());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setLayout(null);
        //frame.setSize(1280,760);
        //frame.setSize(1100,700);
        //frame.setSize(tkWidth,tkHeight);
        frame.setSize(300,150);
        frame.setVisible(true);
    }
    
}

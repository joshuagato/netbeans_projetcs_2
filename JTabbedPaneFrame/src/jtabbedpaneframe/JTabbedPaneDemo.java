package jtabbedpaneframe;

import javax.swing.UIManager.*;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class JTabbedPaneDemo {
    
    public static void main(String[] args) {
        
        try{
            //Set System l&F
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            /*for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        }
        catch(Exception exception){
                exception.printStackTrace();
        }
        
        JTabbedPaneFrame tabbedPaneFrame = new JTabbedPaneFrame();
        tabbedPaneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabbedPaneFrame.setSize(400,250);
        tabbedPaneFrame.setVisible(true);
    }
    
}

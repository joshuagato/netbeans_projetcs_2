package gridbaglayout;

import javax.swing.*;
import javax.swing.UIManager.*;

public class GridBagDemo {

    
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
            } //   /*   */
        }
        catch(Exception exception){
                exception.printStackTrace();
        }
        
       GridBagFrame gridBagFrame = new GridBagFrame();
       gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       gridBagFrame.setSize(300,150);
       gridBagFrame.setVisible(true);
    }
    
}

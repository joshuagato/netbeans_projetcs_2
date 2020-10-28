package firstgraphical;

import javax.swing.*;
import javax.swing.UIManager.*;

public class GooeeTest {

    
    
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
            }
        }
        catch(Exception exception){
                exception.printStackTrace();
        }
        
        Gooee gui = new Gooee();
        gui.setVisible(true);
        gui.setSize(400,500);
        //gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

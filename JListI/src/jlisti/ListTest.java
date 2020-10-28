package jlisti;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.*;



public class ListTest {

    
    
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
        
        
        
        ListFrame listFrame = new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listFrame.setVisible(true);
        listFrame.setSize(350,150);
    }
    
}

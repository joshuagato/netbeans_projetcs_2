package myjdialogdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;

public class JDialogTest {

    
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
        
        //final JFrame frame = new JFrame("JDialog Demo");
        
        JDialogFrame loginDlg = new JDialogFrame();
        loginDlg.setVisible(true);
        loginDlg.setTitle("Login");
        
        /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        //frame.getContentPane().add(btnLogin);
        frame.setVisible(true);*/
        
    }
    
}

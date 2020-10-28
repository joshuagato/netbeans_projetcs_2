package logintest;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.util.InputMismatchException;

public class AncAppTest {
    private static int tkWidth;
    private static int tkHeight;
    public static RealAppFrame realAppFrame;
    public static DatabaseConnection databaseConn;
    public static PasswordUtils pswd;
    
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
        
        // /*  */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) toolkit.getScreenSize().getWidth());
        tkHeight = ((int) toolkit.getScreenSize().getHeight());
        
        realAppFrame = new RealAppFrame();
        realAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        realAppFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //realAppFrame.setLocationRelativeTo(null);
        realAppFrame.setSize(tkWidth, tkHeight);
        realAppFrame.setVisible(true);
        realAppFrame.setEnabled(false);
        
        
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);
        //loginFrame.getContentPane().setOpaque(false);
        
        pswd = new PasswordUtils();
        
        try{
        databaseConn = new DatabaseConnection();
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Couldn't Connect to Database", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        
    
}

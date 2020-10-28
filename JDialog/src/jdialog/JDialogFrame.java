package jdialog;

import java.awt.*;
import javax.swing.*;
//import javax.swing.border.*;

public class JDialogFrame extends JDialog{
    
    private JTextField username;
    private JPasswordField password;
    private JLabel lblusername, lblpassword;
    private JButton submit, cancel;
    
    public JDialogFrame(){
        super("Login");
        
        JPanel panel = new JPanel (new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
    }
}

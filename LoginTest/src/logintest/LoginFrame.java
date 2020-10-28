package logintest;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static logintest.AncAppTest.databaseConn;

public class LoginFrame extends JFrame{
    private static JLabel usernamelbl, passwordlbl;
    private static JTextField usernametxf;
    private static JPasswordField passwordpwf;
    private static JButton cancelbtn, loginbtn;
    private static String un, pwd;
    //String[] resultValue = null;
    //private static DatabaseConnection databaseConn;
    
    
    public LoginFrame(){
        super("Login Test");
        setSize(370,200);
        setLayout(null);
        
        usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(10,10,70,25);
        add(usernamelbl);
        
        usernametxf = new JTextField();
        usernametxf.setBounds(90,10,250,25);
        add(usernametxf);
        
        passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(10,60,70,25);
        add(passwordlbl);
        
        passwordpwf = new JPasswordField();
        passwordpwf.setBounds(90,60,250,25);
        add(passwordpwf);
        
        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(170,110,80,25);
        add(cancelbtn);
        cancelbtn.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.exit(0);
                }
            }
        );
        
        
        loginbtn = new JButton("Login");
        loginbtn.setBounds(260,110,80,25);
        add(loginbtn);
        loginbtn.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    un = usernametxf.getText(); pwd = passwordpwf.getText();
                    
                    try {
                        if((un.equals("")) || (pwd.equals(""))){
                            JOptionPane.showMessageDialog(null, "Please fill all fields!", "All fields Required!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            try{
                                databaseConn = new DatabaseConnection();
                            }
                            catch(SQLException sqlException){
                                JOptionPane.showMessageDialog(null, sqlException.getMessage(), "No Database Connection!", JOptionPane.ERROR_MESSAGE);
                            }
                            
                            String[] resultValue = AncAppTest.databaseConn.userLogin(un, pwd);

                            String securePassword = resultValue[1];
                            String saltValue = resultValue[2];

                            Boolean myVerifiedPassword = PasswordUtils.verifyUserPassword(pwd, securePassword, saltValue);
                            
                            if(myVerifiedPassword == true){
                                
                                //JOptionPane.showMessageDialog(null, "Result: " + myVerifiedPassword, "Login Outcome", JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Welcome to the Antenatal App", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                                
                                AncAppTest.realAppFrame.setEnabled(true);

                                dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "The Username or Password is not Correcct! Please check and try again!", "Username & Password Mismatch", JOptionPane.ERROR_MESSAGE);
                            }

                            
                        }
                    } 
                    catch (Exception ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            }
        );
    }
    
}

package logintest;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import java.util.InputMismatchException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import static logintest.AncAppTest.databaseConn; //***

public class AddUser extends JFrame {
    private static JLabel fnlabel, snlabel, pnlabel, unlabel, pwdlabel, cfmpwwdlabel;
    private static JTextField fnfield, snfield, pnfield, unfield;
    private static JPasswordField password, cfmpassword;
    private static JButton createbtn;
    private static String fn, sn, pn, un, pw, cpw, slt;
    private static int pk, unlength;
    
    public AddUser(){
        super("Add New User");
        setLayout(null);
        setResizable(false);
        
        fnlabel = new JLabel("Firstname");
        fnlabel.setBounds(10,20,60,27);
        add(fnlabel);
        
        fnfield = new JTextField();
        fnfield.setBounds(70,20,200,27);
        add(fnfield);
        
        snlabel = new JLabel("Surname");
        snlabel.setBounds(300,20,55,27);
        add(snlabel);
        
        snfield = new JTextField();
        snfield.setBounds(355,20,200,27);
        add(snfield);
        
        pnlabel = new JLabel("Phone #");
        pnlabel.setBounds(590,20,50,27);
        add(pnlabel);
        
        pnfield = new JTextField();
        pnfield.setBounds(640,20,200,27);
        add(pnfield);
        
        //-----------------------------------------------------------------------------------
        
        unlabel = new JLabel("Username");
        unlabel.setBounds(10,77,60,27);
        add(unlabel);
        
        unfield = new JTextField();
        unfield.setBounds(70,77,200,27);
        add(unfield);
        
        pwdlabel = new JLabel("Password");
        pwdlabel.setBounds(300,77,60,27);
        add(pwdlabel);
        
        password = new JPasswordField();
        password.setBounds(355,77,200,27);
        add(password);
        
        cfmpwwdlabel = new JLabel("Re-Password");
        cfmpwwdlabel.setBounds(580,77,80,27);
        add(cfmpwwdlabel);
        
        cfmpassword = new JPasswordField();
        cfmpassword.setBounds(655,77,200,27);
        add(cfmpassword);
        
        //-------------------------------------------------------------------------------------
        
        
        
        createbtn = new JButton("Create User");
        createbtn.setBounds(720,135,110,27);
        add(createbtn);
        createbtn.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    fn = fnfield.getText(); sn = snfield.getText(); pn = pnfield.getText();
                    un = unfield.getText(); pw = password.getText(); cpw = cfmpassword.getText();
                    //unlength = un.length();
                    
                    String myPassword = pw;
                    String salt = PasswordUtils.getSalt(30);
                    String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
                    slt = salt;
                                            
                    try {
                        if( (fn.equals("")) || (sn.equals("")) || (pn.equals("")) || (un.equals("")) || (pw.equals("")) || (cpw.equals("")) ){
                            
                            JOptionPane.showMessageDialog(null, "Please fill all fields!", "All fields Required!", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(un.length() < 4){
                            JOptionPane.showMessageDialog(null, "Please your Username should not be less than four (4) characters!", "Username too short!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(!pw.equals(cpw)){   //pw.equals(cpw)  pw == cpw
                                JOptionPane.showMessageDialog(null, "The Passwords you entered don't match!", "Passwords Mismatch!", JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                databaseConn = new DatabaseConnection();
                                Boolean verifyUsername = AncAppTest.databaseConn.verifyUsername(un);
                                String verify = AncAppTest.databaseConn.verify(un);
                                
                                //JOptionPane.showMessageDialog(null, "Results: " +verifyUsername, "Results!", JOptionPane.ERROR_MESSAGE);
                                //JOptionPane.showMessageDialog(null, "Results: " +verify, "Results!", JOptionPane.ERROR_MESSAGE);
                                
                                if(verifyUsername == true){
                                    JOptionPane.showMessageDialog(null, "Please choose a different username!", "Username already taken!", JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                AncAppTest.databaseConn.addUser(pk, fn, sn, pn, un, mySecurePassword, mySecurePassword, slt);

                                //JOptionPane.showMessageDialog(null, "Secure Password: " + mySecurePassword, "User Add Success", JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Congrats! New User Successfully Added", "User Add Success", JOptionPane.INFORMATION_MESSAGE);
                                fnfield.setText(""); snfield.setText(""); pnfield.setText("");
                                unfield.setText(""); password.setText(""); cfmpassword.setText("");
                                }
                            }
                        }
                    }
                    
                    catch(Exception exception){
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "No Connection to Database", JOptionPane.ERROR_MESSAGE);
                    } 
                }
            }
        );
        
    }
    
}

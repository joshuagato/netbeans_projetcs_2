package textfield;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TextFieldFrame extends JFrame{
    
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField;
    
    public TextFieldFrame(){
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());
        
        //Construct textfield with 10 columns
        textField1 = new JTextField(10);
        add(textField1);
        
        //Construct textfield default text
        textField2 = new JTextField("Enter text here");
        add(textField2);
        
        //Construct textfield with default text and 21 columns
        textField3 = new JTextField("Uneditable text field", 21);
        textField3.setEditable(false);
        add(textField3);
        
        //Construct passwordfield with default text
        passwordField = new JPasswordField("Hidden Text");
        add(passwordField);
        
        //Register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);      
    }
    
        //Private inner class for event handling
        private class TextFieldHandler implements ActionListener{
            public void actionPerformed(ActionEvent event){
                String string = "";

                //User pressed enter in textfield1
                if(event.getSource() == textField1){
                    //string = textField1.getText();
                    string = String.format("textField1: %s", event.getActionCommand());
                }
                else if(event.getSource() == textField2){
                    string = String.format("textField2: %s", event.getActionCommand());
                }
                else if(event.getSource() == textField3){
                    string = String.format("textField3: %s", event.getActionCommand());
                }
                else if(event.getSource() == passwordField){
                    string = String.format("passwordField: %s", event.getActionCommand());
                }
                JOptionPane.showMessageDialog(null,string);
            }
        }
    
}

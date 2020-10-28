package jtextarea;

import javax.swing.*;
import java.awt.event.*;

public class TextAreaFrame extends JFrame{
    private JTextArea textArea1;  //Displays demo string
    private JTextArea textArea2;  //Highlighted text is copied here
    private JButton copyJButton;  //Initiated copying of text
    
    public TextAreaFrame(){
        super("TextAreaDemo");
        Box box = Box.createHorizontalBox();  //Create box
        String demo = "This is a demo string to \n"
                + "Illustrate copying text \n from one textarea to \n" 
                + "another textarea using an \n external event \n";
        textArea1 = new JTextArea(demo, 10, 15);  //Create textarea1
        box.add(new JScrollPane(textArea1));  //Add scrollpane
        
        copyJButton = new JButton("Copy >>>");  //Create copu button
        box.add(copyJButton);  //add copy button to box
        copyJButton.addActionListener(
            new ActionListener(){   //Anonymous inner class
                public void actionPerformed(ActionEvent event){
                    textArea2.setText(textArea1.getSelectedText());
                }
            }
        );
        
        textArea2 = new JTextArea(10,15);  //Create textarea2
        textArea2.setEditable(false);  //Disable editing
        textArea2.setLineWrap(true);
        box.add(new JScrollPane(textArea2));  //Add scrollpane
        //JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
        
        add(box);
    }
}

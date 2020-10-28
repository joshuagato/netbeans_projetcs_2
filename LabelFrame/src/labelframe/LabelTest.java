package LabelFrame;

import javax.swing.JFrame;
import javax.swing.*;

public class LabelTest {
    
    public static void main(String[] args){
        LabelFrame labelFrame = new LabelFrame();
        
        labelFrame.setSize(260,190);
        labelFrame.setVisible(true);
        labelFrame.setResizable(false);
        labelFrame.setLocationRelativeTo(null);
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}

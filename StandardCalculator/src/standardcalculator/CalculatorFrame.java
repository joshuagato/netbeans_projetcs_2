package standardcalculator;

import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame {
    
    private JTextArea screenTextArea,screenTextArea2;
    private JButton [] numButtons, symButtons;
    private static final String [] buttonNumbers = {"← ","CE","SH","log","(",")","7","8","9","cos","÷","x^",
        "4","5","6","sin","×","√","1","2","3","tan","-","d","0",".","%","n!","+","="};
    private static final String [] buttonSymbols = {};
    private JPanel panel1,panel2;
    
    
    public CalculatorFrame(){
        super("Standard Calculator");
        setLayout(new BorderLayout(1,1));
        
        screenTextArea = new JTextArea(8,69);
        screenTextArea.setEditable(false);
        screenTextArea.setLineWrap(true);
        add(screenTextArea, BorderLayout.NORTH);
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5,6));
        numButtons = new JButton[buttonNumbers.length];
           
        for (int count=0; count < buttonNumbers.length; count++){
            numButtons[count] = new JButton(buttonNumbers[count]);
            panel1.add(numButtons[count]);
        }
        add(panel1, BorderLayout.CENTER);
        
        
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5,2));
        symButtons = new JButton[buttonSymbols.length];
        
        for (int count=0; count<buttonSymbols.length; count++){
            symButtons[count] = new JButton(buttonSymbols[count]);
            panel2.add(symButtons[count]);
        }
        //add(panel2, BorderLayout.EAST);
    }  
}

package forloopgraphical;

import javax.swing.*;
import java.awt.event.*;

public class ForLoopFrame extends JFrame{
    private int sum=0;
    private JTextField sumTextField, numbersTextField;
    
    public ForLoopFrame(){
        super("For Loop");
        setLayout(null);
        
        JLabel topicLabel = new JLabel("A For Loop that adds all even integers from 0 to 10");
        topicLabel.setBounds(40,10,300,25);
        add(topicLabel);
        
        JLabel numbersLabel = new JLabel("The Even numbers:");
        numbersLabel.setBounds(10,75,120,25);
        add(numbersLabel);
        
        numbersTextField = new JTextField();
        numbersTextField.setBounds(140,75,230,25);
        numbersTextField.setEditable(false);
        add(numbersTextField);
        
        JLabel sumLabel = new JLabel("The Sum is:");
        sumLabel.setBounds(10,140,120,25);
        add(sumLabel);
        
        sumTextField = new JTextField();
        sumTextField.setBounds(140,140,230,25);
        sumTextField.setEditable(false);
        add(sumTextField);
        
        CalculateHandler handler = new CalculateHandler();
        JButton calculateButton = new JButton("Calculate Sum");
        calculateButton.setBounds(220,200,150,25);
        add(calculateButton);
        calculateButton.addActionListener(handler);
        
        /*calculateButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    for(int x=0; x<=10; x++){
                        sum = sum + x;
                    }
                }
            }
	);*/
       }
    
        private class CalculateHandler implements ActionListener{
            public void actionPerformed(ActionEvent event){
                if(event.getActionCommand() == "Calculate Sum"){
                    for(int x=1; x<=10; x++){
                        if(x%2==0){
                            numbersTextField.replaceSelection(Integer.toString(x) + ", ");
                            sum = sum + x;
                        }
                        
                    }
                    //sumTextField.setText(Integer.toString(sum));
                    sumTextField.setText(String.valueOf(sum));
                }
            }
        }
        
    
    
}

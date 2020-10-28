package borderlayout;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BorderLayoutFrame extends JFrame implements ActionListener{
    
    private JButton [] buttons;
    private static final String [] names = {"Hide North","Hide South","Hide East","Hide West","Hide Center"};
    private BorderLayout layout;  //Borderlayout object
    
    //Setup GUI and event handling
    public BorderLayoutFrame(){
        super("BorderLayout Demo");
        
        layout = new BorderLayout(5,5); //5 pixel gaps
        setLayout(layout);  //set frame layout
        buttons = new JButton[names.length];  //set size of array
        
        //create buttons and register listeners for them
        for (int count=0; count < names.length; count++){
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
        }
        
        add(buttons[0], BorderLayout.NORTH);  //add button to north
        add(buttons[1], BorderLayout.SOUTH);  //add button to south
        add(buttons[2], BorderLayout.EAST);  //add button to east
        add(buttons[3], BorderLayout.WEST);  //add button to west
        add(buttons[4], BorderLayout.CENTER);  //add button to center
    }
    
    //handle button events
    public void actionPerformed(ActionEvent event){
        
        //Check event source and lay out content pane correspondingly
        for (JButton button : buttons){
            if(event.getSource() == button){
                button.setVisible(false);  //Hide button clicked
            }
            else{
                button.setVisible(true);  //Show other buttons
            }
        }
        layout.layoutContainer(getContentPane());  //lay out content pane
    }
    
}

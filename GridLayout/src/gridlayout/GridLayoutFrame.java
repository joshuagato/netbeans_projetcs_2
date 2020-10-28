package gridlayout;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridLayoutFrame extends JFrame implements ActionListener{
    
    private JButton [] buttons;
    private static final String [] names = {"One","Two","Three","Four","Five","Six"};
    private boolean toggle = true;  //toggle between two layouts
    private Container container;  //Frame container
    private GridLayout gridlayout1;
    private GridLayout gridlayout2;
    
    public GridLayoutFrame(){
        super("GridLayout Demo");
        
        gridlayout1 = new GridLayout(2,3,5,5);  //2 by 3; Gaps of 5
        gridlayout2 = new GridLayout(3,2);
        
        container = getContentPane();  //Get content pane
        setLayout(gridlayout1);  //set JFrame  layout
        buttons = new JButton[names.length];  //Create array of buttons
        
        for (int count=0; count<names.length; count++){
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);  //Register listener
            add(buttons[count]);  //add button  to JFrame
        }
    }
    
    public void actionPerformed(ActionEvent event){
        if(toggle){
            container.setLayout(gridlayout2);  //set layout to second
        }
        else{
            container.setLayout(gridlayout1);  //set layout to first
        }
        toggle = !toggle;  //set toggle to opposite value
        container.validate();  //re-lay out container
    }
    
}

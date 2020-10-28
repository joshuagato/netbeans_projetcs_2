package jpopupmenudemo.PopupTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PopupFrame extends JFrame{
    private JRadioButtonMenuItem [] items;
    private final Color [] colorValues = {Color.blue, Color.yellow, Color.red};
    private JPopupMenu popupMenu;
    
    public PopupFrame(){
        super("Using JPopupMenus");
        ItemHandler handler = new ItemHandler();
        String [] colors = {"Blue", "Yellow", "Red"};
        
        ButtonGroup colorGroup = new ButtonGroup();
        popupMenu = new JPopupMenu();
        items = new JRadioButtonMenuItem[colors.length];
        
        for(int count=0; count<colors.length; count++){
            items[count] = new JRadioButtonMenuItem(colors[count]);
            popupMenu.add(colors[count]);
            colorGroup.add(items[count]);
            items[count].addActionListener(handler);
        }
        setBackground(Color.white);
        
        //Declare a mouse listener for window to display pop-up menu
        addMouseListener(
            new MouseAdapter(){  //Anonymous inner class
                //Handle mouse press event
                public void mousePressed(MouseEvent event){
                    checkForTriggerEvent(event);  //Check for trigger
                }
                public void mouseReleased(MouseEvent event){
                    checkForTriggerEvent(event);  //Check for trigger
                }
                //Determine whether event should trigger pop-up menu
                private void checkForTriggerEvent(MouseEvent event){
                    if(event.isPopupTrigger()){popupMenu.show(event.getComponent(), event.getX(), event.getY());}
                }
            }
        );
    }
    
    //Private inner class to handle menu item events
    public class ItemHandler implements ActionListener{
        
        //Process item menu selections
        public void actionPerformed(ActionEvent event){
            for(int i=0; i<items.length; i++){   //Determine which item was selected
                if(event.getSource()==items[i]);
                getContentPane().setBackground(colorValues[i]);
                return;
            }
        }
    }
    
    
    
}

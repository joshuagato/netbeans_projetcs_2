package jlisti;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame {
    private JList colorJList;
    private JComboBox colorJCombo;
    private static final String [] colorNames = {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray","Magenta",
    "Orange","Pink","Red","White","Yellow"};
    private static final Color [] colors = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,
    Color.lightGray,Color.magenta,Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
    
    public ListFrame(){
        super("List Test");
        setLayout(new FlowLayout());
        
        colorJList = new JList(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Do not allow multiple selections
        add(new JScrollPane(colorJList));
        
        colorJList.addListSelectionListener(
             new ListSelectionListener(){
                 public void valueChanged(ListSelectionEvent event){
                     getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
                 }
            }
        );
        
        colorJCombo = new JComboBox(colorNames);
        colorJCombo.setMaximumRowCount(4);
        add(colorJCombo);
        
        colorJCombo.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if ( event.getStateChange() == ItemEvent.SELECTED ){   // This line of code is optional
                        getContentPane().setBackground(colors[colorJCombo.getSelectedIndex()]);
                    }
                }
            }
        );
    }
}

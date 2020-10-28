package jmenudemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuFrame extends JFrame{
    private final Color [] colorValues = {Color.black, Color.blue, Color.red, Color.green};
    private JRadioButtonMenuItem [] colorItems;
    private JRadioButtonMenuItem [] fonts;
    private JCheckBoxMenuItem [] styleItems;
    private JLabel displayJLabel;
    private ButtonGroup fontButtonGroup;
    private ButtonGroup colorButtonGroup;
    private int style;
    
    //No-Argument Constructor set up GUI
    public MenuFrame(){
        super("Using JMenus");
        
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        
        //Create the File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        bar.add(fileMenu);
        
        //Create About... Menu item
        JMenuItem aboutItem = new JMenuItem("About...");
        aboutItem.setMnemonic('A');
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(
             new ActionListener(){
                 public void actionPerformed(ActionEvent event){
                     JOptionPane.showMessageDialog(MenuFrame.this,"This is an example \nof using Menus",
                     "About", JOptionPane.PLAIN_MESSAGE);
                 }
             }
        );
        
        //Create Exit Menu item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');
        fileMenu.add(exitItem);
        exitItem.addActionListener(
            new ActionListener(){ //Anonymous Inner Class
                public void actionPerformed(ActionEvent event){ //Action Performed
                    System.exit(0);
                }
            }
        );
        
        
        
        //Create the Format Menu
        JMenu formatMenu = new JMenu("Format");
        formatMenu.setMnemonic('r');
        bar.add(formatMenu);
        
        String [] colors = {"Black","Blue","Red","Green"};
        
        //Create the Color Menu
        JMenu colorMenu = new JMenu("Color");
        colorMenu.setMnemonic('c');
        //**bar.add(colorMenu);**
        
        //Create Radio button menu items for colors
        colorItems = new JRadioButtonMenuItem[colors.length];
        colorButtonGroup = new ButtonGroup(); //Manages colors
        ItemHandler itemHandler = new ItemHandler(); //Handler for colors
        
        //Create color radio button menu items
        for(int count=0; count<colors.length; count++){
            colorItems[count] = new JRadioButtonMenuItem(colors[count]); //Create Item
            colorMenu.add(colorItems[count]); //Add item to color menu
            colorButtonGroup.add(colorItems[count]); //Add to group
            colorItems[count].addActionListener(itemHandler);
        }
        
        colorItems[0].setSelected(true);
        formatMenu.add(colorMenu); //Add Color menu to Format menu
        formatMenu.addSeparator(); //Add separator in menu
        
        
        //Array list for font names
        String [] fontNames = {"Serif","Monospaced","SansSerif"};
        
        JMenu fontMenu = new JMenu("Font");
        fontMenu.setMnemonic('n');
        
        //Create radio button menu items for font names
        fonts = new JRadioButtonMenuItem[fontNames.length];
        fontButtonGroup = new ButtonGroup();
        
        //Create radio button menu items
        for (int count=0; count<fontNames.length; count++){
            fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
            fontMenu.add(fonts[count]);
            fontButtonGroup.add(fonts[count]);
            fonts[count].addActionListener(itemHandler);
        }
        fonts[0].setSelected(true);
        fontMenu.addSeparator();
        
        String[] styleNames = {"Bold","Italic"};
        
        styleItems = new JCheckBoxMenuItem[styleNames.length];
        StyleHandler stylehandler = new StyleHandler();
        
        for(int count=0; count<styleNames.length; count++){
            styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
            fontMenu.add(styleItems[count]);
            styleItems[count].addItemListener(stylehandler);
        }
        formatMenu.add(fontMenu);  //Add Font menu to Format menu
        
        
        //Set up label to display text
        displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
        displayJLabel.setForeground(colorValues[0]);
        displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));
        
        getContentPane().setBackground(Color.CYAN);
        add(displayJLabel,BorderLayout.CENTER);
    }    
    
        //Inner class to handle action events from menu items
        private class ItemHandler implements ActionListener{
            
            //Process color and font selections
            public void actionPerformed(ActionEvent  event){
                for (int count=0; count<colorItems.length; count++){
                    if(colorItems[count].isSelected()){
                        displayJLabel.setForeground(colorValues[count]);
                        break;
                    }
                }
                
                //Process font selection
                for (int count=0; count<fonts.length; count++){
                    if(event.getSource()== fonts[count]){
                        displayJLabel.setFont(new Font(fonts[count].getText(), style, 72));
                    }
                }
                
                repaint();
            }
        }
        
        
        //Inner class to handle item events from checkbox menu items
        private class StyleHandler implements ItemListener{
            
            //Process font style selction
            public void itemStateChanged(ItemEvent e){
                String name = displayJLabel.getFont().getName(); //Curent font
                Font font;  //New font based on user selection
                
                //Determine which items are checked and create font
                if (styleItems[0].isSelected() && styleItems[1].isSelected()){
                    font = new Font(name, Font.BOLD + Font.ITALIC, 72);
                }
                else if(styleItems[0].isSelected()){
                    font = new Font(name, Font.BOLD, 72);
                }
                else if(styleItems[1].isSelected()){
                    font = new Font(name, Font.ITALIC, 72);
                }
                else{
                    font = new Font(name, Font.PLAIN, 72);
                }
                
                displayJLabel.setFont(font);
                repaint();
            }
        }
        
        
        
        
    
    
}

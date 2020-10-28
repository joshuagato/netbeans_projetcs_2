package lookandfeel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LookAndFeelFrame extends JFrame {
    private UIManager.LookAndFeelInfo [] looks;
    private String [] lookNames;
    private JRadioButton [] radio;
    private ButtonGroup group;
    private JButton button;
    private JLabel label;
    private JComboBox comboBox;
    
    public LookAndFeelFrame(){
        super("Look and Feel Demo");
        
        //Get installed look-and-feel information
        looks = UIManager.getInstalledLookAndFeels();
        lookNames = new String [looks.length];
        
        //Get names of installed look-and-feels
        for (int i=0; i<looks.length; i++)
        lookNames[i] = looks[i].getName();
        
        JPanel northPanel = new JPanel();  //Create north Panel
        northPanel.setLayout(new GridLayout(3,1,0,5));
        
        label = new JLabel("This is a " + lookNames[0] + " look-and-feel", SwingConstants.CENTER);
        northPanel.add(label);
        
        button = new JButton("JButton");
        northPanel.add(button);
        
        comboBox = new JComboBox(lookNames);
        northPanel.add(comboBox);
        
        //Create array for radio buttons
        radio = new JRadioButton[looks.length];
        
        JPanel southPanel = new JPanel();
        
        //Use a GridLayout with 3  buttons in each row
        int rows = (int)Math.ceil(radio.length/3.0);
        southPanel.setLayout(new GridLayout(rows, 3));
        
        group = new ButtonGroup();
        ItemHandler handler = new ItemHandler();
        
        for (int count=0; count<radio.length; count++){
            radio[count] = new JRadioButton(lookNames[count]);
            radio[count].addItemListener(handler);
            group.add(radio[count]);
            southPanel.add(radio[count]);
        }
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        
        radio[0].setSelected(true);   
    }
    
        private void changeTheLookAndFeel(int value){
            try{
                    UIManager.setLookAndFeel(looks[value].getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        
        //Private inner class to handle radio button events
        private class ItemHandler implements ItemListener{
            public void itemStateChanged(ItemEvent event){
                for(int count=0; count<radio.length; count++){
                    if(radio[count].isSelected()){
                        label.setText(String.format("This is a %s look-and-feel", lookNames[count]));
                        comboBox.setSelectedIndex(count);
                        changeTheLookAndFeel(count);
                    }
                }
            }
        }
}

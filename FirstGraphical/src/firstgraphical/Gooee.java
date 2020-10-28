/*Joshua - 26/02/2018*/
package firstgraphical;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gooee extends JFrame{
    
    private UIManager.LookAndFeelInfo [] looks;
    private String [] lookNames;
    
    public Gooee(){
        super("First GUI Demo");
        
        //Get installed look-and-feel information
        looks = UIManager.getInstalledLookAndFeels();
        lookNames = new String [looks.length];
        
        //Get names of installed look-and-feels
        for (int i=0; i<looks.length; i++)
        lookNames[i] = looks[i].getName();
        
        ImageIcon img = new ImageIcon(getClass().getResource("bug3.jpg"));
        setIconImage(img.getImage());
        
        
        
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        //jmb.setBounds(0,0,385,23);

        JMenu mn1 = new JMenu("File");
        JMenuItem jmi1 = new JMenuItem("New         Ctrl + N"); mn1.add(jmi1);
        JMenuItem jmi2 = new JMenuItem("Open        Ctrl + O"); mn1.add(jmi2);
        JMenuItem jmi3 = new JMenuItem("Save"); mn1.add(jmi3);
        JMenuItem jmi4 = new JMenuItem("Exit"); mn1.add(jmi4);
        JMenuItem jmi5 = new JMenuItem("Print       Ctrl + P"); mn1.add(jmi5);
        jmb.add(mn1);
        
        JMenu mn2 = new JMenu("Edit");
        JMenuItem jmi11 = new JMenuItem("Copy       Ctrl + C"); mn2.add(jmi11);
        JMenuItem jmi12 = new JMenuItem("Cut"); mn2.add(jmi12);
        JMenuItem jmi13 = new JMenuItem("Paste"); mn2.add(jmi13);
        JMenuItem jmi14 = new JMenuItem("Undo"); mn2.add(jmi14);
        JMenuItem jmi15 = new JMenuItem("Redo       Ctrl + Y"); mn2.add(jmi15);
        jmb.add(mn2);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("Panel one", null, panel1, "First Panel");
        panel1.setLayout(null);
        
        
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Panel Two", null, panel2, "Second Panel");        
        
        add(tabbedPane);

        
        JTextField tf1 = new JTextField();
        tf1.setToolTipText("Enter firstname here");
        tf1.setBounds(100,30,270,22);
        panel1.add(tf1);
        
        JLabel lb1 = new JLabel("Firstname");
        lb1.setBounds(10,30,70,23);
        panel1.add(lb1);
        
        
        
        JLabel lb2 = new JLabel("Surname");
        lb2.setBounds(10,70,70,23);
        panel1.add(lb2);
        
        JTextField tf2 = new JTextField();
        tf2.setToolTipText("Enter Surname here");
        tf2.setBounds(100,70,270,22);
        panel1.add(tf2);
        
        
        
        JLabel lb3 = new JLabel("Username");
        lb3.setBounds(10,110,70,23);
        panel1.add(lb3);
        
        JTextField tf3 = new JTextField();
        tf3.setToolTipText("Enter Username here");
        tf3.setBounds(100,110,270,22);
        panel1.add(tf3);
        
        
        
        JLabel lb4 = new JLabel("Password");
        lb4.setBounds(10,150,70,23);
        panel1.add(lb4);
        
        JPasswordField tf4 = new JPasswordField();
        tf4.setToolTipText("Enter Password here");
        tf4.setBounds(100,150,270,22);
        panel1.add(tf4);
        
        
        JLabel lb5 = new JLabel("Gender");
        lb5.setBounds(10,190,70,23);
        panel1.add(lb5);
                
        JRadioButton rb1 = new JRadioButton("Male");
        rb1.setBounds(100,190,80,23);
        panel1.add(rb1);
                
        JRadioButton rb2 = new JRadioButton("Female");
        rb2.setBounds(180,190,80,23);
        panel1.add(rb2);
                
        ButtonGroup rbg = new ButtonGroup();
        rbg.add(rb1);
        rbg.add(rb2);
        
        
        
        JLabel lb6 = new JLabel("Regions Visited");
        lb6.setBounds(10,230,100,23);
        panel1.add(lb6);
        
        JCheckBox cb1 = new JCheckBox("Western");
        cb1.setBounds(110,230,80,23);
        panel1.add(cb1);
                
        JCheckBox cb2 = new JCheckBox("Eastern");
        cb2.setBounds(190,230,80,23);
        panel1.add(cb2);
                
        JCheckBox cb3 = new JCheckBox("Central");
        cb3.setBounds(270,230,80,23);
        panel1.add(cb3);        
        
        
        JLabel lb7 = new JLabel("Western");
        lb7.setBounds(10,270,70,23);
        panel1.add(lb7);
        
        JComboBox cmb1 = new JComboBox();
        cmb1.addItem("Select City");
        cmb1.addItem("Secondi");
        cmb1.addItem("Takoradi");
        cmb1.addItem("Afiekuma");
        cmb1.addItem("Kwesimintim");
        cmb1.setMaximumRowCount(3);
        cmb1.setBounds(70,270,100,23);
        panel1.add(cmb1);
        
        
        JLabel lb8 = new JLabel("Eastern");
        lb8.setBounds(190,270,70,23);
        panel1.add(lb8);
        
        String eastern [] = {"Select City","Suhum","Nsawam","Koforidua","New Abirem"};
        JComboBox cmb2 = new JComboBox(eastern);
        cmb2.setMaximumRowCount(3);
        cmb2.setBounds(245,270,120,23);
        panel1.add(cmb2);
        
        
        ChangeButtonHandler handler = new ChangeButtonHandler();
        
        JButton btn1 = new JButton("Clear");
        panel1.add(btn1);
        btn1.setBounds(180,370,80,23);
        
        btn1.addActionListener(handler);
        
        JButton btn2 = new JButton("Submit");
        panel1.add(btn2);
        btn2.setBounds(280,370,80,23);
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
    private class ChangeButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent event){
                changeTheLookAndFeel(1);
            }
        }
    
}

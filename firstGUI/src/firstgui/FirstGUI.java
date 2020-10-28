// A Simple GUI Appplication
// Joshua Gato, 7th January, 2018
package firstgui;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FirstGUI{
    private UIManager.LookAndFeelInfo[]looks; //Looks and Feels
    private String [] lookNames;  //Names of looks and feels

    //public static final int width = 300;
    //public static final int height = 200;
    
    //public int width = 300;
    //public int height = 200;
    
    public FirstGUI(){
        JFrame firstWindow = new JFrame();

        firstWindow.setSize(385,500);
        firstWindow.setVisible(true);
        firstWindow.setTitle("Forms");
        firstWindow.setResizable(false);
        //firstWindow.setBackground(Color.cyan);
        firstWindow.setLayout(null);
        firstWindow.setLocationRelativeTo(null);
        firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Color wine = new Color(200,150,0);
        //firstWindow.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        
        //ImageIcon img = new ImageIcon("bug1.jpg");
        ImageIcon img = new ImageIcon(getClass().getResource("bug3.png"));
        firstWindow.setIconImage(img.getImage());
        
        
        
        JMenuBar jmb = new JMenuBar();
        firstWindow.setJMenuBar(jmb);
        jmb.setBounds(0,0,385,23);

        JMenu mn1 = new JMenu("File");
        jmb.add(mn1);
        JMenuItem jmi1 = new JMenuItem("New"); mn1.add(jmi1);
        JMenuItem jmi2 = new JMenuItem("Open"); mn1.add(jmi2);
        JMenuItem jmi3 = new JMenuItem("Save"); mn1.add(jmi3);
        JMenuItem jmi4 = new JMenuItem("Exit"); mn1.add(jmi4);
        JMenuItem jmi5 = new JMenuItem("Print"); mn1.add(jmi5);
        mn1.setBounds(1,1,60,23);
        
        JMenu mn2 = new JMenu("Edit");
        jmb.add(mn2);
        JMenuItem jmi11 = new JMenuItem("Copy"); mn2.add(jmi11);
        JMenuItem jmi12 = new JMenuItem("Cut"); mn2.add(jmi12);
        JMenuItem jmi13 = new JMenuItem("Paste"); mn2.add(jmi13);
        JMenuItem jmi14 = new JMenuItem("Undo"); mn2.add(jmi14);
        JMenuItem jmi15 = new JMenuItem("Redo"); mn2.add(jmi15);
        mn2.setBounds(61,1,60,23);

        
        JTextField tf1 = new JTextField();
        firstWindow.add(tf1);
        tf1.setToolTipText("Enter firstname here");
        tf1.setBounds(100,30,270,22);
        
        JLabel lb1 = new JLabel("Firstname");
        firstWindow.add(lb1);
        lb1.setBounds(10,30,70,23);
        
        
        
        JLabel lb2 = new JLabel("Surname");
        firstWindow.add(lb2);
        lb2.setBounds(10,70,70,23);
        
        JTextField tf2 = new JTextField();
        firstWindow.add(tf2);
        tf2.setToolTipText("Enter Surname here");
        tf2.setBounds(100,70,270,22);
        
        
        
        JLabel lb3 = new JLabel("Username");
        firstWindow.add(lb3);
        lb3.setBounds(10,110,70,23);
        
        JTextField tf3 = new JTextField();
        firstWindow.add(tf3);
        tf3.setToolTipText("Enter Username here");
        tf3.setBounds(100,110,270,22);
        
        
        
        JLabel lb4 = new JLabel("Password");
        firstWindow.add(lb4);
        lb4.setBounds(10,150,70,23);
        
        JPasswordField tf4 = new JPasswordField();
        firstWindow.add(tf4);
        tf4.setToolTipText("Enter Password here");
        tf4.setBounds(100,150,270,22);
        
        
        
        JLabel lb5 = new JLabel("Gender");
        firstWindow.add(lb5);
        lb5.setBounds(10,190,70,23);
        
        JRadioButton rb1 = new JRadioButton("Male");
        firstWindow.add(rb1);
        rb1.setBounds(100,190,80,23);
        
        JRadioButton rb2 = new JRadioButton("Female");
        firstWindow.add(rb2);
        rb2.setBounds(180,190,80,23);
        
        ButtonGroup rbg = new ButtonGroup();
        rbg.add(rb1);
        rbg.add(rb2);
        
        
        
        JLabel lb6 = new JLabel("Regions Visited");
        firstWindow.add(lb6);
        lb6.setBounds(10,230,100,23);
        
        JCheckBox cb1 = new JCheckBox("Western");
        firstWindow.add(cb1);
        cb1.setBounds(100,230,80,23);
        
        JCheckBox cb2 = new JCheckBox("Eastern");
        firstWindow.add(cb2);
        cb2.setBounds(180,230,80,23);
        
        JCheckBox cb3 = new JCheckBox("Central");
        firstWindow.add(cb3);
        cb3.setBounds(260,230,80,23);
        
        
        
        JLabel lb7 = new JLabel("Western");
        firstWindow.add(lb7);
        lb7.setBounds(10,270,80,23);
        
        JComboBox cmb1 = new JComboBox();
        cmb1.addItem("Select City");
        cmb1.addItem("Secondi");
        cmb1.addItem("Takoradi");
        cmb1.addItem("Afiekuma");
        cmb1.addItem("Kwesimintim");
        firstWindow.add(cmb1);
        cmb1.setMaximumRowCount(3);
        cmb1.setBounds(100,270,120,23);
        
        
        
        JLabel lb8 = new JLabel("Eastern");
        firstWindow.add(lb8);
        lb8.setBounds(10,310,80,23);
        
        JComboBox cmb2 = new JComboBox();
        cmb2.addItem("Select City");
        cmb2.addItem("Suhum");
        cmb2.addItem("Nsawam");
        cmb2.addItem("Koforidua");
        cmb2.addItem("New Abirem");
        firstWindow.add(cmb2);
        cmb2.setMaximumRowCount(3);
        cmb2.setBounds(100,310,120,23);
        
        
        
        /*JLabel lb9 = new JLabel("Colors");
        firstWindow.add(lb9);
        lb9.setBounds(10,350,80,23);
                
        String [] colors = {"Select Color","Orange","White","Green","Black","Gray","Yellow"};
        JList ls = new JList(colors);
        //firstWindow.add(new JScrollPane(ls));
        firstWindow.add(ls);
        //ls.setVisibleRowCount(3);
        //ls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp = new JScrollPane(ls);
        firstWindow.add(jsp);
        
        ls.setBounds(100,350,120,23);*/
        
        
        /*JButton btn1 = new JButton("Clear");
        firstWindow.add(btn1);
        btn1.setBounds(180,250,80,23);
        //btn1.addActionListener();*/
        
        looks = UIManager.getInstalledLookAndFeels();
        lookNames = new String[looks.length];
        
        for(int i=0; i<looks.length; i++)
            lookNames[i] = looks[i].getName();
        
        
        
        
        JButton btn2 = new JButton("Submit");
        firstWindow.add(btn2);
        btn2.setBounds(280,350,80,23);
        btn2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    changeTheLookAndFeel(lookNames[0]);
                }     
            }
        );

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
    
    
    public static void main(String[] args) {     
        //new FirstGUI();
        FirstGUI firstGUI = new FirstGUI();
    } 
}

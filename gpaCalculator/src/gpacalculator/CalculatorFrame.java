package gpacalculator;

//import javafx.scene.paint.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CalculatorFrame extends JFrame {
    
        public double c1gradePoint,c2gradePoint,c3gradePoint,c4gradePoint; //private double gradePoint1;
        public double c1gradeIndex,c2gradeIndex,c3gradeIndex,c4gradeIndex;
        public int c1creditHours,c2creditHours,c3creditHours,c4creditHours; //private int creditHours1;
        public int c1HourIndex,c2HourIndex,c3HourIndex,c4HourIndex;
        public int c1counter,c2counter,c3counter,c4counter;
        public double totalProduct, c1product,c2product,c3product,c4product;
        public int selected1, selected2,selected3,selected4;
        public int counterSum, selectedSum;
        public double gpa;
        public Color ltGray = new Color(214,220,219);
        public Color ltGreen = new Color(152,233,215);
        
    
    public CalculatorFrame(){
        super("GPA Calculator");
        
        //Creating a Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        
        //Creating a Panel and appending to first tab
        JPanel tab1Panel = new JPanel();
        tab1Panel.setLayout(null);
        //tab1Panel.setBackground(ltGray);
        tabbedPane.addTab("Calculate Semester GPA", null, tab1Panel, "Semester GPA");
        
        
        //Creating a Label and two Combo boxes for Course 1
        JLabel course1label = new JLabel("Course 1");
        tab1Panel.add(course1label);
        course1label.setBounds(10,15,60,25);
        
        double gp [] = {0, 4.0, 1.5};
        String pg = null;
        
        String hours [] = {"Select Hours","1","2","3","4","5","6"};
        JComboBox course1hours = new JComboBox(hours);
        course1hours.setMaximumRowCount(4);
        course1hours.setBounds(70,15,100,25);
        tab1Panel.add(course1hours);
        course1hours.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED);
                    c1HourIndex = course1hours.getSelectedIndex();
                    
                    if(c1HourIndex==1){c1creditHours = 1;}
                    else if(c1HourIndex==2){c1creditHours = 2;}
                    else if(c1HourIndex==3){c1creditHours = 3;}
                    else if(c1HourIndex==4){c1creditHours = 4;}
                    else if(c1HourIndex==5){c1creditHours = 5;}
                    else if(c1HourIndex==6){c1creditHours = 6;}
                }
            }
        );
        
        String grades [] = {"Select Grade","A","B+","B","C+","C","D+","D","E"};
        JComboBox course1Grade = new JComboBox(grades);
        course1Grade.setMaximumRowCount(4);
        course1Grade.setBounds(180,15,100,25);
        tab1Panel.add(course1Grade);
        course1Grade.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c1gradeIndex = course1Grade.getSelectedIndex();
                    
                    if(c1gradeIndex==1){c1gradePoint = 4.0;}
                    else if(c1gradeIndex==2){c1gradePoint = 3.5;}
                    else if(c1gradeIndex==3){c1gradePoint = 3.0;}
                    else if(c1gradeIndex==4){c1gradePoint = 2.5;}
                    else if(c1gradeIndex==5){c1gradePoint = 2.0;}
                    else if(c1gradeIndex==6){c1gradePoint = 1.5;}
                    else if(c1gradeIndex==7){c1gradePoint = 1.0;}
                    else if(c1gradeIndex==8){c1gradePoint = 0;}
                    }
                }
            }
        );
        
               
        
        
        
        //Creating a Label and two Combo boxes for Course 2
        JLabel course2label = new JLabel("Course 2");
        course2label.setBounds(300,15,60,25);
        tab1Panel.add(course2label);
        
        JComboBox course2hours = new JComboBox(hours);
        course2hours.setMaximumRowCount(4);
        course2hours.setBounds(360,15,100,25);
        tab1Panel.add(course2hours);
        course2hours.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c2HourIndex = course2hours.getSelectedIndex();
                    
                    if(c2HourIndex==1){c2creditHours = 1;}
                    else if(c2HourIndex==2){c2creditHours = 2;}
                    else if(c2HourIndex==3){c2creditHours = 3;}
                    else if(c2HourIndex==4){c2creditHours = 4;}
                    else if(c2HourIndex==5){c2creditHours = 5;}
                    else if(c2HourIndex==6){c2creditHours = 6;}
                    }
                }
            }
        );

        JComboBox course2Grade = new JComboBox(grades);
        course2Grade.setMaximumRowCount(4);
        course2Grade.setBounds(470,15,100,25);
        tab1Panel.add(course2Grade);
        course2Grade.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c2gradeIndex = course2Grade.getSelectedIndex();
                    
                    if(c2gradeIndex==1){c2gradePoint = 4.0;}
                    else if(c2gradeIndex==2){c2gradePoint = 3.5;}
                    else if(c2gradeIndex==3){c2gradePoint = 3.0;}
                    else if(c2gradeIndex==4){c2gradePoint = 2.5;}
                    else if(c2gradeIndex==5){c2gradePoint = 2.0;}
                    else if(c2gradeIndex==6){c2gradePoint = 1.5;}
                    else if(c2gradeIndex==7){c2gradePoint = 1.0;}
                    else if(c2gradeIndex==8){c2gradePoint = 0;}
                    }
                }
            }
        );
        
        
        
        
        
        
        
        //Creating a Label and two Combo boxes for Course 3
        JLabel course3label = new JLabel("Course 3");
        course3label.setBounds(10,55,60,25);
        tab1Panel.add(course3label);
        
        JComboBox course3hours = new JComboBox(hours);
        course3hours.setMaximumRowCount(4);
        course3hours.setBounds(70,55,100,25);
        tab1Panel.add(course3hours);
        course3hours.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c3HourIndex = course3hours.getSelectedIndex();
                    
                    if(c3HourIndex==1){c3creditHours = 1;}
                    else if(c3HourIndex==2){c3creditHours = 2;}
                    else if(c3HourIndex==3){c3creditHours = 3;}
                    else if(c3HourIndex==4){c3creditHours = 4;}
                    else if(c3HourIndex==5){c3creditHours = 5;}
                    else if(c3HourIndex==6){c3creditHours = 6;}
                    }
                }
            }
        );
        
        JComboBox course3Grade = new JComboBox(grades);
        course3Grade.setMaximumRowCount(4);
        course3Grade.setBounds(180,55,100,25);
        tab1Panel.add(course3Grade);
        course3Grade.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c3gradeIndex = course3Grade.getSelectedIndex();
                    
                    if(c3gradeIndex==1){c3gradePoint = 4.0;}
                    else if(c3gradeIndex==2){c3gradePoint = 3.5;}
                    else if(c3gradeIndex==3){c3gradePoint = 3.0;}
                    else if(c3gradeIndex==4){c3gradePoint = 2.5;}
                    else if(c3gradeIndex==5){c3gradePoint = 2.0;}
                    else if(c3gradeIndex==6){c3gradePoint = 1.5;}
                    else if(c3gradeIndex==7){c3gradePoint = 1.0;}
                    else if(c3gradeIndex==8){c3gradePoint = 0;}
                    }
                }
            }
        );
        
        
        
        
        //Creating a Label and two Combo boxes for Course 4
        JLabel course4label = new JLabel("Course 4");
        course4label.setBounds(300,55,60,25);
        tab1Panel.add(course4label);
        
        JComboBox course4hours = new JComboBox(hours);
        course4hours.setMaximumRowCount(4);
        course4hours.setBounds(360,55,100,25);
        tab1Panel.add(course4hours);
        course4hours.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c4HourIndex = course4hours.getSelectedIndex();
                    
                    if(c4HourIndex==1){c4creditHours = 1;}
                    else if(c4HourIndex==2){c4creditHours = 2;}
                    else if(c4HourIndex==3){c4creditHours = 3;}
                    else if(c4HourIndex==4){c4creditHours = 4;}
                    else if(c4HourIndex==5){c4creditHours = 5;}
                    else if(c4HourIndex==6){c4creditHours = 6;}
                    }
                }
            }
        );
        
        JComboBox course4Grade = new JComboBox(grades);
        course4Grade.setMaximumRowCount(4);
        course4Grade.setBounds(470,55,100,25);
        tab1Panel.add(course4Grade);
        course4Grade.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if (event.getStateChange()==ItemEvent.SELECTED){
                    c4gradeIndex = course4Grade.getSelectedIndex();
                    
                    if(c4gradeIndex==1){c4gradePoint = 4.0;}
                    else if(c4gradeIndex==2){c4gradePoint = 3.5;}
                    else if(c4gradeIndex==3){c4gradePoint = 3.0;}
                    else if(c4gradeIndex==4){c4gradePoint = 2.5;}
                    else if(c4gradeIndex==5){c4gradePoint = 2.0;}
                    else if(c4gradeIndex==6){c4gradePoint = 1.5;}
                    else if(c4gradeIndex==7){c4gradePoint = 1.0;}
                    else if(c4gradeIndex==8){c4gradePoint = 0;}
                    }
                }
            }
        );
        
        
        
        
        JButton clear = new JButton("Clear");
        tab1Panel.add(clear);
        clear.setBounds(360,95,100,25);
        clear.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    course1hours.setSelectedIndex(0);  course1Grade.setSelectedIndex(0);
                    course2hours.setSelectedIndex(0);  course2Grade.setSelectedIndex(0);
                    course3hours.setSelectedIndex(0);  course3Grade.setSelectedIndex(0);
                    course4hours.setSelectedIndex(0);  course4Grade.setSelectedIndex(0);
                }
            }
        );
        
        
        
        
        
        JButton calculate = new JButton("Calculate");
        tab1Panel.add(calculate);
        calculate.setBounds(470,95,100,25);
        calculate.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    if(course1hours.getSelectedIndex()>0 && course1Grade.getSelectedIndex()>0){
                        selected1 = 1;
                        c1counter = c1creditHours;
                        c1product = c1creditHours * c1gradePoint;
                    }
                    else if(course1hours.getSelectedIndex()==0 && course1Grade.getSelectedIndex()==0){
                        selected1 = 0;
                        c1counter = 0;
                        c1product = 0;
                    }
                    else if(course1hours.getSelectedIndex()>0 && course1Grade.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null, "Please select a grade for course 1", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(course1hours.getSelectedIndex()==0 && course1Grade.getSelectedIndex()>0){
                        JOptionPane.showMessageDialog(null, "Please select credit hours for course 1", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }    
                    
                    
                    
                    if(course2hours.getSelectedIndex()>0 && course2Grade.getSelectedIndex()>0){
                        selected2 = 1;
                        c2counter = c2creditHours;
                        c2product = c2creditHours * c2gradePoint;
                    }
                    else if(course2hours.getSelectedIndex()==0 && course2Grade.getSelectedIndex()==0){
                        selected2 = 0;
                        c2counter = 0;
                        c2product = 0;
                    }
                    else if(course2hours.getSelectedIndex()>0 && course2Grade.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null, "Please select a grade for course 2", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(course2hours.getSelectedIndex()==0 && course2Grade.getSelectedIndex()>0){
                        JOptionPane.showMessageDialog(null, "Please select credit hours for course 2", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
                    if(course3hours.getSelectedIndex()>0 && course3Grade.getSelectedIndex()>0){
                        selected3 = 1;
                        c3counter = c3creditHours;
                        c3product = c3creditHours * c3gradePoint;
                    }
                    else if(course2hours.getSelectedIndex()==0 && course2Grade.getSelectedIndex()==0){
                        selected3 = 0;
                        c3counter = 0;
                        c3product = 0;
                    }
                    else if(course3hours.getSelectedIndex()>0 && course3Grade.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null, "Please select a grade for course 3", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(course3hours.getSelectedIndex()==0 && course3Grade.getSelectedIndex()>0){
                        JOptionPane.showMessageDialog(null, "Please select credit hours for course 3", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
                    if(course4hours.getSelectedIndex()>0 && course4Grade.getSelectedIndex()>0){
                        selected4 = 1;
                        c4counter = c4creditHours;
                        c4product = c4creditHours * c4gradePoint;
                    }
                    else if(course4hours.getSelectedIndex()==0 && course4Grade.getSelectedIndex()==0){
                        selected4 = 0;
                        c4counter = 0;
                        c4product = 0;
                    }
                    else if(course4hours.getSelectedIndex()>0 && course4Grade.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null, "Please select a grade for course 3", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(course4hours.getSelectedIndex()==0 && course4Grade.getSelectedIndex()>0){
                        JOptionPane.showMessageDialog(null, "Please select credit hours for course 3", "Attention", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    selectedSum = selected1 + selected2 + selected3 + selected4;
                    counterSum = c1counter + c2counter + c3counter + c4counter;
                    totalProduct = c1product + c2product + c3product + c4product;
                    gpa = totalProduct/counterSum;
                    
                    JOptionPane.showMessageDialog(null, "The GPA of the " + selectedSum +" Course(s) is: " + gpa   , "Grade Point Average", JOptionPane.PLAIN_MESSAGE);
                    
                }
            }
        );
        
        
        
        
        
        
        JPanel tab2Panel = new JPanel();
        //tab2Panel.setBackground(ltGray);
        tabbedPane.addTab("Calculate Yearly CGPA", null, tab2Panel, "Yearly CGPA");
        
        JInternalFrame tab3Panel = new JInternalFrame("Internal Frame",true,true,true,true);
        tab3Panel.setVisible(true);
        //tab3Panel.setBackground(Color.cyan);
        tabbedPane.addTab("Check Your Summary", null, tab3Panel, "Summary Check");
        
        add(tabbedPane);
    }
    
}

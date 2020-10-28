package gpa_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ButtonHandler /*extends CalculatorFrame*/ implements ActionListener{
    
    public double c1gradePoint,c2gradePoint,c3gradePoint,c4gradePoint; //private double gradePoint1;
    public double c1gradeIndex,c2gradeIndex,c3gradeIndex,c4gradeIndex;
    public int c1creditHours,c2creditHours,c3creditHours,c4creditHours; //private int creditHours1;
    public int c1HourIndex,c2HourIndex,c3HourIndex,c4HourIndex;
    public int c1CreHrsCounter,c2CreHrsCounter,c3CreHrsCounter,c4CreHrsCounter;
    public double totalProduct, c1product,c2product,c3product,c4product;
    public int c1Selected, c2Selected,c3Selected,c4Selected;
    public int counterSum, selectedSum;
    public double gpa;
    public JComboBox course1hours,course2hours,course3hours,course4hours;
    public JComboBox course1Grade,course2Grade,course3Grade,course4Grade;
    int creditHours [] = {0,1,2,3,4,5,6,7,8,9};
    double gradePoints [] = {0,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0};
        
            public void actionPerformed(ActionEvent event){
                if (event.getActionCommand() == "Clear"){
                   course1hours.setSelectedIndex(0);  course1Grade.setSelectedIndex(0);
                    course2hours.setSelectedIndex(0);  course2Grade.setSelectedIndex(0);
                    course3hours.setSelectedIndex(0);  course3Grade.setSelectedIndex(0);
                    course4hours.setSelectedIndex(0);  course4Grade.setSelectedIndex(0);
                }
                else if(event.getActionCommand() == "Calculate"){
                    
                    if(course1hours.getSelectedIndex()>0 && course1Grade.getSelectedIndex()>0){
                        c1Selected=1; c1CreHrsCounter=creditHours[course1hours.getSelectedIndex()];
                        c1product = (creditHours[course1hours.getSelectedIndex()] * gradePoints[course1Grade.getSelectedIndex()]);
                    }
                    if(course2hours.getSelectedIndex()>0 && course2Grade.getSelectedIndex()>0){
                        c2Selected=1; c2CreHrsCounter=creditHours[course2hours.getSelectedIndex()];
                        c2product = (creditHours[course2hours.getSelectedIndex()] * gradePoints[course2Grade.getSelectedIndex()]);
                    }
                    if(course3hours.getSelectedIndex()>0 && course3Grade.getSelectedIndex()>0){
                        c3Selected=1; c3CreHrsCounter=creditHours[course3hours.getSelectedIndex()];
                        c3product = (creditHours[course3hours.getSelectedIndex()] * gradePoints[course3Grade.getSelectedIndex()]);
                    }
                    if(course4hours.getSelectedIndex()>0 && course4Grade.getSelectedIndex()>0){
                        c4Selected=1; c4CreHrsCounter=creditHours[course4hours.getSelectedIndex()];
                        c4product = (creditHours[course4hours.getSelectedIndex()] * gradePoints[course4Grade.getSelectedIndex()]);
                    }
                    
                    selectedSum = c1Selected + c2Selected + c3Selected + c4Selected;
                    counterSum = c1CreHrsCounter + c2CreHrsCounter + c3CreHrsCounter + c4CreHrsCounter;
                    totalProduct = c1product + c2product + c3product + c4product;
                    gpa = totalProduct/counterSum;
                    JOptionPane.showMessageDialog(null,"The GPA of "+selectedSum+" course(s) is: "+ gpa, "Semesterly GPA", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

package jtabbedpaneframe;

import java.awt.*;
import javax.swing.*;

public class JTabbedPaneFrame extends JFrame{
    private Color ltPink = new Color(186,122,150);
    private Color ltGray1 = new Color(214,220,219);
    private Color ltGray2 = new Color(227,224,221);
    private Color ltGray3 = new Color(237,236,234);
    private Color ltGray4 = new Color(244,244,244);
    private static final int width = 400;
    private static final int height = 100;
    
    public JTabbedPaneFrame(){
        super("JTabbedPaneDemo");
        //Color ltGray = new Color(214,220,219);
        getContentPane().setBackground(ltGray1);
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JLabel label1 = new JLabel("Panel one", SwingConstants.CENTER);
        JPanel panel1 = new JPanel();
        panel1.setBackground(ltGray2);
        panel1.setSize(width,height);
        panel1.add(label1);
        tabbedPane.addTab("Calculate Semester GPA", null, panel1, "First Panel");
        
        
        JLabel label2 = new JLabel("Panel two", SwingConstants.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(ltGray3);
        panel2.add(label2);
        tabbedPane.addTab("Calculate Yearly CGPA", null, panel2, "Second Panel");
        
        
        JLabel label3 = new JLabel("Panel three", SwingConstants.CENTER);
        JPanel panel3 = new JPanel();
        panel3.setBackground(ltGray4);
        panel3.add(label3);
        tabbedPane.addTab("Result for the GPAs", null, panel3, "Third Panel");
        
        add(tabbedPane, BorderLayout.NORTH);
        
        JButton buttonClear = new JButton("Clear");
        add(buttonClear, BorderLayout.SOUTH);
    }

}

package simpletexteditor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class SimpleTextEditorFrame extends JFrame{
    private JPanel containerPanel, textAreaPanel, tabbedPanePanel, panel1, panel2, panel3, panel4;
    private JButton button1;
    private JButton [] fileButtons;
    private JTextArea textArea;
    private JScrollPane textAreaScrollPane;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    
    public SimpleTextEditorFrame(){
        super("Imperial Editor");
        
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        
        JButton button1 = new JButton("Button1");
        addComponent(button1, 20,0,3,1);
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        tabbedPane.addTab("File", panel1);
        tabbedPane.addTab("Home", panel2);
        addComponent(tabbedPane, 20,10,1,1);
        
        
        textArea = new JTextArea(5,10);
        textArea.setLineWrap(true);
        constraints.fill = GridBagConstraints.NONE;
        addComponent(textArea, 0,0,3,2);
      
        
    }
    
    private void addComponent(Component component, int row, int column, int width, int height){
            constraints.gridx = row;
            constraints.gridy = column;
            constraints.gridwidth = width;
            constraints.gridheight = height;
            layout.setConstraints(component, constraints);
            add(component);
        }
    
}

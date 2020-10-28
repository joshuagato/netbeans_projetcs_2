package desktoptest;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DesktopFrame extends JFrame{
    
    private JDesktopPane theDesktop;
    
    //set up GUI
    public DesktopFrame(){
        super("Using a JDesktopPane");
        
        theDesktop = new JDesktopPane();  //create desktop pane
        add(theDesktop);
        
        JMenuBar bar = new JMenuBar();  //create menu bar
        
        JMenu addMenu = new JMenu("Add");  //create Add Menu
        
        JMenuItem newFrame = new JMenuItem("Internal Frame");
        
        addMenu.add(newFrame);  //add new frame item to add menu
        
        bar.add(addMenu);
        
        setJMenuBar(bar);  //set menu bar for this application
        
        
        
        //set up listener for newFrame menu item
        newFrame.addActionListener(
            new ActionListener(){  //anonymous inner class
                
                //display new internal window
                public void actionPerformed(ActionEvent event){
                    
                    //create internal frame
                    JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
                    
                    MyJPanel panel = new MyJPanel();  //create a new panel
                    frame.add(panel, BorderLayout.CENTER);  //add panel
                    frame.pack(); //set internal frame to size of contents
                    
                    theDesktop.add(frame);  //attach internal frame
                    frame.setVisible(true);  //show internal frame
                }//end method action performed
            }//end anonymous inner class
        ); //end call to addActionListener
    } //end class DesktopFrameConstructor
  
    //class to display an ImageIcon on a panel
    class MyJPanel extends JPanel{
        private  Random generator = new Random();
        private ImageIcon picture; //image to be displayed
        private final String[] images = {"one.jpg", "two.jpg", "three.jpg", "four.jpg", "five.jpg"};
        
        //load image
        public MyJPanel(){
            int randomNumber = generator.nextInt(images.length);
            picture = new ImageIcon(getClass().getResource(images[randomNumber])); //set icon
        } //end myJPanel constructor
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            picture.paintIcon(this, g, 0, 0);  //display icon
        } //end method paintComponent
        
        //return image dimensions
        public Dimension getPreferredSize(){
            return new Dimension(picture.getIconWidth(), picture.getIconHeight());
        } //end method getPreferredSize
    } // end class myJPanel
    
}

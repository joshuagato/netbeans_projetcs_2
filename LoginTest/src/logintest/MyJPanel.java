package logintest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


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
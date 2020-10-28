package logintest;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class RealAppFrame extends JFrame{
    
    private JDesktopPane theDesktop;
    //private static JLabel usernamelbl, passwordlbl;
    //private static JTextField usernametxf;
    //private static JPasswordField passwordpwf;
    //private static JButton cancelbtn, loginbtn;
    private static int tkWidth, tkHeight;
    private static int dtkWidth, dtkHeight;
    //private static int ftkWidth, ftkHeight;
    
    public RealAppFrame(){
        super("Pregnancy School");
        //setLayout(null);
        //getContentPane().setOpaque(false);
        
        theDesktop = new JDesktopPane();
        add(theDesktop);
        
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        
        //create the usersettings menu
        JMenu usersettings = new JMenu("User Settings");
        usersettings.setMnemonic('U');
        bar.add(usersettings);
        
        //create the menu items under the usuersettings menu
        JMenuItem adduser = new JMenuItem("Add User");
        adduser.setMnemonic('A');
        usersettings.add(adduser);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) toolkit.getScreenSize().getWidth());
        tkHeight = ((int) toolkit.getScreenSize().getHeight());
        dtkWidth = (tkWidth - (tkWidth*30/100));
        dtkHeight = (tkHeight - (tkHeight*70/100));
        
        adduser.addActionListener(
            new ActionListener(){ //Anonymous Inner Class
                public void actionPerformed(ActionEvent event){ //Action Performed
                    AddUser addUser = new AddUser();
                    addUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addUser.setSize(dtkWidth,dtkHeight);
                    addUser.setVisible(true);
                    addUser.setLocationRelativeTo(null);
                }
            }
        );
        
        
        JMenuItem updateuserinfo = new JMenuItem("Update User Information");
        updateuserinfo.setMnemonic('U');
        usersettings.add(updateuserinfo);
        /*Toolkit uuitoolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) uuitoolkit.getScreenSize().getWidth());
        tkHeight = ((int) uuitoolkit.getScreenSize().getHeight());
        dtkWidth = (tkWidth - (tkWidth*30/100));
        dtkHeight = (tkHeight - (tkHeight*70/100));*/
        
        //set up listener for newFrame menu item
        updateuserinfo.addActionListener(
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
                    
                    //JOptionPane.showMessageDialog(null, "How are you?", "Welcome Message", JOptionPane.WARNING_MESSAGE);
                }//end method action performed
            }//end anonymous inner class
        ); //end call to addActionListener
     
        JMenuItem changepassword = new JMenuItem("Change Password");
        changepassword.setMnemonic('C');
        usersettings.add(changepassword);
        
        JMenuItem resetpassword = new JMenuItem("Reset Password");
        resetpassword.setMnemonic('R');
        usersettings.add(resetpassword);
        
        //create the patientsettings menu
        JMenu clientsettings = new JMenu("Client Settings");
        clientsettings.setMnemonic('C');
        bar.add(clientsettings);
        
        //create the menu items under the patientsettings menu
        JMenuItem addclient = new JMenuItem("Add Client");
        addclient.setMnemonic('A');
        clientsettings.add(addclient);
        
        JMenuItem updateclientinfo = new JMenuItem("Update Client Information");
        updateclientinfo.setMnemonic('U');
        clientsettings.add(updateclientinfo);
        
        JMenuItem clientregister = new JMenuItem("Clients' Register");
        clientregister.setMnemonic('C');
        clientsettings.add(clientregister);
        
        JMenu reports = new JMenu("Reports");
        reports.setMnemonic('R');
        bar.add(reports);
        
    }
    
    /*class MyJPanel extends JPanel{
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
    } // end class myJPanel*/
}

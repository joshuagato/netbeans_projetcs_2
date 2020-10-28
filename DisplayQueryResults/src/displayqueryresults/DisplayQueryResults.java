package displayqueryresults;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.util.regex.*;
import java.sql.*;


public class DisplayQueryResults extends JFrame{
    
    static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    static final String USERNAME = "student";
    static final String PASSWORD = "studentpassword";
    static final String DEFAULT_QUERY = "SELECT * FROM Authors";
    
    /*static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static final String DEFAULT_QUERY = "SELECT * FROM Authors";*/
    
    //default query all data from Authors table
    private ResultSetTableModel tableModel;
    private JTextArea queryArea;
    
    //create resultSetTableModel and GUI
    public DisplayQueryResults(){
        super("Displaying Query Results");
        
        //create ResultSetTableModel and display database table
        try{
            //create table model for results of Query SELECT * FROM Authors
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
            
            //set up JTextArea in which user types queries
            queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);
            
            JScrollPane scrollPane = new JScrollPane(queryArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            
            //set up button for submitting queries
            JButton submitButton = new JButton("Submit Query");
            
            //create Box to manage placement of queryArea and submitButton in GUI
            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);
            
            //create JTable based on the tableModel
            JTable resultTable = new JTable(tableModel);
            
            JLabel filterLabel = new JLabel("Filter:");
            final JTextField filterText = new JTextField();
            JButton filterButton = new JButton("Apply Filter");
            Box boxSouth = Box.createHorizontalBox();
            
            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);
            
            //place GUI components on content pane
            add(boxNorth, BorderLayout.NORTH);
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxSouth, BorderLayout.SOUTH);
            
            //create event listener for submitButton
            submitButton.addActionListener(
                new ActionListener(){
                    
                    //pass query to table model
                    public void actionPerformed(ActionEvent event){
                        try{
                            tableModel.setQuery(queryArea.getText());
                        }
                        catch(SQLException sqlException){
                            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                            
                            //try to recover from invalid user entry by executing default query
                            try{
                                tableModel.setQuery(DEFAULT_QUERY);
                                queryArea.setText(DEFAULT_QUERY);
                            }
                            catch(SQLException sqlException2){
                                JOptionPane.showMessageDialog(null, sqlException2.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                            
                                //ensure database connection is closed
                                tableModel.disconnectFromDatabase();
                                System.exit(1);
                            }
                        }
                    }
                }
            );
            
            final TableRowSorter< TableModel > sorter = new TableRowSorter< TableModel >(tableModel);
            resultTable.setRowSorter(sorter);
            setSize(500,250);
            setVisible(true);
            
            //create listener for filterButton
            filterButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String text = filterText.getText();
                        
                        if(text.length()==0)
                            sorter.setRowFilter(null);
                        else
                            try{
                                sorter.setRowFilter(RowFilter.regexFilter(text));
                            }
                            catch(PatternSyntaxException pse){
                                JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex patterb", JOptionPane.ERROR_MESSAGE);
                            }
                    }
                }
            );
        }
        catch(SQLException sqlException){
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            
            //ensure databae is closed
            tableModel.disconnectFromDatabase();
            
            System.exit(1);  //terminate applicattion
        }
        //dispose off window when user quits the application (this overrides the default of HIDE_ON_CLOSE)
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //ensure database connection is closed when the user quits application
        addWindowListener(
            new WindowAdapter(){
                public void windowClosed(WindowEvent event){
                    tableModel.disconnectFromDatabase();
                    System.exit(0);
                }
            }
        );
    }
    

    
    public static void main(String[] args) {
        try{
            //Set System l&F
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception exception){
                exception.printStackTrace();
        }
        
        new DisplayQueryResults();
    }
    
}

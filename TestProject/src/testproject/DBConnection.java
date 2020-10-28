package testproject;

import java.sql.*;
import java.util.logging.*;



public class DBConnection {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:testproject;create=true";
    
    Connection conn;
    
    public DBConnection(){
        
        try {
            this.conn = DriverManager.getConnection(JDBC_URL);
            if(this.conn != null){
                System.out.println("Connected to Database!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTable(){
        try {
            conn.createStatement().execute("CREATE TABLE MyTable(Name varchar(50), Age INT, Gender char(1))");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertIntoTable(String name, int age, char gender){
        try {
            conn.createStatement().execute("INSERT INTO MyTable VALUES('"+name+"',"+age+",'"+gender+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void printAll(){
        try {
            Statement statement = this.conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM MyTable");
            while(res.next()){
                //System.out.print(res);
                System.out.println(res.getString("Name")+" "+res.getString("Age")+" "+res.getString("Gender"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dropTable(){
        try {
            conn.createStatement().execute("DROP TABLE MyTable");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

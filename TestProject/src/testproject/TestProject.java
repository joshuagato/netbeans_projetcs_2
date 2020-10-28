package testproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestProject {

    
    public static void main(String[] args) {
        DBConnection dbConn = new DBConnection();
        //dbConn.createTable();
        //dbConn.insertIntoTable("John", 25, 'M');
        //dbConn.insertIntoTable("Florence", 23, 'F');
        dbConn.printAll();
        //dbConn.dropTable();
    }
    
}

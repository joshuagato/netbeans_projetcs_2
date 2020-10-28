package displayauthors;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class DisplayAuthors {
    
    //Database url
    //ORACLE URL Mask -> jdbc:oracle:thin:@hostname:portNumber:databaseName <-
        static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    
    //Java DB/Apache URL Mask -> jdbc:derby:dataBaseName (embedded)
    //Derby URL Mask -> jdbc:derby://hostname:portNumber/databaseName (network)
    
    // MySQL URL Mask -> jdbc:mysql://hostname:portNumber/databaseName
        //static final String DATABASE_URL = "jdbc:mysql://localhost:3306/books";
        //static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    
    //launch the application
    public static void main(String[] args) {
        Connection connection = null; //manages connection
        Statement statement = null; //query statement
        ResultSet resultSet = null; //manages results
        
        //connect to books and query database
        try{
            //establish connection to database
            connection = DriverManager.getConnection(DATABASE_URL, "student", "studentpassword");
            //connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            
            //create statement for querying database
            statement = connection.createStatement();
            
            //query database
            resultSet = statement.executeQuery("SELECT author_id, fist_name, last_name FROM AUTHORS");
            //resultSet = statement.executeQuery("SELECT AuthorID, FirstName, LastName FROM Authors");
            
            //process query results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors Table of Books Database:\n");
            
            for(int i=1; i<=numberOfColumns; i++){
                System.out.printf("%-8s \t", metaData.getColumnName(i));
            }
            System.out.println();
            
            while(resultSet.next()){
                for(int i=1; i<=numberOfColumns; i++){
                    System.out.printf("%-8s \t", resultSet.getObject(i));
                }
                 System.out.println();
            }//end while
        }//end try
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        finally{ //ensure resultSet, statement and connection are closed
            try{
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        
       
    }
    
}

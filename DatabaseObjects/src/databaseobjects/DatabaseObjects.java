package databaseobjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class DatabaseObjects {
    
        static final String url = "jdbc:mysql://localhost:3306/pregschool";
        static final String username = "root";
        static final String password = "";

    
    public static void main(String[] args) throws Exception {
        
        
        //static final String DEFAULT_QUERY = "SELECT * FROM Authors";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean connectedToDatabase = false;
        
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        connectedToDatabase = true; 
        
        String usernm = "Johnson";
            try{
                resultSet = statement.executeQuery("SELECT username, password FROM users WHERE username='"+usernm+"'");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();

                /*for(int i=1; i<=numberOfColumns; i++){
                    StringBuilder strBld = new StringBuilder();
                    String oupt;
                    Object [] usePt = null;
                    usePt [i]  = resultSet.getObject(i);
                   oupt = metaData.getColumnName(i);
                    oupt = String.format(metaData.getColumnName(i));
                    oupt = String.format(resultSet.getObject(i));
                    oupt = Object.toString(metaData.getColumnName(i));
                    oupt = Object.toString(resultSet.getObject(i));
                    System.out.printf("%-8s \t", metaData.getColumnName(i));    */


                //System.out.println();

                    //while(resultSet.next()){
                        //for(int i=1; i<=numberOfColumns; i++){

                            //Object [] usePts = null;
                            //usePts [i]  = resultSet.getObject(i);
                            //System.out.println("Field " + i +": " + usePts [i]);
                            //System.out.printf("%-8s \t", resultSet.getObject(i));
                            
                            //Statement statement = this.conn.createStatement();
                            ResultSet res = statement.executeQuery("SELECT * FROM users");
                            while(res.next()){
                                //System.out.print(res);
                                
                                String [] rstValue = {res.getString("username"), res.getString("password")};
                                //System.out.println(res.getString("username")+" "+res.getString("password")+" "+res.getString("firstname"));
                                System.out.println("Username: " + rstValue[0] + "Pssword: " + rstValue[1]);
                            }
                            return rstValue;
                            //System.out.printf("%-8s \t", resultSet.getObject(i));
                        //}
                     //System.out.println();
                    //}
                    //resultSet = statement.executeQuery("SELECT username, password FROM users WHERE username='"+usernm+"' AND password='"+passwd+"'");
                    //connection.createStatement().execute("SELECT username, password FROM users WHERE  ");
            }
            catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
    }
    
}

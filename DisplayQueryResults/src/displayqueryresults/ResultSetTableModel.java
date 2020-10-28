package displayqueryresults;

import java.sql.*;
import javax.swing.table.*;

public class ResultSetTableModel extends AbstractTableModel{
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    
    //keep track of database connection status
    private boolean connectedToDatabase = false;
    
    //constructor initializes resultSet and obtains its meta data object
    public ResultSetTableModel(String url, String username, String password, String  query) throws SQLException{
        //connect to database
        connection = DriverManager.getConnection(url, username, password);
        
        //create statement to query database
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        //update database connection status
        connectedToDatabase = true;
        
        //set query and execute it
        setQuery(query);
    }
    
    public Class getColumnClass(int column) throws IllegalStateException{
        
        //ensure database connection is available
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database");
        
        //determine Java class of column
        try{
            String clasName = metaData.getColumnClassName(column + 1);
            
            //return class object that represents className
            return Class.forName(clasName);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return Object.class;  //if problems occur above, assume type objejct
    }
    
    public int getColumnCount() throws IllegalStateException{
        //ensure database connection is available
        
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database");
        
        //determine number of columns
        try{
            return metaData.getColumnCount();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return 0;  //if problems occur above, return 0 for number of columns
    }
    
    public String getColumnName(int column) throws IllegalStateException{
        
        //ensure database connection is available
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database");
        
        //determine column name
        try{
            return metaData.getColumnName(column + 1);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
        
        return "";  //if problems, return empty string for column name
    }
    
    public int getRowCount() throws IllegalStateException{
        
        //ensure database connection is available
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database");
        
        return numberOfRows;
    }
    
    //Obtain value in particular row and column
    public Object getValueAt(int row, int column) throws IllegalStateException{
        
        //ensure database connection is available
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database");
        
        //obtain a value at specified ResultSet row and column
        try{
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return "";  //if problems, return empty string object
    }
    
    public void setQuery(String query) throws SQLException, IllegalStateException{
        //ensure database connection is available
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connencted to Database");
        
        //specify query and execute it
        resultSet = statement.executeQuery(query);
        
        //obtain meta data for resultSet
        metaData = resultSet.getMetaData();
        
        //determine number of rows in resultSet
        resultSet.last();  //move to last row
        numberOfRows = resultSet.getRow();  //get row number
        
        //notify JTable that model has changed
        fireTableStructureChanged();
    }
    
    //close statement and connection
    public void disconnectFromDatabase(){
        if(connectedToDatabase){
            //close statement and connection
            try{
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
            finally{
                connectedToDatabase = false;
            }
        }
    }
}

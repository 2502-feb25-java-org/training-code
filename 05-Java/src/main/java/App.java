package com.revature.JDBCDemo;
//1. Import packages 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
        String hostName = "restaurantdbserver.database.windows.net"; // update me
        String dbName = "MusicDb"; // update me
        String user = "pushpinder"; // update me
        String password = "Password123"; // update me
       //2. Create a connection String
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        
        Connection connection = null;
        try {
        	//3. Initialize Connection String
        	connection = DriverManager.getConnection(url);
        	
        	//Create Statement to Push the Query
        	Statement statement=connection.createStatement();
        	
        	String sql="select [artistName] from Music.Artist";
        	
        	//ExecuteUpdate for Insert and Update
        	//resultSet will hold the values for select query
        	ResultSet artists=statement.executeQuery(sql);

        	//next method will check for record every time
        	while(artists.next()) {
        		System.out.println(artists.getString("artistName"));        		
        	}
        	//make sure to close the ResultSet after read
        	artists.close();
        	
        }
        catch(SQLException ex) {
        	ex.printStackTrace();
        }
       
    }
}

package com.revature.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;

/*
 * The DAO (Data Access Object) should be the only place
 * where a connection is made to the DB
 * This design pattern allows for a separation of concerns
 * and allows for nice cohesive code
 * 
 * JDBC - Java Database Connectivity 
 * 
 */
public class UserDAO {
	
	/*
	 * STATEMENT - important interface in JDBC API
	 * - takes an SQL statement as a string, executes it, and 
	 * returns the result 
	 * - allow SQL injection. These are not ideal to use. Definitely 
	 * do NOT use for any SQL command that uses a parameter/variable
	 * 
	 * SQL injection - common hacking technique. it is the insertion of
	 * code as input that affects your database 
	 */
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		try(Connection conn = 
				ConnectionFactory.getInstance().getConnection()){
			
			 String query = "select * from demo_user";
			 
			 //STATEMENT interface 
			 Statement statement = conn.createStatement();
			 
			 //RESULTSET interface - represents the set of results of a DB query
			 ResultSet rs = statement.executeQuery(query);
			 
			 while(rs.next()) {
				 User temp = new User(
						 rs.getInt(1),
						 rs.getString("USERNAME"),
						 rs.getString(3),
						 rs.getString("BIO"));
				 users.add(temp);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}

package com.jdbc_static ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		System.out.println("*** Start ***");
		
//		Step-1 : Load & register the driver 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Step-2 : Establish the connection 
// 		Copy the connection path from mysql connection and give schema name , user, password 
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_static", "root", "12345");
		
//		Step-3 : Create a Statement
//		createStatement is used to create a static statement
		
		Statement state = con.createStatement();
		
//		Step-4 : Execute the statement
		
		int row = state.executeUpdate("DELETE FROM demo_table WHERE id = 2 ");
//		For data Deletion we have to use abstract method executeUpdate() which return type is integer, 
//		if it is executed without any error it will return 1 or else it will return 0 
		
//		Step-5 : Process the result
		
		System.out.println(row);
		
//		Step-6 : Close the db connection

		state.close();
		con.close();
		
		System.out.println("*** End ***");

		
		
		
	}
}
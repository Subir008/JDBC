package com.jdbc_static;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("***Start***");
		
//		Step-1 : Load & register the driver 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Step-2 : Establish the connection 
// 		Copy the connection path from mysql connection and give schema name , user, password 

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_static", "root", "12345");
		
//		Step-3 : Create a Statement
//		createStatement is used to create a static statement 
		
		Statement state = con.createStatement();
		
//		Step-4 : Execute the statement
		
		boolean b = state.execute("Insert into demo_table values (1,'Ben',7044322442) ");
		
//		Step-5 : Process the result
		
		System.out.println(b);
		
//		Step-6 : Close the db connection
		
		state.close();
		con.close();
		
		System.out.println("***End***");
		
	}
}
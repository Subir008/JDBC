package com.jdbc_static ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch_all {
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
		
		ResultSet res = state.executeQuery("SELECT * FROM demo_table");
//		For data Fetching we have to use abstract method executeQuery() which return type is ResultSet
		
//		Step-5 : Process the result
		
		while(res.next())
		{
			System.out.println("***************");
			System.out.println(res.getInt(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
			System.out.println("***************");
		}
		
//		Step-6 : Close the db connection

		state.close();
		con.close();
		
		System.out.println("*** End ***");

		
		
		
	}
}
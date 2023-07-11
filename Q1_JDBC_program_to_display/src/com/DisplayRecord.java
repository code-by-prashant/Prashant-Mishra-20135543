package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayRecord {

	public static void main(String[] args) {
		// Create Connection object
        Connection connection = null;
        
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt_exam", "root", "admin");
            
            Statement statement = connection.createStatement();
            
            System.out.println("Connection established successfully!\n");
            
//            statement.execute("INSERT INTO Employee VALUES(100,'Thanesh', 25, 50000, 'Developer')");
//            statement.execute("INSERT INTO Employee VALUES(200,'Suman', 45, 60000, 'Clerk')");
//            statement.execute("INSERT INTO Employee VALUES(300,'Praveen', 55, 90000, 'Manager')");
            
//            System.out.println("Data inserted successfully!");
            
			Statement st = connection.createStatement();	
			
			ResultSet rs = st.executeQuery("select * from employee");
			
			while(rs.next()) {
				System.out.println(" " + rs.getInt(1) + " | " + rs.getString(2) 
				+ " 	| " + rs.getInt(3) + "	| "
				+ rs.getInt(4) + "   | " + rs.getString(5));
			}
            System.out.println("\nData retrieval completed successfully!");

        } 
        catch (ClassNotFoundException e) {
            // JDBC driver not found exception
            System.out.println("JDBC driver not found!");
            e.printStackTrace();
        } 
        catch (SQLException e) {
            // Connection error
            System.out.println("Connection failed!");
            e.printStackTrace();
        } 
	}

}

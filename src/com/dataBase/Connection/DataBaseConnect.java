/**
 * 
 * @author Henry F. Granados
 * This program allows to retrieve data from dataBase.
 * 
 */
package com.dataBase.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBaseConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;

	/**
	 * This constructor enables connection to MySql Database
	 */
	public DataBaseConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/javatest", "root", "compu123");
			st = con.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method ensures to retrieve data from DataBase
	 */
	public void getDataFromDB() {
		try {
			String query = "SELECT * FROM persons";
			rs = st.executeQuery(query);
			System.out.println("Customers From DataBase");
			
			/**
			 * This while loop will basically loop through each of the customer's
			 * informacion in the DataBase, and save them into string variables
			 * so they can be display on the screen.
			 */
			while (rs.next()) {
				System.out.println("-------------------");
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String lastName = rs.getString("LastName");
				String age = rs.getString("AGE");
				System.out.println("Customer ID: " + id + "\n" + "Name: "
						+ name + "\n" + "LastName: " + lastName + "\n"
						+ "Age: " + age);

			}
			System.out.println("-------------------");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

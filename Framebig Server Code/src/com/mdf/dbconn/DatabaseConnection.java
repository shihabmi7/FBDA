package com.mdf.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public abstract class DatabaseConnection {
	private static Connection conn = null;

	public static Connection getDBConnection() {

		Locale.setDefault(new Locale("en"));

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// conn =
			// DriverManager.getConnection("jdbc:mysql://87.106.20.80:3306/SCHAETZEDB","root","Beesmart1");
			//conn = DriverManager.getConnection("jdbc:mysql://87.106.244.68:3306/mein_deutsch_freund","sias_admin", "sias_project!");
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daily_app","root","");

			if (conn != null)
				System.out.println("Got the connection");
			else
				System.out.println("did not get the connection");
			
			
		} catch (SQLException ex) {
			System.out.println("Got some sql exception " + ex);
			ex.printStackTrace();
		}

		return conn;
	}// dbConnection
	
	public static void dbConnClose(){
		try {
			conn.close();
//			System.out.println("Connection is Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

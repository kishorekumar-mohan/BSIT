package com.example.batch;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class ConnectionsJdbc {

		private static final String URL = "jdbc:mysql://localhost:3306/Batch";

	    public static Connection getConnection() throws SQLException {
	        Properties properties = new Properties();
	        properties.setProperty("user", "root");
	        properties.setProperty("password", "Msdkishore@01");
	        

	        return DriverManager.getConnection(URL, properties);
	    }


	}



package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionsJdbc {
	
	private static final String URL = "jdbc:mysql://localhost:3306/finezoom"; 

	public static Connection getConnection() throws SQLException {
		Properties pro = new Properties();
		pro.setProperty("user" , "root");
		pro.setProperty("password" , "Msdkishore@01");

        return DriverManager.getConnection(URL, pro);
    }
}
//package students;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectionsJdbc {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/finezoom"; // Replace with your database name
//    private static final String USER = "root"; // Replace with your MySQL username
//    private static final String PASSWORD = "Msdkishore@01"; // Replace with your MySQL password
//
//    // Load the MySQL JDBC driver explicitly
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//}

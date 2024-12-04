package bluescope;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionEmp {
//		public static void main(String[] args) throws ClassNotFoundException, SQLException {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/finezoom";
//			String user = "root";
//			String pwd = "Msdkishore@01";
//			java.sql.Connection con = DriverManager.getConnection(url,user,pwd);
//			System.out.println("Database finezoom connection suceesfully establish");
//
//	        Statement stmt = con.createStatement();
//	        stmt.executeUpdate("insert into bluescope values(1,'kishorekumar','developer')");
//	        stmt.executeUpdate("insert into bluescope values(2,'logeshkumar','analysis')");
//	        stmt.executeUpdate("insert into bluescope values(3,'karthik','developer')");
//	        stmt.executeUpdate("insert into bluescope values(4,'hilda','analysis')");
//	        stmt.executeUpdate("insert into bluescope values(5,'gokul','developer')");
//		}
	private static final String URL = "jdbc:mysql://localhost:3306/finezoom";
    private static final String USER = "root";
    private static final String PASSWORD = "Msdkishore@01";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	}


package information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionsJdbc {
	
	private static final String URL = "jdbc:mysql://localhost:3306/finezoom";
    private static final String USER = "root";
    private static final String PASSWORD = "Msdkishore@01";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
       // try {
            Class.forName("com.mysql.cj.jdbc.Driver");
       // } catch (ClassNotFoundException e) {
          //  e.printStackTrace();
       // }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

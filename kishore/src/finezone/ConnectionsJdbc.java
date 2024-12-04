package finezone;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class ConnectionsJdbc {

		private static final String URL = "jdbc:mysql://localhost:3306/finezoom";

	    public static Connection getConnection() throws SQLException {
	        Properties properties = new Properties();
	        properties.setProperty("user", "root");
	        properties.setProperty("password", "Msdkishore@01");
	        properties.setProperty("SetFloatAndDoubleUseBinary", "true");

	        return DriverManager.getConnection(URL, properties);
	    }

		public static Connection getConnection1() {
			// TODO Auto-generated method stub
			return null;
		}

		public static Connection getConnection2() {
			// TODO Auto-generated method stub
			return null;
		}

	}



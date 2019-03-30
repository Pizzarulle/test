import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

	private static String username = "";
	private static String password = "";
	private static String dbConnection = "";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(dbConnection, username, password);
	}
	
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		JDBCConnector.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		JDBCConnector.password = password;
	}

	public static String getDbConnection() {
		return dbConnection;
	}

	public static void setDbConnection(String dbConnection) {
		JDBCConnector.dbConnection = dbConnection;
	}

}

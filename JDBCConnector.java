import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Simon
 *
 */
public class JDBCConnector {

	private static String username = "";
	private static String password = "";
	private static String conn = "";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(conn, username, password);
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

	public static String getConnectionAddress() {
		return conn;
	}

	public static void setConnectionAddress(String conn) {
		JDBCConnector.conn = conn;
	}

}

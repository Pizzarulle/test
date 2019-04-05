import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A connector class for JDBC that provides utility to create prepared statements.<br>
 * An instance of the class is provided with getInstance().
 * 
 * @author Simon
 *
 */
public class JDBCConnector {

	private static JDBCConnector instance;
	private static Object lock = new Object();

	private Connection connection = null;
	private PreparedStatement statement = null;

	private String dbConnection = "";
	private String username = "";
	private String password = "";

	private JDBCConnector() {}

	public static JDBCConnector getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new JDBCConnector();
				}
			}
		}
		return instance;
	}

	/**
	 * @return Connection to database through the strings provided with the set methods in the JDBCConnector class.
	 */
	public Connection connect() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(dbConnection, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	/**
	 * 
	 * @param dbConnection Address to your desired database.
	 * @param username
	 * @param password
	 * @return Connection to database through the strings provided with the provided strings in the method.
	 */
	public Connection connect(String dbConnection, String username, String password) {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(dbConnection, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	/**
	 * Input properly formatted SQL string. You do not need to explicitly get the Connection, 
	 * but closeConnections() should be called after all usage is finished to prevent issues.
	 * 
	 * @param sql SQL formatted String
	 * @return PreparedStatement with provided SQL String.
	 */
	public PreparedStatement createStatement(String sql) {
		try {
			statement = connect().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	/**
	 * @return The current PreparedStatement without modifications.
	 */
	public PreparedStatement getStatement() {
		return statement;
	}

	public void closeConnections() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConnectionAddress() {
		return dbConnection;
	}

	public void setConnectionAddress(String dbConnection) {
		this.dbConnection = dbConnection;
	}

}

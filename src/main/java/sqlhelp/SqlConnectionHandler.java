package sqlhelp;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectionHandler {
	
	private static SqlConnectionHandler instance = null;
	
	private String username;
	private String password;
	private String host;
	private int port;
	private String database;
	private String error;
	
	private SqlConnectionHandler()
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			error = "Could not load database drivers";
			e.printStackTrace();
		}
	}
	
	public java.sql.Connection getConnection()
	{
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+database,username,password);
		} catch (SQLException e) {
			error = e.getMessage();
			e.printStackTrace();
			return null;
		}
	}
	
	public static SqlConnectionHandler getInstance()
	{
		if(instance == null)
			instance = new SqlConnectionHandler();
		return instance;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host; 
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port; 
	}
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		this.database = database; 
	}

	public boolean canLogin() {
		return getConnection() != null;
	}
}

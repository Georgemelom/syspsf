package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {

	public static Connection getConexao() {
		Connection connection = null;
	    try {
	        // Load the JDBC driver
	        String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
	        Class.forName(driverName);
	    
	        // Create a connection to the database
	        String serverName = "localhost";
	        String mydatabase = "bpad";
	        String url = "jdbc:mysql://" + serverName +  "/" + mydatabase; // a JDBC url
	        String username = "root";
	        String password = "123";
	        connection = DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        // Could not find the database driver
	    	System.err.println(e.getMessage());
	    } catch (SQLException e) {
	    	System.err.println(e.getMessage());
	    }
	    
	    return connection;

	}

}

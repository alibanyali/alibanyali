package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class GenericDao {

	public final String URL = "jdbc:mysql://localhost:3306/vhechils";
	public final String USER_NAME = "root";
	public final String PASSWORD = "123456";

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		return connection;
	}

	public void testConnection() throws SQLException {
		if (getConnection() != null) {
			System.out.println("Connected...");
		} else {
			System.out.println("not connected...");
		}
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return getConnection().prepareStatement(sql);
	}

	public static void main(String[] args) {
		GenericDao dao = new GenericDao();
		try {
			dao.testConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}

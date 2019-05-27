package webApp.dao;

import java.sql.*;


public class DB {
	private final static String url = "jdbc:postgresql://127.0.0.1:5432/Pharmacy";
	private final static String user = "postgres";
	private final static String pwd = "96inav07hgiv25";

	public static Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("Successfully connected to the PostgreSQL server.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return conn;

	}
	public static void main(String[] args) {
		DB db = new DB();
		db.connect();
	}
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPwd() {
		return pwd;
	}
	
	
	/* teszthez jo lesz
	 * if (connection != null) {
			System.out.println("Successfully connected to the PostgreSQL server.");
		} else {
			System.out.println("Failed to make connection!");
		}
	 */
	
	
}

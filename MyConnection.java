package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 //DB接続クラス
public class MyConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/pc_shop_db";
	
	private final static String USER = "shop_user";
	
	private final static String PASSWORD = "pass";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(URL, USER, PASSWORD);

	}

}

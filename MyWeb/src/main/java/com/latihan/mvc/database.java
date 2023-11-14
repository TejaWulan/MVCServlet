package com.latihan.mvc;

import java.sql.*;

public class database {

	public static void main(String[] args) {
		// Get connection from database
		String urlDb = "jdbc:mysql://localhost:3306/latihan_db";
		String userName ="root";
		String password = "";
		try {
			//registrasi driver
			Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(urlDb, userName, password);
String query ="SELECT * FROM product_tbl";
Statement stm = conn.createStatement();
ResultSet rs = stm.executeQuery(query);
while(rs.next()) {
	System.out.println(rs.getInt("id"));
	System.out.println(rs.getString("code"));
	System.out.println(rs.getString("name"));
	System.out.println(rs.getString("type"));
	System.out.println(rs.getDouble("price"));
	System.out.println("=====================");



}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}

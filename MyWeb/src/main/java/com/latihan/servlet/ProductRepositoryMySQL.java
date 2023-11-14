package com.latihan.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProductRepositoryMySQL {
	public List<Product> findAll() throws IOException {
	List <Product>products= new ArrayList<> ();
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
		int id = rs.getInt("id");
		String code = rs.getString("code");
		String name = rs.getString("name");
		String type = rs.getString("type");
		double price = rs.getDouble("price");
	Product item = new Product(code,name,type,price);
	products.add(item);
	}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} return products;
			}
public int save (Product product){
	int result=0;
	String urlDb = "jdbc:mysql://localhost:3306/latihan_db";
	String userName ="root";
	String password = "";
	String code = product.getCode();
	String name = product.getName();
	String type = product.getType();
	double price = product.getPrice();
	
	try {
		//registrasi driver
		Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(urlDb, userName, password);
String query ="INSERT INTO product_tbl(code,name,type,price)VALUES ('" + code +"','" + name +"','"+type+"',"+price+")";
Statement stm = conn.createStatement();
result = stm.executeUpdate(query);


	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} return result;

}




}
		

	
	


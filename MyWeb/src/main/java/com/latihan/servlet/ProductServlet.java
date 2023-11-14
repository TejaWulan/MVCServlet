package com.latihan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.latihan.servlet.ProductRepositoryMySQL;
import com.latihan.servlet.Product;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/productlist.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductRepositoryMySQL repo = new ProductRepositoryMySQL();
		List<Product> products;
PrintWriter writer = response.getWriter();
		//taro writer -> var wrt
		try {
			products = repo.findAll();
			writer.println("<table border=1 width=100%>");
			writer.print("<table>");
			for (Product barang:products){
				//wrt.println("<td>")
				writer.println("<tr>");
				writer.println("<td>"+ barang.getCode()+ "</td>");
				writer.println("<td>"+ barang.getName()+ "</td>");
				writer.println("<td>"+ barang.getType()+ "</td>");
				writer.println("<td>"+ barang.getPrice()+ "</td>");
				writer.println("</tr>");

			} 
			writer.print("</table>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code= request.getParameter("code");
		String name= request.getParameter("name");
		String type= request.getParameter("type");
		String price= request.getParameter("price");
		PrintWriter out = response.getWriter();
		ProductRepositoryMySQL repo2 = new ProductRepositoryMySQL();
		Product jajan = new Product(code, name, type, Double.parseDouble(price));
		int hasil = repo2.save(jajan);
		if (hasil > 0) {
out.println("sukses");
} else {
	out.println("gagal");
		}
	}
	}



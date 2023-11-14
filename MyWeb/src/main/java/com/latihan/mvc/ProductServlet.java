package com.latihan.mvc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product.do")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Integer> findAllId;
		ProductRepositoryMySQL repo = new ProductRepositoryMySQL();
		try {
			List<Product> listproduct = repo.findAll();
			String action = request.getParameter("action");
			String id = request.getParameter("id");
			if ("list".equals(action)) {
				request.setAttribute("data_produk", listproduct);
				request.getRequestDispatcher("product_list.jsp").forward(request, response);
			} if ("new".equals(action)) {
				response.sendRedirect("formsimpanproduct.jsp");
			} if ("view".equals(action)) {
				findAllId = repo.getAllId();
				for (Integer numbers : findAllId) {
					if (String.valueOf(numbers).equals(id)) {
						ProductRepositoryMySQL repo2 = new ProductRepositoryMySQL();

						Product eachProduct = repo2.findById(numbers);
						request.setAttribute("each_product", eachProduct);
						request.getRequestDispatcher("view.jsp").forward(request, response);
					}
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		ProductRepositoryMySQL repo = new ProductRepositoryMySQL();
		Product jajan = new Product(code, name, type, Double.parseDouble(price));
		int save = repo.save(jajan);
		if (save > 0) {
			ProductRepositoryMySQL repo2 = new ProductRepositoryMySQL();
			List<Product> listproduct;
			try {
				listproduct = repo2.findAll();
				request.setAttribute("data_produk", listproduct);
				request.getRequestDispatcher("product_list.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

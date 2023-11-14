<%@page import="com.latihan.mvc.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>:Product List JSP:</h1>
	<a href="formsimpanproduct.jsp">[New Input]</a>
	<table border="1" width=80% align="center">
		<tr>
			<td>Id</td>
			<td>Code</td>
			<td>Name</td>
			<td>Type</td>
			<td>Price</td>
		</tr>
		<% 
		Product eachProduct = (Product) request.getAttribute("each_product");%>
			<tr>
				<td><% out.println(eachProduct.getId()); %></td>
				<td><% out.println(eachProduct.getCode()); %></td>
				<td><% out.println(eachProduct.getName()); %></td>
				<td><% out.println(eachProduct.getType()); %></td>
				<td><% out.println(eachProduct.getPrice()); %></td>
				
			</tr>
	</table>
</body>
</html>
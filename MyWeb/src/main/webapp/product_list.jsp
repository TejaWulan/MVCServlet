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
		<c:forEach items="${data_produk}" var="m">
			<tr>
				<td><c:out value="${m.id}"></c:out></td>
				<td><c:out value="${m.code}"></c:out></td>
				<td><c:out value="${m.name}"></c:out></td>
				<td><c:out value="${m.type}"></c:out></td>
				<td><c:out value="${m.price}"></c:out></td>
				<td><a href = 'product.do?action=view&id=<c:out value= "${m.id}"/>'>[view]</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>
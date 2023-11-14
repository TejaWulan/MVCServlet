<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2> INPUT PRODUCT</h2>
<body>
<form method ="post" action="cart.do">
Code <br/> 
<input type="text" name="code"></input>
<br/>
Name <br/>
<input type="text" name="name">
<br/>
Type <br/>
<input type="text" name="type">
<br/>
Price <br/> 
<input type="text" name="price">
<br/>
<input type="submit" name="tambah"/>
</form>
</body>
</html>
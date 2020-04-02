 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

 <%
 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //http1.1
 response.setHeader("pragma", "no-cache");//http 1.0
 response.setHeader("Expires","0");//proxy
 
 
 if(session.getAttribute("username")==null)
	{
	response.sendRedirect("login.jsp");
	}%> 
	Welcome Page 
	
	<a href=library.jsp>Photos</a><br>
	<form action="Logout">
	
	<input type="submit" value="LogOut">
	</form>
</body>
</html>
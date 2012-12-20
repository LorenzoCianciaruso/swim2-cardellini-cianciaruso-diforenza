<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Profile Page</title>
</head>
<body>
	<%
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	%>
	Ciao! la tua email è <%=email %>, la tua password è <%=password %>!!
	<br>
	<form method="post" action="index.jsp" >
		<input type="submit" value="Log Out" />
	</form>
</body>
</html>
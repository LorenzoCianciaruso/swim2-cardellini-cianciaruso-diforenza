<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Error</title>
<body>
</head>
	<div id =logo>
	<h1>SWIMv2</h1>
	</div>
<div id=text>
	<body><%=request.getAttribute("message")%>
		<br />
		<form method="post" action="index.jsp">
			<input type="submit" value="Restart from the homepage" />
		</form>
</div>

<div id="sidebar">
	<form method="post" action="ServletSearch">
		Search: <input name="search" /> <input type="submit"
			value="Search User" />
	</form>
</div>

<div id="footer">
Copyright &copy; 2013 Site for didactic purpose.
</div>
</body>
</html>
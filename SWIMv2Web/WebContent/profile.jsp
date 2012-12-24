<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.RegisteredUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><% RegisteredUser user = (RegisteredUser) request.getAttribute("user");	%>
		<%= user.getName() %>
		</title>
</head>
<body>
	Hello <%=request.getAttribute("user").toString() %>!!
	<br />
	Session ID is <%=session.getAttribute("id") %>
	<br />
	<br />
	<form method="post" action="ServletSearch" >
		Type user name: <input name="search" />
		<input type="submit" value="Search User" />
	</form>
	<br />
	<form method="post" action="index.jsp" >
		<input type="submit" value="Log Out" />
	</form>
</body>
</html>
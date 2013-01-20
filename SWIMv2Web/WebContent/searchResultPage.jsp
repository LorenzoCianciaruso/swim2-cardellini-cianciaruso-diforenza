<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Results</title>
</head>
<body>
	<div id =logo>
	<a href="ServletProfilePage"><img src="logo.jpg" /></a>
	</div>
<div id="text">

		<%
		List<User> list = (List<User>) request.getAttribute("listOfUsers");
		if(list.size()==0){
		%>
	NO Results for your search, I'm sorry!
		<%
		}else{
		%>
			Here are all users that matches your research:<br />
			<br />
			<br />
			<%
			for(int i = 0; i< list.size(); i++){
				User user = list.get(i);
			%>
	<%=user.getName()+" "+user.getSurname() %>
	<form method="post" action="ServletProfileSeenByOther">
		<input type="hidden" name="userId" value=<%=user.getId()%> />
		<input type="hidden" name="direction" value="0" />
		<input type="submit" value="View Profile" />
	</form>
	<br />
	<%
			}
		}
	%>
	
	</div>

<div id="sidebar">
	Search for an user:
	<br />
	<form method="post" action="ServletSearch">
		<input name="search" placeholder="type name here.."/> <input type="submit"
			value="Search User" />
	</form>
	<br />
	<form method="post" action="ServletSearchByPlace">
		<input name="search" placeholder="type place here.."/> <input type="submit"
			value="Search User" />
	</form>
	<br />
	<form method="post" action="ServletSearchByAbility">
		<input name="search" placeholder="type ability here.."/> <input type="submit"
			value="Search User" />
	</form>
	
	<br />
	<br />
	<br />
	<br />
	
	<form method="post" action="ServletProfilePage" >
		<input type="submit" value="Go Back" />
	</form>
	
</div>

<div id="footer">
Copyright &copy; 2013 <br />Site for didactic purpose.
</div>
</body>
</html>
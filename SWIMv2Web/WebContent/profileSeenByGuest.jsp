<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User"%>
<%@ page import="java.util.List"%>
<%@ page import="it.polimi.swimv2.entities.AbilityDeclared"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>
	<% User user = (User) request.getAttribute("user");	%> <%= user.getName() %>
</title>
</head>
<body>
	<div id =logo>
	<a href="ServletProfilePage"><img src="logo.jpg" /></a>
	</div>
<div id=text>
<table align ="center" cellpadding="0">
<tr>
<td>
	<form method="post" action="ServletJobPageByOther">
		<input type="hidden" name="toShow" value=<%=user.getId()%> />
		<input type="submit" value="See <%=user.getName()%>'s jobs" />
	</form>	
</td>
</tr>
</table>
<br />
<br />
	Profile of:
	<%=user.getName()+" "+user.getSurname() %>
	<br /> Birthday:
	<%=user.getBirthday() %>
	<br /> City:
	<%=user.getCity() %>
	<br /> Phone Number:
	<%=user.getPhone() %>
	<br /> Email:
	<%=user.getEmail() %>
	<br />
	
	<%
	List<String> names = (List<String>) request.getAttribute("names");
	List<Integer> posFeedbacks = (List<Integer>) request.getAttribute("posFeedbacks");
	List<Integer> negFeedbacks = (List<Integer>) request.getAttribute("negFeedbacks");
	for (int i = 0; i < names.size(); i++) {
	%>
	<br /> Ability:
	<%=names.get(i)%>
	Feedback:   <g> +<%=posFeedbacks.get(i)%></g>  <r>-<%=negFeedbacks.get(i) %></r>
	
	<% } %>

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
	<form method="post" action="index.jsp">
		<input type="submit" value="Login"></input>
	</form>
</div>

<div id="footer">
Copyright &copy; 2013<br /> Site for didactic purpose.
</div>

</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.StringTokenizer"%>
<%@ page import="it.polimi.swimv2.entities.User"%>
<%@ page import="java.util.List"%>
<%@ page import="it.polimi.swimv2.entities.AbilityDeclared"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>
	<% User user =  (User) request.getAttribute("user"); %> <%= user.getName()+" "+user.getSurname() %>
</title>
</head>
<body>
	<h1>Welcome back!!</h1>
	<br /> Profile of
	<%=user.getName()+" "+user.getSurname() %>
	<br />
	Birth date:
	<%=user.getBirthday() %>
	<br /> City:
	<%=user.getCity() %>
	<br /> Phone Number:
	<%=user.getPhone() %>
	<br /> Email:
	<%=user.getEmail() %>
	<br />

	<br />
	<%
	List<String> names = (List<String>) request.getAttribute("names");
	List<Integer> feedbacks = (List<Integer>) request.getAttribute("feedbacks");
		for (int i = 0; i < names.size(); i++) {
	%>
	<br /> Ability:
	<%=names.get(i)%>
	Feedback:
	<%=feedbacks.get(i)%>
	<%	
		}
	%>

	<br />
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
	Manage your information:
	
	<br />
	<br />
	
	<form method="post" action="ServletFriendListPage">
		<input type="submit" value="Friends" />
	</form>
	
	<br />
	
	<form method="post" action="ServletSkillPage">
		<input type="submit" value="Skills" />
	</form>
	
	<br />

	<form method="post" action="ServletJobsPage">
		<input type="submit" value="Jobs" />
	</form>

	<br />

	<form method="post" action="ServletJobRequestsPage">
		<input type="submit" value="See job requests" />
	</form>

	<br />
	
	<form method="post" action="ServletFriendshipPage">
		<input type="submit" value="See friendship requests" />
	</form>
	
	<br />
	
	<form method="post" action="ServletLogout">
		<input type="submit" value="Log Out" />
	</form>
	
</body>
</html>
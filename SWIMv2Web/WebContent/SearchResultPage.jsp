<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Result List</title>
</head>
<body>
	Here are all users that matches your research:<br />
	<br />
	<%
		List<User> list = (List<User>) request.getAttribute("listOfUsers");
		if(list.size()==0){
	%>
	NO Results for your search, I'm sorry!
	<%
		}else{
			for(int i = 0; i< list.size(); i++){
				User user = list.get(i);
	%>
	<%=user.toString() %>
	<form method="post" action="ServletProfileSeenByOther">
		<input type="hidden" name="user" value=<%=user.getIdUser()%> />
		<input type="submit" value="View Profile" />
	</form>
	<%
			}
		}
	
	%>
	<br />
	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go to your Profile" />
	</form>
</body>
</html>
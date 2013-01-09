<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Friendship Suggestion</title>
</head>
<body>
<% List<User> listOfPossibleFriends = (List<User>) request.getAttribute("listOfPossibleFriends"); %>
	You accepted the request!<br />
	<br />
	You might know these people:<br />
	<br />
	<%
	for(int i=0; i < listOfPossibleFriends.size() && i < 5; i++){
	%>
	<%=listOfPossibleFriends.get(i).getName()+" "+listOfPossibleFriends.get(i).getSurname() %>
	<br />
	<form method="post" action="ServletProfileSeenByOther">
		<input type="hidden" name="userId" value="<%=listOfPossibleFriends.get(i).getId() %>" />
		<input type="submit" value="View Profile" />
	</form>
	<%
	}
	%>
	<br />
	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go back to your profile" />
	</form>
</body>
</html>
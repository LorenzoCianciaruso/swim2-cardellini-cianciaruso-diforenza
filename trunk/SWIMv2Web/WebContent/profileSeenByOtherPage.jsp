<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User"%>
<%@ page import="java.util.List"%>
<%@ page import="it.polimi.swimv2.entities.AbilitiesDeclared"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>
	<% User user = (User) request.getAttribute("user");	%> <%= user.getName() %>
</title>
</head>
<body>
	<br /> Profile of:
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
	<% //TODO aggiungere qualcosa che cicli su ability declared e restituisca le abilità dell'utente %>
	<%
		List<String> names = (List<String>) request.getAttribute("names");
	List<Integer> feedbacks = (List<Integer>) request.getAttribute("feedbacks");
		for (int i = 0; i < names.size(); i++) {
	%>
	<br />	
	Ability:
	<%=names.get(i)%>
	Feedback:
	<%=feedbacks.get(i)%>
	<%	
		}
	%>
	<br />
	<form method="post" action="newJob.jsp">
		<input type="hidden" name="userPerformerId" value="<%=user.getId()%>" />
		<input type="submit" value="Ask <%=user.getName()%>'s help for a job" />
	</form>
	<br />
</body>
</html>
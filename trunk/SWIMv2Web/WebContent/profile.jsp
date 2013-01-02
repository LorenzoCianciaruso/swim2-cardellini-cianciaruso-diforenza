<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%! 

	public int calculateAge(String birthday){
		StringTokenizer st = new StringTokenizer(birthday, "/");
		String day = st.nextToken();
		String month = st.nextToken();
		String year = st.nextToken();
		return 2013-Integer.parseInt(year);
	}
 %>
<title>
<% User user =  (User) request.getAttribute("user"); %>
<%= user.getName()+" "+user.getSurname() %>
</title>
</head>
<body>
	<h1>Wellcome back!!</h1>
	<br />
	Profile of <%=user.getName()+" "+user.getSurname() %>
	<br />
	<%
		int age = calculateAge(user.getBirthday());
	%>
	Age: <%=age %>
	<br />
	City: <%=user.getCity() %>
	<br />
	Phone Number: <%=user.getPhone() %>
	<br />
	Email: <%=user.getEmail() %>
	<br />
	<br />
	<form method="post" action="ServletSearch" >
		Search by user's name: <input name="search" />
		<input type="submit" value="Search User" />
	</form>
	<br />
	<form method="post" action="ServletLogout" >
		<input type="submit" value="Log Out" />
	</form>
</body>
</html>
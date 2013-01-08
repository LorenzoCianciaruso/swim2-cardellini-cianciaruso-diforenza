<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%
List<User> friendList = (List<User>) request.getAttribute("friendList");
%>
<title>Friend List</title>
</head>
<body>
FRIENDS LIST:<br />
<br />
<%
for(int i=0; i<friendList.size();i++){
%>
<%=friendList.get(i).getName()+" "+friendList.get(i).getSurname() %> 
<form method="post" action="ServletProfileSeenByOther">
	<input type="submit" value="View Profile" />
</form>
<br />
<br />
<%
}
%>
<br />
<form method="post" action="ServletProfilePage" >
	<input type="submit" action="Go Back" />
</form>

</body>
</html>
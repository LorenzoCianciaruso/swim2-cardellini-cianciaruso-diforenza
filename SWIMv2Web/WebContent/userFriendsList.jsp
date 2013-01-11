<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%
List<User> friendList = (List<User>) request.getAttribute("friendList");
%>
<title>Friend List</title>
</head>
<body>
FRIENDS LIST:<br />
<br />
<form method="post" action="ServletSearchAmongFriend" >
	Type here to find a specific friend: 
	<input name="userToSearch" /> 
	<input type="submit" value="Search" />
</form>
<br />
<br />
<%
if(friendList.size() > 0){
for(int i=0; i<friendList.size();i++){
%>
<%=friendList.get(i).getName()+" "+friendList.get(i).getSurname() %> 
<form method="post" action="ServletProfileSeenByOther">
	<input type="hidden" name ="userId" value="<%=friendList.get(i).getId()%>" />
	<input type="submit" value="View Profile" />
</form>
<br />
<br />
<%
}
}else{
%>
Nessuno amico!
<%
}
%>

<br />
<form method="post" action="ServletProfilePage" >
	<input type="submit" value="Go Back" />
</form>

</body>
</html>
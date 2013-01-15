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
	<h1>SWIMv2</h1>
	</div>
<div id=text>
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
	<%
	List<String> names = (List<String>) request.getAttribute("names");
	List<Integer> posFeedbacks = (List<Integer>) request.getAttribute("posFeedbacks");
	List<Integer> negFeedbacks = (List<Integer>) request.getAttribute("negFeedbacks");
	for (int i = 0; i < names.size(); i++) {
	%>
	<br /> Ability:
	<%=names.get(i)%>
	Feedback:   +
	<%=posFeedbacks.get(i)%>
	    -
	 <%=negFeedbacks.get(i)%>
	<%	
	}
	%>
	
	<%
	int currentUserId = (Integer) session.getAttribute("id");
	if(user.getId() != currentUserId){
	%>
	<br />
	<form method="post" action="ServletAskJobToUser">
		<input type="hidden" name="userPerformerId" value="<%=user.getId()%>" />
		<input type="submit" value="Ask <%=user.getName()%>'s help for a job" />
	</form>
	<br />
	<br />
	
	<%
	int isFriend = (Integer)request.getAttribute("isFriend");
	if(isFriend == 0){
	%>
	
	<form method="post" action="ServletFriendshipRequest" >
		<input type="hidden" name="userReceiverId" value="<%=user.getId()%>" />
		<input type="submit" value="Ask friendship to <%=user.getName()%>" />
	</form>
	<%
	}
	%>
	<%
	}
	%>
	<br />		
	<form method="post" action="ServletJobPageByOther">
		<input type="hidden" name="toShow" value=<%=user.getId()%> />
		<input type="submit" value="See <%=user.getName()%>'s jobs" />
	</form>	
	<br />
	
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
	<form method="post" action="ServletProfilePage" >
		<input type="submit" value="Go Back To Your Profile" />
	</form>
	<br />
	<form method="post" action="ServletLogout">
		<input type="submit" value="Log Out" />
	</form>
</div>

<div id="footer">
Copyright &copy; 2013 Site for didactic purpose.
</div>
</body>
</html>
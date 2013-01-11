<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.polimi.swimv2.entities.FriendshipRequest" %>
<%@ page import="it.polimi.swimv2.entities.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Friendship Requests</title>
</head>
<body>
	<%
	List<FriendshipRequest> requestsToMe = (List<FriendshipRequest>) request.getAttribute("requestsToMe");
	List<FriendshipRequest> requestsByMe = (List<FriendshipRequest>) request.getAttribute("requestsByMe");
	List<User> userIAsked = (List<User>) request.getAttribute("userIAsked");
	List<User> userAskedToMe = (List<User>) request.getAttribute("userAskedToMe");
	%>
	<%if(requestsToMe.size()>0) {%>
	List of friendship requests received:<br />
	<br />
	<%
	for (int i = 0; i < requestsToMe.size(); i++) {
	%>
	From: <%=userAskedToMe.get(i).getName()+" "+userAskedToMe.get(i).getSurname()%><br />

	<form method="post" action="ServletFriendshipAccepted">
		<input type="hidden" name="userId" value="<%=userAskedToMe.get(i).getId() %>" /> 
		<input type="hidden" name="idFriendshipRequest" value="<%=requestsToMe.get(i).getId()%>"> </input>
 		<input type="submit" value="Accept"></input>
	</form>
	
	<form method="post" action="ServletFriendshipRefused">
		<input type="hidden" name="idFriendshipRequest" value="<%=requestsToMe.get(i).getId()%>"> </input>
		<input type="submit" value="Refuse"></input>
	</form>
	<%
		}
	}
	else{%>
	You haven't received any new friendship request.<br />
	<br />
	<%
		}
	%>
	<%if(requestsByMe.size()>0) {%>	
	List of friendship requests sent:<br />
	<br />
	<%
	for (int i = 0; i < requestsByMe.size(); i++) {
	%>
	To: <%=userIAsked.get(i).getName()+" "+userIAsked.get(i).getSurname()%><br />

	<form method="post" action="ServletFriendshipRefused">
		<input type="hidden" name="idFriendshipRequest" value="<%=requestsByMe.get(i).getId()%>"> </input>
 		<input type="submit" value="Cancel"></input>
	</form>
	<%
		}
	}
	else{%>
	You haven't sent any friendship request.<br />
	<br />
	<%
		}
	%>
	

	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go Back"></input>
	</form>
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.polimi.swimv2.entities.JobRequest" %>
<%@ page import="it.polimi.swimv2.entities.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Manage your job requests</title>
</head>
<body>
	<br />
	<%
		List<JobRequest> requestsToMe = (List<JobRequest>) request.getAttribute("requestsToMe");
		List<JobRequest> requestsByMe = (List<JobRequest>) request.getAttribute("requestsByMe");
		List<User> userIAsked = (List<User>) request.getAttribute("userIAsked");
		List<User> userAskedToMe = (List<User>) request.getAttribute("userAskedToMe");
	%>
	<%if(requestsToMe.size()>0) {%>
	Job requests you have received.<br />
	You can accept or refuse it<br />
	<br />
	<%
	for (int i = 0; i < requestsToMe.size(); i++) {
	%>
	From: <%=userAskedToMe.get(i).getName()+" "+userAskedToMe.get(i).getSurname()%><br />
	Date: <%=requestsToMe.get(i).getDate() %><br />
	Ability: <%=requestsToMe.get(i).getAbility() %><br />
	Place: <%=requestsToMe.get(i).getPlace() %><br />

	<form method="post" action="ServletJobAccepted">
		<input type="hidden" name="idJobRequest" value="<%=requestsToMe.get(i).getId()%>"> </input>
 		<input type="submit" value="Accept"></input>
	</form>
	
	<form method="post" action="ServletJobRefused">
		<input type="hidden" name="idJobRequest" value="<%=requestsToMe.get(i).getId()%>"> </input>
		<input type="submit" value="Refuse"></input>
	</form>
	<%
		}
		}
		else{
	%>
	You haven't received any new job request.<br />
	<br />
	<%
		}
	%>
	<%
		if(requestsByMe.size()>0) {
	%>
	Job requests you have sent.<br />
	You can cancel them permanently from the system.<br />
	<br />
	<%
		for (int i = 0; i < requestsByMe.size(); i++) {
	%>
	To: <%=userIAsked.get(i).getName()+" "+userIAsked.get(i).getSurname()%><br />
	Date: <%=requestsByMe.get(i).getDate()%><br />
	Ability: <%=requestsByMe.get(i).getAbility()%><br />
	Place: <%=requestsByMe.get(i).getPlace()%><br />

	<form method="post" action="ServletJobRefused">
		<input type="hidden" name="idJobRequest" value="<%=requestsByMe.get(i).getId()%>"> </input>
 		<input type="submit" value="Cancel"></input>
	</form>
	<%
		}
	}
	else{%>
	No job request sent and still pending.<br />
	<br />
	<%
		}
	%>
	

	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go Back"></input>
	</form>
	
</body>
</html>
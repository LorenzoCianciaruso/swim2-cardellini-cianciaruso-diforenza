<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.polimi.swimv2.entities.JobRequest" %>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@ page import="it.polimi.swimv2.entities.Ability" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Job Requests</title>
</head>
<body>
<div id =logo>
	<a href="ServletProfilePage"><img src="logo.jpg" /></a>
	</div>
<div id=text>
	<br />
	<%
		List<JobRequest> requestsToMe = (List<JobRequest>) request.getAttribute("requestsToMe");
		List<JobRequest> requestsByMe = (List<JobRequest>) request.getAttribute("requestsByMe");
		List<Ability> abilityRequestsToMe = (List<Ability>) request.getAttribute("abilityRequestsToMe");
		List<Ability> abilityRequestsByMe = (List<Ability>) request.getAttribute("abilityRequestsByMe");
		List<User> userIAsked = (List<User>) request.getAttribute("userIAsked");
		List<User> userAskedToMe = (List<User>) request.getAttribute("userAskedToMe");
	%>
	<a>JOB REQUEST YOU HAVE RECEIVED.</a><br />
	<%if(requestsToMe.size()>0) {%>	
	You can accept or refuse them.<br />
	<br />
	<%
	for (int i = 0; i < requestsToMe.size(); i++) {
	%>
	From: <%=userAskedToMe.get(i).getName()+" "+userAskedToMe.get(i).getSurname()%><br />
	Date: <%=requestsToMe.get(i).getDate()%><br />
	Ability: <%=abilityRequestsToMe.get(i).getName() %><br />
	Place: <%=requestsToMe.get(i).getPlace()%><br />

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
	<%
		}
	%>
	<br />
	<a>JOB REQUEST YOU HAVE SENT.</a><br />
	<%
		if(requestsByMe.size()>0) {
	%>
	You can cancel them permanently from the system.<br />
	<br />
	<%
		for (int i = 0; i < requestsByMe.size(); i++) {
	%>
	To: <%=userIAsked.get(i).getName()+" "+userIAsked.get(i).getSurname()%><br />
	Date: <%=requestsByMe.get(i).getDate()%><br />
	Ability: <%=abilityRequestsByMe.get(i).getName()%><br />
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
	<%
		}
	%>
	

	
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
	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go To Your Profile"></input>
	</form>
	<br />
	Search among friends: 
	<br />
	<form method="post" action="ServletSearchAmongFriend">
		<input name="userToSearch" placeholder="type name here.."/> <input type="submit"
			value="Search Friends" />
	</form>
	<br />
	<br />
	
	<form method="post" action="ServletLogout">
		<input type="submit" value="Log Out" />
	</form>
</div>

<div id="footer">
Copyright &copy; 2013 <br />Site for didactic purpose.
</div>
</body>
</html>
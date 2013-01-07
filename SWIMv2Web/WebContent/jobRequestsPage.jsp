<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.polimi.swimv2.entities.JobRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title></title>
</head>
<body>
	<br />
	<%
		List<JobRequest> requestsToUser = (List<JobRequest>) request.getAttribute("requestsToUser");
		List<JobRequest> requestsByUser = (List<JobRequest>) request.getAttribute("requestsByUser");
	%>
	List of job requests received:<br />
	<br />
	<%
	for (int i = 0; i < requestsToUser.size(); i++) {
	%>
	From: <%=requestsToUser.get(i).getRequestor()%><br />
	Date: <%=requestsToUser.get(i).getDate() %><br />
	Ability: <%=requestsToUser.get(i).getAbility() %><br />
	Place: <%=requestsToUser.get(i).getPlace() %><br />

	<form method="post" action="ServletJobAccepted">
		<input type="hidden" name="idJobRequest" value="<%=requestsToUser.get(i).getIdJob()%>"> </input>
 		<input type="submit" value="Refuse"></input>
	</form>
	
	<form method="post" action="ServletJobRefused">
		<input type="hidden" name="idJobRequest" value="<%=requestsToUser.get(i).getIdJob()%>"> </input>
		<input type="submit" value="Accept"></input>
	</form>
	<%
		}
	%>
	
	List of job requests sent:<br />
	<br />
	<%
	for (int i = 0; i < requestsByUser.size(); i++) {
	%>
	From: <%=requestsByUser.get(i).getRequestor()%><br />
	Date: <%=requestsByUser.get(i).getDate() %><br />
	Ability: <%=requestsByUser.get(i).getAbility() %><br />
	Place: <%=requestsByUser.get(i).getPlace() %><br />

	<form method="post" action="ServletJobRefused">
		<input type="hidden" name="idJobRequest" value="<%=requestsByUser.get(i).getIdJob()%>"> </input>
 		<input type="submit" value="Cancel"></input>
	</form>
	<%
		}
	%>
	

	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go Back"></input>
	</form>
	
</body>
</html>
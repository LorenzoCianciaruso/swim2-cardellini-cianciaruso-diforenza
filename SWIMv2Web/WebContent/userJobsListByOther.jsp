<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Job" %>
<%@ page import="it.polimi.swimv2.entities.User" %>
<%@ page import="it.polimi.swimv2.entities.Ability" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<% 
List<Job> listPerformedJob = (List<Job>) request.getAttribute("listPerformedJob");
List<Job> listAskedJob = (List<Job>) request.getAttribute("listAskedJob");
List<User> listUserPerformed = (List<User>) request.getAttribute("listUserPerformed");
List<User> listUserRequester = (List<User>) request.getAttribute("listUserRequester");
List<Ability> listOfAbility = (List<Ability>) request.getAttribute("listOfAbility");
%>
<title>Jobs</title>
</head>
<body>
	<div id =logo>
	<a href="ServletProfilePage"><img src="logo.jpg" /></a>
	</div>
<div id=text>
<a>JOBS PERFORMED:</a><br />
<br />
<%
if(listPerformedJob.size() > 0){
for(int i=0; i < listPerformedJob.size(); i++){
%>
JOB:
<br />
Requestor: <%try{ %> <%=listUserPerformed.get(i).getName()+" "+listUserPerformed.get(i).getSurname() %>
			<%}catch(NullPointerException e){ %>
			<%= "User Banned" %>
			<%} %><br />
Date: <%=listPerformedJob.get(i).getDate() %><br />
Place: <%=listPerformedJob.get(i).getPlace() %><br />
<%
	for(int j=0; j< listOfAbility.size(); j++){
	if(listOfAbility.get(j).getId() == listPerformedJob.get(i).getIdAbility()){
%>
Ability: <%try{ %><%=listOfAbility.get(j).getName()%>	
		<%}catch(NullPointerException e){ %>
		<%= "Ability Deleted" %>
		<%} %>
		
		<%
				}
				}
			%><br />
			<%
	if( listPerformedJob.get(i).getComment()!= null ){%>
Feedback: <%if(listPerformedJob.get(i).getFeedback()==1){
	%>
		<g>+<%=listPerformedJob.get(i).getFeedback()%></g>
	<%}else{ %>
	<r><%=listPerformedJob.get(i).getFeedback() %></r>
	<%} %><br />
Comment: <%=listPerformedJob.get(i).getComment()%><br />
<%
	}else{
%>
JOB NOT COMPLETED<br />
<%
	}
%>
<br />
<%
	}
}else{
%>
No jobs performed!<br />
<%
	}
%>
<br />
<a>JOBS REQUESTED:</a><br />
<br />
<%
	if(listAskedJob.size() > 0){
for(int i=0; i < listAskedJob.size(); i++){
%>
JOB:<br />
Performer:	 <%try{ %> <%=listUserRequester.get(i).getName()+" "+listUserRequester.get(i).getSurname()%>
			<%}catch(NullPointerException e){ %>
			<%= "User Banned" %>
			<%} %><br />
			
Date: <%=listAskedJob.get(i).getDate()%><br />
Place: <%=listAskedJob.get(i).getPlace()%><br />
<%
	for(int j=0; j< listOfAbility.size(); j++){
	if(listOfAbility.get(j).getId() == listAskedJob.get(i).getIdAbility()){
%>
Ability:  <%try{ %><%=listOfAbility.get(j).getName()%>	
		<%}catch(NullPointerException e){ %>
		<%= "Ability Deleted" %>
		<%} %>	
		<%
	}
}
%><br /><%
	if( listAskedJob.get(i).getComment() != null){%>
Feedback: <%if(listPerformedJob.get(i).getFeedback()==1){
	%>
		<g>+<%=listPerformedJob.get(i).getFeedback()%></g>
	<%}else{ %>
	<r><%=listPerformedJob.get(i).getFeedback() %></r>
	<%} %><br />
Comment: <%=listAskedJob.get(i).getComment()%><br />
<%
	}else{
%>
JOB NOT COMPLETED<br />
<%
	}
%>
<br />
<%
}
}else{
%>
No jobs requested!<br />
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
	<form method="post" action="ServletProfilePage" >
		<input type="submit" value="Go Back" />
	</form>	
	<br />
	<br />
	
</div>

<div id="footer">
Copyright &copy; 2013 <br />Site for didactic purpose.
</div>
</body>
</html>
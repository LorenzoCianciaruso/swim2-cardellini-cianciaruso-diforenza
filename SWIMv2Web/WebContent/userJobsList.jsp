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
	<h1>SWIMv2</h1>
	</div>
<div id=text>
<b>JOBS YOU HAVE PERFORMED:</b><br />
<br />
<%
if(listPerformedJob.size() > 0){
for(int i=0; i < listPerformedJob.size(); i++){
%>
Requester: <%try{ %> <%=listUserPerformed.get(i).getName()+" "+listUserPerformed.get(i).getSurname() %>
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
FeedBack released: <%=listPerformedJob.get(i).getFeedback()%><br />
<%
	if( !(listPerformedJob.get(i).getComment() == null) ){
%>
Comment: <%=listPerformedJob.get(i).getComment()%><br />
<%
	}else{
%>
Comment: no comment!
<%
	}
%>
<br />
<%
	}
}else{
%>
You haven't performed any jobs!<br />
<%
	}
%>
<br />
<b>JOBS YOU HAVE REQUESTED:</b><br />
<br />
<%
	if(listAskedJob.size() > 0){
for(int i=0; i < listAskedJob.size(); i++){
%>
Performer:	<%=listUserRequester.get(i).getName()+" "+listUserRequester.get(i).getSurname()%><br />
Date: <%=listAskedJob.get(i).getDate()%><br />
Place: <%=listAskedJob.get(i).getPlace()%><br />
<%
	for(int j=0; j< listOfAbility.size(); j++){
	if(listOfAbility.get(j).getId() == listAskedJob.get(i).getIdAbility()){
%>
Ability: <%=listOfAbility.get(j).getName() %>	
		<%
	}
}
%><br />
<%
if( listAskedJob.get(i).getComment() == null ){
%>
<form method="post" action="userReleaseFeedbackPage.jsp" >
	<input type="hidden" name="jobId" value="<%=listAskedJob.get(i).getId()%>" />
	<input type="submit" value="Set Feedback and Comment" />
</form>	
<%
}
%>
<br />
<%
}
}else{
%>
You haven't asked help for any jobs!<br />
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
	<form method="post" action="ServletProfilePage" >
		<input type="submit" value="Go To Your Profile" />
	</form>
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
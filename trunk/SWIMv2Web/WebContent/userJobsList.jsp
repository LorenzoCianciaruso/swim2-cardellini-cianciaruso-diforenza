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
<b>JOBS YOU HAVE PERFORMED:</b><br />
<br />
<%
if(listPerformedJob.size() > 0){
for(int i=0; i < listPerformedJob.size(); i++){
%>
Requester: <%=listUserPerformed.get(i).getName()+" "+listUserPerformed.get(i).getSurname() %><br />
Date: <%=listPerformedJob.get(i).getDate() %><br />
Place: <%=listPerformedJob.get(i).getPlace() %><br />
<%
	for(int j=0; j< listOfAbility.size(); j++){
	if(listOfAbility.get(j).getId() == listPerformedJob.get(i).getAbility()){
%>
Ability: <%=listOfAbility.get(j).getName()%>	
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
Performer: <%=listUserRequester.get(i).getName()+" "+listUserRequester.get(i).getSurname()%><br />
Date: <%=listAskedJob.get(i).getDate()%><br />
Place: <%=listAskedJob.get(i).getPlace()%><br />
<%
	for(int j=0; j< listOfAbility.size(); j++){
	if(listOfAbility.get(j).getId() == listAskedJob.get(i).getAbility()){
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
You haven't performed any jobs!<br />
<%
}
%>
<br />
<form method="post" action="ServletProfilePage" >
	<input type="submit" value="Go Back" />
</form>
</body>
</html>
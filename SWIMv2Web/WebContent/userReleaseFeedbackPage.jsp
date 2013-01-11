<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%
int jobId = Integer.parseInt(request.getParameter("jobId"));
%>
<title>Feedback and comment</title>
</head>
<body>
<b>HERE YOU CAN RELEASE THE FEEDBACK AND ADD A COMMENT TO THE JOB:</b><br />
<br />
Feedback can be positive or negative:<br />

<form method="post" action="ServletJobFeedbackAdder">
	<input type="radio" name="feedback" value="positive" />Positive<br />
	<input type="radio" name="feedback" value="negative" />Negative<br />
	<br />
	<textarea name="comment" rows="5" cols="100" placeholder="Write here the comment..." maxlength="1000"></textarea>
	<br />
	<input type="hidden" name="jobId" value="<%=jobId %>" />
	<input type="submit" value="Set Feedback" />
</form>

<br />
<br />
<form method="post" action="ServletProfilePage" >
	<input type="submit" value="Cancel and Go to the profile" />
</form>
</body>
</html>
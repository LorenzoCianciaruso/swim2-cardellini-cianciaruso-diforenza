<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="it.polimi.swimv2.entities.AbilityDeclared"%>
<%@ page import="it.polimi.swimv2.entities.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Create a job</title>
</head>
<body>
	<div id =logo>
	<h1>SWIMv2</h1>
	</div>
<div id=text>
	<%
		int idPerformer = (Integer) request.getAttribute("userPerformerId");
		List<String> names = (List<String>) request.getAttribute("names");
		List<Integer> idAbilities = (List<Integer>) request
				.getAttribute("idAbilities");
		List<Integer> feedbacks = (List<Integer>) request
				.getAttribute("feedbacks");
	%>

<script>
		function validateForm() {
			var x = document.forms["newJob"]["date"].value;
			var y = document.forms["newJob"]["place"].value;
			if (x == null || x == "" || y == null || y == "") {
				alert("Field must be filled out");
				return false;
			}
			if (!x
						.match("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9][0-9]")) {
					alert("Invalid date format");
				return false;
			
			}
		}
	</script>
	</head>
	<body>
		<form name="newJob" action="ServletNewJobRequest"
			onsubmit="return validateForm()" method="post">
			Date: (dd/mm/yyyy) <input type="text" name="date">
			<select name="ability">
		<%
			for (int i = 0; i < names.size(); i++) {
		%>
		<option value = <%=idAbilities.get(i) %>>
		<%=names.get(i)%> <%=feedbacks.get(i)%>
		</option>		
		<%
			}
		%>
		</select>
			Place: <input type="text" name="place">
			<input type="hidden" name="userPerformerId"
			value="<%=request.getParameter("userPerformerId")%>"></input>
			<input type="submit" value="Submit">
		</form>
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
</div>

<div id="footer">
Copyright &copy; 2013 Site for didactic purpose.
</div>
</body>
</html>
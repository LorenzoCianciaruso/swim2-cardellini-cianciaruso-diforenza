<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Ability"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script>
		function validateNewAbility() {
			var x = document.forms["newAbility"]["name"].value;
			if (x == null || x == "") {
				alert("Field must be filled out");
				return false;
			}
		}
	</script>
<title>Abilities list</title>
</head>
<body>
	<div id =logo>
	<h1>SWIMv2</h1>
	</div>
<div id="text">
	Here all the abilities of the system.
	<br />
	<%
		List<Ability> list = (List<Ability>) request.getAttribute("abilityList");
		for (int i = 0; i < list.size(); i++) {
	%>
	<br /> Ability name:
	<%=list.get(i).getName()%>

	<form method="post" action="ServletAdminDeleteAbility">
		<input type="hidden" name="abilityId" value="<%=list.get(i).getId()%>"></input>
		<input type="submit" value="Remove"></input>
	</form>
	<%
		}
	%>
	<br /> Create new ability.
	<form name="newAbility" action="ServletAcceptAbilityRequest"
		onsubmit="return validateNewAbility()" method="post">
		<input name="name" placeholder="Name"/> <br />
		<input type="submit" value="Create ability">
	</form>
	
	<br />
	
	
	
	
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
	<form method="post" action="adminProfile.jsp">
		<input type="submit" value="Go Back"></input> 
	</form>
	</div>
</div>
	
<div id="footer">
	Copyright &copy; 2013 Site for didactic purpose.
</div>
</body>
</html>
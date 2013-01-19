<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.AbilityRequest"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Abilities requests</title>
</head>
<body>
	<div id =logo>
	<a href="ServletProfilePage"><img src="logo.jpg" /></a>
	</div>
<div id="textcenter">
	Here all suggestion for new abilities.
	<br />
	<%
		List<AbilityRequest> list = (List<AbilityRequest>) request.getAttribute("newAbilitiesList");
			for (int i = 0; i < list.size(); i++) {
	%>
	<br /> Ability Request:
	<%=list.get(i).getName()%>


	<form method="post" action="ServletRefuseAbilityRequest">
		<input type="hidden" name="idNewAbility" value="<%=list.get(i).getId()%>"> </input>
 		<input type="submit" value="Refuse"></input>
	</form>
	
	<form method="post" action="ServletAcceptAbilityRequest">
		<input type="hidden" name="idNewAbility" value="<%=list.get(i).getId()%>"></input>
		<input type="hidden" name="idUser" value="<%=list.get(i).getUser()%>"></input>
		<input type="hidden" name="name" value="<%=list.get(i).getName() %>"></input>
		<input type="submit" value="Accept"></input>
	</form>
	<%
		}
	%>
	
	
	<div id="sidebar">
	<br />
	<br />
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
	<br />
	<br />
	<br />
	<form method="post" action="adminProfile.jsp">
		<input type="submit" value="Go Back"></input> 
	</form>
	<br />
	<form method="post" action="ServletLogout">
		<input type="submit" value="Log Out" />
	</form>
	</div>
</div>
	
<div id="footer">
	Copyright &copy; 2013<br /> Site for didactic purpose.
</div>
	
</body>
</html>
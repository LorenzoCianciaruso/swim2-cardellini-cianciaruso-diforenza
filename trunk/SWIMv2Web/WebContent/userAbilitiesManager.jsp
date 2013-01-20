<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Ability" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Abilities</title>
</head>
<body>
	<div id =logo>
	<a href="ServletProfilePage"><img src="logo.jpg" /></a>
	</div>
	<div id=text>
	<form method="post" action="ServletAbilityDeclared">
		<h2>Manage your abilities</h2>
		<br />
		If you want to add new abilities, choose them from the list below:<br />
		<br />
		<%
		List<Ability> list = (List<Ability>) request.getAttribute("abilitiesList");
		List<Ability> listOwned = (List<Ability>) request.getAttribute("abilitiesOwned");
		list.removeAll(listOwned);
		for(int i = 0; i < list.size(); i++){
		%>
		<input type="checkbox" name="ability" value="<%=list.get(i).getId()%>" /><%=list.get(i).getName()%><br />
		<%
			}
		%>
		<br />
		<input type="submit" value="Add Checked Abilities" />
	</form>
	
	<form method="post" action="ServletAbilityRequested">
		<br />
		If you want to sent a request to add an ability to SWIMv2 type the name of the ability here: <input name="abilityAdded" />
		<input type="submit" value="Send request" />
		<br />
	</form>
	
	<br />
	
	<form method="post" action="ServletAbilityDeleted">
		If you want to delete an ability from your profile check them:<br />
		<br />
		<%
			for(int i=0; i<listOwned.size(); i++){
		%>
		<input type="checkbox" name="abilityDeleted" value="<%=listOwned.get(i).getId()%>" /><%=listOwned.get(i).getName() %><br />
		<%
		}
		%>
		<br />
		<input type="submit" value="Delete Ability" />
	</form>
	
	<br />
	
	
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
	<br />
	<br />
	<br />
	
	<form method="post" action="ServletProfilePage">
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
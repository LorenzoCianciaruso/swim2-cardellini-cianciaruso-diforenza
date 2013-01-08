<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Ability" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Manage Abilities</title>
</head>
<body>
	
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
		<input type="checkbox" name="ability" value="<%=list.get(i).getName() %>" /><%=list.get(i).getName() %><br />
		<%
		}
		%>
		<br />
		<input type="submit" value="Add Checked Abilities" />
	</form>
	
	<form method="post" action="ServletAbilityRequested">
		<br />
		If you can't find the ability, type its name in the field and then click the Add button: <input name="abilityAdded" />
		<input type="submit" value="Add Abilities" />
		<br />
	</form>
	
	<br />
	
	<form method="post" action="ServletAbilityDeleted">
		If you want to delete an ability from your profile check them:<br />
		<br />
		<%
		for(int i=0; i<listOwned.size(); i++){
		%>
		<input type="checkbox" name="abilityDeleted" value="<%=listOwned.get(i).getName()%>" /><%=listOwned.get(i).getName() %><br />
		<%
		}
		%>
		<br />
		<input type="submit" value="Delete Ability" />
	</form>
	
	<br />
	
	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go back" />
	</form>
	
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Ability" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Abilities</title>
</head>
<body>
	<form method="post" action="ServletAbilityAdded">
	
		<h2>List of Abilities:</h2>
		<br />
		<br />
		<%
		List<Ability> list = (List<Ability>) request.getAttribute("abilitiesList");
		for(int i = 0; i < list.size(); i++){
		%>
		<input type="checkbox" name="ability" value="<%=list.get(i).getName() %>" /><%=list.get(i).getName() %><br />
		<%
		}
		%>
		If you can't find the ability, type its name in the field and then click the Add button: <input name="abilityAdded" />
		<input type="submit" value="Add Abilities" />
		<br />
	</form>
	<br />
	<form method="post" action="ServletAbilityDeleted">
		If you want to delete an ability from your profile click the Delete button: <input name="abilityDeleted" />
		<input type="submit" value="Delete Ability" />
	</form>
	<br />
	<form method="post" action="ServletProfilePage">
		<input type="submit" value="Go back" />
	</form>
</body>
</html>
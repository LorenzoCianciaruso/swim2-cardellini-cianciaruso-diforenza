<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.AbilityRequest"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>New Ability Requests</title>
</head>
<body>

	<h2>New Ability Requests</h2>
	<br />
	<%
		List<AbilityRequest> list = (List<AbilityRequest>) request.getAttribute("newAbilitiesList");
			for (int i = 0; i < list.size(); i++) {
	%>
	<br /> Ability Request:
	<%=list.get(i).getName()%>


	<form method="post" action="ServletRefuseAbilityRequest">
		<input type="hidden" name="idNewAbility" value="<%=list.get(i).getIdNewAbility()%>"> </input>
 		<input type="submit" value="Refuse"></input>
	</form>
	
	<form method="post" action="ServletAcceptAbilityRequest">
		<input type="hidden" name="idNewAbility" value="<%=list.get(i).getIdNewAbility() %>"></input>
		<input type="hidden" name="idUser" value="<%=list.get(i).getIdUser() %>"></input>
		<input type="hidden" name="name" value="<%=list.get(i).getName() %>"></input>
		<input type="submit" value="Accept"></input>
	</form>
	<%
		}
	%>

	<form method="post" action="ServletAdminRedirect">
		<input type="submit" value="Go Back"></input>
	</form>
	
	
</body>
</html>
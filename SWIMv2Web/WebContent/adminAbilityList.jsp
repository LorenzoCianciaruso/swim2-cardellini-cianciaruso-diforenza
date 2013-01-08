<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Ability"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Abilities list</title>
</head>
<body>

	<h2>SWIMv2 Abilities</h2>

	<br />

	<%
		List<Ability> list = (List<Ability>) request.getAttribute("abilityList");
		for (int i = 0; i < list.size(); i++) {
	%>
	<br /> Ability name:
	<%=list.get(i).getName()%>

	<form method="post" action="ServletAdminDeleteAbility">
		<input type="hidden" name="abilityId" value="<%=list.get(i).getIdAbility()%>"></input>
		<input type="submit" value="Delete"></input>
	</form>
	<%
		}
	%>
	
	<br />
	
	<form method="post" action="adminProfile.jsp">
		<input type="submit" value="Go Back"></input> 
	</form>

</body>
</html>
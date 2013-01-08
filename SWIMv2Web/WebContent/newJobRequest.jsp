<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="it.polimi.swimv2.entities.AbilitiesDeclared"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><%=request.getAttribute("userPerformerId")%></title>
</head>
<body>
	<%
	int idPerformer = (Integer) request.getAttribute("userPerformerId");
	//dovrebbe ricevere già come parametro una lista di abilita' pero ' da una jsp probabilmente conviene mettercci in mezzo un bel servlet e vaffanculo
	//anzi senza il probilmente cacciamoci il servlet e bona li%>

	<form method="post" action="ServletNewJobRequest">
		Date: (dd/mm/yyyy) <input name="date" /> <br />
		Ability: <input name="ability" /> <br />
		Place:<input name="place" /> <br />
		<input type="hidden" name="userPerformerId" value="<%=request.getParameter("userPerformerId")%>"></input>
		<input type="submit" value="Submit Request"></input>
	</form>
</body>
</html>
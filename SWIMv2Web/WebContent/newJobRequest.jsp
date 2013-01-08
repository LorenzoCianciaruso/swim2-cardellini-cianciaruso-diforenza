<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="it.polimi.swimv2.entities.AbilitiesDeclared"%>
<%@ page import="it.polimi.swimv2.entities.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><%=request.getAttribute("userPerformerId")%></title>
</head>
<body>
	<%
		int idPerformer = (Integer) request.getAttribute("userPerformerId");
		List<String> names = (List<String>) request.getAttribute("names");
		List<Integer> idAbilities = (List<Integer>) request
				.getAttribute("idAbilities");
		List<Integer> feedbacks = (List<Integer>) request
				.getAttribute("feedbacks");
	%>

	<form method="post" action="ServletNewJobRequest">
		Date: (dd/mm/yyyy) <input name="date" /> <br />
		<select name="Ability">
		<%
			for (int i = 0; i < names.size(); i++) {
		%>
		<option value = <%=idAbilities.get(i) %>>
		<%=names.get(i)%> <%=feedbacks.get(i)%>
		</option>
		</select>
		
		<br /> 
		<%
			}
		%>
		<br />
		Place:<input	name="place" />
		<br />
		<input type="hidden" name="userPerformerId"
			value="<%=request.getParameter("userPerformerId")%>"></input>
			<input type="submit" value="Submit Request"></input>
					<input type="submit" value="Add Checked Abilities" />
			
	</form>
</body>
</html>
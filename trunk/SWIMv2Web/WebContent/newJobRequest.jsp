<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><%=request.getAttribute("userPerformerId")%></title>
</head>
<body>
	<%
	int idPerformer = (Integer) request.getAttribute("userPerformerId");
	List<Integer> abilities = (List<Integer>) request.getAttribute("abilities");
	%>

	<form method="post" action="ServletNewJob">
		Date: (dd/mm/yyyy) <input name="date" /> <br />
		Place:<input name="place" /> <br />
		<input type="hidden" name="userPerformerId" value="<%=request.getParameter("userPerformerId")%>"></input>
		<input type="submit" value="Submit Request"></input>
	</form>
</body>
</html>
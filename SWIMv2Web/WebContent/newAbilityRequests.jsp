<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.NewAbility" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>New Ability Requests</title>
</head>
<body>

	<h2> New Ability Requests</h2>
	<br />
	<%
	List<NewAbility> list = (List<NewAbility>) request.getAttribute("newAbilitiesList");
	for(int i = 0; i<list.size(); i++){
	%>
		Ability name: <%= list.get(i).getName() %>
	<%		
	}
	%>

</body>
</html>
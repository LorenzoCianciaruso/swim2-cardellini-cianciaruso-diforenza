<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.polimi.swimv2.entities.Ability" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Results</title>
</head>
<body>
	<div id =logo>
	<h1>SWIMv2</h1>
	</div>
<div id=text>
		<%
		List<Ability> list = (List<Ability>) request.getAttribute("abilities");
		if(list.size()==0){
		%>
	NO Results for your search, I'm sorry!
		<%
		}else{
		%>
			Here are all abilities that matches your research:<br />
			<%
			for(int i = 0; i< list.size(); i++){
				Ability ability = list.get(i);
			%>
	<%=ability.getName() %>
	<form method="post" action="ServletSearchByGivenAbility">
		<input type="hidden" name="id" value=<%=ability.getId()%> />
		<input type="submit" value="Search users with this ability" />
	</form>
	<%
			}
		}
	%>
	
	</div>

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
	
</div>

<div id="footer">
Copyright &copy; 2013<br /> Site for didactic purpose.
</div>
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Admin Home</title>
</head>
<body>
	<div id =logo>
	<h1>SWIMv2</h1>
	</div>
	Welcome Administrator!
	
	<br />
	
	<form method="post" action="ServletNewAbilities" >
	<input type="submit" value="New Ability Requests"></input>
	</form> 
	
	<br />
	
	<form method="post" action="ServletAdminAbilityList" >
	<input type="submit" value="Ability List"></input> 
	</form>
	
	<br />
	<form method="post" action="ServletLogout">
		<input type="submit" value="Log Out" />
	</form>
	
	<br />

	<div id="sidebar">
	<form method="post" action="ServletSearch">
		Search: <input name="search" /> <input type="submit"
			value="Search User" />
	</form>
	</div>
	
	
<div id="footer">
	Copyright &copy; 2013 Site for didactic purpose.
</div>
	
</body>
</html>
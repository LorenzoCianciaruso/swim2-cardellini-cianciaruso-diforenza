<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Admin Home</title>
</head>
<body>
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

	<form method="post" action="ServletSearch">
		Search: <input name="search" /> <input type="submit"
			value="Search User" />
	</form>
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register new profile</title>
</head>
<body>
	<form method="post" action="registration">
		Name: <input name="name" />
		<br /> Surname: <input name="surname" />
		<% //TODO controllo sul formato data che fa impazzire tutto%>
		<br /> Birthday: (dd/mm/yyyy) <input name="birthday" /> 
		<br /> City: <input name="city" />
		<br /> Email: <input name="email" />
		<br /> Telephone: <input name="phone" />
		<br /> Password: <input	name="password" type="password" /> 
		<br /> Confirm Password: <input	name="confirmPassword" type="password" /> 
		<br />
		<input type="submit" value="Submit Registration"></input>
	</form>
</body>
</html>
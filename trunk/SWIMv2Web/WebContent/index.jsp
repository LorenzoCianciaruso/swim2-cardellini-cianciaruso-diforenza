<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SWIMv2 HomePage</title>
</head>
<body>
	<h1>Benvenuti in SWIMv2</h1>
	<br></br>
	<br></br>
	<form method="post" action="login">
		Username: <input name="userName" /><br />
		Password:  <input name="password" /><br />
		<input type="radio" name="kindOfUser" value="registeredUser">Registered User</input>
		<input type="radio" name="kindOfUser" value="admin">Administrator</input>
		<br></br>
		<input type="submit" value="Submit" />
	</form>
	PS: Difo muori
</body>
</html>
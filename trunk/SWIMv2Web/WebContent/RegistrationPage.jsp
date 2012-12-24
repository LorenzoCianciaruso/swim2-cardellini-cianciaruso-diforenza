<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Registration new profile</title>
</head>
<body>
	<form method="post" action="registration">
		Name: <input name="name" /><br />
		City: <input name="city" /><br />
		Email: <input name="email" /><br />
		Telephone: <input name="phone" /><br />
		Password: <input name="password" type="password" /><br />
		Confirm Password: <input name="password" type="password" /><br />
		Abilities: <br />
				   <input type="checkbox" name="abilities" value="imbianchino" />Imbianchino<br />
				   <input type="checkbox" name="abilities" value="muratore" />Muratore<br />
				   <input type="checkbox" name="abilities" value="idraulico" />Idraulico<br />
				   <input type="checkbox" name="abilities" value="Informatico" />Informatico<br />
				   <input type="checkbox" name="abilities" value="babysitter" />Babysitter<br />
				   
		<input type="submit" value="Submit Registration"></input>
    </form>
</body>
</html>
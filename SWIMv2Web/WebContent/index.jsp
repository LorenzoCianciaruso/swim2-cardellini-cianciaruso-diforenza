<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SWIMv2</title>
</head>
<body>
	<h1>Welcome in SWIMv2</h1>
	<br />
	<br />
	<script>
		function validateForm() {
			var x = document.forms["myForm"]["email"].value;
			var y = document.forms["myForm"]["password"].value;
			if (x == null || x == "" || y == null || y == "") {
				alert("Field must be filled out");
				return false;
			}
		}
	</script>
	</head>
	<body>
		<form name="myForm" action="ServletLogin"
			onsubmit="return validateForm()" method="post">
			Email: <input type="text" name="email">
			Password: <input type="password" name="password">
			<input type="submit" value="Submit">
		</form>
	</body>
	or
	<form method="post" action="registrationPage.jsp">
		<input type="submit" value="Register" />
	</form>
</body>
</html>
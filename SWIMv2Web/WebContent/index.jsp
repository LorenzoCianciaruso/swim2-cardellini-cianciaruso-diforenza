<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="global.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SWIMv2</title>
</head>
<body>
	<h1>Welcome in SWIMv2</h1>
	<br />
	<br />
	<script>
		function validateLogin() {
			var x = document.forms["login"]["email"].value;
			var y = document.forms["login"]["password"].value;
			if (x == null || x == "" || y == null || y == "") {
				alert("Field must be filled out");
				return false;
			}
		}
	</script>
	</head>
	Login<br />
	<body>
		<form name="login" action="ServletLogin"
			onsubmit="return validateLogin()" method="post">
			<input type="text" name="email" placeholder="Email">
			<input type="password" name="password" placeholder="Password">
			<input type="submit" value="Login">
		</form>
	</body>
	or register new profile
	<script>

		function validateRegistration() {
			var sname = document.forms["registration"]["name"].value;
			var ssurname = document.forms["registration"]["surname"].value;
			var sbirthday = document.forms["registration"]["birthday"].value;
			var scity = document.forms["registration"]["city"].value;
			var semail = document.forms["registration"]["registrationEmail"].value;
			var sphone = document.forms["registration"]["phone"].value;
			var spassword = document.forms["registration"]["registrationPassword"].value;
			var sconfirm = document.forms["registration"]["confirmPassword"].value;

			if (sname == null || sname == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (ssurname == null || ssurname == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (sbirthday == null || sbirthday == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (scity == null || scity == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (semail == null || semail == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (sphone == null || sphone == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (spassword == null || spassword == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (sconfirm == null || sconfirm == "") {
				alert("All fields must be filled out");
				return false;
			}
			if (spassword != sconfirm) {
				alert("Password must be the same");
				return false;
			}
			if (!sbirthday
					.match("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9][0-9]")) {
				alert("Invalid date format");
				return false;
			}

		}
	</script>
	<form name="registration" action="ServletRegistration"
		onsubmit="return validateRegistration()" method="post">
		<input name="name" placeholder="First name"/> <br />
		<input name="surname" placeholder="Surname"/> <br />
		<input name="birthday" placeholder="Birthdate (dd/mm/yyyy)"/> <br />
		<input name="city" placeholder="City"/> <br />
		<input name="registrationEmail" placeholder="Email"/> <br />
		<input name="phone" placeholder="Phone number"/> <br />
		<input name="registrationPassword" placeholder="Password"type="password" /> <br />
		<input name="confirmPassword" placeholder="Re-enter password"type="password" /><br />
		<input type="submit" value="Register">
	</form>

</body>
</html>
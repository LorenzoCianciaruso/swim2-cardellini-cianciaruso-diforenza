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

	<script>

		function validateForm() {
			var sname = document.forms["registration"]["name"].value;
			var ssurname = document.forms["registration"]["surname"].value;
			var sbirthday = document.forms["registration"]["birthday"].value;
			var scity = document.forms["registration"]["city"].value;
			var semail = document.forms["registration"]["email"].value;
			var sphone = document.forms["registration"]["phone"].value;
			var spassword = document.forms["registration"]["password"].value;
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
		onsubmit="return validateForm()" method="post">
		Name: <input name="name" /> <br /> Surname: <input name="surname" />
		<br /> Birthday: (dd/mm/yyyy) <input name="birthday" /> <br />
		City: <input name="city" /> <br /> Email: <input name="email" /> <br />
		Telephone: <input name="phone" /> <br /> Password: <input
			name="password" type="password" /> <br /> Confirm Password: <input
			name="confirmPassword" type="password" /> <input type="submit"
			value="Submit">
	</form>


</body>
</html>
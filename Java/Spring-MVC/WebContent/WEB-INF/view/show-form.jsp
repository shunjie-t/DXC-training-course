<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHOW FORM</title>
</head>
<body>
	<h4>Fill up the form</h4>
	<form action="processForm" method="GET">
		<input type="text" name="name" placeholder="Enter name">
		<br><br>
		<input type="text" name="role" placeholder="Enter role">
		<br><br>
		<input type="submit" value="Submit form">
	</form>
</body>
</html>
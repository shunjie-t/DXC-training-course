<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STUDENT FORM</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		<label for="firstname">First Name: </label>
		<input type="text" name="firstname">
		<br><br>
		<label for="Lastname">Last Name: </label>
		<input type="text" name="Lastname">
		<br><br>
		<label for="subject">Subject taken: </label>
		<input type="text" name="subject">
		<br><br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>
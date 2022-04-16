<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <% out.println(session.getAttribute("aun")); %>, you have successfully registered</h1>

<form action="/CarServiceSystem/RegisteredCustomer">
	<input type="submit" value="Registered customer">
</form>
<br><br>
<form action="/CarServiceSystem/PendingRequest">
	<input type="submit" value="Pending request">
</form>
<br><br>
<form action="/CarServiceSystem/updateStatus.html">
	<input type="submit" value="Update status">
</form>
<br><br>
</body>
</html>
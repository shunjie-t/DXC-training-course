<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successfully signed in</title>
</head>
<body>
<h1>Welcome <% 
	HttpSession ses = request.getSession();
	out.println(ses.getAttribute("name"));
%></h1>
<h3>Username: <% out.println(ses.getAttribute("username")); %></h3>
<h3>Email: <% out.println(ses.getAttribute("email")); %></h3>

<a href="/SignInApplication/changePassword.html">change password</a>
<br><br>
<a href="/SignInApplication/changeEmail.html">change email</a>
</body>
</html>
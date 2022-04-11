<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <% 
	// HttpSession ses = request.getSession();
	// out.println(ses.getAttribute("cname"));
	out.println(request.getSession().getAttribute("cname"));
%>, you have successfully registered</h1>

<a href="/CarServiceSystem/customerLogin.html">login</a>
</body>
</html>
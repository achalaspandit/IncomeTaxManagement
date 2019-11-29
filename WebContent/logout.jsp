<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logged Out</title>
</head>
<body style="background-size:1450px 700px;
    		background-attachment: fixed;
    		background-repeat: no-repeat;
    		background-image:url(index1.jpg)">
	<%	session.setAttribute("Pan_no", null);
		session.setAttribute("Uname", null);
		%>
	<form action="myname.jsp">
		<div style="align-self: center; background-color: rgba(200, 215, 60, 0.651); width: 450px; height: 400px; padding: 50px; margin: 80px;">
		<h3>You've successfully logged out. See you again!</h3>
		<button>Go Home</button>
		</div>
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.io.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body style="background-size:1450px 700px;
    		background-attachment: fixed;
    		background-repeat: no-repeat;
    		background-image:url(index1.jpg)">
    		
    		<form action="logout.jsp">
    		<button>Logout</button>
    		</form>
    		<%
    			if(session.getAttribute("Uname")==null)
    			{
    				response.sendRedirect("adlog.jsp");	
   				}
    			
    		%>
    		<div style="align-self: center; background-color: rgba(200, 215, 60, 0.651); width: 450px; height: 400px; padding: 50px; margin: 80px;">
    		<form action="newuserentry">
    			<h2>Welcome Admin</h2>
    			<button>Check</button>
    		</form>
    		</div>
</body>
</html> 
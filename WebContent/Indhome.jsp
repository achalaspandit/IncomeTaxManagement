<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body style="background-size:1450px 700px;
    		background-attachment: fixed;
    		background-repeat: no-repeat;
    		background-image:url(index1.jpg)">
    		<div style="align-self: center;
    background-color: rgba(200, 215, 60, 0.651);
    width: 450px;
    height: 400px;
    padding: 50px;
    margin: 80px;">
    		<%
    			if(session.getAttribute("Pan_no")==null)
    			{
    				response.sendRedirect("inlog.jsp");	
   				}
    			
    		%>
    		
  	<form action="logout.jsp">
    		<button>Logout</button>
    </form>
    <form action="Details.jsp">
    		<h2>Welcome User</h2>  	
    		<button>Enter Details</button>
    </form>	
</div>
</body>
</html>
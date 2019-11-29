<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Users are</title>
</head>
<body style="background-size:1450px 700px;
    		background-attachment: fixed;
    		background-repeat: no-repeat;
    		background-image:url(index1.jpg) ">
    		    <div style="align-self: center;
		background-color: rgba(200, 215, 60, 0.651);
		width: 450px;
		height: 400px;
		padding: 50px;
		margin: 80px;">
		<%
		    			if(session.getAttribute("Uname")==null)
		    			{
		    				response.sendRedirect("inlog.jsp");	
		   				}
		    			
		%>
		<%
			Object Tab= session.getAttribute("Content");
		%>
		
    	<form action="logout.jsp">
    		<button>Logout</button>
    	</form>
    	<form name="addfintax" method="post">
			<p> New Users are <br>
				<%= Tab %>
				
			</p>
		</form>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basic Information</title>
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
    			if(session.getAttribute("Pan_no")==null)
    			{
    				response.sendRedirect("inlog.jsp");	
   				}
    			
    	%>
    	<form action="logout.jsp">
    		<button>Logout</button>
    	</form>
    	<form action="addindet" method="post">
    		<div align="center">
    			<br><br><br><br>
    			<h2 align="center">Basic Information</h2> <br>
				Name: <input type="text" name="uname"></input><br><br>
				Father's Name: <input type="text" name="Fathername"></input><br><br>
				Date Of Birth: <input type="date" name="dob"></input><br><br>
				<button>Next</button>
    		</div>
		</form>
	</div>	
</body>
</html>
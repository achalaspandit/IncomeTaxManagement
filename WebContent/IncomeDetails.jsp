<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Income Details</title>
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
    	<form action="addindinc1" method="post">
    		<div align="center">
    			<br><br><br><br>
    			<h2 align="center">Income Details</h2> <br>
				Salary: <input type="number" name="Salary"></input><br><br>
				Professional Tax(paid): <input type="number" name="Ptax"></input><br><br>
				Income from Property: <input type="number" name="Property"></input><br><br>
				Property Tax(paid): <input type="number" name="Mtax"></input><br><br>
				Income from FD: <input type="number" name="FdInc"></input><br><br>
				Interest from SB Accounts: <input type="number" name="Sbinc"></input><br><br>
				<button>Next</button>
    		</div>
		</form>
	</div>	
</body>
</html>
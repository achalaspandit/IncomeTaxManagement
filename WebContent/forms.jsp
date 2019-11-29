<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Deductions</title>
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
    	<form action="addformded" method="post">
    		<div align="center">
    			<br><br>
    			<h2 align="center">Form Payments done</h2> <br>
    			insert 0 if not applicable
				Form 80C:<input type="number" name="fc"></input><br><br>
				Form 80CC:<input type="number" name="fcc"></input><br><br>
				Form 80CCD:<input type="number" name="fccd"></input><br><br>
				Form 80D:<input type="number" name="fd"></input><br><br>
				Form 80DD:<input type="number" name="fdd"></input><br><br>
				Form 80DDB:<input type="number" name="fddb"></input><br><br>
				Form 80E:<input type="number" name="fe"></input><br><br>
				Form 80EE:<input type="number" name="fee"></input><br><br>
				Form 80G:<input type="number" name="fg"></input><br><br>
				Form 80GG:<input type="number" name="fgg"></input><br><br>
				Form 80GGA:<input type="number" name="fgga"></input><br><br>
				<button>Next</button>
    		</div>
		</form>
	</div>	
    
</body>
</html>
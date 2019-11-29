<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Individual</title>
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
    <form action="checkin" method="post">
    	<div align="center">
    		<br><br><br><br>
    		<h2 align="center">Login</h2> <br>
			Pan no.: <input type="text" name="Pan_no"></input><br><br>
			Email id.: <input type="text" name="Email"></input><br><br>
			Password: <input type="password" name="Pwd"></input><br><br>
			<button>Login</button>
    	</div>
	</form>
	</div>	
</body>
</html>
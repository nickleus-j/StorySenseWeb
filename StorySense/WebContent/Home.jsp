<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 


</head>
<body>
<div class="header">
	<div id="LogoHere">	<h1>Story Sense</h1></div>
	<div id="log"><h1>Welcome</h1></div>
</div>

	<div class="container">
	<hr color="indigo">
	<h1>Welcome to Story Sense!</h1>
	<%@ include file="Insertables/LogInTable.jsp" %>
	<hr/>
	<h2>Don't have an account? 
	<button onClick="window.location.href='Register.jsp'">Register</button></h2>
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>
</body>
</html>
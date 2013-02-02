<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About Story Sense</title>
<link rel="stylesheet" href="Style/Default.css"> 
</head>
<body>

<%@ include file="Insertables/TopBar.jsp" %>




<div class="container">
	<h1 class="ErrorMessage">Log In fail</h1>
	Please try again<br/>
	<%@ include file="Insertables/LogInForm.jsp" %>
	
	<h2>Don't have an account? 
	<button onClick="window.location.href='Register.jsp'">Register</button></h2> 
</div>

<%@ include file="Insertables/Footer.jsp" %>
</body>
</html>
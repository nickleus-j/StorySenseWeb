<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 

</head>
<body>
	
	<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/LearnerNavBar.jsp" %>
	<div class="container">
	<hr color="indigo">
	<h1>Welcome to Story Sense</h1>
	<table align="center" bgcolor="white">
	
	<tr><th>Carl Your Level: </th><td>1</td>
	</tr>
	
	<tr><th>Your total points: </th><td>0</td>
	</tr>
	
	</table>
	<hr>
	<table align="center" bgcolor="white">
	<tr>
	<th>Get Started</th>
	<td>
	<button>Create first story</button></td>
	</tr>
	</table>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>
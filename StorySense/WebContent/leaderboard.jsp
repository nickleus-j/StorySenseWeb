<%@page import="dao.UserDAO"%><%@page import="dao.ProfileDAO"%><%@page import="dao.DAOFactory"%>
<%@page import="java.util.*"%><%@page import="worker.WebCodeMaker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Leader board</title>
<style>
img{
  	width: 50px;
  	height: 50px;
  
  }

</style>
</head>



<body>


<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/LearnerNavBar.jsp" %>
	<div class="container">
	<h1>Top 10 learners</h1>
	

	<table align="center" width="75%" bgcolor="white" >
	
	<tr>
	<th>Learner name</th><th>Level</th><th>Points</th>
	<%		WebCodeMaker encoder=new WebCodeMaker(out);
		out.write(encoder.getleaderBoardHTMLTable());
		%>
	</tr>
	
	
	
	</table><br/>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>

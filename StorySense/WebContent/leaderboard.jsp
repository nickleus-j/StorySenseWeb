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
	</tr>
	
	<%		WebCodeMaker encoder=new WebCodeMaker(out);
	out.write("<tr><td>haha");
	out.write(encoder.doThis());
	out.write("</tD></tr>");
		%>
	
	<tr>
	<td><img src="images/dis.jpg" class="profPic"/> ShakeSpir</td>
	<td>15</td>
	<td>1510</td>
	
	</tr><tr>
	<td><img src="images/Case.jpg" /> AlPow</td>
	<td>15</td>
	<td>1500</td>
	
	</tr><tr>
	<td><img src="images/disPic.jpg" /> MoranDoyl</td>
	<td>14</td>
	<td>1485</td>
	
	</tr><tr>
	<td><img src="images/Untitled.jpg" /> Kublay</td>
	<td>14</td>
	<td>1475</td>
	
	</tr><tr>
	<td><img src="images/dis.jpg" /> Hoopla</td>
	<td>14</td>
	<td>1450</td>
	
	</tr><tr>
	<td><img src="images/Case.jpg" /> GoshoKen</td>
	<td>14</td>
	<td>1445</td>
	</tr><tr>
	
	<td><img src="images/Untitled.jpg" /> ShohenFan</td>
	<td>14</td>
	<td>1440</td>
	</tr><tr>
	
	<td><img src="images/dis.jpg" /> LukeWanYin</td>
	<td>14</td>
	<td>1440</td>
	</tr><tr>
	
	<td><img src="images/disPic.jpg" /> Curage</td>
	<td>14</td>
	<td>1430</td>
	</tr><tr>
	
	<td><img src="images/Untitled.jpg" /> StifenKing</td>
	<td>14</td>
	<td>1420</td>
	
	</tr>
	
	</table><br/>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>

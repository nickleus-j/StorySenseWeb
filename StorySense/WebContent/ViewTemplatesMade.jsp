<%@page import="webEncoder.TemplateEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 

</head>
<body bgcolor="white">
<%@ include file="Insertables/AdminNavBar.jsp" %>
<div id="container">
<div id="center" class="column">
	<% TemplateEncoder tEncoder=new TemplateEncoder();
	out.write(tEncoder.showTemplateList(u.getAccountID()));%>

</div>
</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>
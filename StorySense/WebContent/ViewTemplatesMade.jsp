<%@page import="webEncoder.TemplateEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
<script src="Scripts/AJAXscirpts.js"></script>

<script>
function viewTemplateMade(id){
	window.location.href="TemplateEditLoader?t="+id;
}
</script>

</head>
<body bgcolor="CCFFFF">
<%@ include file="Insertables/AdminNavBar.jsp" %>
<%@ include file="../Scripts/AdminScripts.jsp" %>
<div id="container">
<div id="center" class="column">
	<% TemplateEncoder tEncoder=new TemplateEncoder();
	out.write(tEncoder.showTemplateList(u.getAccountID()));%>

</div>
</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>
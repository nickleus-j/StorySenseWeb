<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="entity.*"
    %>
<html>
<head>
<title>Insert title here</title>

<style>
#LogoHere{
	width:65%;
	float:left;
}
#log{
	float:right;
	width: 35%;
}

div.header{
	width:100%;
	background: seagreen;
	color:white;
	float:left;
}
</style>

</head>
<body>
<%	//Load user from the session
	User u=(User)session.getAttribute("user");
%>

<div class="header">
	<div id="LogoHere">	<h1>Story Sense</h1></div>
	<div>
	
	<h2>
	<%
		if(u!=null){
			out.println("Hello "+u.getName());%>
			<form id="logoutBT" action="Logout" method="post">
			<button type="submit">Log out</button>
			</form>
	<%  }
		else {
	%><%@ include file="LogInTable.jsp" %> <% } %>
	</h2>
	
	</div>
	
	
</div>

</body>
</html>
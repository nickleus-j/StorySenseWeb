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

<% 
	if(u!=null){
		if(User.Roles.learner.isLearner(u.getRole())) {%>
			<%@ include file="Insertables/LearnerNavBar.jsp" %>
		<%}//End of Learner Condition
		
		else if(User.Roles.reviewer.isReviwer(u.getRole())){ %>
			<%@ include file="Insertables/ReviewerNavBar.jsp" %>
		<%} //End of Reviewer condition
			
		}//End of not null condtion %>


<div class="container">
	<h1>About us</h1>
	Story Sense aims to evaluate and develop common sense knowledge of children. The site features story creation
	 to see what children know and their creativity. 
</div>

<%@ include file="Insertables/Footer.jsp" %>
</body>
</html>
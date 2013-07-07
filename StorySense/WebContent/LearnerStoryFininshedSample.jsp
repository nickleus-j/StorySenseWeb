<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Your story</title>
</head>
<body>

<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/LeadearboardPanel.jsp" %>
	<div class="container">
	<h1>Story Finished</h1>
	
	<table align="center" width="50%" bgcolor="white">
		<caption>Story</caption>

		
		<tr>
			<td><p>
				Let's take a trip to park. 
				A Memorial is an object we can find in the park. 
		Last week, I was Skating when I was at the park. 
		After going to the park, I went to the bay. 
			</p></td>
		</tr>
	
	</table>

	<hr/>

	<table align="center" width="50%" bgcolor="skyblue">
	<caption>New Knowledge from the Story</caption>
	<tr>
	<td>Memorial</td><td>is an</td><td>object</td>
	</tr>
	<tr>
	<td>Memorial</td><td>can be found in the </td><td>park</td>
	</tr>
	</table>
	
	<hr>
	
	
	<table align="center" width="50%" bgcolor="lime">
	<caption>Known Knowledge from the Story</caption>
	
	<tr>
	<td>Skating</td><td>is an</td><td>Action</td>
	</tr>
	<tr>
	<td>Bay</td><td>is a</td><td>place</td>
	</tr>
	
	</table>
	<form action="LearnerHomeSample.jsp" name="doneCheck">
	<hr>
	<table align="center" width="50%" bgcolor="white">
	<tr>
	<td>Story Name</td>
	<th><h3>A Walk in the Park</h3></th>
	</tr>
	<tr>
	<td>Score for finishing the template</td>
	<th><h2>25</h2></th>
	</tr>
	<tr>
	<td align="center" colspan="2"><input type="submit" value="Done"></td>
	</tr>
	</table>
	</form>
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Completed Stories</title>
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
	<h1>Stories from other learners</h1>
	<form>
	<input type="submit" value="submit"/>
	<table align="center" width="75%" bgcolor="skyblue" >
	<tr>
	<th>Author</th>
	<td>KyleXY <img src="images/Untitled.jpg" /></td>
	<th>Story Title</th>
	<td>Park Trip</td>
	
	<th>How do you like the story</th>
	
	<td><select>
	<option>I don't like it</option>
	<option>It is okay</option>
	<option>I like it</option>
	<option>I really like it</option>
	</select></td>
	
	</tr>
	
	<tr>
	<th colspan="2">Story: </th>
	<td colspan="4">
	<hr>
		Let's take a trip to park. 
		A skate board is an object we can find in the park. 
		Last week, I was relaxing when I was at the park. 
		After going to the park, I went to the skyscraper. 
	<hr>
	</td></tr>
	
	<tr>
	
	<th>Author</th>
	<td>Viziox <img src="images/disPic.jpg" /></td>
	<th>Story Title</th>
	<td>Delightful Message</td>
	
	<th>How much do you like the story</th>
	<td><select>
	<option>I don't like it</option>
	<option>It is okay</option>
	<option>I like it</option>
	<option>I really like it</option>
	</select></td>
	</tr>
	
	<tr>
	<th colspan="2">Story: </th>
	<td colspan="4">
	<hr>
		I was given a message by a mailman on a sunny day. After reading the letter
		I felt delightful.
	<hr>
	</td></tr>
	
	
	
	
	</table>
	</form>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>

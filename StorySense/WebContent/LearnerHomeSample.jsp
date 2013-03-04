<%@page import="webEncoder.CompleteStoryLoader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
   <script src="Scripts/AJAXscirpts.js"></script>
  <style type="text/css">
  
  .storyTbl{
  	width: 100%;
  	height: 100%;
  	background: skyblue;
  }
  
  #tableStyle0{
    width: 120%;
  }
  
  #fontStyle2{
font-family: Segoe UI; font-size: 20pt;
color: white;
}

#tableBorder3
{
border: 5px solid #770077;
border-radius: 0px;
width: 100%;
font-family: Segoe UI; font-size: 13pt;
}

#learnerstories {
}
  
  </style>
  
</head>
<body>
<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/accountbar.jsp" %>
<div>
	
<table width="80%" align="right">
	
	<tr align="center"><td>
		<table id="tableBorder3" bgcolor = "#BB0099">
		<thead><tr><th  id="fontStyle2">My Stories</th></tr></thead>	
		</table>
	</td></tr>
	

	<tr><td>
		<tr><td>
			<table id="tableBorder3" bgcolor = "#BB0099">
				<tr id="fontStyle3"><th width="15%">Story Name</th><th width="15%">Score Earned</th><th width="15%">Date Finished</th><th width="15%">Likes</th><th width="15%">View</th></tr>
			</table>
		</td></tr>
		<tr >
			<td id="storyStage"></td>
		</tr>
		<tr><td>
			<table  id="tableBorder3" bgcolor = "#FF88FF">
				
			<% CompleteStoryLoader sLoader=new CompleteStoryLoader();
			sLoader.PreviewUserStories((User)request.getSession().getAttribute("user"), out);
			%>
			</table>
		</td></tr>
	
</table>


</div>
<%@ include file="Insertables/Footer.jsp" %>



	
	

</body>
</html>
<%@page import="webEncoder.CompleteStoryLoader"%>
<%@page import="ajaxReviewer.StoriesRated"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
   <script src="Scripts/AJAXscirpts.js"></script>
    <%@ include file="Scripts/LearnerScripts.jsp" %>
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
color: black;
}

#tableBorder3 ,.headTbl
{
border: 5px solid green;
border-radius: 0px;
width: 100%;
font-family: Segoe UI; font-size: 13pt;
}

#learnerstories {
}
  
  </style>
  
</head>
<body onload="getStoryData(userName)">
<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/accountbar.jsp" %>
<% CompleteStoryLoader sLoader=new CompleteStoryLoader(u);
			//sLoader.PreviewUserStories(myUser, out);
			%>
<script > username=<% userEncoder.writeJsElementReference(myUser.getName());%>
likedStories=<% out.write(sLoader.PreviewLikedStoriesJson(myUser));%>
</script>
<div>
	
<table width="80%" align="right">
	
	<tr align="center"><td>
		<table id="tableBorder3" class="tableBorder3" bgcolor = "#7DFB9D">
		<thead><tr><th  id="fontStyle2">Stories of
			<% out.print(myUser.getName()); %></th></tr></thead>
			<tr><td>
		<input type="radio" name=<% wcm.writeJsElementReference(orderTypreMyStories); %> 
			Value=<% wcm.writeJsElementReference(AscVal);%> checked/>Ascending
		<input type="radio" name=<% wcm.writeJsElementReference(orderTypreMyStories); %>
			Value=<% wcm.writeJsElementReference(DesVal); %>/>Descending
		</td>
		</tr>			
		</table>
	</td></tr>
	
	<!-- 
	<tr><td>
		<tr><td>
			<table id="tableBorder3" bgcolor = "#7DFB9D">
				<tr id="fontStyle3">
				<th width="15%">Story Name</th>
				<th width="15%">Score Earned</th>
				<th width="15%">Date Finished</th>
				<th width="15%">Likes</th>
				<th width="15%">View</th></tr>
			</table>
		</td></tr>
		 -->
		<tr><td>
			<table  id=<% wcm.writeJsElementReference(storyPrevID); %> bgcolor = "white" class="headTbl">
				
			
			
			<tr >
			<td id="storyStage" colspan="5"></td>
		</tr>
			</table>
		</td></tr>
		
		<tr align="center"><td>
		<table class="headTbl" bgcolor = "#7DFB9D">
		<thead><tr><th  id="fontStyle2">Stories <% out.print(myUser.getName()); %> Like</th></tr></thead>
		<tr><td>
		<input type="radio" name=<% wcm.writeJsElementReference(orderTyprelikedStories); %> 
			Value=<% wcm.writeJsElementReference(AscVal); %> checked/>Ascending
		<input type="radio" name=<% wcm.writeJsElementReference(orderTyprelikedStories); %>
			Value=<% wcm.writeJsElementReference(DesVal); %>/>Descending
		</td></tr>		
		</table>
	</td></tr>
	
	<tr><td>
			<table  id=<% wcm.writeJsElementReference(likeTable); %>  bgcolor = "white" class="headTbl">
				
			<% 
			//sLoader.previewLikedStories(myUser, out);
			%>
			
			<tr >
			<td id="storyStage" colspan="5"></td>
		</tr></table>
		</td></tr>
		
		<tr align="center"><td>
		<table class="headTbl" bgcolor = "#7DFB9D">
		<thead><tr><th  id="fontStyle2">Scores Given </th></tr></thead>	
		</table>
	</td></tr>
	<tr><td>
			<table  id="tableBorder3" bgcolor = "white">
				
			<% 
			StoriesRated ratedS=new StoriesRated();
			ratedS.encodeScoresInHTML(out,myUser, sLoader, "<table  id=\"tableBorder3\"  bgcolor = \"white\">");
			/* <table  id="tableBorder3" bgcolor = "white">*/
			%>
			
			<tr >
			<td id="storyStage" colspan="5"></td>
		</tr></table></td></tr>
		
</table>


</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>
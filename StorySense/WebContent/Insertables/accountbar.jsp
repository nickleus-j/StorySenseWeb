<%@page import="webEncoder.learnerInfoEncoder"%>
<%@page import="webEncoder.WebCodeMaker"%>
<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style TYPE="text/css">


.storyTbl{
  	width: 100%;
  	height: 100%;
  	background: skyblue;
  }
  
#tableBorder6, .accountBarTbl
{
border: 5px solid green;
border-radius: 0px;
font-family: Segoe UI; font-size: 13pt;
width: 15%;
}



#fontStyle2{
font-family: Segoe UI; font-size: 12pt;
}

  
</style>

<% User myUser=(User)request.getAttribute("viewedUser");
	if(myUser==null)
		myUser=(User)session.getAttribute("user");
	WebCodeMaker webEncoder=new WebCodeMaker(out);
	learnerInfoEncoder liEncoder=new learnerInfoEncoder();
%>
<br/>
	<table bgcolor = "#7DFB9D" id="tableBorder6" align="left" style="margin-left:10%">
	<tr><th  align="center" id="fontStyle2">&nbsp;</th></tr>
	<tr><th  align="center"> <% out.print(webEncoder.enterUserImageTag(myUser)); %> </th></tr>
	<% if(myUser==(User)session.getAttribute("user")){ %>
	<tr><th  align="center" id="fontStyle2"><% out.print(webEncoder.enterUserRealName(myUser)); %></th></tr>
	<% }else{ %>
	<tr><th  align="center" id="fontStyle2"><% out.print(myUser.getName()); %></th></tr>
	<% }%>
	<tr><th  align="center" id="fontStyle2">Level <% out.print(myUser.getLevel()); %></th></tr>
	<tr><th  align="center" id="fontStyle2">Points <% out.print(myUser.getPoints()); %></th></tr>
	<tr>
		<th>Number of Stories Made:<% out.write(""+liEncoder.enterNumberStoriesMade(myUser)); %></th>
</tr>

<tr>
		<th>Number of Stories Rated:<% out.write(""+liEncoder.enterNumberStoriesRated(myUser)); %></th>
</tr>

<tr>
		<th>Highest Score:<% out.write(""+liEncoder.getTopUserScore(myUser)); %></th>
</tr>


<tr>
		<th>Lowest Score:<% out.write(""+liEncoder.getLowestUserScore(myUser)); %></th>
</tr>
	<tr><td  align="center">
	<% liEncoder.writeHtmlAchievements(out,myUser,50,50); %>
	</td></tr>
	
	<tr><th  align="center" id="fontStyle2">&nbsp;</th></tr>
	<tr>
	<td>
	<table >
	<tr>
		<th>Likes given to stories:</th><td>
		<% out.write(""+liEncoder.getLikesGiven(myUser)); %></td>
	</tr>
	<tr>
		<th>Likes Received :</th><td>
		<% out.write(""+liEncoder.getLikesReceived(myUser)); %></td>
	</tr>
	<tr>
		<th>Highest likes obtained from Story:</th><td>
		<% out.write(""+liEncoder.getMaximumLikedStory(myUser)); %></td>
	</tr>
	<tr>
		<th>Most liked Story:</th><td>
		<% out.write(""+liEncoder.getmostLikedStory(myUser)); %></td>
	</tr>
	</table>
	</td>
	</tr>
	</table><br/>
	
	


<%@page import="webEncoder.WebCodeMaker"%>
<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style TYPE="text/css">


.storyTbl{
  	width: 100%;
  	height: 100%;
  	background: skyblue;
  }
  
#tableBorder6
{
border: 5px solid green;
border-radius: 0px;
font-family: Segoe UI; font-size: 13pt;
width: 20%;
}



#fontStyle2{
font-family: Segoe UI; font-size: 20pt;
}

  
</style>

<div >
<% User myUser=(User)request.getAttribute("viewedUser");
	if(myUser==null)
		myUser=(User)session.getAttribute("user");
	WebCodeMaker webEncoder=new WebCodeMaker(out);
%>
<br/>
	<table bgcolor = "#7DFB9D" id="tableBorder6" align="left">
	<tr><th  align="center" id="fontStyle2">&nbsp;</th></tr>
	<tr><th  align="center"> <% out.print(webEncoder.enterUserImageTag(myUser)); %> </th></tr>
	<tr><th  align="center" id="fontStyle2"><% out.print(webEncoder.enterUserRealName(myUser)); %></th></tr>
	<tr><th  align="center" id="fontStyle2">Level <% out.print(myUser.getLevel()); %></th></tr>
	<tr><th  align="center" id="fontStyle2">&nbsp;</th></tr>
	</table>
	
</div>


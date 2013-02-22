<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="webEncoder.CompleteStoryLoader"%>
<style TYPE="text/css">
#tableBorderfeed
{
border: 2px solid black;
border-radius: 4px;
margin-left: 2%;
margin-top: 2%;
margin-right: 2%;
width: 96%;
}

#tableBorderfeed2
{
border: 2px solid black;
border-radius: 4px;
margin-left: 2%;
margin-right: 2%;
width: 96%;
height: 525;
}
#fontStylefeed{
font-family: Segoe UI; font-size: 20pt;
} 
</style>

<div id="center" class="column">

<% CompleteStoryLoader sLoader=new CompleteStoryLoader();
		 sLoader.showStories(out);
		 %>

 <!--  <table width="100%">
 <tr><td>
	<table id="tableBorderfeed" bgcolor = "orange">
		<tr id="fontStylefeed" ><th colspan = 3>Story Feed</th></tr>
	</table>	
 </td></tr>
  <tr><td>
	<table id="tableBorderfeed2">
		<thead><tr id="fontStylefeed" bgcolor="white" height="525px"><th colspan = 3></th></tr></thead>
	</table>	
 </td></tr>
 </table>
 -->
</div>


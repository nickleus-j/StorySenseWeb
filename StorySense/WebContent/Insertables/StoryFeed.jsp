<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="webEncoder.CompleteStoryLoader"%>
<%@page import="entity.User"%>
<style TYPE="text/css">
#tableBorderfeed
{
border: 2px solid black;
border-radius: 4px;
margin-left: 15%;
margin-top: 2%;
margin-right: 2%;
width: 75%;

}

#tableBorderfeed2
{
border: 2px solid black;
border-radius: 4px;
margin-left: 15%;
margin-right: 2%;
width: 75%;
height: 525;
}
#fontStylefeed{
font-family: Segoe UI; font-size: 12pt;
} 
#titleFont{

font-family: Segoe UI; font-size: 20pt;
font-weight: bold;
text-align: left;
padding-left: 5dp;
}
</style>

<div id="center" class="column">

<table width="100%">
 <tr><td>
<table id="tableBorderfeed" bgcolor = "orange" onload="">
		<tr id="fontStylefeed" ><th colspan = 3>Story Feed</th></tr>
	</table>	
	 </td></tr>
	
	 </table>

<table id="tableBorderfeed2" bgcolor="white" >
 <tr>
	 <th>Loading...</th>
	 </tr></table>


</div>

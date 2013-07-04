<%@page import="webEncoder.SidebarEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style TYPE="text/css">
#tableBorderfeatured
{
border: 2px solid black;
border-radius: 4px;
width: 100%;
}
#fontStylefeatured{
font-family: Segoe UI; font-size: 11pt;
} 
</style>

 <div id="right" class="column">
	<table>
		<tr><td>
			<table id="tableBorderfeatured" bgcolor = "Yellow" ><tr id="fontStylefeatured" ><th colspan = 3>Story of the Day</th></tr></table>
			<table id="tableBorderfeatured" bgcolor = "white">

				<tr align="center"><td>
				<% SidebarEncoder sidebarEnc=new SidebarEncoder();
					sidebarEnc.showPopularStory(out);
				%>
				</td></tr>

			</table>
		</td></tr>
		<tr><td>
			<table id="tableBorderfeatured" bgcolor = "Yellow" ><tr id="fontStylefeatured" >
			<th colspan = 3>Trending Term</th></tr></table>
			<table id="tableBorderfeatured" bgcolor = "white">

				<tr align="center">
				<td>
				<% sidebarEnc.showPopularTerm(out); %>
				</td></tr>

			</table>
		</td></tr>
	</table>
</div>

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
<script>
var popularStory;
	function writeHighScoredStory(elem){
		elem.innerHTML=writeStoryLink()+"<br/>"+writePopularStoryAuthorLink()+"Average Score: "+popularStory.Avg;
	}

	
	function writeStoryLink(){
		return"<a href='StoryDisplay.jsp?aID="+popularStory.storyID+"'>"+popularStory.StoryName+"</a>";
	}
	function writePopularStoryAuthorLink(){
		return"<a href='viewAUser?uID="+popularStory.userID+"'> By "+popularStory.Author+"</a><br>";
	}
</script>
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
			<th colspan = 3>Highest Rated Story</th></tr></table>
			<table id="tableBorderfeatured" bgcolor = "white">

				<tr align="center">
				<td id="highScorePane">
				</td><td>
				<script>
				popularStory=<%out.print(sidebarEnc.getHighScoredStory());
						//out.write("{\"StoryName\":\"Just Another Story\"}");
				%>;
				writeHighScoredStory(document.getElementById("highScorePane"));</script>
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

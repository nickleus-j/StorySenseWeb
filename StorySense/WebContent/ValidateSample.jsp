<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Check stories</title>

<script>
var currentIndex=0;
var stories={
		story:[
			{Title:"A walk in the park",
			templateScore:"25"	
			},
			
			{
			Title:"1 day I will",
			templateScore:"30"
			},
			
			{Title:"Mark my words",
				templateScore:"20",
				words:[
				       "The word",
				       "Hello there",
				       "the purity",
				       "Come to me"
				       ]
			}
		],//End Story Array
		
};


function arrangeDescriptionTable(story){
	var Storytitle=document.getElementById("StoryTitle"),templateScore=document.getElementById("templateScore");
	Storytitle.innerHTML=story.Title;
	templateScore.innerHTML=story.templateScore;
	
}

function changeStory(addend){
	if(currentIndex+addend<0)
		currentIndex=stories.story.length-1;
	else
		currentIndex=(currentIndex+addend)%stories.story.length;
	arrangeDescriptionTable(stories.story[currentIndex]);
}


function nextStory(){
	currentIndex=(currentIndex+1)%stories.story.length;
	arrangeDescriptionTable(stories.story[currentIndex]);
}


</script>


</head>
<body>

<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/ReviewerNavBar.jsp" %>
	<div class="container">
	<h1>Answer the form to give a Score</h1>
	
	
	<table align="center" width="50%" bgcolor="white" id="storyDesc">
	
	<tr>
		<th colspan="2">Level Preference:</th>
		<td>
		<select onchange="nextStory()">
		<option>5</option>
		<option>4</option>
		<option>3</option>
		<option>2</option>
		<option>1</option>
		</select>
		</td>
		
	</tr>
	
	
	<tr>
	<td><Button onclick="changeStory(-1)">Previous Story</Button>
	</td>
	<td>Story Name</td>
	<th><h3 ID="StoryTitle">A Walk in the Park</h3></th>
	<td><Button onclick="changeStory(1)">Next Story</Button>
	</td>
	</tr>
	
	</table>
	
	<hr/>
	
	<table align="center" width="50%" bgcolor="white">
		<caption>Story</caption>

		
		<tr>
			<td>
				Let's take a trip to park. 
				A Memorial is an object we can find in the park. 
		Last week, I was Skating when I was at the park. 
		After going to the park, I went to the bay. 
			</td>
		</tr>
	
	</table>
	
	<hr>

	<table align="center" width="50%" bgcolor="white" border="1" id="Extraction">
	<caption>Knowledge from the Story</caption>
	<tr>
	<th>Knowledge</th>
		<th>Strongly Disagree</th>
		<th>Disagree</th>
		<th>Agree</th>
		<th>Strongly Agree</th>
	</tr>
	<tr>
	<td>Memorial is an object</td>
		<td><input type="radio"  name ="v1"></td><td><input type="radio" name ="v1"></td>
		<td><input type="radio"  name ="v1"></td><td><input type="radio"  name ="v1"></td>
	</tr>
	<tr>
	<td>Memorial can be found in the park</td>
		<td><input type="radio" name ="v2"></td><td><input type="radio" name ="v2"></td>
		<td><input type="radio" name ="v2"></td><td><input type="radio" name ="v2"></td>
	</tr>
	
	<tr>
	<td>Skating is an Action</td>
		<td><input type="radio" name ="v3"></td><td><input type="radio" name ="v3"></td>
		<td><input type="radio" name ="v3"></td><td><input type="radio" name ="v3"></td>
	</tr>
	<tr>
	<td>Bay  is a place</td>
		<td><input type="radio" name ="v4"></td><td><input type="radio" name ="v4"></td>
		<td><input type="radio" name ="v4"></td><td><input type="radio" name ="v4"></td>
	</tr>
	
	</table>
	
	<!--  
	<table align="center" width="50%" bgcolor="white" border="1" id="ExtractionTbl">
	<caption>Knowledge from the Story</caption>
	
	-->
	
	</table>
	<hr>
	<table align="center" width="50%" bgcolor="white">
	
	<tr>
	<th>How do you like the story</th>
	<td><select>
	<option>Unsatisfactory</option>
	<option>Almost Satisfactory</option>
	<option>Satisfactory</option>
	<option>Above Satisfactory</option>
	<option>Excellent</option>
	</select></td>
	</tr>
	
	<!-- 
	<tr>
	<th>Rate the vocabulary out of 5</th>
	<td><select>
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	<option>5</option>
	</select></td>
	</tr> -->
	
	<tr>
	<td>Score for finishing the template</td>
	<th><h2 id="templateScore">25</h2></th>
	</tr>
	<tr>
	<td align="center" colspan="2"><input type="button" value="Submit and calculate Total"></td>
	</tr>
	</table>
	
	<hr>
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>

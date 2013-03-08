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

<style>

	.tableTopValidateSample{
		width: 100%;
		background: #B8C9FF;
		font-family: "Segoe UI";
		max-width: "100%";
	}
	
	.tableTopValidateSample th{
	}

	#header{
		background: #0087BD;
	}
	
	#subheader{
		background: #002387;
		color: white;
		align: center;
		size: 18px;
		padding: 10px;
	}
	
	
	.innerTableValidateSample{
		border-collapse: collapse; 
		align: center;
		width: 90%;
		border-color: #000080;
		border-style: groove;
		border-width: 3px;
		padding:5px;
	}
	
	.innerTableValidateSample td{
		width: 15%;
		border-color: #000080;
		border-style: groove;
		border-width: 3px;
		text-align: center;
	}
	
	.innerTableValidateSample th{
		width: 40%;
		border-color: #000080;
		border-style: groove;
		border-width: 3px;
		text-align: center;
	}
	
</style>

</head>
<body>

<%@ include file="Insertables/ReviewerNavBar.jsp" %>
	<div id="container">
	
	
	<table class="tableTopValidateSample" align="center">
	
	<tr><td colspan = "3"><img src="images/validateSample/validateStoriesheader.png" height="80%" width="100%"/></td></tr>
	<tr align="center">
		<td colspan="3" style="align: center;"><p>Select the level to evaluate:
		<select onchange="nextStory()">
		<option>5</option>
		<option>4</option>
		<option>3</option>
		<option>2</option>
		<option>1</option>
		</select></p>
		</td>
		
	</tr>
	
	<tr align="center">
	<td align="left" width="15%" align="center">
	<img src="images/validateSample/arrow.png" onclick="changeStory(-1)"/>
	</td>
	<td>
		<img src="images/dis.jpg" height="10%" width="15%"></br>
		<b>"A Walk in the Park"</b> </br>by Jake The Dog  
	</td>
	<td align="right" width="15%" align="center"><img src="images/validateSample/arrow2.png"
	onclick="changeStory(1)"/></td>
	</tr>
	<tr>
	<td> </td>
	</tr>
	
	
		
		<tr><td id="subheader"> Story</td></tr>
		
		<tr>
			<td colspan="3" align="center"><p>
				Let's take a trip to park. 
				A Memorial is an object we can find in the park. 
		Last week, I was Skating when I was at the park. 
		After going to the park, I went to the bay. 
			</p></td>
		</tr>
		
		
	<tr><td id="subheader">Validation</td></tr>
	
	<tr><td colspan=3 ><br/><br/>
		<table class="innerTableValidateSample" align="center">
		<tr>
		<td>Knowledge</td>
		<td>Strongly Disagree</td>
		<td>Disagree</td>
		<td>Agree</td>
		<td>Strongly Agree</td>
		</tr>
		<tr>
		<th>Memorial is an object</th>
			<td><input type="radio"  name ="v1"></td><td><input type="radio" name ="v1"></td>
			<td><input type="radio"  name ="v1"></td><td><input type="radio"  name ="v1"></td>
		</tr>
		<tr>
		<th>Memorial can be found in the park</th>
			<td><input type="radio" name ="v2"></td><td><input type="radio" name ="v2"></td>
			<td><input type="radio" name ="v2"></td><td><input type="radio" name ="v2"></td>
		</tr>
		
		<tr>
		<th>Skating is an Action</th>
			<td><input type="radio" name ="v3"></td><td><input type="radio" name ="v3"></td>
			<td><input type="radio" name ="v3"></td><td><input type="radio" name ="v3"></td>
		</tr>
		<tr>
		<th>Bay  is a place</th>
			<td><input type="radio" name ="v4"></td><td><input type="radio" name ="v4"></td>
			<td><input type="radio" name ="v4"></td><td><input type="radio" name ="v4"></td>
		</tr>
		
		</table>
	</td>
	</tr>
	
	<tr></tr><tr></tr>
	<tr>
	<td colspan="3" align="center"><p>How do you like the story&nbsp;&nbsp;&nbsp;
	<select>
	<option> --------------- </option>
	<option>Unsatisfactory</option>
	<option>Almost Satisfactory</option>
	<option>Satisfactory</option>
	<option>Above Satisfactory</option>
	<option>Excellent</option>
	</select></p></td>
	</tr>
	
	<tr>
	<td colspan="3" align="center"><p>Score for finishing the template: 25</p></td>
	</tr>
	<tr>
	<td colspan="3" align="center"><img src="images/validateSample/submitEvaluation.png" width="25%"/></td>
	</tr>
	<tr></tr>
	</table>
	
	
	
	<!--  
	<table align="center" width="50%" bgcolor="white" border="1" id="ExtractionTbl">
	<caption>Knowledge from the Story</caption>
	
	-->
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>
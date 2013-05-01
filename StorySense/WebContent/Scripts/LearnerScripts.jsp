<%@page import="webEncoder.WebCodeMaker"%>
<%@page import="infoResource.LearnerElemAttr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% LearnerElemAttr attributeProvider=new LearnerElemAttr();
   	WebCodeMaker wcm=new WebCodeMaker(out);
   	String storyPrevID="prevStoryTbl";
   %>
<script>

/*Shows the story where one story is shown one at a time*/
function showScores(storyID){
	var xmlhttp=getAJAXRequest();
	var scoreTblId=<% out.write(wcm.giveJsStringParam(attributeProvider.getScoreSummaryID())); %>;
	var summaryTblId=<% out.write(wcm.giveJsStringParam(attributeProvider.getLearnerSummaryID())); %>;
	var stage=document.getElementById(scoreTblId);

	/*if (stageID==null||stageID=="")
	  {
		stage.innerHTML="";
	  return;
	  }
	*/

	hideElement(document.getElementById(summaryTblId));
	stage.setAttribute("class","headTbl");
	//showElement(stage);
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			
			//showElement(document.getElementById(stageID));
			stage.innerHTML=xmlhttp.responseText;
			//stage.innerHTML=stage.innerHTML+"Done"
		}
		else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","StoryScoreLoader?"+<% out.write(wcm.giveJsStringParam(attributeProvider.getStoryIdParameter()));%>+
	  "="+storyID,true);
	  xmlhttp.send();
}


function createPreviweTblHeaders(table){
	var nameCell,scoreCell,dateCell,likesCell,row;
	var nameLink,scoreLink,dateLink,likesLink
	
	row=document.createElement("tr");
	nameCell=document.createElement("th");
	scoreCell=document.createElement("th");
	dateCell=document.createElement("th");
	likesCell=document.createElement("th");
	
	nameLink=document.createElement("a");
	scoreLink=document.createElement("a");
	dateLink=document.createElement("a");
	likesLink=document.createElement("a");
	
	nameLink.innerHTML="Story Name";
	scoreLink.innerHTML="Story Score";
	dateLink.innerHTML="Date Finished";
	likesLink.innerHTML="Likes";
	
	nameLink.setAttribute("onclick","sortUserStories(userStories.story,'Name')");
	scoreLink.setAttribute("onclick","sortUserStories(userStories.story,'Score')");
	likesLink.setAttribute("onclick","sortUserStories(userStories.story,'Likes')");
	dateCell.setAttribute("onclick","sortUserStoriesByDate(userStories.story)");
	//sortUserStoriesByDate
	
	nameCell.appendChild(nameLink);
	scoreCell.appendChild(scoreLink);
	dateCell.appendChild(dateLink);
	likesCell.appendChild(likesLink);
	
	row.appendChild(nameCell);
	row.appendChild(scoreCell);
	row.appendChild(dateCell);
	row.appendChild(likesCell);
	table.appendChild(row);
}

var userStories;

function generateStage(table,id,colWidth){
	var row=document.createElement("tr"),stage;
	stage=document.createElement("td");
	stage.setAttribute("id",id);
	stage.setAttribute("colspan",colWidth);
	stage.setAttribute("class","hiddenElem");
	row.appendChild(stage);
	table.appendChild(row);
}

function setUpStoryNameCell(name,storyID,stageID,cell){
	var linkID="Link_"+storyID;
	var anchor=document.createElement("a");
	
	anchor.setAttribute("id",linkID);
	anchor.setAttribute("onclick","showStoryClicked('"+stageID+"',"+storyID+")");
	anchor.innerHTML=name;
	cell.appendChild(anchor);
}

function generateStoryPreviweTable(table){
	var nameCell,scoreCell,dateCell,likesCell,row,current,arr;
	//var stage;
	arr=userStories.story;
	createPreviweTblHeaders(table);

	
	for(var ctr=0;ctr<arr.length;ctr++){
	current=userStories.story[ctr];
	row=document.createElement("tr");
	nameCell=document.createElement("td");
	scoreCell=document.createElement("td");
	dateCell=document.createElement("td");
	likesCell=document.createElement("td");
	
	//nameCell.innerHTML=current.Name;
	setUpStoryNameCell(current.Name,current.storyID,current.stageID,nameCell);
	scoreCell.innerHTML=current.Score;
	dateCell.innerHTML=current.TimeFinished;
	likesCell.innerHTML=current.Likes;
	
	row.appendChild(nameCell);
	row.appendChild(scoreCell);
	row.appendChild(dateCell);
	row.appendChild(likesCell);
	table.appendChild(row);
	
	generateStage(table,current.stageID,"3");
	
	}/*End of loop that writes rows of information*/
}

function getStoryData(userName){
	var xmlhttp=getAJAXRequest();
	var stage=document.getElementById(<% wcm.writeJsElementReference(storyPrevID); %> );
	//var sCell=stage=document.getElementById("storyStage");

	xmlhttp.onreadystatechange=function(){
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			//userStories=eval("("+xmlhttp.responseText+")");
			userStories=JSON.parse(xmlhttp.responseText);
			//sCell.innerHTML=xmlhttp.responseText;
			generateStoryPreviweTable(stage);
		}
		//else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","UserStoriesPreviewer?"+
	  	<% out.write(wcm.giveJsStringParam(attributeProvider.getUserParamName()));%>+"="+userName,true);
	  xmlhttp.send();
}

function sortUserStories(stories,category){
	var stage=document.getElementById(<% wcm.writeJsElementReference(storyPrevID); %> );
	
	stage.innerHTML="";
	stories.sort( sortBy(category) );
	generateStoryPreviweTable(stage);
}

function sortUserStoriesByDate(stories){
	var stage=document.getElementById(<% wcm.writeJsElementReference(storyPrevID); %> );
	
	stage.innerHTML="";
	stories.sort( sortByDate("TimeFinished") );
	generateStoryPreviweTable(stage);
}

</script>
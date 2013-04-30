<%@page import="webEncoder.WebCodeMaker"%>
<%@page import="infoResource.LearnerElemAttr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% LearnerElemAttr attributeProvider=new LearnerElemAttr();
   	WebCodeMaker wcm=new WebCodeMaker(out);
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
var userStories;
function getStoryData(userName){
	var xmlhttp=getAJAXRequest();
	var stage=document.getElementById("storyStage");

	/* if (stageID==null||stageID=="")
	  {
		stage.innerHTML="";
	  return;
	  }
	*/


	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			userStories=xmlhttp.responseText;
			stage.innerHTML=xmlhttp.responseText;
		}
		else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","UserStoriesPreviewer?"+
	  	<% out.write(wcm.giveJsStringParam(attributeProvider.getUserParamName()));%>+"="+userName,true);
	  xmlhttp.send();
}

</script>
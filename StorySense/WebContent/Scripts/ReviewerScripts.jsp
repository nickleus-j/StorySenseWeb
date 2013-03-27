<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webEncoder.WebCodeMaker"%>
<%!
	String storyCellID="storyCell",validationTable="validationTable",assertionTbl="assertionTbl";

%>

<% WebCodeMaker encoder=new WebCodeMaker(out); %>
<script type="text/javascript">

function putRatingStoryToCell(storyID){
	var stage=document.getElementById(<% encoder.writeJsElementReference(storyCellID); %>);
	var stageID=<% encoder.writeJsElementReference(storyCellID); %>;
	var xmlhttp=getAJAXRequest();

	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			stage.innerHTML=xmlhttp.responseText;
		}
	  };
	  
	  xmlhttp.open("GET","StoryShower?q="+storyID+"&screen="+stageID,true);
	  xmlhttp.send();
}



/*Shows the story where one story is shown one at a time*/
function createRelationPaneHtml(storyID){
	var xmlhttp=getAJAXRequest();
	var stageID=<% encoder.writeJsElementReference(assertionTbl); %>;
	var stage=document.getElementById(<% encoder.writeJsElementReference(assertionTbl); %>);

	if (stageID==null||stageID=="")
	  {
		stage.innerHTML="";
	  return;
	  }
	showElement(document.getElementById(<% encoder.writeJsElementReference(validationTable); %>));
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200&&stage!=null){
			putRatingStoryToCell(storyID);
			stage.innerHTML=xmlhttp.responseText;
		}
	  };
	  
	  xmlhttp.open("GET","StoryRater?q="+storyID+"&screen="+stageID,true);
	  xmlhttp.send();
}

</script>
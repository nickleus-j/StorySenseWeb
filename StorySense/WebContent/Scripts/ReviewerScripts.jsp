<%@page import="infoResource.ReviewerResource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webEncoder.WebCodeMaker"%>
    <% ReviewerResource rRes=new ReviewerResource();
    
    %>
<%!

	String storyCellID="storyCell",validationTable="validationTable",assertionTbl="assertionTbl";
	String StoryDescReview="StoryDescRev",descriptionStage="descStage";
	String validatedStoriesTable="validatedStoriesTable",validatedStoriesTableID="#container";
	String validationFormHtmlID="validationForm",warningCellHtmlID="errorCell";
	String hiddenValVault="acomID";
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
	var hElem=document.getElementById(<% encoder.writeJsElementReference(hiddenValVault); %>);
	
	hElem.value=storyID;
	
	if (stageID==null||stageID=="")
	  {
		stage.innerHTML="";
	  return;
	  }
	showElement(document.getElementById(<% encoder.writeJsElementReference(validationTable); %>));
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200&&stage!=null){
			generateDescription(storyID);
			putRatingStoryToCell(storyID);
			stage.innerHTML=xmlhttp.responseText;
		}
	  };
	  
	  xmlhttp.open("GET","StoryRater?q="+storyID+"&screen="+stageID,true);
	  xmlhttp.send();
}

function generateDescription(storyID){
	var xmlhttp=getAJAXRequest();
	
	var stage=document.getElementById(<% encoder.writeJsElementReference(descriptionStage); %>);
	var href=<%encoder.writeJsElementReference(StoryDescReview);%>;
	if(stage==null)
		return;
	
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200&&stage!=null){
			putRatingStoryToCell(storyID);
			stage.innerHTML=xmlhttp.responseText;
		}
	  };
	  
	  xmlhttp.open("GET",href+"?q="+storyID,true);
	  xmlhttp.send();
}


/*Submit the registration form
 */
function submitRegistration()
{	
	 document.getElementById(<% encoder.writeJsElementReference(validationFormHtmlID);%>).submit();
}

function getInputNames(){
	var arr=new Array();
	var form=document.forms[<% encoder.writeJsElementReference(validationFormHtmlID);%>];
	var errorCell=document.getElementById(<% encoder.writeJsElementReference(warningCellHtmlID);%>);
	
	errorCell.innerHTML="";
	for(var ctr=0;ctr<form.elements.length;ctr++){
		arr.push(form.elements[ctr].name);
		errorCell.innerHTML=errorCell.innerHTML+arr[ctr]+"**<br>";
	}
	return arr;
}


function checkForm(){
	var form=document.forms[<% encoder.writeJsElementReference(validationFormHtmlID);%>];
	var errorCell=document.getElementById(<% encoder.writeJsElementReference(warningCellHtmlID);%>);
	
	for(var ctr=0;ctr<form.elements.length;ctr++){
		if(form.elements[ctr].value==null||form.elements[ctr].value==""){
			errorCell.innerHTML="There unanswered form entries <br>"+form.elements[ctr].name+ctr;
			return;
		}
	}
	

	submitRegistration();
}



</script>
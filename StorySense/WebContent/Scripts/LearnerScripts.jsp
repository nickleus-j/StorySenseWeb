<%@page import="webEncoder.WebCodeMaker"%>
<%@page import="infoResource.LearnerElemAttr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% LearnerElemAttr attributeProvider=new LearnerElemAttr();
   	WebCodeMaker wcm=new WebCodeMaker(out);
   	String storyPrevID="prevStoryTbl",likeTable="likedStoriesTbl",thClass="sortBt";
   	String orderTypreMyStories="myStoriesSortOpt",orderTyprelikedStories="likedStoriesSortOpt";
   	String orderTypeScores="scoresSortOpt";
   	String AscVal="+",DesVal="-";
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

function createHeadersForSort(elems,row){
	for(var ctr=0;ctr<elems.length;ctr++){
		elems[ctr].setAttribute("class",<% out.write(wcm.giveJsStringParam(thClass));%>);
		row.appendChild(elems[ctr]);
	}
}

function createPreviweTblHeaders(table){
	var nameCell,scoreCell,dateCell,likesCell,row, elems=new Array();
	
	row=document.createElement("tr");
	
	nameCell=document.createElement("th");
	scoreCell=document.createElement("th");
	dateCell=document.createElement("th");
	likesCell=document.createElement("th");
	
	elems.push(nameCell);
	elems.push(scoreCell);
	elems.push(dateCell);
	elems.push(likesCell);
	
	createHeadersForSort(elems,row);
	
	nameCell.innerHTML="Story Name";
	scoreCell.innerHTML="Story Score";
	dateCell.innerHTML="Date Finished";
	likesCell.innerHTML="Likes";
	
	nameCell.setAttribute("onclick","sortUserStories(userStories.story,'Name')");
	scoreCell.setAttribute("onclick","sortUserStories(userStories.story,'Score')");
	likesCell.setAttribute("onclick","sortUserStories(userStories.story,'Likes')");
	dateCell.setAttribute("onclick","sortUserStoriesByDate(userStories.story)");
	
	table.appendChild(row);
}

function createLikeTblHeders(table){
	var nameCell,authorCell,likesCell,row, elems=new Array();
	row=document.createElement("tr");
	
	nameCell=document.createElement("th");
	authorCell=document.createElement("th");
	likesCell=document.createElement("th");
	elems.push(nameCell);
	elems.push(authorCell);
	elems.push(likesCell);
	
	createHeadersForSort(elems,row);
	nameCell.innerHTML="Title";
	authorCell.innerHTML="Author";
	likesCell.innerHTML="Likes";
	
	nameCell.setAttribute("onclick","sortLikedStories(likedStories.story,'Name')");
	authorCell.setAttribute("onclick","sortLikedStories(likedStories.story,'authorName')");
	likesCell.setAttribute("onclick","sortLikedStories(likedStories.story,'likeNum')");
	
	table.appendChild(row);
}

function createScoreTblHeader(table){
	var readerCell,scoreCell,storyName,row,elems=new Array();
	row=document.createElement("tr");
	
	readerCell=document.createElement("th");
	storyName=document.createElement("th");
	scoreCell=document.createElement("th");
	elems.push(readerCell);
	elems.push(storyName);
	elems.push(scoreCell);
	createHeadersForSort(elems,row);
	
	readerCell.innerHTML="Reader";
	storyName.innerHTML="Story";
	scoreCell.innerHTML="Score";
	
	readerCell.setAttribute("onclick","sortScores(storyScores.scores,'Reader')");
	storyName.setAttribute("onclick","sortScores(storyScores.scores,'StoryName')");
	scoreCell.setAttribute("onclick","sortScores(storyScores.scores,'Score')");
	table.appendChild(row);
}


var userStories,likedStories,storyScores;

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
	scoreCell.innerHTML="<a onclick=\"showStoryScores('"+current.Name+"')\" href='#scoreTbl'>"+current.Score+"</a>";
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

function createLinkToUser(userID,text){
	var anchor=document.createElement("a");
	anchor.setAttribute("href","viewAUser?uID="+userID);
	anchor.innerHTML=text;
	return anchor;
}

function createLikeCell(storyId,likeNum,container){
	var likeCtrID="likedStory_"+storyId,bt=document.createElement("button"),b=document.createElement("b");
	var btElemName="likeBt_"+storyId;
	b.setAttribute("id",likeCtrID);
	b.innerHTML=likeNum;
	bt.setAttribute("id",btElemName);
	bt.setAttribute("onclick","showNumberOfLikes('"+likeCtrID+"',"+storyId+",'--','"+btElemName+"')");
	bt.innerHTML="unlike";
	container.appendChild(b);
	container.appendChild(bt);
	//return b;
}

function generateStoriesLikedTable(table){
	var nameCell,authorCell,likesCell,row,current,arr;
	//var stage;
	arr=likedStories.story;
	createLikeTblHeders(table);

	
	for(var ctr=0;ctr<arr.length;ctr++){
	current=likedStories.story[ctr];
	row=document.createElement("tr");
	nameCell=document.createElement("td");
	authorCell=document.createElement("td");
	likesCell=document.createElement("td");
	
	setUpStoryShowLink(current.Name,current.storyID,current.stageID,nameCell,"likeLink_");
	authorCell.appendChild(createLinkToUser(current.authorId,current.authorName));
	createLikeCell(current.storyID,current.likeNum,likesCell);
	//likesCell.innerHTML=current.likeNum;
	
	row.appendChild(nameCell);
	row.appendChild(authorCell);
	row.appendChild(likesCell);
	table.appendChild(row);
	
	generateStage(table,current.stageID,"2");
	
	}/*End of loop that writes rows of information*/
}

function generateScoresTable(table){
	var readerCell,scoreCell,titleCell,row,current,arr=storyScores.scores;
	createScoreTblHeader(table);
	
	for(var ctr=0;ctr<arr.length;ctr++){
		current=arr[ctr];
		row=document.createElement("tr");
		readerCell=document.createElement("td");
		titleCell=document.createElement("td");
		scoreCell=document.createElement("td");
		
		readerCell.innerHTML=current.Reader;
		titleCell.innerHTML=current.StoryName;
		scoreCell.innerHTML=current.Score;
		row.appendChild(readerCell);
		row.appendChild(titleCell);
		row.appendChild(scoreCell);
		table.appendChild(row);
	}/*End of Loop*/
}

function showStoryScores(title){
	var table=document.getElementById("scoreTbl");
	var readerCell,scoreCell,titleCell,row,current,arr=storyScores.scores;
	
	table.innerHTML="";
	createScoreTblHeader(table);
	
	for(var ctr=0;ctr<arr.length;ctr++){
		current=arr[ctr];
		if(current.StoryName==title){
			row=document.createElement("tr");
			readerCell=document.createElement("td");
			titleCell=document.createElement("td");
			scoreCell=document.createElement("td");
		
			readerCell.innerHTML=current.Reader;
			titleCell.innerHTML=current.StoryName;
			scoreCell.innerHTML=current.Score;
			row.appendChild(readerCell);
			row.appendChild(titleCell);
			row.appendChild(scoreCell);
			table.appendChild(row);
		}/*End of Condition*/
	}/*End of Loop*/
}

function getStoryData(userName){
	var xmlhttp=getAJAXRequest();
	var stage=document.getElementById(<% wcm.writeJsElementReference(storyPrevID); %> );
	var sCell=document.getElementById(<% wcm.writeJsElementReference(likeTable); %> );

	xmlhttp.onreadystatechange=function(){
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			//userStories=eval("("+xmlhttp.responseText+")");
			userStories=JSON.parse(xmlhttp.responseText);
			//sCell.innerHTML=likedStories;
			generateStoryPreviweTable(stage);
			generateStoriesLikedTable(sCell);
			generateScoresTable(document.getElementById("scoreTbl"));
		}
		//else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","UserStoriesPreviewer?"+
	  	<% out.write(wcm.giveJsStringParam(attributeProvider.getUserParamName()));%>+"="+userName,true);
	  xmlhttp.send();
}



function sortUserStories(stories,category){
	var stage=document.getElementById(<% wcm.writeJsElementReference(storyPrevID); %> );
	var orderTypreMyStories=document.getElementsByName(<% wcm.writeJsElementReference(orderTypreMyStories); %>);
	var value;
	
	for (var i = 0;i < orderTypreMyStories.length; i++) {
	    if (orderTypreMyStories[i].checked)
	    	value=orderTypreMyStories[i].value;
	}
	
	stage.innerHTML="";
	stories.sort( sortBy(category,value) );
	generateStoryPreviweTable(stage);
}

function sortLikedStories(stories,category){
	var stage=document.getElementById(<% wcm.writeJsElementReference(likeTable); %> );
	var orderTypreMyStories=document.getElementsByName(<% wcm.writeJsElementReference(orderTyprelikedStories); %>);
	
	for (var i = 0;i < orderTypreMyStories.length; i++) {
	    if (orderTypreMyStories[i].checked)
	    	value=orderTypreMyStories[i].value;
	}
	
	stage.innerHTML="";
	stories.sort( sortBy(category,value) );
	generateStoriesLikedTable(stage);
}

function sortScores(stories,category){
	var stage=document.getElementById("scoreTbl");
	var orderTypreMyStories=document.getElementsByName(<% wcm.writeJsElementReference(orderTypeScores); %>);
	
	for (var i = 0;i < orderTypreMyStories.length; i++) {
	    if (orderTypreMyStories[i].checked)
	    	value=orderTypreMyStories[i].value;
	}
	
	stage.innerHTML="";
	stories.sort( sortBy(category,value) );
	generateScoresTable(stage);
}

function sortUserStoriesByDate(stories){
	var stage=document.getElementById(<% wcm.writeJsElementReference(storyPrevID); %> );
	var orderTypreMyStories=document.getElementsByName(<% wcm.writeJsElementReference(orderTypreMyStories); %>);
	var value;
	
	for (var i = 0;i < orderTypreMyStories.length; i++) {
	    if (orderTypreMyStories[i].checked)
	    	value=orderTypreMyStories[i].value;
	}
	stage.innerHTML="";
	stories.sort( sortByDate("TimeFinished",value) );
	generateStoryPreviweTable(stage);
}




</script>
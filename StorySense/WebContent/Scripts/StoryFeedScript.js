/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez - initial API and implementation
 *******************************************************************************/
/**
	Requires AjaxScript
	This is for the story feed
*/
var _curretnStoryLimit=10;
function loadStories(limit){
	var xmlhttp=getAJAXRequest(),stageID="tableBorderfeed2";
	_curretnStoryLimit=limit;
	/*Check if the element passed is valid*/
	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById(stageID).innerHTML=xmlhttp.responseText;
		}
	  };
	  
	xmlhttp.open("GET","StoryFeedFetcher?limit="+limit+"&screen="+stageID,true);
	xmlhttp.send();
}

function loadMoreStoriesInFeed(){
	if(_curretnStoryLimit<=40)
		loadStories(_curretnStoryLimit+10);
}

function loadStoriesToReview(limit){
	var xmlhttp=getAJAXRequest(),stageID="validatedStoriesTable";
	_curretnStoryLimit=limit;
	/*Check if the element passed is valid*/
	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById(stageID).innerHTML=xmlhttp.responseText;
		}
	  };
	  
	xmlhttp.open("GET","ReviewerFeed?limit="+limit+"&screen="+stageID,true);
	xmlhttp.send();
}

function loadStoriesToReview(limit,page){
	var xmlhttp=getAJAXRequest(),stageID="validatedStoriesTable";
	_curretnStoryLimit=limit;
	/*Check if the element passed is valid*/
	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById(stageID).innerHTML=xmlhttp.responseText;
		}
	  };
	  
	xmlhttp.open("GET","ReviewerFeed?limit="+limit+"&screen="+stageID+"&page="+page,true);
	xmlhttp.send();
}

function ReviewStoriesInLevel(limit,page,level){
	var xmlhttp=getAJAXRequest(),stageID="validatedStoriesTable";
	_curretnStoryLimit=limit;
	var user = document.getElementById("user").value;
	/*Check if the element passed is valid*/
	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById(stageID).innerHTML=xmlhttp.responseText;
		}
	  };
	  
	xmlhttp.open("GET","ReviewerFeed?limit="+limit+"&screen="+stageID+
			"&page="+page+"&level="+level+"&u="+user,true);
	xmlhttp.send();
}

function ReviewStoriesInUser(limit,page,user){
	var xmlhttp=getAJAXRequest(),stageID="validatedStoriesTable";
	var level=document.getElementById("level").value;
	_curretnStoryLimit=limit;
	/*Check if the element passed is valid*/
	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById(stageID).innerHTML=xmlhttp.responseText;
		}
	  };
	  
	xmlhttp.open("GET","ReviewerFeed?limit="+limit+"&screen="+stageID+
			"&page="+page+"&level="+level+"&u="+user,true);
	xmlhttp.send();
}






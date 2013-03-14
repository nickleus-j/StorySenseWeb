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
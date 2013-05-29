/*******************************************************************************
 *Copyright (c) 2013 StorySense.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://nickleus-j.blogspot.com
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
/**
	This File is for ajax javascript events
*/
function getAJAXRequest(){
	var request;
	try {// Non IE Browser?
		request = new XMLHttpRequest();
	}
	catch(e1)	{
		try{ // IE 6+?
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e2){
			try {// IE 5?

				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e3){ // There is no Ajax Support
				request = false;
			}
		}
	}
	return request;
}


function showNumberOfLikes(elemID,storyID,res,btIDElemName){
var xmlhttp=getAJAXRequest();
var bt=document.getElementById(btIDElemName);

/*Check if the element passed is valid*/
if (elemID==null||elemID=="")
  {
  document.getElementById(elemID).innerHTML="";
  return;
  }

/*What happens when a response from the server is obtained*/
xmlhttp.onreadystatechange=function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById(elemID).innerHTML=xmlhttp.responseText;
	}
  };

  /*Send a request to the server*/
xmlhttp.open("GET","LikeChanger?q="+storyID+"&res="+res,true);
xmlhttp.send();

/*The value for onclick attribute*/
var dislikeFunction="showNumberOfLikes('"+elemID+"'," +storyID+","+"'--','"+btIDElemName+"')";
var likeFunction="showNumberOfLikes('"+elemID+"'," +storyID+","+"'like','"+btIDElemName+"')";

/*If the user hit the like
 * then the button will be replaced with an cancel the like button*/
if(res=="like"){
	bt.innerHTML="Unlike";
	bt.setAttribute("onclick",dislikeFunction);
}
else{
	bt.innerHTML="Like";
	bt.setAttribute("onclick",likeFunction);
  }

}/*End of function*/


var currentStage;

function gethiddenElemClass(){return "hiddenElem";}
function getShownElemClass(){return "storyPreviewStage";}

function hideElement(elem){
	elem.setAttribute("class",gethiddenElemClass());
}
function showElement(elem){
	elem.setAttribute("class",getShownElemClass());
}

function toggleShoHider(bt,stageID){
	var elem=document.getElementById(stageID);
	if(elem.getAttribute("class")==gethiddenElemClass()){
		//bt.setAttribute("onclick", "showElement("+stageID+")");
		bt.innerHTML="Hide Story";
		showElement(document.getElementById(stageID));
		
	}
	else if(elem.getAttribute("class")==getShownElemClass()){
		//bt.setAttribute("onclick", "hideElement("+stageID+")");
		bt.innerHTML="See Story";
		hideElement(document.getElementById(stageID));
	}
}

function toggleShowHider(stageID){
	var elem=document.getElementById(stageID);
	if(elem.getAttribute("class")==gethiddenElemClass()){
		showElement(document.getElementById(stageID));
		
	}
	else if(elem.getAttribute("class")==getShownElemClass()){
		hideElement(document.getElementById(stageID));
	}
}

/*Shows the story where one story is shown one at a time*/
function showStory(stageID,storyID,btID){
	var xmlhttp=getAJAXRequest();
	var bt=document.getElementById(btID);
	var stage=document.getElementById(stageID);
	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			
			stage.innerHTML=xmlhttp.responseText;
			toggleShoHider(bt,stageID);
			
		}
		else{
			document.getElementById(stageID).innerHTML="Error occured";
		}
	  };
	  
	  if(stage.innerHTML.length<1){
		  xmlhttp.open("GET","StoryShower?q="+storyID+"&screen="+stageID,true);
		  xmlhttp.send();
	  }
	  else toggleShoHider(bt,stageID);
}


/*Shows the story where one story is shown one at a time*/
function showStoryClicked(stageID,storyID){
	var xmlhttp=getAJAXRequest(),stage=document.getElementById(stageID);

	if (stageID==null||stageID=="")
	  {
	  document.getElementById(stageID).innerHTML="";
	  return;
	  }
	
	
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById(stageID).innerHTML=xmlhttp.responseText;
			toggleShowHider(stageID);
			//showElement(document.getElementById(stageID));
		}
	  };
	  
	  /*stage.getAttribute("class")==gethiddenElemClass()*/
	  if(stage.innerHTML.length<1){
		  xmlhttp.open("GET","StoryShower?q="+storyID+"&screen="+stageID,true);
		  xmlhttp.send();
	  }
	  else toggleShowHider(stageID);
}


/*Shows the story where one story is shown one at a time*/
function generateStory(stageID,level){
	var xmlhttp=getAJAXRequest();
	stage=document.getElementById(stageID);

	if (stageID==null||stageID=="")
	  {
		stage.innerHTML="";
	  return;
	  }
	
	showElement(stage);
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			stage.innerHTML=xmlhttp.responseText;
		}
	  };
	  
	  xmlhttp.open("GET","AJAXStoryGen?level="+level+"&screen="+stageID,true);
	  xmlhttp.send();
}

/*Shows the story where one story is shown one at a time*/
function generateRelationPane(stageID,storyID){
	var xmlhttp=getAJAXRequest();
	var stage=document.getElementById(stageID);

	if (stageID==null||stageID=="")
	  {
		stage.innerHTML="";
	  return;
	  }
	
	showElement(document.getElementById("validationTable"));
	showElement(stage);
	/*What happens when a response from the server is obtained StoryShower*/
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			
			//showElement(document.getElementById(stageID));
			stage.innerHTML=xmlhttp.responseText;
		}
	  };
	  
	  xmlhttp.open("GET","StoryRater?q="+storyID+"&screen="+stageID,true);
	  xmlhttp.send();
}

function setUpStoryShowLink(name,storyID,stageID,cell,preposition){
	var anchor=document.createElement("a");
	
	anchor.setAttribute("id",preposition+storyID);
	cell.setAttribute("onclick","showStoryClicked('"+stageID+"',"+storyID+")");
	anchor.innerHTML=name;
	cell.appendChild(anchor);
}

function sortBy(prop,type){
	if(type=="+")
	   return function(a,b){
	      if( a[prop] > b[prop]){
	          return 1;
	      }else if( a[prop] < b[prop] ){
	          return -1;
	      }
	      return 0;
	   };
	   else 
		   return function(a,b){
		      if( a[prop] > b[prop]){
		          return -1;
		      }else if( a[prop] < b[prop] ){
		          return 1;
		      }
		      return 0;
		   };
}

/*//Usage
yourArray.sort( sortBy("age") );*/

function sortByDate(obj,type){
	if(type=="+")
	return function(a,b){
		  a = new Date(a[obj]);
		  b = new Date(b[obj]);
		  return a<b?-1:a>b?1:0;
		};
	else
		return function(a,b){
		  a = new Date(a[obj]);
		  b = new Date(b[obj]);
		  return a<b?1:a>b?-1:0;
		};
}

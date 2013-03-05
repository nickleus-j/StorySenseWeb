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

function hideElement(elem){elem.setAttribute("class","hiddenElem");}
function showElement(elem){elem.setAttribute("class","r");}

/*Shows the story where one story is shown one at a time*/
function showStory(stageID,storyID){
	var xmlhttp=getAJAXRequest();
	
	/*hide current stage if it is not null
	 * The stage is where the story is displayed 
	 */
	if(currentStage!=null)
		hideElement(currentStage);
	
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
			
			//showElement(document.getElementById(stageID));
		}
	  };
	  
	  xmlhttp.open("GET","StoryShower?q="+storyID+"&screen="+stageID,true);
	  xmlhttp.send();
	  currentStage=document.getElementById(stageID);
		showElement(currentStage);
}

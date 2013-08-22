<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style TYPE="text/css">
#tableBorderfeed
{
border: 2px solid black;
border-radius: 4px;
margin-left: 2%;
margin-top: 2%;
margin-right: 2%;
width: 96%;
}

#tableBorderfeed2
{
border: 2px solid black;
border-radius: 4px;
margin-right: 2%;
width: 96%;
}
.limitedTbl{
max-width: 100%;
border: 4px solid #660000;
border-radius: 4px;
}
#tableBorderfeed3
{
border: 4px solid #660000;
border-radius: 4px;
/*width: 75%;*/
}
#borderedTable
{
border: 4px solid #660000;
border-radius: 4px;
width: 100%;
}

#fontStylefeed{
font-family: Segoe UI; font-size: 12pt;
} 

#fontStylefeed2, .templateProperties{
font-family: Segoe UI; 
background-color: #660000; 
color: white;
}

#marginTemplate{
margin: 2%;
}
</style>
<%@ include file="../Scripts/AdminScripts.jsp" %>
<div id="center" class="column" align="left">
<form method="post" id=<% out.write(wEncoder.giveJsStringParam(storyFormID));%>>
<table bgcolor=white id="tableBorderfeed3" style="margin-top:2%; width: 100%; ">
	<tr><th id="fontStylefeed2" colspan="6" >Template Details</th></tr>
	<tr>
	<th>Template Name</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(templateNameBox));%> name="nameField"/></td>
	
	<th>Level Required</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(levelBox));%> name="lvlField"/></td>
	
	<th>Bonus points Factor</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(pointBox));%> name="ptField"/></td>
	</tr>
</table>
</form>

<table style="border: 4px solid #660000; border-radius: 4px; width: 100%; margin-top:2%;" bgcolor="white" id=<% out.write(wEncoder.giveJsStringParam(variablesTbl));%>>
<tr>
<th colspan="4" class="templateProperties">Query Variables</th>
</tr>
<tr align="center">
<th>Name</th><th>Concept 1</th><th>relationship</th><th>Concept 2</th>
</tr>
</table>

 <table align="center" bgcolor=white id="tableBorderfeed3" style="margin-top:2%; width: 100%; ">
	  	    <tr><th id="fontStylefeed2" colspan="4">Relations</th></tr>
	  		<tr><th>Concept 1</th><th>Object</th><th>Concept 2</th></tr>
	  		<tr>
	  			<td align="center" "conceptA">
	  				<select id=<% wEncoder.writeJsElementReference(showConceptsBox1); %> name="Concept A"
	  				onChange="resetOtherConceptBoxIndex(this,'<% out.print(showConceptsBox2); %>')"
	  				>
	  				<option value=""></option>
	  				</select>
	  			</td>
	  		
	  		<td align="center" id="object">
	  			<select id=<% wEncoder.writeJsElementReference(showRelationsBox); %> name="Object" ></select>
	  			</td>
	  		
	  		
	  			<td align="center" id="conceptB">
	  				<select id=<% wEncoder.writeJsElementReference(showConceptsBox2); %> name="Concept B"
	  				onChange="resetOtherConceptBoxIndex(this,'<% out.print(showConceptsBox1); %>')">
	  				<option value=""></option>
	  				</select>	
	  			</td>
	  			
	  			<td align="center">
	  			<input type="Submit" value="Add" onclick="addRelation()" />
	  			</td>
	  		
	  		
	  <td id=<% wEncoder.writeJsElementReference(rTemplateCell); %>> </td>
	  </tr>
	  	</table>
	  
 	
 <br/><br/>
 
 

<table id="borderedTable">
<tr><th colspan="3" class="templateProperties">Story Workspace</th></tr>
<tr>
<td>
<input type="button" value="Add Query Variable" onclick="addTemplateVariable(this)"/>
<button onclick="previewStoryTemplate()">Preview</button>
<button onclick="submitStory()">Save Story</button>
</td></tr>
<tr>
<td id=<% wEncoder.writeJsElementReference(storyTemplateWorkSpaceID); %>>
<textarea rows="20" cols="50" id=<%wEncoder.writeJsElementReference(wrkSpaceTxtAreaID); %> 
placeholder="Write story template here"></textarea>
</td><td id=<% wEncoder.writeJsElementReference(sTemplateCell); %>></td>
</tr></table>

<table style="margin-top:3%;" class="limitedTbl">
<tr>
<th style="font-family: Segoe UI; background-color: #660000; color: white; ">Story Template Sample </th>
</tr>
 	 <tr bgcolor="white">
 	 <td><pre class="scrollFit">
 	 
&lt$person = (?,Is-A,"person")&gt 	
&lt$job = (?,Is-A,"job")&gt 	

#if("boy",GenderOf,$person)
{
&lt$pronoun = "he"&gt 
&lt$possessive_pronoun = "his"&gt 
&lt$action_pronoun = "him"&gt 
}
#else
{
&lt$pronoun = "she"&gt 
&lt$possessive_pronoun = "her"&gt 
&lt$action_pronoun = "her"&gt 
}

Today during lunch time, I felt very [1] so my friend and I just talked instead. %$possessive_pronoun% name is 
%&person% and %$pronoun% said that I can be a [2,3] someday. I told %$possessive_pronoun% that she can be a [2,3]
because she is smart. Another friend of mine came and she said that she wants to be a %$job%. A %$job% is someone who 
does [4]. We went back to class afterwards as it was already time.
THE END
 	</pre> </td>
 	 </tr>
</table>
</div>


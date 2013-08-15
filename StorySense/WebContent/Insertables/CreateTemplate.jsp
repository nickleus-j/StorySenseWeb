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
max-width: 50%;
}
#tableBorderfeed3, .borderedTable
{
border: 4px solid #660000;
border-radius: 4px;
/*width: 75%;*/
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
<table>
	<tr>
	<th>Template Name</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(templateNameBox));%> /></td>
	
	<th>Level Required</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(levelBox));%>/></td>
	
	<th>Points Required</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(pointBox));%>/></td>
	</tr>
</table>

<table id=<% out.write(wEncoder.giveJsStringParam(variablesTbl));%>>
<tr>
<th colspan="4" class="templateProperties">Query Variables</th>
</tr>
<tr>
<th>Name</th><th>Concept 1</th><th>relationship</th><th>Concept 2</th>
</tr>


</table>

 <table id="tableBorderfeed3">
  <tr><th id="fontStylefeed2" colspan="3">Relations</th></tr>
  <tr>
	  <td>
	  	<table id="marginTemplate">
	  		<tr><td>Concept A</td></tr>
	  		<tr id="conceptA">
	  			<td>
	  				<select id=<% wEncoder.writeJsElementReference(showConceptsBox1); %> name="Concept A"
	  				onChange="resetOtherConceptBoxIndex(this,'<% out.print(showConceptsBox2); %>')"
	  				>
	  				<option value=""></option>
	  				</select>
	  			</td></tr>
	  		<tr style="width:193px"><td>Object</td></tr>
	  		<tr id="object"><td>
	  			<select id=<% wEncoder.writeJsElementReference(showRelationsBox); %> name="Object" ></select>
	  			</td></tr>
	  		<tr style="width:193px"><td>Concept B</td></tr>
	  		<tr id="conceptB">
	  			<td>
	  				<select id=<% wEncoder.writeJsElementReference(showConceptsBox2); %> name="Concept B"
	  				onChange="resetOtherConceptBoxIndex(this,'<% out.print(showConceptsBox1); %>')">
	  				<option value=""></option>
	  				</select>
	  				<input type="Submit" value="Add" onclick="addRelation()" />
	  			</td></tr>
	  		
	  	</table>
	  </td>
	  
	  <td id=<% wEncoder.writeJsElementReference(rTemplateCell); %>></td>
 </tr>
 </table>
 
 <br/><br/>
 
 

<table class="borderedTable">
<tr><th colspan="3" class="templateProperties">Story Workspace</th></tr>
<tr>
<td>
<input type="button" value="Add Query Variable" onclick="addTemplateVariable()"/>
<button onclick="previewStoryTemplate()">Preview</button>
</td></tr>
<tr>
<td id=<% wEncoder.writeJsElementReference(storyTemplateWorkSpaceID); %>>
<textarea rows="20" cols="35" id=<%wEncoder.writeJsElementReference(wrkSpaceTxtAreaID); %> 
placeholder="Write story template here"></textarea>
</td><td id=<% wEncoder.writeJsElementReference(sTemplateCell); %>></td>
</tr></table>

<table class="limitedTbl">
<tr>
<th>Story Template Sample </th>
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

Today during lunch time, I felt very [1] so my friend and I just talked instead. %$possessive_pronoun% name is %&person% and %$pronoun% said that I can be a [2,3] someday. 
I told %$possessive_pronoun% that she can be a [2,3] because she is smart. 
Another friend of mine came and she said that she wants to be a %$job%. 
A %$job% is someone who does [4]. We went back to class afterwards as it was already time.
THE END
 	</pre> </td>
 	 </tr>
</table>
</div>


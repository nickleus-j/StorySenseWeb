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
#tableBorderfeed3
{
border: 4px solid #660000;
border-radius: 4px;
width: 75%;
}
#fontStylefeed{
font-family: Segoe UI; font-size: 12pt;
} 

#fontStylefeed2, .templateProperties{
font-family: Segoe UI; font-size: 12pt;
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
<th colspan="4" class="templateProperties">Variables</th>
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
	  			</td></tr>
	  		
	  	</table>
	  </td>
	  <td>
	  	<table id="marginTemplate">
	  		<tr><td><input type="Submit" value="Add" onclick="addRelation()" /></td></tr>
	  		<tr><td><input type="Submit" value="Edit" style="width:100px; margin-bottom:10%"/></td></tr>
	  		<tr><td><input type="Submit" value="Delete" style="width:100px; margin-bottom:10%"/></td></tr>
	  	</table>
	  </td>
	  <td>
		<table id="tableBorderfeed2">
			<tr id="fontStylefeed2"><th>Concept A</th><th>Relation</th><th>Concept B</th></tr>
			<tr id="fontStylefeed" ><th>Location</th><th>is where I</th><th>Action</th></tr>
			<tr id="fontStylefeed" ><th>Object</th><th>is</th><th>Texture</th></tr>
		</table>	
	 </td>
 </tr>
 </table>
 
 <br/><br/>
 
 <table id="tableBorderfeed3">
   <tr><th id="fontStylefeed2" colspan="2">Stories</th></tr>
 	<tr><td>
 		<table>
 			<tr><td align="center">
		 		<table id="tableBorderfeed">
		 			<tr id="fontStylefeed2"><th>Templates</th></tr>
					<tr id="fontStylefeed" ><th>Location</th></tr>
					<tr id="fontStylefeed" ><th>Object</th></tr>
		 		</table>
	 		</td></tr>	
	 		<tr><td>
	 			<table>
		  			<tr>
		  				<td><input type="Submit" value="Edit" style="width:100px; margin-bottom:10%;"/></td>
						<td><input type="Submit" value="Delete" style="width:100px; margin-bottom:10%;"/></td>
					</tr>
		 		</table>
	 		</td></tr>
 		</table>
 	 </td>
 	 
 	 <td>
 		<table>
 			<tr><td>
		 		<table id="tableBorderfeed">
		 			<tr id="fontStylefeed2"><th>Add/Edit Panel</th></tr>
					<tr id="fontStylefeed" ><th>Location</th></tr>
					<tr id="fontStylefeed" ><th>Object</th></tr>
		 		</table>
	 		</td></tr>
	 		<tr><td>	
	 			<table>
		  			<tr>
		  				<td><input type="Submit" value="Add Story Template" style="width:100px; margin-bottom:10%;"/></td>
					</tr>
		 		</table>
		 	</td></tr>
 		</table>
 	 </td>
 	 </tr>
 	 
</table>

<table >
<tr><th>Workspace</th></tr>
<tr>
<td><input type="button" value="Add text" onclick="addTemplateText()"/>
</td></tr>
<tr>
<td id=<% wEncoder.writeJsElementReference(storyTemplateWorkSpaceID); %>>
</td>
</tr></table>

<table>
<tr><th>Relational Template</th>
<th>Story Template </th><td><button onclick="previewStoryTemplate()">Preview</button></td>
</tr>
 	 <tr bgcolor="white">
 	 <td id=<% wEncoder.writeJsElementReference(rTemplateCell); %>></td>
 	 <td id=<% wEncoder.writeJsElementReference(sTemplateCell); %>></td>
 	 </tr>
</table>
</div>


<%@ page language="java" %>
<HTml>
<HEAD><TITLE>Display file upload form to the user</TITLE></HEAD>  
<% //  for uploading the file we used Encrypt type of multipart/form-data and input of file type to browse and submit the file %>
  <BODY> <FORM  ENCTYPE="multipart/form-data" ACTION="user_Registration" METHOD=POST>
		<br><br><br>
	  <table border="2" align="center">
                    <tr><center><td colspan="2"><B>PROGRAM FOR UPLOADING THE FILE</B></center></td></tr>
                    <tr><td><b>Choose the file To Upload:</b></td>
                    <td><INPUT NAME="F1" TYPE="file"></td></tr>
					<tr><td colspan="2"><p align="right"><INPUT TYPE="submit" VALUE="Send File" ></p></td></tr>
             </table>
          
     </FORM>
</BODY>
</HTML>

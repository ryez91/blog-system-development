<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<HTML>
	<HEAD>
		<title>Create your article</title>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<link rel="stylesheet" href="image/style.css">
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	</HEAD>
	<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<form action="addArticle.action" method="post">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
						
						<br>
		
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
							<tr height="30">
								<td background="image/l-bg3.jpg">&nbsp;&nbsp;&nbsp;<font color="#ffff66"><b>Create your article</b></font></td>
							</tr>
							<tr height="20">
								<td>
									&nbsp;&nbsp;&nbsp;Title:
								<div>&nbsp;&nbsp;&nbsp;<input type="text" name="title"  Width="600px" Style="inputcss" /></div>
								</td>
							</tr>
							<tr>
								<td>
								   <br>
									
									<textarea rows="30" cols="40" name="content" id="editor1"></textarea>
									
									<script>
                                        CKEDITOR.replace('editor1',
    	                                                 {
     	                                                   width : '100%',
     	                                                   toolbar : 'MyToolbar',
                                                           filebrowserUploadUrl : 'ckeditor/uploader?Type=File',
     	                                                   filebrowserImageUploadUrl : 'ckeditor/uploader?Type=Image',
     	                                                   filebrowserFlashUploadUrl : 'ckeditor/uploader?Type=Flash'
                                                           });
                                     </script>
									
								</td>
							</tr>
							<tr height="20">
								<td>
									<input type="submit"  value="Create" Style="ButtonCss" />
									<input type="button" name="cancelButton" value="Cancel" onClick="history.back()" Class="ButtonCss">
								</td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</HTML>


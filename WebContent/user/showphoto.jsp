<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" href="image/style.css">
<title>Pictures</title>
</head>
<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<form action="uploadPhoto.action" method="post" enctype="multipart/form-data">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<tr>
				    <table cellspacing="5" align="center">
				       <s:iterator value="#request.photoList" id="photo" status="stu">
				           <tr>
				           <td>
				               <img src='photo/${sessionScope.username }/<s:property value="photo"/>' width="300" height="280" >
				               
				           </td>
				           <s:if test="(#stu.index + 1) % 6 == 0">
				               </tr>
				               <tr>
				           </s:if>
				           </tr>
				       </s:iterator>
				    
				    </table>
				</tr>
				<TR>
					<TD>
						<div align="center">
						<s:fielderror></s:fielderror>
						<input type="file" name="myFile">
						<input type="submit" value="Upload"> 
						</div>
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</html>
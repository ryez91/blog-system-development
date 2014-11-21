<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Header</title>
<script language="javascript">
<!--
function mhEnter()
{
window.event.srcElement.className="lt1";
}
function mhLeave()
{
window.event.srcElement.className="lt0";
}
//-->
</script>
<link rel="stylesheet" href="image/style.css"/>
<style type="text/css">
<!--
.blogtitle {
    color:#E8EB50;
	font-size: 18px;
	font-weight: bold;
	left: 20px;
}
.idiograph {
	position: relative;
	left: 50px;
}

-->
</style>
</head>

<body>
<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td background="user/image/bg1.jpg" height="150">
		
		<span class="blogtitle">&nbsp;&nbsp;&nbsp; ${sessionScope.blogtitle}</span><br />
	  <span class="idiograph" style="color:#E8EB50">${sessionScope.idiograph}     </span>				</td>
	</tr>
	<tr height="31">
		<td background="user/image/line.jpg">
			<table width="1000" border="0" cellpadding="0" cellspacing="0">
				<tr height="20" align="center">
				<%
				   String username = request.getParameter("username");
				   if(username==null || "".equals(username)){
				%>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllArticlesHome.action">What's New</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllArticles.action">Archive</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="user/addArticle.jsp">Writing</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showPhoto.action">Pictures</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="editbloginfo.jsp">Settings</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">Comments</a></td>
				</tr>
				
				<%
				   }
				   else{
					  
				%>
				<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllArticlesHome.action">What's New</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllArticles.action?username=${param.username }">Archive</a></td>
					<td class="ltsep">|</td>
					<!--  <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="user/addArticle.jsp">Writing</a></td>
					<td class="ltsep">|</td>
					-->
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showPhoto.action">Pictures</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllArticles.action">My Homepage</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">Comments</a></td>
				</tr>
				<%
				   }
				%>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
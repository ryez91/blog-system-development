<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Archive</title>
<link rel="stylesheet" href="user/image/style.css" />
</head>
<body>
    <jsp:include page="include/MainHeader.jsp"></jsp:include>
		<table width="1000" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" valign="bottom">
				<td class="title">
					&nbsp;&nbsp;Archive
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
					<table cellpadding="4" cellspacing="1">
						<tr>
							<td>
								<table width="1000" cellpadding="6" cellspacing="1"
									bgcolor="#CCCCCC">
							

									<!-- iterator -->
									
									<s:iterator value="#request.all" var="art">
										<tr>
											<td bgcolor="#FFFFFF">
											
												  <font class="chinesefont105main"> 
												  <a href="showArticleDetails.action?id=<s:property value='#art.id'/>"><s:property value="#art.title"/></a>
													<hr size='1' noshade color='#CCCCCC'> <br>
													<div align='right' class='smalltxt' height='32px'>
														Posted on &nbsp;
														<s:date name="#art.date"/>
														
														|Comments(<s:property value="#request.commentCount[#art.id - 1]"/>)|Views(<s:property value="#art.hasRead"/>)
													</div> </font>
													
													<!--<s:property value='#art.title'/>-->
											</td>
											
										</tr>
										</s:iterator>
										<tr>
										   <td align="center">
										    <s:if test="#request.page.hasPrepage">
										    <a href="showAllArticles.action?currentPage=1">First</a>
										    <a href="showAllArticles.action?currentPage=${page.currentPage -1 }">Pre</a>
										    </s:if>
										    <s:else>
										        First
										        Pre
										    </s:else>
										    <s:if test="#request.page.hasNextPage">
										      <a href="showAllArticles.action?currentPage=${page.currentPage +1 }">Next</a>
										      <a href="showAllArticles.action?currentPage=${page.totalPage }">Last</a>
										    </s:if>
										    <s:else>
										        Next
										        Last
										    </s:else>
										    </td>
										 </tr>
										
									
								
									
								</table>
								<table id="noCount" runat="server" width="1000" cellpadding="6"
									cellspacing="1" bgcolor="#cccccc">
									<tr bgcolor="#ffffff" height="50">
										<td align="center">
										<% 
										   String username = request.getParameter("username");
										   if(username==null ||"".equals(username)){
										%>
											${sessionScope.username}'s blog
											<%
										   }else{   
										   
											%>
											${param.username }'s blog
											<%
										   }
											%>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

</body>
</html>
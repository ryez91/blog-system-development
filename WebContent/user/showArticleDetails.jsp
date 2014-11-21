<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>My Blog</title>
<link rel="stylesheet" href="image/style.css" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td width="722" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr height="30" valign="bottom">
							<td class="title">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="2" valign="top">
								<table width="1000" cellpadding="4" cellspacing="1">
									<tr>
										<td>
											<table width="1000" cellpadding="6" cellspacing="1"
												bgcolor="#CCCCCC">

												<tr>
													<td bgcolor="#FFFFFF">
													   <center>
														<p style="font-size=20px"><s:property value="#request.article.title"/></p>
														</center>
															<hr size='1' noshade color='#CCCCCC'> <br>
															
															<div>
														<s:property value="#request.article.content" escape="false"/>
															</div> 
													</td>
												</tr>
												
												<!-- Show comments -->
												<s:iterator value="#request.allCM" id="cm">
													<tr>
														<td height="20"></td>
													</tr>
													<tr>
													<td bgcolor="#FFFFFF">
														
														<s:property value="#cm.content" escape="false"/>
															<hr size='1' noshade color='#CCCCCC'> <br>
														<p align="right">Comment by &nbsp;<s:property value="#cm.username"/></p>
															
													</td>
													</tr>
												</s:iterator>
																					<tr>
											<td align="center">
												<s:if test="#request.page.hasPrePage">
													<a href="showArticleDetails.action?id=${requestScope.article.id}&currentPage=1">First</a>
													<a href="showArticleDetails.action?id=${requestScope.article.id}&currentPage=${page.currentPage -1 }">Pre</a>
												</s:if>
												<s:else>
													First
												    Pre
												</s:else>
												
												<s:if test="#request.page.hasNextPage">
													<a href="showArticleDetails.action?id=${requestScope.article.id}&currentPage=${page.currentPage + 1 }">Next</a>
													<a href="showArticleDetails.action?id=${requestScope.article.id}&currentPage=${page.totalPage }">Last</a>			
												</s:if>
												<s:else>
												    Next
												    Last
												</s:else>
											</td>
										</tr>
											</table>	
													
											<form action="addComment.action" method="post">
											<input type="hidden" name="id" value='${requestScope.article.id }'/>
											<table width="1000" height="300" border="0" cellpading="0" cellspacing="0" align="center">
											    <tr height="20">
											        <td height="24" colspan="2">&nbsp;</td>
											    </tr>
											    <tr>
											       <td valign="top">
											       </td>
											       <td colspan="2" align="center" valign="top">
											           <table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
							<tr height="30">
								<td background="image/l-bg3.jpg">&nbsp;&nbsp;&nbsp;<font color="#ffff66"><b>Comments</b></font></td>
							</tr>
							<tr>
								<td>
									<textarea rows="10" cols="40" name="content" id="editor2"></textarea>
									
									<script>
                                        CKEDITOR.replace('editor2',
    	                                                 {
     	                                                   width : '100%',
     	                                                   toolbar :{
         	                                                   name: 'basicstyles', items:['Bold','Italic']
                                                                }

                                                           });
                                     </script>

								</td>
							</tr>
							<tr height="20">
								<td>
								    <center>
									<input type="submit"  value="Post" Style="ButtonCss" />
									<input type="button" name="cancelButton" value="Cancle" onClick="history.back()" Class="ButtonCss">
								    </center>
								</td>
							</tr>
						</table>
											           
					</td>
				</tr>
			</table>
											
         </form>
											<table id="noCount" runat="server" width="1000"
												cellpadding="6" cellspacing="1" bgcolor="#cccccc">
												<tr bgcolor="#ffffff" height="50">
													<td align="center">
														${sessionScope.username}'blog
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
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
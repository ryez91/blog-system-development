<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<form id="Form1" method="post">
			<table width="1000" cellpadding="0" cellspacing="0" border="0">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="400"><img src="image/success.gif"></td>
					<td width="20">&nbsp;</td>
					<td valign="top">
						<table width="400" border="1" cellpadding="0" cellspacing="0" style="BORDER-RIGHT:#cccccc 1px solid;BORDER-TOP:#cccccc 1px solid;BORDER-LEFT:#cccccc 1px solid;BORDER-BOTTOM:#cccccc 1px solid;BORDER-COLLAPSE:collapse;BACKGROUND-COLOR:#ffffff">
							<tr height="30">
								<td colspan="2" align="center" background="image/l-bg1.jpg"><font color="#ffff66"><b>Success!</b></font></td>
							</tr>
							<tr height="150">
								<td align="center">${request.info }</td>
								<%
									 String url = (String)request.getAttribute("url");
								     response.setHeader("Refresh", "3;url=" + url);
									 
								%>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
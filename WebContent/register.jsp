<%@ page language="java" import="java.util.*" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
    <jsp:include page="include/MainHeader.jsp"></jsp:include>
    <s:actionerror/>
    <form id="Form1" action="register.action" method="post">
        <table width="1000" cellpadding="0" cellspacing="0" border="0">
        <tr height="100">
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td align="right" width="100" valign="top">
            <img src="image/register.jpg">
            </td>
            <td width="20">&nbsp;</td>
            <td valign="top">
                <table width="600" border="1" cellpadding="0" cellspacing="0" style="background-color:#FFFFFF;BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse">
                    <tr height="30">
                      <td colspan="3" align="center"><font color="#f09619"><b>Hello, New Blogger</b></font></td>  
                    </tr>
                    <tr height="30">
                      <td align="right" width="160">E-mail&nbsp;</td>
                      <td><input type="text" name="email"/>*</td>
                      <td><s:fielderror><s:param>email</s:param></s:fielderror></td>         
                    </tr>
                    
                    <tr height="30">
                      <td align="right" width="160">Password&nbsp;</td>
                      <td><input type="password" name="password"/>*</td>
                     <td><s:fielderror><s:param>password</s:param></s:fielderror></td>        
                    </tr>
                    
                    <tr height="30">
                      <td align="right" width="160">Confirm your password&nbsp;</td>
                      <td><input type="password" name="repassword"/>*</td>
                      <td><s:fielderror><s:param>repassword</s:param></s:fielderror></td>        
                    </tr>
                    
                    <tr height="30">
                      <td align="right" width="160">Username&nbsp;</td>
                      <td><input type="text" name="username"/>*</td>
                      <td><s:fielderror><s:param>username</s:param></s:fielderror></td>         
                    </tr>
                    
                    <tr height="30">
                      <td align="right">Question for security&nbsp;</td>
                      <td>
                        <select name="question">
                          <option value="yourBirthday">Your birthday</option>
                          <option value="yourHometown">Your hometown</option>
                          <option value="yourFood">Your favorite food</option>
                        </select>* 
                      </td>  
                      <td><s:fielderror><s:param>question</s:param></s:fielderror></td>  
                    </tr>
                    <tr height="30">
                      <td align="right">Your answer&nbsp;</td>
                      <td><input type="text" name="answer"/>*</td>
                      <td><s:fielderror><s:param>answer</s:param></s:fielderror></td>
                    </tr>
                    <tr height="30">
                        <td colspan="3" align="center"><input type="submit" value="Submit"/>
                        <input type="reset" value="Reset"/>
                        </td>
                    </tr>   
                </table>
            </td>
        </tr>
        </table>
    
    </form>

</body>
</html>
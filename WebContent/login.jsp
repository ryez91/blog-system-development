<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Log in Page</title>
</head>
<body onLoad="document.forms[0]['username'].focus()" topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
  <jsp:include page="include/MainHeader.jsp"></jsp:include>
  <form id="Form1" action="login.action" method="post">
    <table width="1000" cellpadding="0" celsspacing="0" border="0">
      <tr height="100">
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
         <td width="200">&nbsp;</td>
         <td width="420" align="center" valign="bottom">
           <table width="360" border="1" cellpadding="0" cellspacing="0" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#ffffff">
             <tr height="30">
               <td colspan="2" align="center" background="image/main/l-bg1.jpg"><span class="STYLE1">Blog Log in</span></td>
             </tr>
             <tr height="30">
               <td width="60" rowspan="5">&nbsp;</td>
               <td width="300">Username</td>
             </tr>
             <tr height="30">
               <td><input type="text" name="username" Width="120"/></td>
             </tr>
             <tr height="30">
               <td>Password</td>
             </tr>
             <tr height="30">
               <td><input type="password" name="password" Width="120"/></td>
             </tr>
             <tr height="40">
               <td><input type="submit" id="loginButton" value="Log in"/></td>
             </tr>
           </table>
         </td>
         <td><img src="image/login.gif"></td>
      </tr>
    
    </table>
  
  
  </form>



</body>
</html>
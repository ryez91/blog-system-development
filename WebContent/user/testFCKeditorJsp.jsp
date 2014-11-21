<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>fck editor test</title>
</head>
<body>
  <center>

  <FCK:editor instanceName="myFckEditor" basePath="/user/fckeditor" width="80%" height="500" toolbarSet="myToolbar"></FCK:editor>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.ckeditor.*" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>CKEditor tester</title>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
<center>
  <textarea rows="30" cols="40" name="editor1" id="editor1"></textarea> 
  <%
      //CKEditorConfig settings = new CKEditorConfig();
      //settings.addConfigValue("width", "400");
      //settings.addConfigValue("toolbar","[[ 'Source', '-', 'Bold', 'Italic' ]]");
  %>
  <script>
      CKEDITOR.replace('editor1',
    	 {
     	     width : '80%',
     	     toolbar : 'MyToolbar',
     	  //   filebrowserBrowseUrl : 'ckeditor/filemanager/browser/default/browser.html?Connector=http://localhost:8080/BlogProjectDemo1/user/ckeditor/filemanager/connectors/php/connector.php',
     	  //   filebrowserImageBrowseUrl : 'ckeditor/filemanager/browser/default/browser.html?Type=Image&amp;Connector=http://localhost:8080/BlogProjectDemo1/user/ckeditor/filemanager/connectors/php/connector.php',
     	  //   filebrowserFlashBrowseUrl : 'ckeditor/filemanager/browser/default/browser.html?Type=Flash&amp;Connector=http://localhost:8080/BlogProjectDemo1/user/ckeditor/filemanager/connectors/php/connector.php',
     	 //   filebrowserUploadUrl  :'http://localhost:8080/BlogProjectDemo1/user/ckeditor/filemanager/connectors/php/upload.php?Type=File',
    	//	filebrowserImageUploadUrl : 'http://localhost:8080/BlogProjectDemo1/user/ckeditor/filemanager/connectors/php/upload.php?Type=Image',
    	//	filebrowserFlashUploadUrl : 'http://localhost:8080/BlogProjectDemo1/user/ckeditor/filemanager/connectors/php/upload.php?Type=Flash'
     	    filebrowserUploadUrl : 'ckeditor/uploader?Type=File',
     	    filebrowserImageUploadUrl : 'ckeditor/uploader?Type=Image',
     	   filebrowserFlashUploadUrl : 'ckeditor/uploader?Type=Flash'

          });
  </script>
</center>

</body>
</html>
package com.rikki.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CKEditorUploadServlet extends HttpServlet {
	private static String baseDir;// CKEditor root directory
    private static boolean debug = false;// debug mode 
    private static boolean enabled = false;// editor
    private static Hashtable allowedExtensions;// extenstion allowed 
    private static Hashtable deniedExtensions;//   
    private static SimpleDateFormat dirFormatter;// yyyyMM  
    private static SimpleDateFormat fileFormatter;// yyyyMMddHHmmssSSS  
    /** 
     * Servlet initialization
     */  
    public void init() throws ServletException {  
        // web.xml: debug
        debug = (new Boolean(getInitParameter("debug"))).booleanValue();  
        if (debug)  
            System.out  
                    .println("\r\n---- SimpleUploaderServlet initialization started ----");  
        // 
        dirFormatter = new SimpleDateFormat("yyyyMM");  
        fileFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");  
        // web.xml root name
        baseDir = getInitParameter("baseDir");  
        // web.xml file upload
        enabled = (new Boolean(getInitParameter("enabled"))).booleanValue();  
        if (baseDir == null)  
            baseDir = "/UserFiles/";  
        String realBaseDir = getServletContext().getRealPath(baseDir);  
        File baseFile = new File(realBaseDir);  
        if (!baseFile.exists()) {  
            baseFile.mkdirs();  
        }  
        // 
        allowedExtensions = new Hashtable(3);  
        deniedExtensions = new Hashtable(3);  
        // get config from web.xml 
        allowedExtensions.put("File",  
        stringToArrayList(getInitParameter("AllowedExtensionsFile")));  
        deniedExtensions.put("File",  
        stringToArrayList(getInitParameter("DeniedExtensionsFile")));  
        allowedExtensions.put("Image",  
    stringToArrayList(getInitParameter("AllowedExtensionsImage")));  
        deniedExtensions.put("Image",           stringToArrayList(getInitParameter("DeniedExtensionsImage")));  
        allowedExtensions.put("Flash",          stringToArrayList(getInitParameter("AllowedExtensionsFlash")));  
        deniedExtensions.put("Flash",           stringToArrayList(getInitParameter("DeniedExtensionsFlash")));  
        if (debug)  
            System.out  
                    .println("---- SimpleUploaderServlet initialization completed ----\r\n");  
    }  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response);  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        if (debug)  
            System.out.println("--- BEGIN DOPOST ---");  
        response.setContentType("text/html; charset=UTF-8");  
        response.setHeader("Cache-Control", "no-cache");  
        PrintWriter out = response.getWriter();  
        // File/Image/Flash  
        String typeStr = request.getParameter("Type");  
        if (typeStr == null) {  
            typeStr = "File";  
        }  
        if (debug)  
            System.out.println(typeStr);  
        // get date 
        Date dNow = new Date();  
        // set upload path 
        String currentPath = baseDir + typeStr + "/"  
                + dirFormatter.format(dNow);  
        // upload path 
        String currentDirPath = getServletContext().getRealPath(currentPath);  
        // filename exists?
        File dirTest = new File(currentDirPath);  
        if (!dirTest.exists()) {  
            dirTest.mkdirs();  
        }  
        // get web app name 
        currentPath = request.getContextPath() + currentPath;  
        if (debug)  
            System.out.println(currentDirPath);  
        // path 
        String newName = "";  
        String fileUrl = "";  
        if (enabled) {  
            // Apache Common: fileupload
            FileItemFactory factory = new DiskFileItemFactory();  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            try {  
                List items = upload.parseRequest(request);  
                Map fields = new HashMap();  
                Iterator iter = items.iterator();  
                while (iter.hasNext()) {  
                    FileItem item = (FileItem) iter.next();  
                    if (item.isFormField())  
                        fields.put(item.getFieldName(), item.getString());  
                    else  
                        fields.put(item.getFieldName(), item);  
                }  
                // CEKditor file.name=upload  
                FileItem uplFile = (FileItem) fields.get("upload");  
                // get file and handle 
                String fileNameLong = uplFile.getName();  
                fileNameLong = fileNameLong.replace('\\', '/');  
                String[] pathParts = fileNameLong.split("/");  
                String fileName = pathParts[pathParts.length - 1];  
                // get file extension 
                String ext = getExtension(fileName);  
                // set filename
                fileName = fileFormatter.format(dNow) + "." + ext;  
                // get filename without extension 
                String nameWithoutExt = getNameWithoutExtension(fileName);  
                File pathToSave = new File(currentDirPath, fileName);  
                fileUrl = currentPath + "/" + fileName;  
                if (extIsAllowed(typeStr, ext)) {  
                    int counter = 1;  
                    while (pathToSave.exists()) {  
                        newName = nameWithoutExt + "_" + counter + "." + ext;  
                        fileUrl = currentPath + "/" + newName;  
                        pathToSave = new File(currentDirPath, newName);  
                        counter++;  
                    }  
                    uplFile.write(pathToSave);  
                } else {  
                    if (debug)  
                        System.out.println("invalid file format: " + ext);  
                }  
            } catch (Exception ex) {  
                if (debug)  
                    ex.printStackTrace();  
            }  
        } else {  
            if (debug)  
                System.out.println("You haven't enabled CKEditor upload function!");  
        }  
        // CKEditorFuncNum param
        String callback = request.getParameter("CKEditorFuncNum");  
        out.println("<script type=\"text/javascript\">");  
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
                + ",'" + fileUrl + "',''" + ")");  
        out.println("</script>");  
        out.flush();  
        out.close();  
        if (debug)  
            System.out.println("--- END DOPOST ---");  
    }  
    /** 
     * get filename
     */  
    private static String getNameWithoutExtension(String fileName) {  
        return fileName.substring(0, fileName.lastIndexOf("."));  
    }  
    /** 
     * get extension method
     */  
    private String getExtension(String fileName) {  
        return fileName.substring(fileName.lastIndexOf(".") + 1);  
    }  
    /** 
     * Arraylist
     */  
    private ArrayList stringToArrayList(String str) {  
        if (debug)  
            System.out.println(str);  
        String[] strArr = str.split("\\|");  
        ArrayList tmp = new ArrayList();  
        if (str.length() > 0) {  
            for (int i = 0; i < strArr.length; ++i) {  
                if (debug)  
                    System.out.println(i + " - " + strArr[i]);  
                tmp.add(strArr[i].toLowerCase());  
            }  
        }  
        return tmp;  
    }  
    /** 
     * 判断扩展名是否允许的方法 
     */  
    private boolean extIsAllowed(String fileType, String ext) {  
        ext = ext.toLowerCase();  
        ArrayList allowList = (ArrayList) allowedExtensions.get(fileType);  
        ArrayList denyList = (ArrayList) deniedExtensions.get(fileType);  
        if (allowList.size() == 0) {  
            if (denyList.contains(ext)) {  
                return false;  
            } else {  
                return true;  
            }  
        }  
        if (denyList.size() == 0) {  
            if (allowList.contains(ext)) {  
                return true;  
            } else {  
                return false;  
            }  
        }  
        return false;  
    }

}

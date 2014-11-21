package com.rikki.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadPhoto extends ActionSupport {
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String execute() throws Exception {
		
		Map session = ServletActionContext.getContext().getSession();
		String username = (String)session.get("username");
		InputStream is = new FileInputStream(myFile);
		
		String photoPath = 
			ServletActionContext.getServletContext().getRealPath("/user/photo/" + username);
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) {
			filePhotoPath.mkdir();
		}
		
		
		
		File tofile = new File(photoPath,this.getMyFileFileName());
		
		OutputStream os = new FileOutputStream(tofile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		
		is.close();
		
		os.close();
		
		return this.SUCCESS;
	}

}

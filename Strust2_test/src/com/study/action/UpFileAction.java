package com.study.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UpFileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private File upfile;
	private String upfileContentType;
	private String upfileFileName;
	private String upfileSavePath = "F:" + File.separator +"upload" + File.separator;
//	private String upfileSavePath;
	private String token;

	@Override
	public String execute() throws Exception {
		System.out.println("execute----------------");
		System.out.println("upfile---------------" + upfile);
		System.out.println("upfileFileName---------------" + upfileFileName);
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(upfile));
		
		File saveFile = new File(upfileSavePath);
		System.out.println("--------------------upfileSavePath" + upfileSavePath);
		System.out.println("--------------------saveFile" + saveFile);
		
		if(!saveFile.exists()){
			System.out.println("--------------------saveFile" + saveFile);
			saveFile.mkdirs();
		}
		
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(upfileSavePath+upfileFileName));
		
		byte[] b = new byte[1024];
		int n = 0;
		
		while((n = bin.read(b)) != -1){
			bout.write(b, 0, n);
			bout.flush();
		}
		
		bout.close();
		bin.close();
		addActionMessage("文件上传成功");
		
		return SUCCESS;
	}

	public File getUpfile() {
		return upfile;
	}

	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}

	public String getUpfileContentType() {
		return upfileContentType;
	}

	public void setUpfileContentType(String upfileContentType) {
		this.upfileContentType = upfileContentType;
	}

	public String getUpfileSavePath() {
		return upfileSavePath;
	}

	public void setUpfileSavePath(String upfileSavePath) {
		this.upfileSavePath = upfileSavePath;
	}

	public String getUpfileFileName() {
		return upfileFileName;
	}

	public void setUpfileFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}

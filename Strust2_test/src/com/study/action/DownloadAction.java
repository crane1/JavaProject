package com.study.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String downloadFileName;
	
	public InputStream getInputStream(){
		BufferedInputStream bis = null;
		try {
			FileInputStream fileinput = new FileInputStream(downloadFileName);
			bis = new BufferedInputStream(fileinput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return bis;
	}

	@Override
	public String execute() throws Exception {
		downloadFileName = "F:"+ File.separator + "音乐" + File.separator + "miu-clips - 绊.mp3";
		return super.execute();
	}
	

}

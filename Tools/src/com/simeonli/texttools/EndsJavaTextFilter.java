package com.simeonli.texttools;

import java.io.File;
import java.io.FilenameFilter;

public class EndsJavaTextFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		if(name.endsWith(".java") || dir.isDirectory()){
			return true;
		}
		return false;
	}

}

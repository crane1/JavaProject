package com.study.vo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class MyFirstTagLib extends TagSupport {
	PageContext pageContext;
	private String key;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().write("Â¥Ö÷ÊÇ£º" + key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		super.setPageContext(pageContext);
	}

}

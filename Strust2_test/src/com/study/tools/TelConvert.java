package com.study.tools;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.study.bean.Tel;

public class TelConvert extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String tel = arg1[0];
		String second = tel.substring(tel.length()-8);
		String first = tel.substring(0,tel.length()-8);
		
		Tel otel = new Tel(first, second);
		
		System.out.println("first:" + first);
		System.out.println("second:" + second);
		return otel;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		String temp = "";
        if (arg1 instanceof Tel) {
        	Tel tel = (Tel) arg1;
            temp = tel.getFirst() + "-" + tel.getSecond();
        }
        return temp;
	}
	
	public static void main(String[] args) {
		TelConvert tel = new TelConvert();
		
		String[] tels = new String[]{"091756387940"};
		tel.convertFromString(null, tels, Tel.class);
	}

}

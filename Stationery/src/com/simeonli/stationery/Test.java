package com.simeonli.stationery;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Pen pen1 = new Pen("¸Ö±Ê", 100);
		Pen pen2 = new Pen("ÖĞĞÔ±Ê", 4);
		
		Eraser eraser1 = new Eraser("ÏãÏğÆ¤", 2);
		Eraser eraser2 = new Eraser("ÏğÆ¤Äà", 10);
		
		Student stu = new Student("ÑÕÏş³¿");
		Painter pai = new Painter("±Ï¿¨Ë÷");
		
		StationeryStore ss = new StationeryStore();
		
		System.out.println("*********ÎÄ¾ßµê¨r(¨s_¨t)¨q¿ªÒµÀ²*********");
		System.out.println("ÇëÑ¡ÔñÎÄ¾ß: 1.¸Ö±Ê\t2.ÖĞĞÔ±Ê\t3.ÏãÏğÆ¤\t4.ÏğÆ¤Äà");
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		switch(str){
		case 1:
			stu.setPen(pen1);
			ss.sale(pen1);
			break;
		case 2:
			stu.setPen(pen2);
			ss.sale(pen2);
			break;
		case 3:
			pai.setEraser(eraser1);
			try {
				ss.sale(eraser1);
			} catch (PersonalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			pai.setEraser(eraser2);
			try {
				ss.sale(eraser2);
			} catch (PersonalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		System.out.println(stu);
		System.out.println(pai);
		
	}
}

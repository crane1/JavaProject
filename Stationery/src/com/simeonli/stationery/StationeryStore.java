package com.simeonli.stationery;


public class StationeryStore {
	
	public void sale(Pen pen){
		if (pen.isSaled()){
			System.out.println("这支笔已经买出去了");
			return;
		}
		System.out.println("这支" + pen.getName() + "售价：" + pen.getPrice());
		pen.setSaled(true);
	}
	
	public void sale(Eraser eraser) throws PersonalException{
		if (eraser.isSaled()){
			throw new PersonalException("这块橡皮已经买出去了");
		}
		System.out.println("这块" + eraser.getName() + "售价：" + eraser.getPrice());
		eraser.setSaled(true);
	}
}

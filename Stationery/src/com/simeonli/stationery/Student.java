package com.simeonli.stationery;

public class Student extends Person{
	private Pen pen;
	
	public Student(){}
	public Student(String name){
		super(name);
	}

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
	public String toString(){
		return this.getName() + "ÓÐÒ»Ö§" + this.pen;
	}
}

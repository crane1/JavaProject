package com.javateam1.restuarant.model;

public class Food {
	private String name;
	private double price;
	private boolean isDelete;
	
	public Food(){}
	public Food(String name, double price){
		this.name = name;
		this.price = price;
		setDelete(true);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void printInfo(){
		System.out.printf("%s\t%s\n",getName(),getPrice());
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}

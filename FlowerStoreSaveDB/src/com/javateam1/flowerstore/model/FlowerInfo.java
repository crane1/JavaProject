package com.javateam1.flowerstore.model;

public class FlowerInfo {
	private String id;
	private String name;
	private double price;
	private int num;
	private double total_price;
	
	public FlowerInfo(){}
	public FlowerInfo(String id, String name, double price, int num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
		this.total_price = price * num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	public void addNum(){
		num++;
		this.total_price = price * num;
	}
	@Override
	public String toString() {
		return "FlowerInfo [id=" + id + ", name=" + name + ", price=" + price
				+ ", num=" + num + ", total_price=" + total_price + "]";
	}
	
	
	
	
}

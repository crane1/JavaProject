package com.javateam1.flowerstore.model;

public class Flower {
//	id, name, price, materials, package, flowerWord,num, type
	private String id;
	private String name;
	private double price;
	private String materials;
	private String packages;
	private int num;
	private String type;
	private String flowerWord;
	private boolean isDelete;
	
	public Flower(){}
	public Flower(String name, double price){
		this.name = name;
		this.price = price;
		setDelete(true);
	}
	public Flower(String id, String name, double price, String materials,
			String packages,  int num, String type, String flowerWord
			) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.materials = materials;
		this.packages = packages;
		this.flowerWord = flowerWord;
		this.num = num;
		this.type = type;
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

	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getFlowerWord() {
		return flowerWord;
	}
	public void setFlowerWord(String flowerWord) {
		this.flowerWord = flowerWord;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Flower [编号：" + id + ", 花名：" + name + ", 价格：" + price
				+ ", 花材：" + materials + ", 包装：" + packages
				+  ", 数量：" + num + ", 花语" + flowerWord;
	}
	
}

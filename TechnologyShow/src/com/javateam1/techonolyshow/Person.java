package com.javateam1.techonolyshow;


public class Person {
    String name = "李白";   
    Car car;
    BankCard card;
    
    public Person(){
    	card = new BankCard();
		car = new Car();
    }
    
	public Person(String name) {
		this.name = name;
		card = new BankCard();
		car = new Car();
	}
    
    String getName(){
    	return name;
    }
    
    void setName(String name){
    	this.name = name;
    }
    
    // 打印人物信息
    void printPersonInfo(){
    	this.car.printCarInfo();
    }
    
    // 驾驶车辆
    void driveCar(){
    	System.out.println(this.getName() + "正在驾驶 " + this.car.getName());
    	this.car.move();
    }
    
}

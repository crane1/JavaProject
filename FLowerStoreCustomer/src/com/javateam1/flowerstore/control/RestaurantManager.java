package com.javateam1.flowerstore.control;

import java.util.Scanner;

import com.javateam1.flowerstore.model.*;

public class RestaurantManager extends Account{
	private Scanner sc = new Scanner(System.in);
	
	public RestaurantManager(){
	}

	public void addFood(FlowerManager foodlist){
	}
	
	public void deletFood(FlowerManager foodlist){
	}
	
	public void modifyFood(FlowerManager foodlist){
	}
	
	public void findFood(FlowerManager foodlist){
	}
	
	public void printFoodList(FlowerManager foodlist){
		foodlist.printList();
	}
	

	public void printAllOrder(OrderManager orders) {
		orders.printOrderList();
	}

	public void deleteOrder(OrderManager orders) {
		orders.printOrderList();
		System.out.println("ÇëÊäÈëÄãÒªÉ¾³ıµÄ¶©µ¥±àºÅ");
		System.out.println("#");
	}
}

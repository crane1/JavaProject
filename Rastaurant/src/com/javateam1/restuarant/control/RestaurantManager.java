package com.javateam1.restuarant.control;

import java.util.Scanner;

import com.javateam1.restuarant.model.*;
import com.javateam1.restuarant.view.Menu;

public class RestaurantManager extends Account{
	private Scanner sc = new Scanner(System.in);
	
	public RestaurantManager(){
	}

	public void addFood(FoodManager foodlist){
		foodlist.addFood();
	}
	
	public void deletFood(FoodManager foodlist){
		foodlist.deleteFood();
	}
	
	public void modifyFood(FoodManager foodlist){
		foodlist.modifyFood();
	}
	
	public void findFood(FoodManager foodlist){
		foodlist.findFood();
	}
	
	public void printFoodList(FoodManager foodlist){
		foodlist.printList();
	}
	
	public void printModifyFoodlist(FoodManager foodlist){
		while(true){
			System.out.println("1.Ìí¼Ó²Ë  2.É¾³ı²Ë  3.ĞŞ¸Ä²Ë  4.²éÕÒ²Ë  5.´òÓ¡²Ëµ¥ 0.ÍË³ö");
			System.out.print("#:");
			int str = Menu.getInputIntNum();
			if (str == 0){
				break;
			}
			
			switch(str) {
			case 1:
				addFood(foodlist);
				break;
			case 2:
				deletFood(foodlist);
				break;
			case 3:
				modifyFood(foodlist);
				break;
			case 4:
				findFood(foodlist);
				break;
			case 5:
				printFoodList(foodlist);
				break;
			default:
				System.out.println("ÊäÈëÓĞÎó");
				break;
			}
		}
		
	}

	public void printAllOrder(OrderManager orders) {
		orders.printOrderList();
	}

	public void deleteOrder(OrderManager orders) {
		orders.printOrderList();
		System.out.println("ÇëÊäÈëÄãÒªÉ¾³ıµÄ¶©µ¥±àºÅ");
		System.out.println("#");
		int num = Menu.getInputIntNum();
		orders.deletOrder(num);
	}
}

package com.javateam1.restuarant.model;

import com.javateam1.restuarant.control.FoodManager;
import com.javateam1.restuarant.control.OrderManager;

public class Restaurant {
	private FoodManager foodlist;
	private Balance balance;
	private OrderManager orders;
	
	public Restaurant(){
		foodlist = new FoodManager();
		balance = new Balance();
		setOrders(new OrderManager());
	}

	public FoodManager getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(FoodManager foodlist) {
		this.foodlist = foodlist;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public OrderManager getOrders() {
		return orders;
	}

	public void setOrders(OrderManager orders) {
		this.orders = orders;
	}
	
	
}

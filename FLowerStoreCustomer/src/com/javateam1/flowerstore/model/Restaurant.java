package com.javateam1.flowerstore.model;

import com.javateam1.flowerstore.control.FlowerManager;
import com.javateam1.flowerstore.control.OrderManager;

public class Restaurant {
	private FlowerManager foodlist;
	private Balance balance;
	private OrderManager orders;
	
	public Restaurant(){
		foodlist = new FlowerManager();
		balance = new Balance();
		setOrders(new OrderManager());
	}

	public FlowerManager getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(FlowerManager foodlist) {
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

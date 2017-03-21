package com.javateam1.flowerstore.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Flower> list = new ArrayList<Flower>();
	
	public boolean addFlower(Flower f){
		if(list.add(f)){
			return true;
		}
		return false;
	}
	
	public List<Flower> viewCart(){
		for(Flower f : list){
			System.out.println(f);
		}
		return list;
	}
}

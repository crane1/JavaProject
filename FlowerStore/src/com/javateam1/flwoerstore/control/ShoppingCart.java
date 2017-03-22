package com.javateam1.flwoerstore.control;

import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.model.Flower;
import com.javateam1.flowerstore.model.FlowerInfo;

public class ShoppingCart {
	private List<FlowerInfo> list = new ArrayList<FlowerInfo>();
	
	public boolean addFlower(String id){
		
		for(FlowerInfo fi : list){
			if(fi.getId().equals(id)){
				fi.addNum();
				return true;
			}
		}
		
		Flower f = FlowerManager.findFoodById(id);
		FlowerInfo fi = new FlowerInfo(f.getId(), f.getName(), f.getPrice(), 1);
		
		if(list.add(fi)){
			return true;
		}
		return false;
	}
	
	public List<String> viewCart(){
		List<String> flist = new ArrayList<String>();
		for(FlowerInfo f : list){
			flist.add(f.getId());
			flist.add(f.getName());
			flist.add(String.valueOf(f.getPrice()));
			flist.add(String.valueOf(f.getNum()));
			flist.add(String.valueOf(f.getTotal_price()));
		}
		return flist;
	}
	
	public FlowerInfo getFlowerById(String id){
		FlowerInfo f1 = null;
		for(FlowerInfo f : list){
			if(f.getId().equals(id)){
				f1 = f;
				break;
			}
		}
		return f1;
	}

	public List<FlowerInfo> getList() {
		return list;
	}

	public void setList(List<FlowerInfo> list) {
		this.list = list;
	}
	
	
}

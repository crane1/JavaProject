package com.javateam1.flwoerstore.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.model.Flower;
import com.javateam1.flowerstore.model.FlowerInfo;

public class ShoppingCart {
	private List<FlowerInfo> list = new ArrayList<FlowerInfo>();
	
	public void initShoppingCart(Account a){
		try {
			File file = new File("config/carts/"+ a.getId() + "_cart.csv");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String line = "";
			// 按行读取配置文件
			while((line = bf.readLine()) != null && line.length() > 0){
				if(line.charAt(0) == '#'){
					continue;
				}
				
				String[] attrs = line.split(",");
				
				Flower f = FlowerManager.findFoodById(attrs[0]);
				if(f != null){
					FlowerInfo fi = new FlowerInfo(f.getId(), f.getName(), f.getPrice(), Integer.valueOf(attrs[1]));
					list.add(fi);
				}
			}
			// 必须关闭所有打开的流，否则会报notfoundfile异常
			bf.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveShoppingInfo(Account a){
		try {
			File file = new File("config/carts/"+ a.getId() + "_cart.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String s = "";
			for(FlowerInfo fi : list){
				s =fi.getId() + "," + fi.getNum() + "\n";
				bw.write(s);
				bw.flush();
			}
			
			// 必须关闭所有打开的流，否则下次使用会报notfoundfile异常
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addFlower(Account a, String id){
		
		for(FlowerInfo fi : list){
			if(fi.getId().equals(id)){
				fi.addNum();
				saveShoppingInfo(a);
				return true;
				
			}
		}
		
		Flower f = FlowerManager.findFoodById(id);
		FlowerInfo fi = new FlowerInfo(f.getId(), f.getName(), f.getPrice(), 1);
		
		if(list.add(fi)){
			saveShoppingInfo(a);
			return true;
		}
		return false;
	}
	
	public boolean deleteFlower(Account a, String id){
		for(FlowerInfo fi : list){
			if(fi.getId().equals(id)){
				fi.setNum(0);
				saveShoppingInfo(a);
				return true;
			}
		}
		return false;
	}
	
	public List<String> viewCart(){
		List<String> flist = new ArrayList<String>();
		for(FlowerInfo f : list){
			if(f.getNum() > 0){
				flist.add(f.getId());
				flist.add(f.getName());
				flist.add(String.valueOf(f.getPrice()));
				flist.add(String.valueOf(f.getNum()));
				flist.add(String.valueOf(f.getTotal_price()));
			}
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

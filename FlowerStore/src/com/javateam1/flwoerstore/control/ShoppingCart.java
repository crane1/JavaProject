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
			File file = new File("config/shoppingcartlist.csv");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String line = "";
			// ���ж�ȡ�����ļ�
			while((line = bf.readLine()) != null){
				// ע����ʡ��
				if(line.charAt(0) == '#'){
					continue;
				}
				
				//����ȡ�������԰������ֿ����ֱ�洢
				String[] attrs = line.split(",");
				if(attrs[0].equals(a.getId()) || Integer.valueOf(attrs[2]) > 0){
					Flower f = FlowerManager.findFoodById(attrs[1]);
					FlowerInfo fi = new FlowerInfo(f.getId(), f.getName(), f.getPrice(), f.getNum());
					list.add(fi);
				}
			}
			// ����ر����д򿪵���������ᱨnotfoundfile�쳣
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
	
	private static void saveShoppingInfo(Account a){
		try {
			File file = new File("config/shoppingcartlist.csv");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String s =a.getId() + "," + a.getPwd() + "," + a.getName()
					 + "," + a.getAddress()+ "," + a.getTelephone() + "," + a.getType();
			bw.write(s);
			bw.flush();
			// ����ر����д򿪵���������ᱨnotfoundfile�쳣
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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

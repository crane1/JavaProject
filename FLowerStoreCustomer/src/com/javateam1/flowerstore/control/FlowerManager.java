package com.javateam1.flowerstore.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.javateam1.flowerstore.model.Flower;

public class FlowerManager {
	private static List<Flower> flowerList;  // 所有菜组成的一个菜单
	
	static{
		flowerList = new LinkedList<Flower>();
		initFoodList();
	}
	
	public FlowerManager(){}
	
	private static void initFoodList(){
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("config/flowerlist.csv")));
			String line = "";
			// 按行读取配置文件
			while((line = bf.readLine()) != null){
				// 注释行省略
				if(line.charAt(0) == '#'){
					continue;
				}
				
				//将读取到的属性按，划分开，分别存储
				String[] attrs = line.split(",");
				Flower f = new Flower();
//				id, name, price, materials, package, flowerWord,num, type
				f.setId(attrs[0]);
				f.setName(attrs[1]);
				f.setPrice(Double.parseDouble(attrs[2]));
				f.setMaterials(attrs[3]);
				f.setPackages(attrs[4]);
				f.setNum(Integer.parseInt(attrs[5]));
				f.setType(attrs[6]);
				f.setFlowerWord(attrs[7]);
				
				flowerList.add(f);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 打印花单列表
	public void printList(){
		for(Flower f : flowerList){
			System.out.println(f);
		}
	}
	
	// 添加花
	public void addFood(Flower f){
		flowerList.add(f);
	}
	
	// 删除花
	public Flower deleteFlower(Flower f){
		Flower fd = findFoodById(f.getId());
		fd.setDelete(false);
		return fd;
	}
	
	// 按id查找花
	public Flower findFoodById(String id){
		Flower fd = null;
		for(Flower f : flowerList){
			if (f.getId().equals(id)){
				fd = f;
				break;
			}
		}
		return fd;
	}
	
	public Flower findFoodByName(String name){
		Flower fd = null;
		for(Flower f : flowerList){
			if (f.getName().equals(name)){
				fd = f;
				break;
			}
		}
		return fd;
	}
	
	public List<Flower> findFoodByMaterials(String materials){
		List<Flower> fd = new ArrayList<Flower>();
		for(Flower f : flowerList){
			if (f.getMaterials().equals(materials)){
				fd.add(f);
			}
		}
		return fd;
	}
	
	public List<Flower> findFoodByPrice(double priceSub, double priceUp){
		List<Flower> fd = new ArrayList<Flower>();
		for(Flower f : flowerList){
			double fprice = f.getPrice();
			if (fprice > priceSub && fprice < priceUp ){
				fd.add(f);
			}
		}
		return fd;
	}
	
	public List<Flower> findFoodByNum(int num){
		List<Flower> fd = new ArrayList<Flower>();
		for(Flower f : flowerList){
			if (f.getNum() == num){
				fd.add(f);
			}
		}
		return fd;
	}
	
	// 修改食物
	public boolean modifyFood(Flower f){
		Flower f1 = findFoodById(f.getId());
		if(f1 == null){
			System.out.println("当前编号不存在");
			return false;
		}
		f1.setName(f.getName());
		f1.setPrice(f.getPrice());
		f1.setNum(f.getNum());
		f1.setFlowerWord(f.getFlowerWord());
		f1.setMaterials(f.getMaterials());
		f1.setPackages(f.getPackages());
		return true;
	}
	
	public static void main(String[] args) {
		FlowerManager fl = new FlowerManager();
		
		Flower f = new Flower("rr001", "情窦", 442.0,"黑玫瑰","礼盒",22,"礼盒","无论世界如何在改变");
		if(fl.modifyFood(f)){
			System.out.println("修改成功");
		}
		fl.printList();
	}
}

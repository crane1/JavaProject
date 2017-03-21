package com.javateam1.flwoerstore.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.javateam1.flowerstore.model.Flower;

public class FlowerManager {
	private static Map<String,Flower> flowerMap;  // ���л���ɵ�һ���˵�
	private static List<String> recoFlowerId; 
	
	
	static{
		flowerMap = new HashMap<String,Flower>();
		recoFlowerId = new ArrayList<String>();
		initFoodList();
	}
	
	public FlowerManager(){}
	
	private static void initFoodList(){
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("config/flowerlist.csv")));
			String line = "";
			// ���ж�ȡ�����ļ�
			while((line = bf.readLine()) != null){
				// ע����ʡ��
				if(line.charAt(0) == '#'){
					continue;
				}
				
				//����ȡ�������԰������ֿ����ֱ�洢
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
				if (attrs[8].equals("1")){
					recoFlowerId.add(attrs[0]);
				}
				
				flowerMap.put(attrs[0], f);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ��ӡ�����б�
	public void printList(){
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			System.out.println(f);
		}
	}
	
	// ��ӻ�
	public void addFood(Flower f){
		flowerMap.put(f.getId(), f);
	}
	
	// ɾ����
	public Flower deleteFlower(Flower f){
		Flower fd = findFoodById(f.getId());
		fd.setDelete(false);
		return fd;
	}
	
	// ��id���һ�
	public Flower findFoodById(String id){
		Flower fd = null;
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			if (f.getId().equals(id)){
				fd = f;
				break;
			}
		}
		return fd;
	}
	
	public Flower findFoodByName(String name){
		Flower fd = null;
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			if (f.getName().equals(name)){
				fd = f;
				break;
			}
		}
		return fd;
	}
	
	public List<Flower> findFlowerByMaterials(String materials){
		List<Flower> fd = new ArrayList<Flower>();
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			if (f.getMaterials().equals(materials)){
				fd.add(f);
			}
		}
		return fd;
	}
	
	public List<Flower> findFlowerByPrice(double priceSub, double priceUp){
		List<Flower> fd = new ArrayList<Flower>();
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			double fprice = f.getPrice();
			if (fprice > priceSub && fprice < priceUp ){
				fd.add(f);
			}
		}
		return fd;
	}
	
	public List<Flower> findFlowerByType(String type){
		List<Flower> fd = new ArrayList<Flower>();
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			if (f.getType().equals(type)){
				fd.add(f);
			}
		}
		return fd;
	}
	
	public List<Flower> findFlowerByNum(int num){
		List<Flower> fd = new ArrayList<Flower>();
		for(String k : flowerMap.keySet()){
			Flower f = flowerMap.get(k);
			if (f.getNum() == num){
				fd.add(f);
			}
		}
		return fd;
	}
	
	// �޸�ʳ��
	public boolean modifyFood(Flower f){
		Flower f1 = findFoodById(f.getId());
		if(f1 == null){
			System.out.println("��ǰ��Ų�����");
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
	
	public List<String> getRecommendFlower(){
		Flower f = null;
		List<String> list = new ArrayList<String>();
		for(String k : recoFlowerId){
			f = flowerMap.get(k);
			addString(list, f);
		}
		return list;
	}
	
	public List<String> getMaterFlower(String type){
		List<String> list = new ArrayList<String>();
		List<Flower> flist = this.findFlowerByMaterials(type);
		for(Flower f : flist){
			addString(list, f);
		}
		return list;
	}
	
	public List<String> getTypeFlower(String type){
		List<String> list = new ArrayList<String>();
		List<Flower> flist = this.findFlowerByType(type);
		for(Flower f : flist){
			addString(list, f);
		}
		return list;
	}
	
	public List<String> getNumFlower(int num){
		List<String> list = new ArrayList<String>();
		List<Flower> flist = this.findFlowerByNum(num);
		for(Flower f : flist){
			addString(list, f);
		}
		return list;
	}
	
	public List<String> getPriceFlower(double beg, double end){
		List<String> list = new ArrayList<String>();
		List<Flower> flist = this.findFlowerByPrice(beg, end);
		for(Flower f : flist){
			addString(list, f);
		}
		return list;
	}
	
	public void addString(List<String> list, Flower f){
		list.add(f.getId());
		list.add(f.getName());
		list.add(String.valueOf(f.getPrice()));
		list.add(f.getMaterials());
		list.add(f.getPackages());
		list.add(String.valueOf(f.getNum()));
		list.add(f.getType());
		list.add(f.getFlowerWord());
	}
	
	public static void main(String[] args) {
		FlowerManager fl = new FlowerManager();
		
		Flower f = new Flower("rr001", "���", 442.0,"��õ��","���",22,"���","������������ڸı�");
		if(fl.modifyFood(f)){
			System.out.println("�޸ĳɹ�");
		}
		fl.printList();
	}
}

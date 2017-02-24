package com.javateam1.restuarant.control;

import java.util.Scanner;

import com.javateam1.restuarant.model.Food;
import com.javateam1.restuarant.view.Menu;

public class FoodManager {
	private final Food[] foods = {
		new Food("外婆菜炒河虾", 42), new Food("香蕉鲈鱼", 42),
		new Food("拆骨肉焖蛋", 38),  new Food("锅巴盖肉", 38),
		new Food("农家一锅香", 42), new Food("大蒜叶炒湘西腊肉", 42),
		new Food("小炒黑山羊", 42), new Food("盐蛋黄水晶粉", 42),
		new Food("酱汁淮山", 42), new Food("青椒炒攸县香干", 42),
	};
	private Scanner sc = new Scanner(System.in);
	
	private Food[] foodList;  // 所有菜组成的一个菜单
	private int listLength;
	
	public FoodManager(){
		initFoodList();
	}
	public FoodManager(Food[] foodlist){
		initFoodList();
		System.arraycopy(foodlist, 0, this.foodList, 0, foodlist.length);
	}
	
	public void initFoodList(){
		foodList = new Food[100];
		listLength = 0;
		System.arraycopy(foods, 0, this.foodList, 0, foods.length);
		listLength = foods.length;
	}

	public Food[] getFoodList() {
		return foodList;
	}

	public void setFoodList(Food[] foodList) {
		this.foodList = foodList;
	}
	
	// 打印菜单列表
	public void printList(){
		System.out.printf("%s\t\t%s\n", "菜名", "价格");
		int index = 1;
		for (int i = 0; i < listLength; i++){
			Food f = foodList[i];
			if(f==null) break;
			if (f.isDelete()){
				System.out.print(index + ".");
				f.printInfo();
				index++;
			}
		}
	}
	
	// 添加食物
	public void addFood(Food f){
		int num = listLength;
		if (num < foodList.length-1){
			foodList[num] = f;
			listLength++;
		} else {
			System.out.println("你的菜单存储不够了，不能添加");
		}
	}
	
	public void addFood(){
		System.out.println("添加菜：");
		Food f = new Food();
		
		while(true){
			System.out.println("请输入菜名：");
			String name = sc.next();
			int index = findFood(name);  // 查找是否存在
			if ( index < 0){  // 数组里面没有，直接添加
				f.setName(name);
				System.out.println("请输入价格：");
				f.setPrice(sc.nextDouble());
				System.out.println("是否可查看(输入'y' or 'n')：");
				String isOrNo = sc.next();
				if (isOrNo.equals("y")){
					f.setDelete(true);
				} else {
					f.setDelete(false);
				}
				addFood(f);
				break;
			} else if(!foodList[index].isDelete()){  // 当前菜不可见，换句换说就是曾经被删除过
				foodList[index].setDelete(true);  //直接让它可见即可
				System.out.println("检测到你曾经添加过这道菜，需要修改内容吗？（'y' or 'n'）");
				foodList[index].printInfo();
				String str = sc.next();
				if (str.equals("y")){
					modifyFood(name);
					break;
				}else{
					break;
				}
			}else {  
				System.out.println("当前菜已存在");
				break;
			}
		}
		
		
	}
	
	// 删除食物
	public void deleteFood(int index){
		int indexTrue = 0; // 真实索引
		int indexVitral = 0; //虚拟打印索引
		for (int i = 0; i< listLength; i++){
			indexTrue = i;
			if (foodList[i].isDelete()){
				indexVitral++;
				if (indexVitral == index){
					break;
				}
			}
		}
		if (index >= 0 && index < listLength ){
			foodList[indexTrue].setDelete(false);
		} else {
			System.out.println("输入索引不存在");
		}
	}
	
	public void deleteFood(){
		System.out.println("删除菜：");
		System.out.println("请输入菜的索引：");
		int num = Menu.getInputIntNum();
		deleteFood(num);
	}
	
	// 查找食物
	public int findFood(String name){
		boolean isFind = false;
		int index = 0;
		for(int i = 0; i < listLength; i++){
			Food f = foodList[i];
			if (f == null) break;
			if (f.getName().equals(name)){
//				f.printInfo();
				isFind = true;
				index = i;
			}
		}
		if(!isFind){
			return -1;
		}
		return index;
	}
	
	public void findFood(){
		System.out.println("请输入要查询的菜名");
		String name = sc.next();
		int index = findFood(name);
		if( index < 0 || !foodList[index].isDelete()){
			System.out.println("输入菜名不存在，联系老板添加");
		}
	}
	
	// 修改食物
	public void modifyFood(String name){
		int index = findFood(name);
		if (index < 0){
			System.out.println("当前菜不存在");
			return;
		}
		System.out.println("请输入菜名(不变按'n'):");
		String str = sc.next();
		if(str.equals("n") || str.equals("N")){
			sc.nextLine();
		}else {
			foodList[index].setName(str);
		}
		
		System.out.println("请输入价格(不变按'n'):");
		String strP = sc.next();
		if(strP.equals("n") || strP.equals("N")){
			sc.nextLine();
		}else {
			double price = Double.valueOf(strP); 
			foodList[index].setPrice(price);
		}
	}
	public void modifyFood(){
		System.out.println("请输入你要修改的菜名：");
		String name = sc.next();
		modifyFood(name);
	}
	
	
	public static void main(String[] args) {
		FoodManager fl = new FoodManager();
		fl.printList();
		fl.addFood();
		fl.printList();
		fl.deleteFood();
		fl.printList();
		fl.modifyFood();
		fl.printList();
		fl.findFood();
		fl.printList();
	}
}

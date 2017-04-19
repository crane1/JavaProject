/**
 *   程序名称：图书管理系统
 *   功能说明：实现图书管理系统的 “增、删、改、查” 功能。
 *   做成者：ChianSofti.java170207.lizm    
 *   更新者：
 *   
 *   
 */
package com.bookmanager;

import java.util.Scanner;


/**
 *   类名称：图书馆理类
 *   类说明：对Book类对象使用数组存储，实现对象数组上的 “增、删、改、查” 功能。
 *   做成者：ChianSofti.java170207.lizm    
 *   更新者：
 *   
 *   
 */
public class BookManager {
	private final static Scanner sc = new Scanner(System.in);  
	private final static String[] BOOK_INFO = {
		"编号", "名称", "作者", "出版社", "总量", "余量", "类型"
	};
	private final static String[] ATTRS = {"bookName", "authorName"}; // 图书属性名 0 bookName， 1 authorName
	private Book[] bookList = null;
	private int listLength = 0;
	
	/**
	 * 
	 * 方法名： initBookList 初始化数组
	 * 功能说明：为第一次添加数组初始化数组，分配一个Book的内存
	 */
	public void initBookList(){
		bookList = new Book[1];
	}
	
	public boolean listIsNull(){
		return bookList == null;
	}
	/**
	 * 
	 * 方法名： findBookById 通过id查找Book信息
	 * 功能说明： 传入一个id，通过遍历Book数组，查找Book信息
	 * @param id 需要检索的id
	 * @return 返回查找到的Book数组下标索引
	 */
	public int findBookById(String id){
		int index = -1;
		if(listIsNull()){
			return -1;
		}
		for(int i = 0; i < bookList.length; i++){
			Book b = bookList[i];
			if(b.getBookId().equals(id)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 
	 * 方法名： findBookByName 通过图书名或作者名查找Book信息,
	 * 功能说明： 传入name和type，确定需要检索的属性名，通过遍历Book数组，查找Book信息,并返回一个索引列表
	 * @param name 需要检索的name，可以是图书名和作者名
	 * @return 放回查找到的Book数组下标索引的列表
	 */
	public int[] findBookByName(String name, String type){
		String indexStr = "";
		if(listIsNull()){
			return null;
		}
		for(int i = 0; i < bookList.length; i++){
			Book b = bookList[i];
			String attr = "";
			if(type.equals(ATTRS[0])){
				attr = b.getBookName();
			}else if(type.equals(ATTRS[1])){
				attr = b.getBookAuthor();
			}
			if(attr.equals(name)){
				indexStr = indexStr + i + ",";
			}
		}
		int[] indexIntArray = getIntArrayFromStr(indexStr);
		return indexIntArray;
	}
	
	
	/**
	 * 
	 * 方法名： getIntArrayFromStr 从一个逗号字符串中提取一个int数组
	 * 功能说明： 为了处理查询到结果有多个索引的情况，这个函数从得到的索引字符串中提取int数组的索引列表并返回
	 * @param indexStr 需要处理的索引列表字符串，中间用","分隔
	 * @return 放回处理后的int数组列表
	 */
	public int[] getIntArrayFromStr(String indexStr){
		indexStr = indexStr.substring(0, indexStr.length() - 1); //截取到最后一个","之前
		String[] indexStrArray = indexStr.split(",");
		int[] indexIntArray = new int[indexStrArray.length];
		for (int i = 0; i < indexStrArray.length; i++) {
			indexIntArray[i] = Integer.valueOf(indexStrArray[i]);
		}
		
		return indexIntArray;
	}
	
	/**
	 * 
	 * 方法名： creatNewBookList 创建新图书列表
	 * 功能说明： 根据添加和删除元素，对原数组进行扩充或缩小
	 * @param length 新数组的长度
	 */
	public void creatNewBookList(int length, int copyLength){
		if ( listIsNull()) {
			initBookList();
		}else {
			Book[] b = new Book[length];
			System.arraycopy(bookList, 0, b, 0, copyLength);
			bookList = b;
		}
	}
	
	/**
	 * 
	 * 方法名： setBookInfo 设置一本书的信息
	 * 功能说明： 当数组中没有元素时，调用这个方法，需要设置id，当有元素时，不需要这里设置id
	 * @param index  需要设置的下标
	 */
	public void setBookInfo(Book b){
		//创建表头时
		b.setBookName(getInputString(BOOK_INFO[1], null));
		b.setBookAuthor(getInputString(BOOK_INFO[2], null));
		b.setBookPublish(getInputString(BOOK_INFO[3], null));
		b.setBookTotalNum(getInputInt(BOOK_INFO[4], null));
		b.setBookRemainderNum(getInputInt(BOOK_INFO[5], null));
		b.setBookType(getInputString(BOOK_INFO[6], null));
	}
	
	/**
	 * 
	 * 方法名： addBook
	 * 功能说明： 
	 * @return
	 */
	public boolean addBook(){

		String id = getInputString(BOOK_INFO[0], null);
		int index = findBookById(id);
		
		if(index > 0){
			System.out.println("已检测到有此编号的书存在，为您添加库存");
			System.out.print("请输入添加的库存量：");
			Book b = bookList[index];
			int addNum = getInputInt(null,null);
			addBookNum(b, addNum);
			System.out.println("图书编号" + b.getBookId() + "添加库存" + addNum +"成功");
		}else{
			creatNewBookList(listLength + 1, listLength); // 在原数组的基础上多加一个
			//获取最后一个元素
			bookList[listLength] = new Book(); //初始化对象
			bookList[listLength].setBookId(id); // 设置对象id
			setBookInfo(bookList[listLength]); // 设置对象其他属性
			Book b = bookList[listLength];
			listLength++; // 数组长度+1
			System.out.println("图书编号" + b.getBookId() + "添加成功");
		}
		
		return true;
	}
	
	
	/**
	 * 
	 * 方法名： addBookNum 添加图书库存
	 * 功能说明： 添加图书总量和剩余数量
	 * @param b 需要添加的Book引用
	 * @param addNum  需要添加的数量
	 */
	public void addBookNum(Book b, int addNum){
		int oldTotal = b.getBookTotalNum();
		b.setBookTotalNum(oldTotal + addNum);
		int oldRemain = b.getBookRemainderNum();
		b.setBookRemainderNum(oldRemain + addNum);
	}
	
	
	
	private boolean modifyBook() {
		String id = getInputString(BOOK_INFO[0], null);
		int index = findBookById(id);
		if(index >= 0){
			System.out.println("原图书信息如下：");
			printBook(index);
			Book b = bookList[index];
			setBookInfo(b);
			System.out.println("图书编号" + b.getBookId() + "修改完成");
			return true;
		}else{
			System.out.println("所修改的图书编号不存在");
			return false;
		}
	}

	/**
	 * 
	 * 方法名： moveBookList  移动数组
	 * 功能说明： 在删除数组中元素时，从index位置开始把后面的元素移动到前面去
	 * @param index  需要开始移动元素的位置
	 */
	public void moveBookList(int index){
		for (int i = index; i < listLength - 1; i++) {
			bookList[index] = bookList[index + 1];
		}
	}
	
	/**
	 * 
	 * 方法名： deleteBook 删除一本书
	 * 功能说明： 删除一个bookList元素，并缩小数组长度
	 * @return 返回删除是否成功
	 */
	private boolean deleteBook() {
		String id = getInputString(BOOK_INFO[0], null);
		int index = findBookById(id);
		if(index >= 0){
			Book b = bookList[index];
			moveBookList(index);
			creatNewBookList(listLength-1, listLength - 1);
			listLength--;
			System.out.println("图书编号为：" + b.getBookId() + "删除成功");
			return true;
		}else{
			System.out.println("所删除的图书编号不存在");
			return false;
		}
		
	}
	
	/**
	 * 
	 * 方法名： getInputString  获取一个字符串输入
	 * 功能说明： 接收2个提示语，并打印，然后从键盘获取一个字符串输入
	 * @param info 书的属性信息
	 * @param other  其他需要的提示信息
	 * @return 返回从键盘接收到的字符串
	 */
	public String getInputString(String info, String other){
		printInfo(info, other);
		String value = sc.nextLine();
		exitSystem(value);
		return value;
	}
	
	/**
	 * 
	 * 方法名： getInputInt  获取一个整型输入
	 * 功能说明：  接收2个提示语，并打印，然后从键盘获取一行字符串输入，并使用正则表达式来判断是否是数字
	 *        如果是，则转换为整型输出，否则继续循环获取
	 * @param info 书的属性信息
	 * @param other 其他需要的提示信息
	 * @return 返回从键盘接收到的整型
	 */
	public int getInputInt(String info, String other){
		String str = null;  // 接收输入的字符
		int value = 0;  // 转换为数字的字符
		
		printInfo(info, other);
		while(true){
			str = sc.nextLine();
			exitSystem(str);
			if (str.matches("[0-9]+")){
				value = Integer.valueOf(str);
				break;
			}else{
				System.out.println("输入不匹配，请重新输入:");
			}
		}
		return value;
	}
	
	/**
	 * 
	 * 方法名： exitSystem  退出系统
	 * 功能说明： 如果接收到"exit"，系统退出
	 * @param value
	 */
	public void exitSystem(String value){
		//如果在任意地方输入"exit"， 则系统直接退出
		if(value.equals("exit")){
			System.out.println("程序强制退出");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * 方法名： printBookList 打印当前bookList中的所有元素
	 * 功能说明：bookList 非空情况下，打印当前bookList中的所有元素
	 */
	private void printBookList() {
		if(listIsNull()){
			System.out.println("当前书库没有书，赶快添加吧！");
			return;
		}
		for(Book b : bookList){
			System.out.println(b);
		}
		
	}
	
	/**
	 * 
	 * 方法名： printBooks  控制台打印一组书信息
	 * 功能说明： 在控制台打印给定bookList 索引列表的一组书籍元素
	 * @param indexArry 传入的索引列表
	 */
	private void printBooks(int[] indexArry) {
		for(int i = 0; i < indexArry.length; i++){
			int index = indexArry[i];
			System.out.println(bookList[index]);
		}
		
	}
	
	/**
	 * 
	 * 方法名： printBook  控制台打印书信息
	 * 功能说明： 在控制台打印给定bookList 索引的一个书籍元素
	 * @param index 传入的索引
	 */
	private void printBook(int index) {
		System.out.println(bookList[index]);
		
	}
	
	/**
	 * 
	 * 方法名： printInfo  输出提示语
	 * 功能说明： 根据传入提示语的不同输出提示语，如果info不为空，输出书属性的提示语
	 *  	   如果other不为空，输出一般提示语
	 *       如果前两个都为空则输出 “请输入：”表示序号输入提示语
	 * @param info 书的属性信息
	 * @param other 其他需要的提示信息
	 */
	public void printInfo(String info, String other){
		if(info != null){
			System.out.println("请输入图书" + info + ":");
		}else if(other != null){
			System.out.println(other);
		}else{
			System.out.println("请输入：");
		}
	}
	
	/**
	 * 
	 * 方法名： showMenu   程序的开始菜单
	 * 功能说明： 程序对外操作的窗口，展示程序的所有功能，并调用相应的方法
	 */
	public void showMenu(){
		while(true){
			System.out.println("\n************欢迎来到图书管理系统*************");
			System.out.println("*           请选择要执行的操作：                              *");
			System.out.println("*           1.查询                                                       *");
			System.out.println("*           2.添加                                                       *");
			System.out.println("*           3.删除                                                       *");
			System.out.println("*           4.修改                                                       *");
			System.out.println("*           5.退出系统                                                *");
			System.out.println("*           输入exit退出系统                                   *");
			int index = getInputInt(null, null);
			switch (index) {
			case 1:
				selectMenu();
				break;
			case 2:
				addBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				modifyBook();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("输入有误");
			}
		}
	}
	

	/**
	 * 
	 * 方法名： selectMenu 查询的菜单
	 * 功能说明：对查询分 编号，书名，作者 进行查询，调用相应的方法
	 */
	public void selectMenu(){
		while(true){
			System.out.println("\n请选择查询类型：\n1.编号\n2.书名\n3.作者\n4.库中所有\n5.返回上一层\n输入exit退出系统");
			int num = getInputInt(null, null);
			String info = "";
			int type = 0;  // 编号项
			int index = -1;
			int[] indexArry = null;
			switch(num){
			case 1:
				info = getInputString("编号", null);
				index = findBookById(info);
				break;
			case 2:
				info = getInputString("书名", null);
				indexArry = findBookByName(info, ATTRS[0]);
				type = 1;  // 作者
				break;
			case 3:
				info = getInputString("作者", null);
				indexArry = findBookByName(info, ATTRS[1]);
				type = 1;  // 作者
				break;
			case 4:
				printBookList();
				break;
			case 5:
				return;
			default:
				System.out.println("输入有误");
			}
			
			//区分返回值是一个还是多个
			if(type == 0){
				if (index >= 0) {
					printBook(index);
				}else{
					System.out.println("没有查询到数据");
				}
			}else{
				if(indexArry != null){
					printBooks(indexArry);
				}else{
					System.out.println("没有查询到数据");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BookManager lb = new BookManager();
		lb.showMenu();
	}
}

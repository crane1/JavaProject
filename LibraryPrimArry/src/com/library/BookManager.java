/**
 *   程序名称：图书管理系统，图书馆理类
 *   功能说明：实现图书管理系统的 “增、删、改、查” 功能。
 *   做成者：ChianSofti.java170207.lizm    2017年4月13日 下午7:15:14
 *   更新者：
 *   
 *   
 */

package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *   类名称：BookManager  图书管理类
 *   类说明：对图书信息管理的类，里面集成了增删改查的方法
 *   做成者：ChianSofti.java170207.lizm    2017年4月13日 下午7:15:14
 *   更新者：
 *   
 *
 */
public class BookManager {
	private final static Scanner sc = new Scanner(System.in);  
	private final static String[] bookInfo = {
		"编号", "名称", "作者", "出版社", "总量", "余量", "类型"
	};
	
	private String[] bookId = null;    //图书编号数组
	private String[] bookName = null;    //图书名称数组
	private String[] bookAuthor = null;    //图书作者数组
	private String[] bookPublish = null;    //图书出版社数组
	private int[] bookTotalNum = null;    //图书库存总量数组
	private int[] bookRemainderNum = null;    //图书库存余量数组
	private String[] bookType = null;    //图书类型数组
	private int bookListLength = 0;    //库中不同图书的数量
	
	/**
	 * 方法名：初始化数组
	 * 功能说明：为各个属性分配内存
	 */
	public void initBookList(){
		bookId = new String[1];
		bookName = new String[1];
		bookAuthor = new String[1];
		bookPublish = new String[1];
		bookTotalNum = new int[1];
		bookRemainderNum = new int[1];
		bookType = new String[1];
	}
	
	/**
	 * 
	 * 方法名： createNewBookList  动态的扩充或缩小原数组
	 * 功能说明： 当删除数组中元素时，创建新数组，把移动后的原数组中的元素拷贝到新数组
	 *         当给数组中添加元素时，创建原数组长度+1的新数组，把原数组中的元素拷贝的新数组中
	 * @param newLength  新数组的长度
	 * @param copyLength  原数组中需要拷贝的长度
	 */
	public void createNewBookList(int newLength, int copyLength){
		String[] nBookId = new String[newLength];
		String[] nBookName = new String[newLength];
		String[] nBookAuthor = new String[newLength];
		String[] nBookPublish = new String[newLength];
		int[] nBookTotalNum = new int[newLength];
		int[] nBookRemainderNum = new int[newLength];
		String[] nBookType = new String[newLength];
		
		System.arraycopy(bookId, 0, nBookId, 0, copyLength);
		System.arraycopy(bookName, 0, nBookName, 0, copyLength);
		System.arraycopy(bookAuthor, 0, nBookAuthor, 0, copyLength);
		System.arraycopy(bookPublish, 0, nBookPublish, 0, copyLength);
		System.arraycopy(bookTotalNum, 0, nBookTotalNum, 0, copyLength);
		System.arraycopy(bookRemainderNum, 0, nBookRemainderNum, 0, copyLength);
		System.arraycopy(bookType, 0, nBookType, 0, copyLength);
		
		bookId = nBookId;
		bookName = nBookName;
		bookAuthor = nBookAuthor;
		bookPublish = nBookPublish;
		bookTotalNum = nBookTotalNum;
		bookRemainderNum = nBookRemainderNum;
		bookType = nBookType;
	}
	
	/**
	 * 
	 * 方法名： moveBookList  移动数组
	 * 功能说明： 在删除数组中元素时，从index位置开始把后面的元素移动到前面去
	 * @param index  需要开始移动元素的位置
	 */
	public void moveBookList(int index){
		for (int i = index; i < bookListLength - 1; i++) {
			bookId[index] = bookId[index + 1];
			bookName[index] = bookName[index + 1];
			bookAuthor[index] = bookAuthor[index + 1];
			bookPublish[index] = bookPublish[index + 1];
			bookTotalNum[index] = bookTotalNum[index + 1];
			bookRemainderNum[index] = bookRemainderNum[index + 1];
			bookType[index] = bookType[index + 1];
		}
	}
	
	/**
	 * 
	 * 方法名： addBook  给数组中添加新元素
	 * 功能说明： 如果数组为空，则先初始化数组，
	 *        否则，先查询数组中是否有该id，有，则添加元素的库存
	 *        没有，则创建一个大于原数组+1的数组，再为最后一个元素赋值
	 * @return 返回是否添加成功
	 */
	public boolean addBook(){
		if(bookListLength == 0){
			initBookList();
			setBookInfo(bookListLength);
			return true;
		}
		
		String id = getInputString(bookInfo[0], null);
		int index = findBookById(id);
		if(index >= 0){
			int addNum = getInputInt(null, "检测到图书库中已有书籍，请输入添加数量");
			bookTotalNum[index] += addNum;
			bookRemainderNum[index] += addNum;
			System.out.println("检测到图书库中已有书籍，已自动添加库存");
		}else{
			createNewBookList(bookListLength + 1, bookListLength);
			bookId[bookListLength] = id;
			setBookInfo(bookListLength);
			bookListLength++;
		}
		
		System.out.println("图书《" + bookName[bookListLength-1] + "》添加完成");
		return true;
	}
	
	/**
	 * 
	 * 方法名： setBookInfo 设置一本书的信息
	 * 功能说明： 当数组中没有元素时，调用这个方法，需要设置id，当有元素时，不需要这里设置id
	 * @param index  需要设置的下标
	 */
	public void setBookInfo(int index){
		//创建表头时
		if(index == 0){
			bookId[bookListLength] = getInputString(bookInfo[0], null);
		}
		
		bookName[index] = getInputString(bookInfo[1], null);
		bookAuthor[index] = getInputString(bookInfo[2], null);
		bookPublish[index] = getInputString(bookInfo[3], null);
		bookTotalNum[index] = getInputInt(bookInfo[4], null);
		bookRemainderNum[index] = getInputInt(bookInfo[5], null);;
		bookType[index] = getInputString(bookInfo[6], null);
	}
	
	/**
	 * 
	 * 方法名： deleteBook  删除数组中的一条书的信息
	 * 功能说明： 根据bookId, 查找数组中的元素，如果存在，在数组中删除这个条数据，
	 *         删除时需要调用moveBookList(int index)方法进行
	 *         元素移动，并调用createNewBookList(int newLength, int copyLength)方法对数组长度进行
	 *         缩小
	 * @return 返回true或false是否删除成功
	 */
	public boolean deleteBook(){
		String id = getInputString(bookInfo[0], null);
		
		int index = findBookById(id);
		if(index >= 0){
			moveBookList(index);
			createNewBookList(bookListLength-1, bookListLength-1);
			bookListLength--;
			System.out.println("图书编号为：" + bookId[index] + "删除成功");
			return true;
		}else{
			System.out.println("所删除的图书编号不存在");
			return false;
		}
	}
	
	/**
	 * 
	 * 方法名： findBookByString  通过字符串查找book信息
	 * 功能说明： 通过传入bookId或者bookName的数组，以及字符串信息，对数组进行检索
	 * @param infoArray  需要检索的数组
	 * @param infoString 检索字符串
	 * 
	 * @return 返回查找到的索引 index
	 */
	public int findBookByString(String[] infoArray, String infoValue) {
		System.out.println(infoValue);
		int index = -1;
		for (int i = 0; i < bookListLength; i++) {
			if(infoArray[i].equals(infoValue)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 
	 * 方法名： findBookById  通过bookId查找book信息
	 * 功能说明： 通过调用findBookByString(String[] infoArray, String infoString)并传入bookId
	 *         查找
	 * @param id 需要查询的bookId
	 * @return 返回查找到的索引 index
	 */
	
	public int findBookById(String id){
		return findBookByString(bookId, id);
	}
	
	/**
	 * 
	 * 方法名： findBookByName  通过bookName查找book信息
	 * 功能说明： 通过调用findBookByString(String[] infoArray, String infoString)并传入bookName
	 *         查找
	 * @param name 需要查询的bookName
	 * @return 返回查找到的索引 index
	 */
	public int findBookByName(String name){
		return findBookByString(bookName, name);
	}
	
	/**
	 * 
	 * 方法名： findBookByAuthor  通过bookAuthor查找book信息
	 * 功能说明： 对数组进行遍历，找出所有与bookAuthor相同的book信息
	 * @param authorName   需要查询的authorName
	 *
	 * @return 返回查找到的索引列表 indexList
	 */
	public List<Integer> findBookByAuthor(String authorName){
		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < bookListLength; i++) {
			if(bookAuthor[i].equals(authorName)){
				indexList.add(i);
			}
		}
		return indexList;
	}
	
	/**
	 * 
	 * 方法名： modifyBook 修改book信息
	 * 功能说明： 通过id获取到book信息，并修改
	 * @return 返回true或false是否修改成功
	 */
	public boolean modifyBook(){
		String id = getInputString(bookInfo[0], null);
		int index = findBookById(id);
		if(index >= 0){
			System.out.println("原图书信息如下：");
			printBook(index);
			setBookInfo(index);
			System.out.println("图书编号" + bookId[index] + "修改完成");
			return true;
		}else{
			System.out.println("所修改的图书编号不存在");
			return false;
		}
	}
	
	/**
	 * 
	 * 方法名： printBook  打印一条数据
	 * 功能说明： 通过传入的index 获取到对应book信息，并打印素有属性
	 * @param index 需要打印的book 在数组中的索引位置
	 */
	public void printBook(int index){
		System.out.println(
				bookInfo[0] + ":" + bookId[index] + " " + 
				bookInfo[1] + ":" + bookName[index] + " " + 
				bookInfo[2] + ":" + bookAuthor[index] + " " + 
				bookInfo[3] + ":" + bookPublish[index] + " " + 
				bookInfo[4] + ":" + bookTotalNum[index] + " " + 
				bookInfo[5] + ":" + bookRemainderNum[index] + " " + 
				bookInfo[6] + ":" + bookType[index]);
	}
	
	/**
	 * 
	 * 方法名： printBooks  打印多条book数据
	 * 功能说明： 通过传入的索引列表 获取到对应book信息，并打印素有属性
	 * @param indexs  索引列表，需要打印的所有book在数组中的索引位置 
	 */
	public void printBooks(List<Integer> indexs){
		for(int i : indexs){
			printBook(i);
		}
	}
	
	/**
	 * 
	 * 方法名： printBookList 打印数组中所有book信息
	 * 功能说明：打印数组中所有book信息
	 */
	public void printBookList(){
		if(bookListLength == 0){
			System.out.println("库中没有图书");
		}
		for (int i = 0; i < bookListLength; i++) {
			printBook(i);
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
	
	public void exitSystem(String value){
		//如果在任意地方输入"exit"， 则系统直接退出
		if(value.equals("exit")){
			System.out.println("程序强制退出");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * 方法名： getInputInt  获取一个整型输入
	 * 功能说明：  接收2个提示语，并打印，然后从键盘获取一个整型输入，并处理类型不匹配异常
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
			System.out.println("************欢迎来到图书管理系统*************");
			System.out.println("*           1.查询图书                                                *");
			System.out.println("*           2.添加图书                                                *");
			System.out.println("*           3.删除图书                                                *");
			System.out.println("*           4.修改图书                                                *");
			System.out.println("*           5.查看所有图书                                        *");
			System.out.println("*           6.退出系统                                                *");
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
				printBookList();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("输入有误");
				break;
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
			System.out.println("请选择查询类型：1.编号 2.书名 3.作者 4.返回上一层");
			int num = getInputInt(null, null);
			String info = "";
			int type = 0;  // 前两项
			int index = -1;
			List<Integer> indexs = null;
			switch(num){
			case 1:
				info = getInputString("编号", null);
				index = findBookById(info);
				break;
			case 2:
				info = getInputString("书名", null);
				index = findBookByName(info);
				break;
			case 3:
				info = getInputString("作者", null);
				indexs = findBookByAuthor(info);
				type = 1;  // 作者
				break;
			case 4:
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
				if(indexs != null){
					printBooks(indexs);
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

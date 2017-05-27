package com.library.manager;

import java.util.List;

import com.library.model.Book;
import com.library.model.User;
import com.library.tools.ConstStr;
import com.library.tools.Tools;

public class Menu {
	public static BookManager bookManager = new BookManager();
	public static RecordManager recordManager = new RecordManager();
	public static UserManager userManager = new UserManager();
	
	/**
	 * ��ʾ���˵�������
	 * 1.��¼
	 * 2.ע��
	 * 3.�鿴�����û�
	 * ��������
	 */
	public static void showMainMenu(){
		while(true){
			Tools.printContent("Mes_menuWelcom");
			Tools.printContent("Mes_login");
			Tools.printContent("Mes_register");
			
			String str = Tools.getInputInt("Mes_selectOperation");
			int type = -1;
			if(Tools.isBack(str)){
				return;
			}else{
				type = Integer.parseInt(str);
			}
			handleMainMenu(type);
		}
	}
	
	/**
	 * �������˵�ѡ��ֱ���ò�ͬ����
	 * @param type ѡ��ֵ
	 */
	public static void handleMainMenu(int type){
		switch(type){
		case ConstStr.LOGIN_USER:
			User user = userManager.login();
			if(user != null){
				userManager.addOnlineUser(user);
				showUserMenu(user);
			}
			
			break;
		case ConstStr.REGISTER_USER:
			userManager.register();
			break;
		case ConstStr.BACK:
			return;
		default:
			Tools.printContent("Mes_noIndefineOperation");
		}
	}
	
	/**
	 * 
	 * �������� showMainMenu ��ʾ���˵�<br>
	 * ����˵���� ��ʾ���˵�<br>
	 */
	public static void showUserMenu(User user){
		while(true){
			if(userManager.isNormal(user)){
				showNormalMenu();
			}else if(userManager.isManager(user)){
				showManagerMenu();
			}else{
				showAdminMenu();
			}
			showBackPromt();
			
			String str = Tools.getInputInt("Mes_selectOperation");
			int type = -1;
			if(Tools.isBack(str)){
				return;
			}else{
				type = Integer.parseInt(str);
			}
			
			//�����ͨ�û��������1�����벻�Ϸ�
			if(userManager.isNormal(user) && type > 1){
				Tools.printContent("Mes_noIndefineOperation");
				continue;
			//�������ͨ�û�����ͨ����Ա�������ͨ�˵�������
			}else if(userManager.isManager(user) || userManager.isNormal(user)){
				handleNormalMenu(type);
			}else if(userManager.isAdmin(user)){
				handleAdminMenu(type);
			}
		}
	}
	
	public static void showBackPromt(){
		Tools.printContent("Mes_inputBack");
	}
	public static void showNormalMenu(){
		Tools.printContent("Mes_findBooks");
	}
	
	public static void showManagerMenu(){
		showNormalMenu();
		Tools.printContent("Mes_addBooks");
		Tools.printContent("Mes_modBooks");
		Tools.printContent("Mes_delBooks");
		
	}
	
	public static void handleNormalMenu(int type){
		switch(type){
		case ConstStr.FIN_BOOK:
			showFindMenu();
			break;
		case ConstStr.ADD_BOOK:
			bookManager.operateBook(ConstStr.ADD_BOOK);
			break;
		case ConstStr.MOD_BOOK:
			bookManager.operateBook(ConstStr.MOD_BOOK);
			break;
		case ConstStr.DEL_BOOK:
			bookManager.operateBook(ConstStr.DEL_BOOK);
			break;
		default:
			Tools.printContent("Mes_noIndefineOperation");
		}
	}
	
	public static void showAdminMenu(){
		Tools.printContent("Mes_lookAll");
		Tools.printContent("Mes_addUser");
		Tools.printContent("Mes_modUser");
		Tools.printContent("Mes_delUser");
	}
	
	public static void handleAdminMenu(int type){
		switch(type){
		case ConstStr.FIND_USER:  
			userManager.printUsers();
			break;
		case ConstStr.ADD_USER:
			userManager.addUser();
			break;
		case ConstStr.MOD_USER:
			userManager.modifyUser();
			break;
		case ConstStr.DEL_USER:
			userManager.deleteUser();
			break;
		default:
			Tools.printContent("Mes_noIndefineOperation");
		}
	}
	
	public static void showFindMenu(){
		while(true){
			Tools.printContent("Mes_selectFindType");
			Tools.printContent("Attr_Id");
			Tools.printContent("Attr_name");
			Tools.printContent("Attr_author");
			Tools.printContent("Attr_publish");
			Tools.printContent("Attr_type");
			
			showBackPromt();
			String str = Tools.getInputInt("Mes_selectOperation");
			int type = -1;
			if(Tools.isBack(str)){
				return;
			}else{
				type = Integer.parseInt(str);
			}
			
			String keyWord = Tools.getInputString("Mes_inputFindContent");
			switch(type){
			case ConstStr.ATTR_ID:
				Book book= bookManager.findBookById(keyWord);
				if(book == null){
					Tools.printContent("Mes_noFindRecord");
				}else{
					bookManager.printBook(book);
				}
				
				break;
			case ConstStr.ATTR_NAME:
			case ConstStr.ATTR_AUTHOR:
			case ConstStr.ATTR_PUBLISH:
			case ConstStr.ATTR_TYPE:
				List<Book> books = bookManager.findBookByKeyWord(keyWord, type);
				if(books.size() == 0){
					Tools.printContent("Mes_noFindRecord");
				}else{
					bookManager.printBooks(books);
				}
				
				break;
			case ConstStr.BACK:
				return;
			default:
				Tools.printContent("Mes_noIndefineOperation");
			}
		}
	}
	
	public static void main(String[] args) {
		Menu.showMainMenu();
	}

}

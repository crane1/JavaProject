/**
 *   �������ƣ��û�������
 *   ����˵�������ڶ��û���Ϣ����"����ɾ���ġ���"����¼��ע�Ṧ��
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��19�� ����7:55:55
 *   �����ߣ�
 *   
 *   
 */
package com.library.manager;

import java.util.ArrayList;
import java.util.List;

import com.library.model.User;
import com.library.tools.ConstStr;
import com.library.tools.Tools;

/**
 *   �����ƣ��û�������
 *   ��˵�������ڶ��û���Ϣ����"����ɾ���ġ���"����¼��ע�Ṧ��
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��19�� ����7:55:55
 *   �����ߣ�
 *   
 *   
 */
public class UserManager {
	List<User> userList = new ArrayList<User>();
	
	
	/**
	 * 
	 * �������� addUser ����û�<br>
	 * ����˵���� ����в���һ������<br>
	 * @param user ��Ҫ�������Ϣ
	 * @return �����Ƿ���ӳɹ�<br>
	 */
	public boolean addUser(User user){
		boolean flag = userList.add(user);
		if(flag){
			Tools.printContent("Mes_userSucceedAdd");
		}else{
			Tools.printContent("Mes_userFailedAdd");
		}
		
		return flag;
	}
	
	/**
	 * 
	 * �������� collectUserInfo �ռ��û���Ϣ<br>
	 * ����˵���� �ռ��û���Ϣ���������û���Ϣ<br>
	 * @return �����û���Ϣ<br>
	 */
	private User collectUserInfo(boolean needId) {
		User newUser = new User();
		String id = null;
		if(needId){
			id = getInputInfo("Mes_inputUserId","Mes_idCannotEmpty");
		}
		
		
		String name = Tools.getInputString("Mes_inputUserName"); // ����name
		String pwd = getInputPwd(); //��������
		
		//�´����û�����������Ϣ�������û�
		setUserInfo(newUser, id, name, pwd);
		return newUser;
	}
	
	/**
	 * 
	 * �������� getInputId ���������id<br>
	 * ����˵���� ���������id�����ж�id����Ϊ��<br>
	 * @return ����id<br>
	 */
	public String getInputInfo(String promt1, String promt2){
		String str = "";
		
		while(true){
			str = Tools.getInputString(promt1);
			if(str.equals("")){
				Tools.getInputString(promt2);
			}else{
				break;
			}
		}
		
		return str;
	}
	
	public String getInputPwd(){
		String pwd = "";
		while(true){
			pwd = Tools.getInputString("Mes_inputUserPwd");
			String pwdConfirm = Tools.getInputString("Mes_confirmPwd");
			if(!pwd.equals("")&&!pwd.equals(pwdConfirm)){
				Tools.printContent("Mes_pwdIsError");
			}else{
				break;
			}
		}
		
		return pwd;
	}
	
	/**
	 * 
	 * �������� deleteUser ɾ���û�<br>
	 * ����˵�������ݴ����id�����û��Ƿ���ڣ�������ɾ���û���Ϣ<br>
	 * @param id  ��Ҫ������id
	 * @return ����ɾ���Ƿ�ɹ�<br>
	 */
	public boolean deleteUser(String id){
		User result = findUserById(id); //��ѯ�Ƿ��и��û�
		boolean flag = false; // ��ʾɾ���������
		
		// �����Ϊ����ɾ������user
		if(result != null){
			userList.remove(result);
			flag = true;
		}else{
			Tools.printContent("Mes_userNoExist");
		}
		
		return flag;
	}
	
	public void setUserInfo(User user, String id, String name, String pwd){
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
	}
	
	
	/**
	 * 
	 * �������� modifyUser �޸��û���Ϣ<br>
	 * ����˵���� ͨ��id�������û��Ƿ���ڣ�������ڣ����޸��û���Ϣ<br>
	 * @param id ��Ҫ�޸ĵ��û�id
	 * @return �����޸Ľ��<br>
	 */
	public boolean modifyUser(String id){
		User result = findUserById(id); //��ѯ�Ƿ��и��û�
		boolean flag = false; // ��ʾ�޸Ĳ������
		
		// �����Ϊ�����޸Ĵ���user
		if(result != null){
			User newUser = collectUserInfo(false);
			setUserInfo(result, id, newUser.getName(), newUser.getPwd());
			flag = true;
		}else{
			Tools.printContent("Mes_userNoExist");
		}
		
		return flag;
	}
	
	/**
	 * 
	 * �������� findUserById �����û�idȡ�����û�<br>
	 * ����˵���� ͨ��������û�id�ڿ��м����û��Ƿ���ڣ������򷵻ظ��û�<br>
	 * @param id ��Ҫ������id
	 * @return ���ز��ҵ����û����ã�û�鵽�ķ���null<br>
	 */
	public User findUserById(String id) {
		User result = null;
		
		for(User user : userList){
			if(user.getId().equals(id)){
				result = user;
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * �������� findUsersByKeyName ͨ���û����ּ����û������ܴ��ڶ��<br>
	 * ����˵���� ͨ���û������ڿ��м����û��Ƿ���ڣ����ܴ��ڶ���û�<br>
	 * @param name ��Ҫ�������û���
	 * @return ���ؼ��������û��б�<br>
	 */
	public List<User> findUsersByKeyName(String name){
		List<User> users = new ArrayList<User>();
		
		for(User user : userList){
			if(user.getName().equals(name)){
				users.add(user);
			}
		}
		
		return users;
	}
	
	public User login(){
		String id = getInputInfo("Mes_inputUserId","Mes_idCannotEmpty");
		String name = getInputInfo("Mes_inputUserPwd","Mes_nameCannotEmpty");
		User user = login(id, name);
		return user;
				
	}
	
	/**
	 * 
	 * �������� Login  �û���¼<br>
	 * ����˵���� ���ݴ����id�����û��Ƿ���ڣ��������ж������Ƿ�һ�£�һ���򷵻��û�����һ������ʾ<br>
	 * @param id ��Ҫ������id
	 * @param pwd ��Ҫ�ȶԵ�����
	 * @return ���رȶ�id������֮��Ľ�������һ�·��ز��ҵ�������û�<br>
	 */
	public User login(String id, String pwd){
		User result = null;  //���ص�¼�������ȷ��¼�����û�
		
		User find = findUserById(id); // ���ҵ�ǰid���û��Ƿ����
		
		//�ȶ�id������
		if(find == null){
			Tools.printContent("Mes_userNoExist");
		}else{
			if(!find.getPwd().equals(pwd)){
				Tools.printContent("Mes_pwdIsError");
			}else{
				result = find;
				Tools.printContent("Mes_loginSucceed");
			}
		}
		
		return result;
	}
	
	public boolean register(){
		User userInfo = collectUserInfo(true);
		User find = findUserById(userInfo.getId()); 
		
		if(find != null){
			Tools.printContent("Mes_userHasExist");
		}else{
			addUser(userInfo);
		}
		return false;
	}
	
	public void showUserMenu(){
		while(true){
			
			Tools.printContent("Mes_login");
			Tools.printContent("Mes_register");
			Tools.printContent("Mes_lookAll");
			int type = Tools.getInputInt("Mes_selectOperation");
			switch(type){
			case ConstStr.LOGIN_USER:
				login();
				break;
			case ConstStr.REGISTER_USER:
				register();
				break;
			case ConstStr.FIND_USER:
				printUsers();
				break;
			case ConstStr.BACK:
				return;
			default:
				Tools.printContent("Mes_noIndefineOperation");
			}
		}
	}

	private void printUsers() {
		if(userList.size() == 0){
			Tools.printContent("Mes_userNoExist");
		}
		for(User user : userList){
			Tools.printContent2(user.toString());
		}
		
	}

	public static void main(String[] args) {
		new UserManager().showUserMenu();
	}
}

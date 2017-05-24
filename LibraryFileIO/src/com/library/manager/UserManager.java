/**
 *   程序名称：用户管理类
 *   程序说明：用于对用户信息进行"增、删、改、查"，登录、注册功能
 *   做成者：ChianSofti.java170207.lizm    2017年4月19日 下午7:55:55
 *   更新者：
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
 *   类名称：用户管理类
 *   类说明：用于对用户信息进行"增、删、改、查"，登录、注册功能
 *   做成者：ChianSofti.java170207.lizm    2017年4月19日 下午7:55:55
 *   更新者：
 *   
 *   
 */
public class UserManager {
	List<User> userList = new ArrayList<User>();
	
	
	/**
	 * 
	 * 方法名： addUser 添加用户<br>
	 * 功能说明： 像库中插入一条数据<br>
	 * @param user 需要插入的信息
	 * @return 返回是否添加成功<br>
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
	 * 方法名： collectUserInfo 收集用户信息<br>
	 * 功能说明： 收集用户信息，并返回用户信息<br>
	 * @return 返回用户信息<br>
	 */
	private User collectUserInfo(boolean needId) {
		User newUser = new User();
		String id = null;
		if(needId){
			id = getInputInfo("Mes_inputUserId","Mes_idCannotEmpty");
		}
		
		
		String name = Tools.getInputString("Mes_inputUserName"); // 接收name
		String pwd = getInputPwd(); //接收密码
		
		//新创建用户，并设置信息，返回用户
		setUserInfo(newUser, id, name, pwd);
		return newUser;
	}
	
	/**
	 * 
	 * 方法名： getInputId 接收输入的id<br>
	 * 功能说明： 接收输入的id，并判断id不能为空<br>
	 * @return 返回id<br>
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
	 * 方法名： deleteUser 删除用户<br>
	 * 功能说明：根据传入的id检索用户是否存在，存在则删除用户信息<br>
	 * @param id  需要检索的id
	 * @return 返回删除是否成功<br>
	 */
	public boolean deleteUser(String id){
		User result = findUserById(id); //查询是否有该用户
		boolean flag = false; // 表示删除操作结果
		
		// 如果不为空则删除传入user
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
	 * 方法名： modifyUser 修改用户信息<br>
	 * 功能说明： 通过id检索到用户是否存在，如果存在，则修改用户信息<br>
	 * @param id 需要修改的用户id
	 * @return 返回修改结果<br>
	 */
	public boolean modifyUser(String id){
		User result = findUserById(id); //查询是否有该用户
		boolean flag = false; // 表示修改操作结果
		
		// 如果不为空则修改传入user
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
	 * 方法名： findUserById 根据用户id取检索用户<br>
	 * 功能说明： 通过传入的用户id在库中检索用户是否存在，存在则返回该用户<br>
	 * @param id 需要检索的id
	 * @return 返回查找到的用户引用，没查到的返回null<br>
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
	 * 方法名： findUsersByKeyName 通过用户名字检索用户，可能存在多个<br>
	 * 功能说明： 通过用户名字在库中检索用户是否存在，可能存在多个用户<br>
	 * @param name 需要检索的用户名
	 * @return 返回检索到的用户列表<br>
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
	 * 方法名： Login  用户登录<br>
	 * 功能说明： 根据传入的id查找用户是否存在，存在则判断密码是否一致，一致则返回用户，不一致则提示<br>
	 * @param id 需要检索的id
	 * @param pwd 需要比对的密码
	 * @return 返回比对id和密码之后的结果，如果一致返回查找到的这个用户<br>
	 */
	public User login(String id, String pwd){
		User result = null;  //返回登录结果，正确登录返回用户
		
		User find = findUserById(id); // 查找当前id的用户是否存在
		
		//比对id和密码
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

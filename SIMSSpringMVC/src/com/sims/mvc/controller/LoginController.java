package com.sims.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.service.ILoginService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.tools.JsonMesg;

@Controller("hello")
public class LoginController extends MultiActionController{
	private String userId = null;
	private String pwd = null;
	private String permissions = null;
	private String randNum = null;  
	private String result = null;
	
	private String name;	//����
	private String sex;	//�Ա�
	private String age;	//����
	private String gradFrom;	//��ҵԺУ
	private String tel;	//�绰����
	private String addr;	//��ַ
	private String idCard;	//���֤����
	private String email;	//����
	
	private ILoginService loginService;
	private IStudentService studentService;
	
	private Student stuInfo = null;

	public LoginController() {
	}
	
	


	@RequestMapping("/login.action")
	public String login(String userId,String pwd, String permissions
			) throws Exception{
		
		System.out.println("login------------------");
		JsonMesg mesg = null;
		/*HttpSession session = req.getSession();
		String RandNum = (String)session.getAttribute("rand");
		*/
		System.out.println("userId:" + userId);
		System.out.println("pwd:" + pwd);
		System.out.println("permissions:" + permissions);
		

		if (userId == null || pwd == null || userId.equals("")
				|| pwd.equals("") || permissions == null
				|| permissions.equals("")) {
			
			mesg = new JsonMesg("1");
			result = JsonMesg.getJsonObject(mesg);
			
			return "success";
		} else {
			stuInfo = loginService.checkStuInfo(userId, pwd);

			if (stuInfo == null) {
				mesg = new JsonMesg("2");
				result = JsonMesg.getJsonObject(mesg);
				return "success";
			} else {
				
				String permi = loginService.checkPermi(permissions, userId);
				
				//��֤Ȩ��
				if (permi.equals("fail")) {
					
					mesg = new JsonMesg("3");
					result = JsonMesg.getJsonObject(mesg);
					return "success";
				}
				
				/*//��֤����֤
				if (!randNum.equals(RandNum)) {
					
					mesg = new JsonMesg("4");
					result = JsonMesg.getJsonObject(mesg);
					return "success";
				}
				
				// ��stuInfo�ŵ�session
				session.setAttribute("stuInfo", stuInfo);
*/
				if (stuInfo.getId().equals("admin")) {
					permissions = "admin";
				}
				
				mesg = new JsonMesg("5");
				result = JsonMesg.getJsonObject(mesg);
//				session.setAttribute("user_right", permissions);
				
				// ��ת��ѧ����Ϣչʾҳ��
				return "success";
			}
		}
		
	}
	
//	public String regist() throws Exception{
//		if(userId==null||userId.equals("")||pwd==null||pwd.equals("")||name==null||name.equals("")||sex==null||sex.equals("")
//				 ||age==null||age.equals("")||gradFrom.equals("")||gradFrom==null||tel.equals("")||tel==null||
//				 addr.equals("")||addr==null||idCard.equals("")||idCard==null||email.equals("")||email==null){
//			addActionError("ע����Ϣ��������");
//			return INPUT;
//		}else{
//			stuInfo=new Student();
//			stuInfo.setId(userId);
//			stuInfo.setName(name);
//			stuInfo.setSex(sex);
//			stuInfo.setAge(Integer.parseInt(age));
//			stuInfo.setGradFrom(gradFrom);
//			stuInfo.setTel(Long.parseLong(tel));
//			stuInfo.setAddr(addr);
//			stuInfo.setIdCard(idCard);
//			stuInfo.setEmail(email);
//			 int addStudent = studentService.addStudent(stuInfo, pwd);
//			 if(addStudent>0){
//				 addActionMessage("ע��ɹ���");
//				 return SUCCESS;
//			 }else{
//				 addActionError("ע��ʧ��");
//				 return INPUT;
//			 }
//		}
//		
//		
//	}
//	
//	public String passwordBack(){
//		if(userId.equals("")||userId==null||tel.equals("")||tel==null||idCard.equals("")||idCard==null||email.equals("")||email==null){
//			addActionError("�ύ��Ϣ����Ϊ�գ�");
//			return INPUT;
//		}else{
//			Student stu = studentService.findStudentById(userId);
//			if(stu.getTel()==Long.parseLong(tel)){
//				if(stu.getIdCard().equals(idCard)){
//					if(stu.getEmail().equals(email)){
//						addActionMessage("�޸ĳɹ���");
//						return SUCCESS;
//					}else{
//						addActionError("���䲻��ȷ��");
//						return INPUT;
//					}
//				}else{
//					addActionError("���֤����ȷ��");
//					return INPUT;
//				}
//			}else{
//				addActionError("�ֻ��Ų���ȷ��");
//				return INPUT;
//			}
//		}
//	}
//	
//	String apwd=null;
//	
//	public String getApwd() {
//		return apwd;
//	}
//
//	public void setApwd(String apwd) {
//		this.apwd = apwd;
//	}
//
//	public String changePwd(){
//		 if(apwd!=null||!apwd.equals("")||pwd!=null&&!pwd.equals("")||!userId.equals("")||userId!=null){
//			 if(apwd.equals(pwd)){
//				 int changePwd = studentService.modifyStudentPWD(userId, pwd);
//				 if(changePwd>0){
//					 addActionMessage("ע��ɹ���");
//					 return SUCCESS;
//				 }else{
//					 addActionError("�޸�ʧ�ܣ�����������");
//					 return INPUT;
//				 }
//			 }else{
//				 addActionError("�������벻��ͬ");
//				 return INPUT;
//			 }
//			
//		 }else{
//			 addActionError("�������ݲ���Ϊ��");
//			 return INPUT;
//		 }
//	 
//		
//		
//	}
//	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Student getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(Student stuInfo) {
		this.stuInfo = stuInfo;
	}

	public String getRandNum() {
		return randNum;
	}

	public void setRandNum(String randNum) {
		this.randNum = randNum;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGradFrom() {
		return gradFrom;
	}

	public void setGradFrom(String gradFrom) {
		this.gradFrom = gradFrom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	
}

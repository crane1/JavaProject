package com.sims.mvc.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.StudentServiceImp;
import com.sims.mvc.tools.JsonMesg;
import com.sims.mvc.tools.PageManager;

public class SuperAdminAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private IStudentService stuService = null;
	private String result = null;
	
	private String oper = null;
	private String page = null;
	
	private String id = null;
	
	public SuperAdminAction(){
		stuService = new StudentServiceImp();
	}
	
	public String queryAdmin() throws Exception {
		PageManager.setFindPage(page);  //���÷�ҳ��ǰҳ
		
		//��ȡһ�����Ա�б�
		List<Student> list = stuService.findStudentByIsAdmin();
		
		if(list != null){
			System.out.println("list-------------1" + list.size());
			result =  JsonMesg.getJsonArray(list);
		}else{
			System.out.println("list-------------2" + list.size());
			JsonMesg mesg = new JsonMesg("��������");
			result = JsonMesg.getJsonObject(mesg);
		}
		return SUCCESS;	
	}
	
	public String addAdmin() throws Exception {
		Student stu = stuService.findStudentById(id);
		
		//��ӵ��˲�����
		if(stu == null){
			JsonMesg mesg = new JsonMesg("��ӵ�id�����ڣ�����");
			result = JsonMesg.getJsonObject(mesg);
		}
		
		//��ӵ����Ѿ��ǹ���Ա��
		else if(stu.getNormal_manager() == 1){
			JsonMesg mesg = new JsonMesg("�Ѿ��ǹ���Ա�ˣ������ظ���ӣ�����");
			result = JsonMesg.getJsonObject(mesg);
		}else{
			//���ô�idΪ����Ա
			stu.setNormal_manager(1);
			int res = stuService.modifyStudent(stu);
			if(res == 1){
				JsonMesg mesg = new JsonMesg("id:" + id + ",�Ѿ����Ϊ����Ա");
				result = JsonMesg.getJsonObject(mesg);
			}
		}
		
		return SUCCESS;
	}
	
	public String delAdmin() throws Exception{
		Student stu = stuService.findStudentById(id);
		
		//������˲�����
		if(stu == null){
			JsonMesg mesg = new JsonMesg("�����id�����ڣ�����");
			result = JsonMesg.getJsonObject(mesg);
			return SUCCESS;
		}
		
		//������˲��ǹ���Ա
		else if(stu.getNormal_manager() != 1){
			JsonMesg mesg = new JsonMesg("��id���ǹ���Աid�����ܰ��⣡����");
			result = JsonMesg.getJsonObject(mesg);
			return SUCCESS;
		}
		
		//�����id����Ա
		stu.setNormal_manager(0);
		int res = stuService.modifyStudent(stu);
		if(res == 1){
			JsonMesg mesg = new JsonMesg("id:" + id + ",�Ѿ�������");
			result = JsonMesg.getJsonObject(mesg);
			return SUCCESS;
		}
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	

}

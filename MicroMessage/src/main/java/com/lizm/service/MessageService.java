package com.lizm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lizm.beans.Message;
import com.lizm.dao.MessageDao;

public class MessageService {
	public List<Message> queryMesgList(String commod, String descript){
		return new MessageDao().queryMesgList(commod, descript);
	}
	
	public Message queryMesgById(String id){
		Message message = null;
		if(id != null && !"".equals(id)){
			message = new MessageDao().queryMesgById(Integer.parseInt(id));
		}
		return message;
	}
	
	public int deleteOne(String id){
		int result = 0;
		if(id != null && !"".equals(id)){
			result = new MessageDao().deleteOne(Integer.parseInt(id));
		}
		return result;
	}
	
	public int deleteBatch(String[] ids){
		int result = 0;
		List<String> idList = Arrays.asList(ids);
		List<Integer> idIntList = new ArrayList<Integer>();
		for(String id : idList){
			//这里假设页面上接收的是int数字
			idIntList.add(Integer.parseInt(id));
		}
		result = new MessageDao().deleteBatch(idIntList);
		return result;
	}
	
	public int InsertOne(String commod, String descript, String context){
		Message message = new Message();
		message.setCommod(commod);
		message.setDescript(descript);
		message.setContext(context);
		
		int result = new MessageDao().InsertOne(message);
		return result;
	}
	
	public int UpdateOne(Message message){
		int result = new MessageDao().UpdateOne(message);
		return result;
	}
}

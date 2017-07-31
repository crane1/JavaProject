package com.lizm.dao;

import java.io.IOException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lizm.beans.Message;
import com.lizm.db.DBAccess;

public class MessageDao {
	
	public List<Message> queryMesgList(String commod, String descript){
		Message message = new Message();
		message.setCommod(commod);
		message.setDescript(descript);
		
		List<Message> mesgList = new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSeesion();
			mesgList = sqlSession.selectList("Message.queryMesgList",message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return mesgList;
	}
	
	public Message queryMesgById(int id){
		Message message = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSeesion();
			message = sqlSession.selectOne("Message.queryMesgById", id);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
		return message;
	}
	
	public int deleteOne(int id){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return result;
	}
	
	public int deleteBatch(List<Integer> ids){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return result;
	}
	
	public int InsertOne(Message message){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.insert("Message.InsertOne",message);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return result;
	}
	
	public int UpdateOne(Message message){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.update("Message.UpdateOne",message);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return result;
	}
	
	@Test
	public void testDao(){
		new MessageDao().queryMesgList("", ""); 
	}
		
}

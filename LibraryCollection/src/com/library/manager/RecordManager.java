package com.library.manager;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Record;
import com.library.model.User;
import com.library.tools.Tools;

public class RecordManager {
	private List<Record> recordList = null; //记录库
	
	
	/**
	 * 添加借阅记录
	 * @param record 需要添加的记录<br>
	 * @return 添加是否成功
	 */
	public boolean addRecord(Record record) {
		if(recordList == null){
			recordList = new ArrayList<Record>();
		}
		boolean add = recordList.add(record);
		return add;
	}
	
	
	/**
	 * 根据记录id查询记录
	 * @param user 需要查询的用户
	 * @param id 需要查询的记录id
	 * @return 是否查询到记录
	 */
	public Record findRecordById(User user, String id){
		Record flag = null;
		for(Record r : recordList){
			if(user.getId().equals(r.getUserId()) && r.getId().equals(id)){
				flag = r;
			}
		}
		return flag;
	}
	
	/**
	 * 根据借阅图书id查询借阅记录
	 * @param user  查询用户
	 * @param bookId 所查询bookId
	 * @return 返回查询到的记录列表
	 */
	public List<Record> findRecordsByBookId(User user, String bookId) {
		List<Record> list = null;
		for(Record r : recordList){
			if(user.getId().equals(r.getUserId()) && r.getBookId().equals(bookId)){
				if(list == null){
					list = new ArrayList<Record>();
				}
				list.add(r);
			}
		}
		return list;
	}
	
	/**
	 * 根据借阅用户id查询借阅记录
	 * @param user  需要查询的用户
	 * @return 返回记录列表
	 */
	public List<Record> findRecordsByBook(User user) {
		List<Record> list = null;
		for(Record r : recordList){
			if(r.getUserId().equals(user.getId())){
				if(list == null){
					list = new ArrayList<Record>();
				}
				list.add(r);
			}
		}
		return list;
	}
	
	public List<Record> findRecordsByDate(User user, String date) {
		List<Record> list = null;
		for(Record r : recordList){
			if(user.getId().equals(r.getUserId()) && r.getDate().equals(date)){
				if(list == null){
					list = new ArrayList<Record>();
				}
				list.add(r);
			}
		}
		return list;
	}
	
	public boolean deleteRecord(User user, String id){
		boolean flag = false;
		Record r = findRecordById(user, id);
		if(r != null){
			flag = recordList.remove(r);
		}else{
			Tools.printContent("Mes_recordNoExist");
		}
		return flag;
	}
	
	public boolean deleteRecord(User user){
		String id = Tools.getInputString("Mes_inputRecordId");
		return deleteRecord(user, id);
	}

}

package com.library.manager;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Record;
import com.library.model.User;
import com.library.tools.Tools;

public class RecordManager {
	private List<Record> recordList = null; //��¼��
	
	
	/**
	 * ��ӽ��ļ�¼
	 * @param record ��Ҫ��ӵļ�¼<br>
	 * @return ����Ƿ�ɹ�
	 */
	public boolean addRecord(Record record) {
		if(recordList == null){
			recordList = new ArrayList<Record>();
		}
		boolean add = recordList.add(record);
		return add;
	}
	
	
	/**
	 * ���ݼ�¼id��ѯ��¼
	 * @param user ��Ҫ��ѯ���û�
	 * @param id ��Ҫ��ѯ�ļ�¼id
	 * @return �Ƿ��ѯ����¼
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
	 * ���ݽ���ͼ��id��ѯ���ļ�¼
	 * @param user  ��ѯ�û�
	 * @param bookId ����ѯbookId
	 * @return ���ز�ѯ���ļ�¼�б�
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
	 * ���ݽ����û�id��ѯ���ļ�¼
	 * @param user  ��Ҫ��ѯ���û�
	 * @return ���ؼ�¼�б�
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

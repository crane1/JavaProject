package com.library.manager;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Record;
import com.library.model.User;
import com.library.tools.ConstStr;
import com.library.tools.ReadList;
import com.library.tools.SaveList;
import com.library.tools.Tools;

public class RecordManager {
	private static List<Record> recordList = new ArrayList<Record>();
	
	static{
		recordList = ReadList.readData(ConstStr.READ_RECORD);
		if(recordList.size() != 0){
			System.out.println("��¼�б�������");
		}
	}
	/**
	 * 
	 * �������� addRecord ���һ����¼<br>
	 * ����˵���� ����ļ�¼�������һ����¼<br>
	 * @param record
	 * @return<br>
	 */
	public boolean addRecord(Record record){
		boolean add = false;
		Record result = recordIsExist(record);
		if(result != null){
			Tools.printContent("Mes_recordIsExist");
		}else{
			add = recordList.add(record);
		}
		if(add){
			SaveList.saveData(recordList, ConstStr.SAVE_RECORD);
		}
		return add;
	}
	
	/**
	 * 
	 * �������� recordIsExist ��ѯ��¼�Ƿ����<br>
	 * ����˵���� <br>
	 * @param record
	 * @return<br>
	 */
	public Record recordIsExist(Record record){
		return findRecordById(record.getId());
	}
	
	/**
	 * 
	 * �������� deletRecord ɾ��һ����¼<br>
	 * ����˵�����ӽ��ļ�¼����ɾ��һ����¼ <br>
	 * @param record
	 * @return<br>
	 */
	public boolean deletRecord(Record record){
		boolean remove = false;
		Record result = recordIsExist(record);
		if(result == null){
			Tools.printContent("Mes_recordIsNotExist");
		}else{
			remove = recordList.remove(result);
		}
		
		if(remove){
			SaveList.saveData(recordList, ConstStr.SAVE_RECORD);
		}
		return remove;
	}
	
	/**
	 * 
	 * �������� updateRecord ����һ����¼<br>
	 * ����˵���� �Խ��ļ�¼�����һ����¼���и���<br>
	 * @param record
	 * @return<br>
	 */
	public boolean updateRecord(Record record){
		boolean update = false;
		Record result = recordIsExist(record);
		if(result == null){
			Tools.printContent("Mes_recordIsNotExist");
		}else{
			result = record;
			update = true;
		}
		
		if(update){
			SaveList.saveData(recordList, ConstStr.SAVE_RECORD);
		}
		return update;
	}
	
	public Record findRecordById(int id){
		Record isExist = null;
		for(Record r : recordList){
			if(r.getId() == id){
				isExist = r;
				break;
			}
		}
		return isExist;
	}
	
	public List<Record> findRecordsByString(User user, int attrType, String keyword){
		List<Record> isFind = new ArrayList<Record>();
		for(Record r : recordList){
			String attr = "";
			switch(attrType){
			case ConstStr.RECORD_BOOKID:
				attr = r.getBookId();
				break;
			case ConstStr.RECORD_USERID:
				attr = r.getUserId();
				break;
			case ConstStr.RECORD_DATE:
				attr = r.getDate();
			}
			
			String part = String.format(".*%s.*",keyword);
			if(attr.matches(part)){
				//�������ͨ�û������ѯ��ǰ��¼�Ƿ��Ǹ��û���¼
				if(Menu.userManager.isNormal(user) && r.getUserId().equals(user.getId())){
					isFind.add(r);
				}else if(Menu.userManager.isManager(user)){
					isFind.add(r);
				}
			}
		}
		
		return isFind;
	}
	
	public List<Record> findRecordsByBookId(User user, String bookId ){
		List<Record> isFind = new ArrayList<Record>();
		for(Record r : recordList){
			if(r.getBookId().equals(bookId)){
				//�������ͨ�û������ѯ��ǰ��¼�Ƿ��Ǹ��û���¼
				if(user.getType() == 0 && r.getUserId().equals(user.getId())){
					isFind.add(r);
				}else if(user.getType() == 1){
					isFind.add(r);
				}
				
			}
		}
		
		return isFind;
	}
	
	public List<Record> findRecordsByDate(User user, String date){
		List<Record> isFind = new ArrayList<Record>();
		for(Record r : recordList){
			if(r.getDate().equals(date)){
				if(user.getType() == 0 && r.getUserId().equals(user.getId())){
					isFind.add(r);
				}else if(user.getType() == 1){
					isFind.add(r);
				}
			}
		}
		return isFind;
	}
	
	public List<Record> findRecordsByUser(User user){
		List<Record> isFind = new ArrayList<Record>();
		for(Record r : recordList){
			if(r.getUserId().equals(user.getId())){
				isFind.add(r);
			}
		}
		return isFind;
	}
	
	public void showUserRecords(User user){
		List<Record> records = findRecordsByUser(user);
		for(Record r : records){
			Tools.printContent2(r.toString());
		}
	}
	
	public void showRecords(List<Record> list){
		for(Record r : list){
			Tools.printContent2(r.toString());
		}
	}

	public static List<Record> getRecordList() {
		return recordList;
	}

	public static void setRecordList(List<Record> recordList) {
		RecordManager.recordList = recordList;
	}
	
	
}

/**
 *   �������ƣ�ͼ�����ϵͳ
 *   ����˵����ʵ��ͼ�����ϵͳ�� ������ɾ���ġ��顱 ���ܡ�
 *   �����ߣ�ChianSofti.java170207.lizm    
 *   �����ߣ�
 *   
 *   
 */
package com.bookmanager;

import java.util.Scanner;


/**
 *   �����ƣ�ͼ�������
 *   ��˵������Book�����ʹ������洢��ʵ�ֶ��������ϵ� ������ɾ���ġ��顱 ���ܡ�
 *   �����ߣ�ChianSofti.java170207.lizm    
 *   �����ߣ�
 *   
 *   
 */
public class BookManager {
	private final static Scanner sc = new Scanner(System.in);  
	private final static String[] BOOK_INFO = {
		"���", "����", "����", "������", "����", "����", "����"
	};
	private final static String[] ATTRS = {"bookName", "authorName"}; // ͼ�������� 0 bookName�� 1 authorName
	private Book[] bookList = null;
	private int listLength = 0;
	
	/**
	 * 
	 * �������� initBookList ��ʼ������
	 * ����˵����Ϊ��һ����������ʼ�����飬����һ��Book���ڴ�
	 */
	public void initBookList(){
		bookList = new Book[1];
	}
	
	public boolean listIsNull(){
		return bookList == null;
	}
	/**
	 * 
	 * �������� findBookById ͨ��id����Book��Ϣ
	 * ����˵���� ����һ��id��ͨ������Book���飬����Book��Ϣ
	 * @param id ��Ҫ������id
	 * @return ���ز��ҵ���Book�����±�����
	 */
	public int findBookById(String id){
		int index = -1;
		if(listIsNull()){
			return -1;
		}
		for(int i = 0; i < bookList.length; i++){
			Book b = bookList[i];
			if(b.getBookId().equals(id)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 
	 * �������� findBookByName ͨ��ͼ����������������Book��Ϣ,
	 * ����˵���� ����name��type��ȷ����Ҫ��������������ͨ������Book���飬����Book��Ϣ,������һ�������б�
	 * @param name ��Ҫ������name��������ͼ������������
	 * @return �Żز��ҵ���Book�����±��������б�
	 */
	public int[] findBookByName(String name, String type){
		String indexStr = "";
		if(listIsNull()){
			return null;
		}
		for(int i = 0; i < bookList.length; i++){
			Book b = bookList[i];
			String attr = "";
			if(type.equals(ATTRS[0])){
				attr = b.getBookName();
			}else if(type.equals(ATTRS[1])){
				attr = b.getBookAuthor();
			}
			if(attr.equals(name)){
				indexStr = indexStr + i + ",";
			}
		}
		int[] indexIntArray = getIntArrayFromStr(indexStr);
		return indexIntArray;
	}
	
	
	/**
	 * 
	 * �������� getIntArrayFromStr ��һ�������ַ�������ȡһ��int����
	 * ����˵���� Ϊ�˴����ѯ������ж���������������������ӵõ��������ַ�������ȡint����������б�����
	 * @param indexStr ��Ҫ����������б��ַ������м���","�ָ�
	 * @return �Żش�����int�����б�
	 */
	public int[] getIntArrayFromStr(String indexStr){
		indexStr = indexStr.substring(0, indexStr.length() - 1); //��ȡ�����һ��","֮ǰ
		String[] indexStrArray = indexStr.split(",");
		int[] indexIntArray = new int[indexStrArray.length];
		for (int i = 0; i < indexStrArray.length; i++) {
			indexIntArray[i] = Integer.valueOf(indexStrArray[i]);
		}
		
		return indexIntArray;
	}
	
	/**
	 * 
	 * �������� creatNewBookList ������ͼ���б�
	 * ����˵���� ������Ӻ�ɾ��Ԫ�أ���ԭ��������������С
	 * @param length ������ĳ���
	 */
	public void creatNewBookList(int length, int copyLength){
		if ( listIsNull()) {
			initBookList();
		}else {
			Book[] b = new Book[length];
			System.arraycopy(bookList, 0, b, 0, copyLength);
			bookList = b;
		}
	}
	
	/**
	 * 
	 * �������� setBookInfo ����һ�������Ϣ
	 * ����˵���� ��������û��Ԫ��ʱ�����������������Ҫ����id������Ԫ��ʱ������Ҫ��������id
	 * @param index  ��Ҫ���õ��±�
	 */
	public void setBookInfo(Book b){
		//������ͷʱ
		b.setBookName(getInputString(BOOK_INFO[1], null));
		b.setBookAuthor(getInputString(BOOK_INFO[2], null));
		b.setBookPublish(getInputString(BOOK_INFO[3], null));
		b.setBookTotalNum(getInputInt(BOOK_INFO[4], null));
		b.setBookRemainderNum(getInputInt(BOOK_INFO[5], null));
		b.setBookType(getInputString(BOOK_INFO[6], null));
	}
	
	/**
	 * 
	 * �������� addBook
	 * ����˵���� 
	 * @return
	 */
	public boolean addBook(){

		String id = getInputString(BOOK_INFO[0], null);
		int index = findBookById(id);
		
		if(index > 0){
			System.out.println("�Ѽ�⵽�д˱�ŵ�����ڣ�Ϊ����ӿ��");
			System.out.print("��������ӵĿ������");
			Book b = bookList[index];
			int addNum = getInputInt(null,null);
			addBookNum(b, addNum);
			System.out.println("ͼ����" + b.getBookId() + "��ӿ��" + addNum +"�ɹ�");
		}else{
			creatNewBookList(listLength + 1, listLength); // ��ԭ����Ļ����϶��һ��
			//��ȡ���һ��Ԫ��
			bookList[listLength] = new Book(); //��ʼ������
			bookList[listLength].setBookId(id); // ���ö���id
			setBookInfo(bookList[listLength]); // ���ö�����������
			Book b = bookList[listLength];
			listLength++; // ���鳤��+1
			System.out.println("ͼ����" + b.getBookId() + "��ӳɹ�");
		}
		
		return true;
	}
	
	
	/**
	 * 
	 * �������� addBookNum ���ͼ����
	 * ����˵���� ���ͼ��������ʣ������
	 * @param b ��Ҫ��ӵ�Book����
	 * @param addNum  ��Ҫ��ӵ�����
	 */
	public void addBookNum(Book b, int addNum){
		int oldTotal = b.getBookTotalNum();
		b.setBookTotalNum(oldTotal + addNum);
		int oldRemain = b.getBookRemainderNum();
		b.setBookRemainderNum(oldRemain + addNum);
	}
	
	
	
	private boolean modifyBook() {
		String id = getInputString(BOOK_INFO[0], null);
		int index = findBookById(id);
		if(index >= 0){
			System.out.println("ԭͼ����Ϣ���£�");
			printBook(index);
			Book b = bookList[index];
			setBookInfo(b);
			System.out.println("ͼ����" + b.getBookId() + "�޸����");
			return true;
		}else{
			System.out.println("���޸ĵ�ͼ���Ų�����");
			return false;
		}
	}

	/**
	 * 
	 * �������� moveBookList  �ƶ�����
	 * ����˵���� ��ɾ��������Ԫ��ʱ����indexλ�ÿ�ʼ�Ѻ����Ԫ���ƶ���ǰ��ȥ
	 * @param index  ��Ҫ��ʼ�ƶ�Ԫ�ص�λ��
	 */
	public void moveBookList(int index){
		for (int i = index; i < listLength - 1; i++) {
			bookList[index] = bookList[index + 1];
		}
	}
	
	/**
	 * 
	 * �������� deleteBook ɾ��һ����
	 * ����˵���� ɾ��һ��bookListԪ�أ�����С���鳤��
	 * @return ����ɾ���Ƿ�ɹ�
	 */
	private boolean deleteBook() {
		String id = getInputString(BOOK_INFO[0], null);
		int index = findBookById(id);
		if(index >= 0){
			Book b = bookList[index];
			moveBookList(index);
			creatNewBookList(listLength-1, listLength - 1);
			listLength--;
			System.out.println("ͼ����Ϊ��" + b.getBookId() + "ɾ���ɹ�");
			return true;
		}else{
			System.out.println("��ɾ����ͼ���Ų�����");
			return false;
		}
		
	}
	
	/**
	 * 
	 * �������� getInputString  ��ȡһ���ַ�������
	 * ����˵���� ����2����ʾ�����ӡ��Ȼ��Ӽ��̻�ȡһ���ַ�������
	 * @param info ���������Ϣ
	 * @param other  ������Ҫ����ʾ��Ϣ
	 * @return ���شӼ��̽��յ����ַ���
	 */
	public String getInputString(String info, String other){
		printInfo(info, other);
		String value = sc.nextLine();
		exitSystem(value);
		return value;
	}
	
	/**
	 * 
	 * �������� getInputInt  ��ȡһ����������
	 * ����˵����  ����2����ʾ�����ӡ��Ȼ��Ӽ��̻�ȡһ���ַ������룬��ʹ��������ʽ���ж��Ƿ�������
	 *        ����ǣ���ת��Ϊ����������������ѭ����ȡ
	 * @param info ���������Ϣ
	 * @param other ������Ҫ����ʾ��Ϣ
	 * @return ���شӼ��̽��յ�������
	 */
	public int getInputInt(String info, String other){
		String str = null;  // ����������ַ�
		int value = 0;  // ת��Ϊ���ֵ��ַ�
		
		printInfo(info, other);
		while(true){
			str = sc.nextLine();
			exitSystem(str);
			if (str.matches("[0-9]+")){
				value = Integer.valueOf(str);
				break;
			}else{
				System.out.println("���벻ƥ�䣬����������:");
			}
		}
		return value;
	}
	
	/**
	 * 
	 * �������� exitSystem  �˳�ϵͳ
	 * ����˵���� ������յ�"exit"��ϵͳ�˳�
	 * @param value
	 */
	public void exitSystem(String value){
		//���������ط�����"exit"�� ��ϵͳֱ���˳�
		if(value.equals("exit")){
			System.out.println("����ǿ���˳�");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * �������� printBookList ��ӡ��ǰbookList�е�����Ԫ��
	 * ����˵����bookList �ǿ�����£���ӡ��ǰbookList�е�����Ԫ��
	 */
	private void printBookList() {
		if(listIsNull()){
			System.out.println("��ǰ���û���飬�Ͽ���Ӱɣ�");
			return;
		}
		for(Book b : bookList){
			System.out.println(b);
		}
		
	}
	
	/**
	 * 
	 * �������� printBooks  ����̨��ӡһ������Ϣ
	 * ����˵���� �ڿ���̨��ӡ����bookList �����б��һ���鼮Ԫ��
	 * @param indexArry ����������б�
	 */
	private void printBooks(int[] indexArry) {
		for(int i = 0; i < indexArry.length; i++){
			int index = indexArry[i];
			System.out.println(bookList[index]);
		}
		
	}
	
	/**
	 * 
	 * �������� printBook  ����̨��ӡ����Ϣ
	 * ����˵���� �ڿ���̨��ӡ����bookList ������һ���鼮Ԫ��
	 * @param index ���������
	 */
	private void printBook(int index) {
		System.out.println(bookList[index]);
		
	}
	
	/**
	 * 
	 * �������� printInfo  �����ʾ��
	 * ����˵���� ���ݴ�����ʾ��Ĳ�ͬ�����ʾ����info��Ϊ�գ���������Ե���ʾ��
	 *  	   ���other��Ϊ�գ����һ����ʾ��
	 *       ���ǰ������Ϊ������� �������룺����ʾ���������ʾ��
	 * @param info ���������Ϣ
	 * @param other ������Ҫ����ʾ��Ϣ
	 */
	public void printInfo(String info, String other){
		if(info != null){
			System.out.println("������ͼ��" + info + ":");
		}else if(other != null){
			System.out.println(other);
		}else{
			System.out.println("�����룺");
		}
	}
	
	/**
	 * 
	 * �������� showMenu   ����Ŀ�ʼ�˵�
	 * ����˵���� �����������Ĵ��ڣ�չʾ��������й��ܣ���������Ӧ�ķ���
	 */
	public void showMenu(){
		while(true){
			System.out.println("\n************��ӭ����ͼ�����ϵͳ*************");
			System.out.println("*           ��ѡ��Ҫִ�еĲ�����                              *");
			System.out.println("*           1.��ѯ                                                       *");
			System.out.println("*           2.���                                                       *");
			System.out.println("*           3.ɾ��                                                       *");
			System.out.println("*           4.�޸�                                                       *");
			System.out.println("*           5.�˳�ϵͳ                                                *");
			System.out.println("*           ����exit�˳�ϵͳ                                   *");
			int index = getInputInt(null, null);
			switch (index) {
			case 1:
				selectMenu();
				break;
			case 2:
				addBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				modifyBook();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("��������");
			}
		}
	}
	

	/**
	 * 
	 * �������� selectMenu ��ѯ�Ĳ˵�
	 * ����˵�����Բ�ѯ�� ��ţ����������� ���в�ѯ��������Ӧ�ķ���
	 */
	public void selectMenu(){
		while(true){
			System.out.println("\n��ѡ���ѯ���ͣ�\n1.���\n2.����\n3.����\n4.��������\n5.������һ��\n����exit�˳�ϵͳ");
			int num = getInputInt(null, null);
			String info = "";
			int type = 0;  // �����
			int index = -1;
			int[] indexArry = null;
			switch(num){
			case 1:
				info = getInputString("���", null);
				index = findBookById(info);
				break;
			case 2:
				info = getInputString("����", null);
				indexArry = findBookByName(info, ATTRS[0]);
				type = 1;  // ����
				break;
			case 3:
				info = getInputString("����", null);
				indexArry = findBookByName(info, ATTRS[1]);
				type = 1;  // ����
				break;
			case 4:
				printBookList();
				break;
			case 5:
				return;
			default:
				System.out.println("��������");
			}
			
			//���ַ���ֵ��һ�����Ƕ��
			if(type == 0){
				if (index >= 0) {
					printBook(index);
				}else{
					System.out.println("û�в�ѯ������");
				}
			}else{
				if(indexArry != null){
					printBooks(indexArry);
				}else{
					System.out.println("û�в�ѯ������");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BookManager lb = new BookManager();
		lb.showMenu();
	}
}

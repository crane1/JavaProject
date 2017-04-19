package com.library.bookmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import com.library.book.Book;
import com.library.tools.ConstStr;
import com.library.tools.Tools;

public class BookManager {
	private List<Book> bookList = new ArrayList<Book>(); //���
	
	public BookManager(){
		//׼�����԰���Դ
		Tools.initResourse();
	}
	
	/**
	 * 
	 * �������� setBookInfo ����ͼ����Ϣ<br>
	 * ����˵���� ����ͼ���Id�����������Ϣ��id��Ϣ�����֮ǰ�Ĳ�ѯʱ�ṩ���޸�ʱ���޸�id<br>
	 * @param book<br>
	 */
	public void setBookInfo(Book book){
		book.setBookName(Tools.getInputString("Mes_inputBookName"));
		book.setBookAuthor(Tools.getInputString("Mes_inputBookAuthor"));
		book.setBookPublish(Tools.getInputString("Mes_inputBookPublish"));
		book.setBookType(Tools.getInputString("Mes_inputBookType"));
		book.setBookTotalNum(Tools.getInputInt("Mes_inputBookTotal"));
		book.setBookRemainderNum(Tools.getInputInt("Mes_inputBookRemain"));
	}
	
	/**
	 * 
	 * �������� operateBook ����һ��BookԪ��<br>
	 * ����˵���� ����һ���������ͣ��Ƚ����û������һ��id�������б��в��ң����ز�ѯ������ٽ��з������<br>
	 * @param type ��������
	 * @return ���ز����Ƿ�ɹ�<br>
	 */
	public boolean operateBook(int type){
		String id = Tools.getInputString("Mes_inputBookId"); // ����һ��id
		Book isExist = findBookById(id);  //��¼��ѯ���
		boolean flag = false; //��¼����������Ƿ���ӳɹ�
		
		switch(type){
		case ConstStr.ADD_BOOK:
			flag = addBook(isExist, id);
			break;
		case ConstStr.DEL_BOOK:
			flag = deleteBook(isExist);
			break;
		case ConstStr.MOD_BOOK:
			flag = modifyBook(isExist);
			break;
		default:
			Tools.printContent("Mes_noIndefineOperation");
		}
		
		return flag;
	}
	
	/**
	 * 
	 * �������� addBook  ���ͼ��<br>
	 * ����˵���� ���ͼ�����Ѵ��ڣ���ô����ӣ��������<br>
	 * @param book �������Ҫ��ӵ�Ԫ��<br>
	 * @return �����Ƿ���ӳɹ�<br>
	 */
	public boolean addBook(Book book, String id){
		boolean flag = false; //�������
		
		// ��ѯ�����Ϊ�գ���ʾ����
		if (book != null) {
			Tools.printContent("Mes_bookHasExist");
		} else {
			//������ͼ����Ϣ,����ӽ�ͼ���б�
			Book newbook = new Book();
			newbook.setBookId(id);
			setBookInfo(newbook);
			bookList.add(newbook);
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * �������� deleteBook ɾ��ͼ��<br>
	 * ����˵���� ���ݴ����ͼ����������������ɾ����������ʾ������<br>
	 * @param book �������Ҫɾ����Ԫ��<br>
	 * @return<br>
	 */
	public boolean deleteBook(Book book){
		boolean flag = false; //��¼����������Ƿ���ӳɹ�
		
		// ��ѯ�����Ϊ�գ���ʾ����
		if (book == null) {
			Tools.printContent("Mes_delBookNoExist");
		} else {
			//��ͼ���б���ɾ��ͼ��
			bookList.remove(book);
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * �������� modifyBook �޸�ͼ����Ϣ<br>
	 * ����˵���� ���ݴ����book����������������޸ģ���������ʾ������<br>
	 * @param book ��Ҫ�޸ĵ�ͼ��
	 * @return ���ز����Ƿ�ɹ�<br>
	 */
	public boolean modifyBook(Book book){
		boolean flag = false; //��¼����������Ƿ���ӳɹ�
		
		// ��ѯ�����Ϊ�գ���ʾ����
		if (book == null) {
			Tools.printContent("Mes_modBookNoExist");
		} else {
			//��ͼ����Ϣ�����޸�
			setBookInfo(book);
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * �������� findBookById ͨ��id��Book��Ϣ
	 * ����˵���� ͨ��id���Ψһ����������ѯBook��Ϣ
	 * @param id ��Ҫ��ѯ��id
	 * @return ��Ҫ���ز�ѯ����Book����
	 */
	public Book findBookById(String id){
		Book b = null;
		
		//ѭ���������������id��ͬ��bookԪ��
		for(Book book : bookList){
			if(book.getBookId().equals(id)){
				b = book;
			}
		}
		
		return b;
	}
	
	/**
	 * 
	 * �������� findBookByKeyWord ͨ���ؼ��ֺ����Ͳ�ѯͼ��<br>
	 * ����˵���� ���ݴ������ͻ�ȡ��Ӧ���ԣ���ͨ��name�ȶԲ����Ƿ����<br>
	 * @param keyWord ��Ҫ�����Ĺؼ���
	 * @param type
	 * @return<br>
	 */
	public List<Book> findBookByKeyWord(String keyWord, int type){
		//ʹ��list�б���ղ�ѯ�������õ��Ķ��Ԫ��ֵ
		List<Book> books = new ArrayList<Book>();
		
		//ѭ���������������name��ͬ��bookԪ��
		for(Book b : bookList){
			String attr = "";
			
			//���ݲ�ͬ����ȡ��ͬ������ֵ
			switch(type){
			case ConstStr.ATTR_NAME:
				attr = b.getBookName();
				break;
			case ConstStr.ATTR_AUTHOR:
				attr = b.getBookAuthor();
				break;
			case ConstStr.ATTR_PUBLISH:
				attr = b.getBookPublish();
				break;
			case ConstStr.ATTR_TYPE:
				attr = b.getBookType();
				break;
			default:
				Tools.printComment("");
			}
		
			String pattern = String.format(".*%s.*", keyWord);
			if(attr.matches(pattern)){
				books.add(b);
			}
		}
		
		return books;
	}
	
	public void printBook(Book book){
		Tools.printContent2(book.toString());
	}
	
	public void printBooks(List<Book> books){
		int i = 1;
		for(Book book : books){
			Tools.printContent2( i + "." + book.toString());
			i++;
		}
	}
	
	public static void main(String[] args) {
		new BookManager();
	}
}

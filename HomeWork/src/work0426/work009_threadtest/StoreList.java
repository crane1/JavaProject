package work0426.work009_threadtest;
import java.util.ArrayList;
import java.util.List;

public class StoreList {
	// Ʊ��
	public List<Ticket> list = new ArrayList<Ticket>();
	
	// ���Ʊ
	public  void push(Ticket ticket){
		list.add(ticket);
		System.out.println("��������" + ticket);
	}
	
	// ɾ��Ʊ
	public  void pop(){
		Ticket remove = list.remove(0);
		System.out.println("�����ѣ�" + remove);
	}
}

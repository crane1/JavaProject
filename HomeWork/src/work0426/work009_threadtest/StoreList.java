package work0426.work009_threadtest;
import java.util.ArrayList;
import java.util.List;

public class StoreList {
	// 票库
	public List<Ticket> list = new ArrayList<Ticket>();
	
	// 添加票
	public  void push(Ticket ticket){
		list.add(ticket);
		System.out.println("已生产：" + ticket);
	}
	
	// 删除票
	public  void pop(){
		Ticket remove = list.remove(0);
		System.out.println("已消费：" + remove);
	}
}

package work0426.work009_threadtest;


public class TicketTest {
	public static void main(String[] args) {
		StoreList store = new StoreList();
		Producer pro = new Producer(store);
		Customer cus = new Customer(store);
		
		pro.start();
		cus.start();
	}
}

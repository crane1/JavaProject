package work0426.work009_threadtest;


public class Producer extends Thread{
	private final int MAX_NUM = 100;
	private StoreList store = null;
	private int count = 1;
	
	public Producer(StoreList store){
		this.store = store;
	}
	
	public void push(){
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (store) {
				if(store.list.size() >= MAX_NUM){
					System.out.println("仓库已满，请通知消费者消费");
					store.notifyAll();
				}else{
					store.push(new Ticket(count, "南京k" + count));
					count++;
				}
			}
		}
		
		
	}
	
	@Override
	public void run() {
		push();
	}
}

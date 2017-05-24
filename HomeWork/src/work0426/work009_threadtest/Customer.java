package work0426.work009_threadtest;


public class Customer extends Thread{
	private StoreList store = null;
	
	public Customer(StoreList store){
		this.store = store;
	}
	
	public void pop(){
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (store) {
				if(store.list.size() <= 0){
					System.out.println("仓库已空，请通知生产者生产");
					try {
						store.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					store.pop();
				}
			}
		}
		
	}
	
	@Override
	public void run() {
		pop();
	}
}

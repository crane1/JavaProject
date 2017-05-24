package work0426.work009_threadtest;

public class Ticket {
	private int id;
	private String name;
	
	
	public Ticket(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ticket ±àºÅ£º" + id + ", ÄÚÈÝ" + name + "]";
	}
	
}

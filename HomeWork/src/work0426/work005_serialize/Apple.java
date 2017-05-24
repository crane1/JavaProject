package work0426.work005_serialize;
import java.io.Serializable;


public class Apple implements Serializable{
	private int id;
	
	public Apple(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + "]";
	}
	
	
		
}
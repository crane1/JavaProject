package work0426.work001_apple;

//1.ƻ�����������򣬰���С���򣬰�������Сһ������(��������)
public class Apple{
	private double weight; //����
	private double volume; //��С�����
	
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apple(double weight, double volume) {
		super();
		this.weight = weight;
		this.volume = volume;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	@Override
	public String toString() {
		return String.format("Apple [weight=%013.2f, volume=%013.2f]", weight,volume);
	}
}

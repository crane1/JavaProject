package work0426.work010_settest;

//class Person {	
class Person implements Comparable<Person>{	
	private String name;
	private int age;
	
	public Person() {}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	/**
	 * 1.ArrayList 是可以重复的，即使是实现了hashCode和equals方法
	 * 2.LinkedList 是可以重复的，即使是实现了hashCode和equals方法
	 * 3.Vector 是可以重复的，即使是实现了hashCode和equals方法
	 * 4.HashSet 是不可以重复的，在实现了hashCode和equals方法之后
	 */
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age > o.age){
			return 1;
		}else if(this.age < o.age){
			return -1;
		}
		return 0;
	}
}

package test;

class Employee{
	private String name;
	private double salary;
	private double subsidy;
	
	public Employee(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}
	
	public double getTotalSalary(){
		return salary + subsidy;
	}
	public double calbackSalary(){
		double total_salary = getTotalSalary();
		double backSalary = total_salary - getTax(total_salary);
		return backSalary;
		
	}
	
	private double getTax(double salary){
		double upSalary = salary - 2000;
		double tax = 0;
		if(upSalary > 20000){
			tax = upSalary * 0.3;
		}else if(upSalary > 5000){
			tax = upSalary * 0.2;
		}else if(upSalary > 2000){
			tax = upSalary * 0.15;
		}else if(upSalary > 500){
			tax = upSalary * 0.1;
		}else if(upSalary > 0){
			tax = upSalary * 0.05;
		}else {
			tax = 0;
		}
		return tax;
	}
	
	public void printEmplyeeInfo(){
		System.out.println("员工" + name + "的税前收入为：" + getTotalSalary()
				+ "元，税后收入为" + calbackSalary() + "元，您缴纳的个人所得税为" + getTax(getTotalSalary()) + "元" );
	}
}
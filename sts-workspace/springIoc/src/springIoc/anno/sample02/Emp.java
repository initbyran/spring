package springIoc.anno.sample02;

public class Emp {

	private String name;
	private int age;
	
	public Emp() {
		this.name = "문성훈";
		System.out.println("Emp default constructor");
	}

	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("default 원래");
	}
	
	
	
	
	

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " +age;
	}
	
	
}

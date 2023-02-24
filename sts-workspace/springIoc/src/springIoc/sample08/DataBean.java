package springIoc.sample08;

public class DataBean {

	private String name;
	
	public DataBean() {
		System.out.println("DataBean default constructor");
	}

	public DataBean(String name) {
		super();
		this.name = name;
		System.out.println("생성자 ; " +name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

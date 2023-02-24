package springIoc.sample10;

public class TestBean {

	private DataBean data1;
	private DataBean data2;

	public TestBean() {
	    System.out.println("Test Bean default constructor");
	}
	
	public TestBean(DataBean data1, DataBean data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
		System.out.println("Test Bean constructor (parameter)");
	}

	public DataBean getData1() {
		return data1;
	}

	public void setData1(DataBean data1) {
		this.data1 = data1;
		System.out.println("setData1() setter");
	}

	public DataBean getData2() {
		return data2;
	}

	public void setData2(DataBean data2) {
		this.data2 = data2;
		System.out.println("setData2() setter");
	}
	
	
	
}


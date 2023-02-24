package springIoc.sample07;

public class Engineer {

	// 상속보다 interface를 통해 주입받는 것이 더 좋다 ; stratege pattern
	
	private Emp emp;
    private String dept;
    
    public Engineer() {
		// TODO Auto-generated constructor stub
	}

	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
    
	
   
}

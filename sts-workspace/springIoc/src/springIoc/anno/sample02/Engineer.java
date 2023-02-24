package springIoc.anno.sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Engineer { 

//	@Autowired
//	@Qualifier(value="emp1")
//	@Resource(name="emp1")
//	@Autowired(required=false)
	private Emp emp;
	private String dept;	
	private Emp emp2;
	
	public Engineer() {
		System.out.println("Engineer default constructor");
	}
	
	@Autowired
	public Engineer(Emp emp2) {
		super();
		this.emp2 = emp2;
		System.out.println("Engineer parameter ; "+emp2);
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Autowired(required=false)
	public void my_dept(String dept) {
	    // 일반method (setter와 비슷한 기능)
		this.dept = dept;
		System.out.println("일반 method()");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return emp + ", "+emp2 +", "+dept;
	}
}

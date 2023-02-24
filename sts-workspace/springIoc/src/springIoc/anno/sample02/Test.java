package springIoc.anno.sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",Emp.class);
		
		Engineer engineer = context.getBean("engineer", Engineer.class);
		
//		Engineer engineer1 = context.getBean("engineer", Engineer.class);
		
		System.out.println(engineer);
//		System.out.println(engineer1);
		
		((ClassPathXmlApplicationContext)context).close();

	}

}

package springIoc.sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// application context 객체 생성 -> Spring IoC Container 생성
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml", User.class);
		
		UserService service = context.getBean("userService", UserService.class);
		
		User user = context.getBean("obj1",User.class);
		
		service.addUser(user);
		
		((ClassPathXmlApplicationContext)context).close();
		

	}

}

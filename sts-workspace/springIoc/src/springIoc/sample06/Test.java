package springIoc.sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		//Application context
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", Output.class);
		
		MessageBean bean = context.getBean("myBean", MessageBean.class);
		
		bean.sayHello(); // 설정에 따라 console에 출력할 수도 있고 file에 출력할 수도 있다
		
		MessageBean bean1 = context.getBean("myBeanConsole", MessageBean.class);
		
		bean1.sayHello();
		
		// 상위 타입으로 형변환(casting)
		((ClassPathXmlApplicationContext)context).close();
		

	}

}

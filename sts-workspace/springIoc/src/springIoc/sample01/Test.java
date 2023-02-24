package springIoc.sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// Application context부터 생성해보아요
		// full-path : ApplicationContext context = new ClassPathXmlApplicationContext("springIoc/sample01/applicationContext.xml");
	   ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", MessageBean.class);
		// 두번째 parameter ; 찾을 xml의 class위치 설정
		

	   System.out.println("======IoC/DI 컨테이너 생성 =======");

	   // prototype과 singletone의 차이 
	   MessageBean myBean = context.getBean("messageBean", MessageBean.class);
	   myBean.sayHello();
	   System.out.println(myBean);
	   System.out.println(context.getBean("messageBean", MessageBean.class));
	   
	   // context는 interface이므로 close가 되지않으므로 형변환 필요
	   ((ClassPathXmlApplicationContext)context).close();
   		
	}
}

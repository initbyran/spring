package my.spring.springweb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{

	// static ; 객체 생성하지 않는다
	private static ApplicationContext ctx;
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// applicationContext ; root application context
	}
	
}

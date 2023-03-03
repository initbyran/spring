package my.spring.springweb.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// 수동으로 bean을 application context에 등록 : @Bean

@Configuration
public class LibraryComponent {

	// method이름으로 bean id 설정
	@Bean
	public Gson getGson() {
		return new Gson();
	}
	
	
}

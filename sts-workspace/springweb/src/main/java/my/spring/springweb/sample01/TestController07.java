package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testController07")
public class TestController07 {
 
	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);

	@GetMapping
	public String myMethod01(Model model) {
		// Model 객체가 주입(by. Application Context)
		logger.debug("TestController07 호출");
		
		model.addAttribute("myName", "홍길동");
		model.addAttribute("myAge",20);
		
		// jsp 문자열
		return "sample01/testController07";
		
	}
	
}

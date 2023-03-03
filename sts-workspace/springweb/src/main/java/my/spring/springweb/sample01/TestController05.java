package my.spring.springweb.sample01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testController05")
public class TestController05 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);

	@GetMapping(params="myName")
	String myMethod01() {
//		logger.debug("testController05 호출-myName");
		return "sample01/testController05";
	}

	@GetMapping(params="myName=신사임당")
	String myMethod02() {
//		logger.debug("testController05 호출-myName=신사임당");
		return "sample01/testController05";
	}
}

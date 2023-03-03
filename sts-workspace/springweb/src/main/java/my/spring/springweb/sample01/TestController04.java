package my.spring.springweb.sample01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="testController04")
public class TestController04 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController04.class);

	@GetMapping
	String myMethod01() {
//		logger.debug("testController04 GET호출");
		return "sample01/testController01";
	}
	@PostMapping
	String myMethod02() {
//		logger.debug("testController04 POST호출");
		return "sample01/testController01";
	}
}

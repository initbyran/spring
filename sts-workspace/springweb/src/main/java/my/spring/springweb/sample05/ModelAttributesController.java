package my.spring.springweb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.springweb.sample05.vo.User;

@Controller
public class ModelAttributesController {

	Logger log = LogManager.getLogger("case3");
	
	// method에 @ModelAttribute를 지정할때 이름을 하나 명시
	// 이 method는 handler가 호출되기 전에 자동으로 호출(handler-client가 보내는 request를 실제로 처리하는 controller안의 method-는 마지막에 호출)
	// 그리고 해당 method의 리턴값이 Model에 자동으로 등록돼요.
	// -> container가 처리
	
	@ModelAttribute("v1")
	public String createString() {
		
		log.debug("문자열 객체 생성");
		return "이것은 소리없는 아우성!";
		
	}
	
	@ModelAttribute("v2")
	public User createUser() {
		
		log.debug("VO 객체 생성");
		User user = new User(25, "홍길동", "철학과");
		return user;
		
	}
	
	@ModelAttribute("data1")
	public int createNumber1() {
		
		log.debug("첫번째 숫자 생성");
		return 100;
		
	}
	
	@ModelAttribute("data2")
	public int createNumber2() {
		
		log.debug("두번째 숫자 생성");
		return 200;
		
	}
	
	@RequestMapping(value="modelAttributes1")
	public String myMethod1(
			@ModelAttribute("data1") int num1,
			@ModelAttribute("data2") int num2, Model model
			) {
		
		log.debug("handler 호출!!");
		model.addAttribute("sum",num1+num2);
		
		return "sample05/modelResult";
	}
	
	@PostMapping(value="modelAttributes2")
	public String myMethod2(@ModelAttribute User user){
		
		// 이렇게 client가 보내준 데이터로 객체를 생성할 수 있어요 : Command 객체 -대부분 vo
		
		// user vo의 field명과 html의 input name이 일치해야함
		
		log.debug("handler 호출!!");
//		model.addAttribute("sum",num1+num2);
		
		return "sample05/modelResult";
	}
	
}

package my.spring.springweb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes({"data1", "shin", "newStudent"})
@RequestMapping(value = "/sessionAttributesTest06")
public class SessionAttributesController06 {
	
	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 method가 호출돼요
	// data1이라는 key로 method의 return값이 Model에 저장돼요
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출되었어요!");
		return "createString1";
	}

	// 한 번 실행 후 같은 controller내에서 반복적으로 호출되지않음
	@ModelAttribute("newStudent")
	public Student createString3() {
	
		Student student = new Student();
		
		return student;
	}

	@ModelAttribute("data2")
	public String createString2(Model model) {
	
		Student student = new Student(30, "신사임당", "국어국문");
		model.addAttribute("shin",student);

		log.debug("createString2() 호출되었어요!");
		return "createString2";
	}
	
	// controller에 @SessionAttributes({"data1","shin","newStudent"}) 명시.
	// handler인자에 @ModelAttribute("newStudent") Student studentVO 잡혀있음.
	// command 객체를 만들기전에 handler 인자를 먼저 가져온다(session에 newStudent 키값으로 저장되어있는 객체를 찾아 인자로 주입).
	
	// 1. @ModelAttribute("newStudent") Student studentVO 오류가 안나려면 ;
	// session에 newStudent 키값이 있어야함
	//  => @ModelAttribute annotation을 method위에 붙이고 비어있는 command 객체를 생성해서  Model에 저장 
	//     + session에도 자동저장(@SessionAttributes)
	// 2. 그 다음 handler가 호출 
	//   -> command 객체를 생성하지않음 ; 클라이언트가 보내준 데이터를 setter를 이용해서 command객체에 데이터 삽입.
	
	
	// handler
	// 나중에 수행된다
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value="msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
		// session의 key값이 "newStudent"를 찾아 studentVO에 넣으려고함 ; 없으므로 오류
		
		log.debug("handler()에서 출력 : " +str1 + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " +studentVO);
		
	
		return "sample07/sessionResult05";
	}
	
}

package my.spring.springweb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springweb.sample07.vo.Member;

@Controller
@SessionAttributes(value={"memberInfo"})
public class MemberRegisterController {

	Logger log = LogManager.getLogger("case3");
	
	// 한 번 실행 후 같은 controller내에서 반복적으로 호출되지않음 ;처음 session에 key 만들어주는 역할
	@ModelAttribute("memberInfo")
	public Member createMember() {
		
		log.debug("createMember가 호출되었어요");
		
		Member member = new Member();
		
		return member;
	}
	
	@PostMapping(value="memberRegisterStep1")
	public String handler1() {

		log.debug("handler() 호출 : 회원가입 첫 페이지");
		return "sample07/step1";
	}
	
	@GetMapping(value="memberRegisterStep1")
	public String handler() {

		log.debug("handler() 호출 : 회원가입 첫 페이지");
		return "sample07/step1";
	}
	
	@PostMapping(value="memberRegisterStep2")
	public String handler2(@ModelAttribute("memberInfo") Member member) {
		
		log.debug("handler2() 호출 : 회원가입 두번째 페이지");
		log.debug(member);
		return "sample07/step2";
	}
	
	@PostMapping(value="memberRegisterStep3")
	public String handler3(@ModelAttribute("memberInfo") Member member, 
			SessionStatus sessionStatus) {
		
		log.debug("handler3() 호출 : 회원가입 세번째 페이지");
		log.debug(member); // 사용자의 모든 정보 출력
		
		// @Service , @Repository를 이용해서 처리
		
		sessionStatus.setComplete(); // session에서 key 제거
		
		
		return "redirect:/memberRegisterStep1";
	}
}

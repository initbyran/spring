package my.spring.springweb.sample02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {
 
//	private static final Logger logger = LoggerFactory.getLogger(TestController08.class);
	   
	@PostMapping(value="member1")
    public ModelAndView myMethod1(
    		@RequestParam(value="name", defaultValue="없음") String name,
    		@RequestParam(value="phone", defaultValue="없음") String phone,
            String id,
    		@RequestParam(value="password", defaultValue="없음") String password,
    		Model model
    		) {
	    
		ModelAndView mav = new ModelAndView();
	    
//		mav.addObject("name",name);
//		mav.addObject("phone",phone);
//		mav.addObject("id",id);
//		mav.addObject("password",password);
		
		model.addAttribute("name",name);
		model.addAttribute("phone",phone);
		model.addAttribute("id",id);
		model.addAttribute("password",password);
		
		mav.setViewName("sample02/memberView"); // 나중에 사용할 jsp명을 인자로
	   
		return mav;
	}
	
	@PostMapping(value="member2")
    public ModelAndView myMethod2(Member vo) {
	    // vo가 가지고 있는 field에 해당하는 값 자동으로 vo형태로 가져올 수 있음
		
//		logger.debug(vo.toString());
		
		ModelAndView mav = new ModelAndView();
		
	    mav.addObject("memberVO", vo);
		mav.setViewName("sample02/memberView"); // 나중에 사용할 jsp명을 인자로
	   
		return null;
	}
	
	@PostMapping(value="member3")
//    public String myMethod3(@ModelAttribute Member vo) {
	  public String myMethod3(@ModelAttribute(value="mem") Member vo) {
	    // ModelAttribute : Model이 속성 => Model에 자동으로 들어감(key값, value값 필요)
		// Key값으로 첫글자 소문자로 바뀌  vo이름이 들어감 : member
		
//		logger.debug(vo.toString());
		
		return "sample02/memberView";
	}
	
	@PostMapping(value="member4")
    public ModelAndView myMethod4(Member vo, String address) {
	    // vo가 가지고 있는 field에 해당하는 값 자동으로 vo형태로 가져올 수 있음
		
//		logger.debug(vo.toString());
		
		ModelAndView mav = new ModelAndView();
		
	    mav.addObject("memberVO", vo);
		mav.setViewName("sample02/memberView"); // 나중에 사용할 jsp명을 인자로
	   
		return null;
	}
	
}

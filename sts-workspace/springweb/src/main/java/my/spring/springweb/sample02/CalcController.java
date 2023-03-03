package my.spring.springweb.sample02;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc.do")
public class CalcController {

	
//	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);

//	@PostMapping
//	public ModelAndView process(@RequestParam("firstNum") int num1,
//			@RequestParam("secondNum") int num2) {
//		// 사용자가 보내준 데이터를 받아야함
//		
//		return null;
//		
//	}
	
	@PostMapping
	public ModelAndView process(int firstNum, int secondNum, String operator, Model model) {
		// 사용자가 보내준 데이터를 받아야함
		ModelAndView mav = new ModelAndView();
		String viewName = "";
		
		if(operator.equals("div")&& secondNum ==0) {
			// 나눗셈을 하는데 분모가 0 => 무한대 ; 자바에는 무한대 개념이 없다 ; Exception
			viewName = "sample02/errorResult";
			mav.addObject("msg","0으로 나눌 수 없어요!");
		} else {
			int result=0;
			if(operator.equals("plus")) {
				result = firstNum + secondNum;
			} else if (operator.equals("minus")) {
				result = firstNum - secondNum;
			} else if (operator.equals("mul")) {
				result = firstNum * secondNum;
			}else {
				result = firstNum / secondNum;
			}
		     viewName = "sample02/calcResult";
		     mav.addObject("msg",result);
		}
		mav.setViewName(viewName);
		return mav;
		
	}
}

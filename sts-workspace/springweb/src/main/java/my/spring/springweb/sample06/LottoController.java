package my.spring.springweb.sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import my.spring.springweb.sample06.vo.Lotto;

@Controller
public class LottoController {
	
	@Autowired
	private LottoService service;
	
	@GetMapping(value="/lotto")
	public String lottoProcess(@ModelAttribute Lotto lotto) {
		
		// query string 이므로 @PathVariable 사용할 수 없다
		// vo ; command 객체
		
		// 서비스 객체를 만들어서 로직 처리
		
		boolean result = service.checkLottoNumber(lotto);
		if(result) {
			lotto.setResult("당첨되었습니다. 행복시작!!");
		} else {
		    lotto.setResult("될 리가 없죠ㅠㅜ");
		}
		return "sample06/lottoView";
		
	}
	
}

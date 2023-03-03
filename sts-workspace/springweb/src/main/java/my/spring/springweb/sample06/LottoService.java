package my.spring.springweb.sample06;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import my.spring.springweb.sample06.dao.LottoDao;
import my.spring.springweb.sample06.vo.Lotto;

@Service
public class LottoService {
	

	Logger log = LogManager.getLogger("case3");
	
	// @Autowired
	// @Qualifier(value="lottoDao")
	@Resource(name="lottoDao")
	private LottoDao dao;

	public LottoService() {
		// TODO Auto-generated constructor stub
	}

	public boolean checkLottoNumber(Lotto lotto) {
		
		// 일반적인 로직 처리 진행
		// 데이터 베이스 처리 ; dao
		
		boolean result = false;
		int randomNumber = dao.selectLottoNumber();
		// dao이용해서 랜덤넘버 중 하나인 당첨 번호 알아오기
		
		log.debug("내가 선택한 로또 번호 : " +lotto.getLottoNum());
		log.debug("로또 당첨 번호 : "+randomNumber);
		
		if (randomNumber==lotto.getLottoNum()) {
			
		}
		return false;
	}
}

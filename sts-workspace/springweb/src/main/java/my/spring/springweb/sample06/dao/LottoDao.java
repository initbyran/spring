package my.spring.springweb.sample06.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository("lottoDao")
public class LottoDao {
	
	public LottoDao() {
		// TODO Auto-generated constructor stub
	}

	public int selectLottoNumber() {
		//난수 생성
		Random rand = new Random();
		
		return rand.nextInt(6)+1; // 0~5까지의  난수 발생
	}

	
	
}

package my.spring.springweb.sample10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/user")
public class MyRestController {

	Logger log = LogManager.getLogger("case3");
	
	@GetMapping
	public ResponseEntity<?> method01(String id, String name){
		
		log.debug("GET방식으로 호출 되었어요!");
		log.debug(id + " , " + name);
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name){
		
		log.debug("DELETE방식으로 호출 되었어요!");
		log.debug(id + " , " + name);
		return null;
	}
	
}

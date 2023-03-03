package my.spring.springweb.sample09;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.spring.springweb.sample09.vo.User;

@RestController
@RequestMapping(value="body")
public class ResponseBodyController {

	@RequestMapping(value="text/{id}", produces="text/plain; charset=UTF-8")
//    @ResponseBody
	public String method01(@PathVariable String id) {
		
		return "<h1>이 것은 소리 없는 아우성  : " + id +"</h1>";
		
		}
	
	@RequestMapping(value="textObject/{id}", produces="text/plain; charset=UTF-8")
//    @ResponseBody
	public ResponseEntity<String> method02(@PathVariable String id) {
		// data ; 문자열 데이터
		String msg = "<h1>이 것은 소리 없는 아우성  : " + id +"</h1>";

		// header ; header 객체 만들기
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "plain", Charset.forName("UTF-8")));
		
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.CREATED);
		
		}
	
	@RequestMapping(value="json/{name}", 
			produces="application/json; charset=UTF-8")
//    @ResponseBody
	public User method03(@PathVariable String name) {
		User user = new User();
		user.setName(name);
		user.setAddr("서울");
		
		return user;
		}
	
}
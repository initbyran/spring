package my.spring.springweb.sample08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import my.spring.springweb.common.ApplicationContextProvider;

@Controller
public class RequestMappingProducesController {

	Logger log = LogManager.getLogger("case3");
	
//	@Autowired
//	private Gson gson;
	
	@RequestMapping(value="testProduces1")
	public String method01(Model model) {
		
		model.addAttribute("msg","소리없는 아우성");
			
		return "sample08/requestMappingProducesView";
	}
	
	@RequestMapping(value="testProduces2", produces="text/plain; charset=UTF-8")
	public String method02(Model model) {
		
		model.addAttribute("msg","소리없는 아우성");
		
		return "sample08/requestMappingProducesView";
	}

	@RequestMapping(value="testProduces3", produces="text/html; charset=UTF-8")
	public void method03(HttpServletResponse response) {
		
		try {
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head></head>");
			out.println("<body>소리없는 아우성!</body></html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="testProduces4", produces="application/json; charset=UTF-8")
	public void method04(HttpServletResponse response) {
		
		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			// data 생성
			Map map = new HashMap<String, String>();
			map.put("userName", "홍길동");
			map.put("userAge", "20");
			map.put("userAddr", "서울");
			
			// data -> json으로 변형
//			Gson gson = new Gson();
			
			ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			Gson gson = ctx.getBean("getGson()", Gson.class);
			String str = gson.toJson(map);
			
			// Stream을 통해 client에게 전송
			out.println(str);
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
}

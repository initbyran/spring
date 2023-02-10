package servlet;

import argument.HttpServletRequest;
import argument.HttpServletResponse;

// Servlet이라고 불리는 이 class는 원래 특정 class(HttpServlet)를 상속해서 만들어야함

public class AddServlet {

	public void init() {
		
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 이 메소드는 이미 하는 일이 정해져있음
		// request 객체를 뒤져서 클라이언트의 요청방식이 어떤 방식인지 알아냄
		doGet(request, response);
		doPost(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// request 객체와 response 객체를 이용해서 입력처리와 로직처리, 출력 처리를 진행
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void doPut() {
		
	}
	
	public void doDelete() {
		
	}
	
}

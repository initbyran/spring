package container;

import ThreadInvoker.ClientThread;
import argument.HttpServletRequest;
import argument.HttpServletResponse;
import servlet.AddServlet;

// Tomcat(WAS) 안의 Servlet container 역할을 하는 class
public class ServletContainer {
	
	public static void main(String[] args) {
		// 실제 servlet container는 main 없음
		
		AddServlet servlet = new AddServlet();
		
		servlet.init();
		
		HttpServletRequest request = new HttpServletRequest();
		
		HttpServletResponse response = new HttpServletResponse();
		
		ClientThread thread = new ClientThread(servlet, request, response);
		thread.start();
		
		
	}
}

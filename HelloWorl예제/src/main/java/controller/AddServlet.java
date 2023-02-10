package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/sum")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력 처리 : Query String ; GET 방식
		String num1 = request.getParameter("num1"); // "10"
		String num2 = request.getParameter("num2"); // "20"
		// 2. 로직 처리
		int sum = Integer.parseInt(num2)+Integer.parseInt(num1);
		// 3. 출력 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>"+sum+"</body></html>");
		out.close();
		// 호출 : http://127.0.0.1:8080/first/sum?num1=10&num2=20 
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // 1. 입력 처리 : Form으로부터 post 방식으로 데이터 받음
		String num1 = request.getParameter("myNum1"); // "10"
		String num2 = request.getParameter("myNum2"); // "20"
		// 2. 로직 처리
		int sum = Integer.parseInt(num2)+Integer.parseInt(num1);
		// 3. 출력 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>"+sum+"</body></html>");
		out.close();
		// 호출 : http://127.0.0.1:8080/first/sum
		
	}

}

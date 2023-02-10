package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class board
 */
@WebServlet("/board")
public class board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기는 로그인한 사람만 들어올 수 있어야해요.
		// 1. 입력처리
		// 2. 로직처리
		// 3. 출력처리

		// client에게 기존에 할당된 session 객체가 있으면 그거 줌
		// false의 의미 : session 객체가 없으면 만들지말고 null 리턴
		
		HttpSession session = request.getSession(false);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		if(session!=null) {
			String name = (String)session.getAttribute("loginName");
			out.println("<h1>"+name+"님 게시판에 오신 것을 환영합니다.</h1>");
		} else {
			out.println("<h1>로그인을 해야 사용할 수 있어요! 페이지 재설정</h1>");
		}
		
		out.println("</body></html>");
		out.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

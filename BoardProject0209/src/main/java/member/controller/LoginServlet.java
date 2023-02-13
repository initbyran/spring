package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받기
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
		// 입력받은 데이터로 VO 생성
		// 데이터베이스 테이블을 기준으로 VO를 생성해야합니다 -> member.vo
		// Table을 생성한 후 VO를 만들고 data setting해서 service를 넘겨줄 준비를 함
		
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);
		
		// 2. 로직처리
		// 로직 처리를 하기위해 service 객체 생성
		MemberService service = new MemberService();
		// 객체가 생성되었으면 이제 일을 시킴
		// 만약 로그인이 성공하면 VO안에 회원의 이름까지 포함해서 들고와요.
		// 만약 로그인이 실패하면 null을 리턴해줘요.
		Member result = service.login(member);
		
		// 게시판 관련 데이터를 가져와야함
		List<Board> list = null;
	
		if(result !=null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
			
		}
		
		// 3. 출력처리
		if(result !=null) {
			// 로그인 성공
			// 나에게 할당된 로그인 세션에 데이터 저장해두기
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result);
			// session.setAttribute("boardList", list); -> session의 데이터 크기가 커짐
			// 계속 유지가 될 필요가 있는 data만 session에 저장
			
			// 게시판 HTML page를 client에게 전송(JSP)
			// JSP : 프로그램적 요소가 들어갈 수 있음
			// JSP의 실체 : servlet
			// html -> servlet -> service -> dao -> service -> controller -> jsp(servlet) -> client
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			
			request.setAttribute("boardList", list);
			
			
			dispatcher.forward(request, response);
			
			
			
		} else {
			// 로그인 실패
			// 오류 HTML 페이지를 client에게 전송(HTML)
			response.sendRedirect("loginFail.html");
			// 다시 접속하라고 응답을 보냄
		}
			
		}
		
		
	}

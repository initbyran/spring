package board.controller;

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

import member.vo.Member;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
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
        HttpSession session = request.getSession(true);
        
        Member member = new Member();
        member = (Member) session.getAttribute("member");
		String boardAuthor = member.getMemberName();
		
		request.setCharacterEncoding("UTF-8");
		String articleTitle = request.getParameter("articleTitle");
		String articleContents = request.getParameter("articleContents");
		
		Board board = new Board();
		board.setBoardTitle(articleTitle);
		board.setBoardContent(articleContents);
		board.setMemberName(boardAuthor);
		
		// 2. 로직처리
		
		BoardService service = new BoardService();
		service.upload(board);
		
		// 3. 출력처리
		List<Board> list = null;
		
		BoardService bservice = new BoardService();
		
		list = bservice.getAllBoard();
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
		
		request.setAttribute("boardList", list);
		
		
		dispatcher.forward(request, response);
		
	}

}

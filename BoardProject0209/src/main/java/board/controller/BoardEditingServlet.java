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
import comments.service.CommentsService;
import comments.vo.Comments;
import member.vo.Member;

/**
 * Servlet implementation class BoardEditing
 */
@WebServlet("/edit")
public class BoardEditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEditingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력처리
		request.setCharacterEncoding("UTF-8");
		
		String boardNum = request.getParameter("boardNum");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(boardNum));
		
		// 2. 로직처리
		
		BoardService service = new BoardService();
		Board result = service.selectOne(board);
	    String bContents = result.getBoardContent();
	    
		// 3. 출력처리
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editArticle.jsp");
		request.setAttribute("article", result);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 입력처리
//		HttpSession session = request.getSession(true);
//		
//		Member member = new Member();
//		member = (Member) session.getAttribute("member");
//		
		request.setCharacterEncoding("UTF-8");
		
		String boardNum = request.getParameter("boardNum");
		String boardAuthor = request.getParameter("boardAuthor");
		String editTitle = request.getParameter("editTitle");
		String editContents = request.getParameter("editContents");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(boardNum));
		board.setBoardAuthor(boardAuthor);		
		board.setBoardTitle(editTitle);
		board.setBoardContent(editContents);
			
		// 2. 로직처리	
		BoardService service = new BoardService();
		service.update(board);
		
		// 3. 출력처리
		BoardService bservice = new BoardService();
		Board result = bservice.selectOne(board);
		
		// 3. 출력처리
		List<Comments> list = null;
		
		CommentsService cservice = new CommentsService();
		
		list = cservice.getAllComments(board.getBoardNum());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		request.setAttribute("article", result);
		request.setAttribute("comments", list);
		
		dispatcher.forward(request, response);
		}
		
		
		
	}



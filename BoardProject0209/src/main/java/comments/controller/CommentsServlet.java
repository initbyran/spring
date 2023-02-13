package comments.controller;

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
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/comments")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsServlet() {
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

		HttpSession session = request.getSession(true);
		
		Member member = new Member();
		member = (Member) session.getAttribute("member");
		String commentsId = member.getMemberId();
		System.out.println(commentsId);
//		Board board = new Board();
//		board = (Board) session.getAttribute("article");
//		int commentsArticleNum = board.getBoardNum();
		
		// 1. 입력처리
		request.setCharacterEncoding("UTF-8");
		String commentsContents = request.getParameter("commentsContents");
		int commentsArticleNum = Integer.parseInt(request.getParameter("commentsArticleNum"));
		System.out.println("!!! " + commentsArticleNum);
		
		Comments comments = new Comments();
		comments.setCommentsArticleNum(commentsArticleNum);
		comments.setCommentsId(commentsId);
		comments.setCommentsContents(commentsContents);
		
		// 2. 로직처리
		CommentsService service = new CommentsService();
		service.uploadComments(comments);
		
		// 3. 출력처리
		
		
		Board board = new Board();
		board.setBoardNum(commentsArticleNum);
		
		BoardService bservice = new BoardService();
		Board result = bservice.selectOne(board);
		
		List<Comments> list = null;
		
	
		
		list = service.getAllComments(commentsArticleNum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		request.setAttribute("article", result);
		request.setAttribute("comments", list);
		
		dispatcher.forward(request, response);
		
	}

}

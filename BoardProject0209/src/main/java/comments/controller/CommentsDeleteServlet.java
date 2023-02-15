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
 * Servlet implementation class CommentsDelete
 */
@WebServlet("/deletecomments")
public class CommentsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsDeleteServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		
        HttpSession session = request.getSession(true);
        
        Member member = new Member();
        member = (Member) session.getAttribute("member");
		
		int commentsArticleNum = Integer.parseInt(request.getParameter("commentsArticleNum"));
		
		String commentsNum = request.getParameter("commentsNum");
		
		Comments comments = new Comments();
		comments.setCommentsNum(Integer.parseInt(commentsNum));
		comments.setCommentsArticleNum(commentsArticleNum);
		CommentsService service = new CommentsService();
		service.delete(comments);
		

		Board board = new Board();
		board.setBoardNum(commentsArticleNum);
		
		BoardService bservice = new BoardService();
		Board result = bservice.selectOne(board);
		
		List<Comments> list = null;
		
		list = service.getAllComments(commentsArticleNum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		request.setAttribute("article", result);
		request.setAttribute("comments", list);
		request.setAttribute("login", member);
		
		dispatcher.forward(request, response);
		
	}

}

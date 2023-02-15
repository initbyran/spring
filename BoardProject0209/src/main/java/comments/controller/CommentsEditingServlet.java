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
 * Servlet implementation class CommentsEditing
 */
@WebServlet("/editcomments")
public class CommentsEditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsEditingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        
        Member member = new Member();
        member = (Member) session.getAttribute("member");
        
		String commentsNum = request.getParameter("commentsNum");
		
		Comments comments = new Comments();
		comments.setCommentsNum(Integer.parseInt(commentsNum));
		
		CommentsService service = new CommentsService();
		Comments result = service.selectOne(comments);
		
//		String commentsContents = result.getCommentsContents();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editComments.jsp");
		request.setAttribute("comments", result);
		request.setAttribute("login", member );
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String commentsNum = request.getParameter("commentsNum");
//		String commentsId = request.getParameter("commentsId");
		String commentsContents = request.getParameter("editCommentsContents");
		
		Comments comments = new Comments();
		comments.setCommentsNum(Integer.parseInt(commentsNum));
		comments.setCommentsContents(commentsContents);
		
		CommentsService service = new CommentsService();
		service.update(comments);
		comments = service.selectOne(comments);
		
		Board board = new Board();
		board.setBoardNum(comments.getCommentsArticleNum());
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



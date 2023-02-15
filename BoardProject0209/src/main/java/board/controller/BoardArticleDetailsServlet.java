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
import board.vo.BoardLike;
import comments.service.CommentsService;
import comments.vo.Comments;
import member.vo.Member;


/**
 * Servlet implementation class BoardArticle
 */
@WebServlet("/article")
public class BoardArticleDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardArticleDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // 1. 입력처리
		        request.setCharacterEncoding("UTF-8");
				
				String boardNumber = request.getParameter("boardNum");
				int boardNum = Integer.parseInt(boardNumber);
				Board board = new Board();
				board.setBoardNum(boardNum);
				
				HttpSession session = request.getSession(true);
			        
			    Member member = new Member();
			    member = (Member) session.getAttribute("member");
				
			    BoardLike boardlike = new BoardLike();
			    boardlike.setArticleNum(boardNum);
			    
			    
			     // 2. 로직처리
				BoardService service = new BoardService();
				Board result = service.selectOne(board);
//				BoardLike likeInfo = service.selectAllLikes(boardlike);
				
				// 3. 출력처리
				List<BoardLike> likeIdList = service.selectAllLikes(boardlike);
				
				List<Comments> list = null;
				CommentsService cservice = new CommentsService();
				list = cservice.getAllComments(board.getBoardNum());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
				request.setAttribute("article", result);
				request.setAttribute("login", member );
				request.setAttribute("comments", list);
				request.setAttribute("likeInfo", likeIdList);
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
		
		
	}



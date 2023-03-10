package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import board.service.BoardService;
import board.vo.Board;
import board.vo.BoardLike;
import member.vo.Member;

/**
 * Servlet implementation class BoardLikeDeleteServlet
 */
@WebServlet("/likedelete")
public class BoardLikeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardLikeDeleteServlet() {
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
		
		String boardNum = request.getParameter("boardNum");
		
		HttpSession session = request.getSession(true);
        
	    Member member = new Member();
	    member = (Member) session.getAttribute("member");
		String loginId = member.getMemberId();
		
		BoardLike boardlike = new BoardLike();
		boardlike.setArticleNum(Integer.parseInt(boardNum));
		boardlike.setClicklikeId(loginId);
		
		BoardService service = new BoardService();
	    service.deleteLike(boardlike);
	    
	    Board board = new Board();
	    board.setBoardNum(Integer.parseInt(boardNum));
	    Board result = service.selectOne(board);
	    
	    // json
        Gson gson = new Gson();
		
		String countLikes = gson.toJson(result.getBoardLike());
	
		
		response.setContentType("application/json; charset=UTF-8");
		
	    PrintWriter writer = response.getWriter();
	    writer.println(countLikes);
	    writer.close();
		
	}

}

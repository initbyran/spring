package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;
import board.vo.BoardComments;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
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
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(boardNum));
		
		BoardService service = new BoardService();
		service.delete(board);
		

		List<BoardComments> list = null;
		
		BoardService bservice = new BoardService();
		
		list = bservice.getAllBoard();
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
		
		request.setAttribute("boardList", list);
		
		
		dispatcher.forward(request, response);
		
		
	}

}

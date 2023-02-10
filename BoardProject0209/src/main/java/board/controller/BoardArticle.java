package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.myBatis.MyBatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class BoardArticle
 */
@WebServlet("/article")
public class BoardArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardArticle() {
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
		
		SqlSession session = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<Board> result = session.selectList("myBoard.article", board);
		session.close();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<h3>검색키워드: " + keyword + "</h3>");
		out.println("<h3>검색가격: " + price + "</h3>");
		out.println("<ul>");
		
		for(Book tmp: result) {
			out.println("<li>" + tmp.getBtitle() + "," 
						+ tmp.getBprice() + "</li>");
		}

		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();		
		
		
		
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Members;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
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
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userID");
		String password = request.getParameter("userPW");
		
		Members members = new Members();
		members.setId(id);
		members.setPassword(password);
		
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Members result = sqlSession.selectOne("myMembers.selectMembersById",members);
		
		if( result != null) {
			// 로그인 성공
			// servlet container에 session을 요청
			// 기존 session이 존재하면 그걸 줌
			// 없으면 만들어줌
		
			HttpSession session= request.getSession(true);
		    
			// map 형태
			session.setAttribute("loginName", result.getName());
			
			
		}
		sqlSession.close();
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		if( result == null) {
			
			out.println("<h1>로그인에 실패했습니다!</h1>");
			
			
			
			
		} else {
		
			out.println("<h1>" + result.getName() + "님 환영합니다</h1>");
			out.println("<br><br>");
		    out.println("<a href='board'>게시판 들어가기!</a>");
		}
		out.println("</body></html>");
		out.close();		
		
	}

}

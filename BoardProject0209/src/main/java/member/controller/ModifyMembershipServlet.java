package member.controller;

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
import board.vo.BoardComments;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class ModifyMembership
 */
@WebServlet("/modify")
public class ModifyMembershipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMembershipServlet() {
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
		
		String memberPw = request.getParameter("changedPw");
		String memberName = request.getParameter("changedName");
	
		HttpSession session = request.getSession(true);
		
		Member member = new Member();
		
        member = (Member) session.getAttribute("member");
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		MemberService service = new MemberService();
        service.update(member);
        
        List<BoardComments> list = null;
		
		BoardService bservice = new BoardService();
		
		list = bservice.getAllBoard();
	
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
        request.setAttribute("boardList", list);
        dispatcher.forward(request, response);
		
	}

}

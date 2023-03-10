package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.service.MemberService;

/**
 * Servlet implementation class idCheck
 */
@WebServlet("/idcheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
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
		// 1. 입력처리 
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		
		// 2. 로직처리
		MemberService service = new MemberService();
	
		String foundId = service.selectOne(memberId);
		
		boolean result = false;
		
		if (foundId != null) {
			result = true ;
		}
		
		// 3. json
		
		Gson gson = new Gson();
		
	    String idCheck = gson.toJson(result);
	    
	    response.setContentType("application/json; charset=UTF-8");
		
	    PrintWriter writer = response.getWriter();
	    writer.println(idCheck);
	    writer.close();
		 
	}

}

package my.spring.myspringboard.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.spring.myspringboard.member.dao.MemberDao;
import my.spring.myspringboard.member.vo.Member;

@Controller
@RequestMapping(value="member")
public class LoginController {

	@Autowired
	private MemberDao dao;
	
	@PostMapping(value="login")
	public String method01(@RequestParam(value="userId") String memberId,
			@RequestParam(value="userPw") String memberPw, Model model) {
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		model.addAttribute("result", dao.getMember(member));
		
		return "/loginSuccess";
	}
	
}

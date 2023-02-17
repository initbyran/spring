package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// 로그인이라는 transaction 처리 진행
		// database 처리 : DAO
		MemberDao dao = new MemberDao();
		Member result = dao.select(member);
		
		return result;
	}

	public String selectOne(String memberId) {
		
		MemberDao dao = new MemberDao();
		String foundId = dao.selectOne(memberId);
		
		return foundId;
	}

	public void insert(Member member) {


		MemberDao dao = new MemberDao();
		dao.insert(member);
		
	}

	public void update(Member member) {
		
		MemberDao dao = new MemberDao();
		dao.update(member);
		
	}

	
}

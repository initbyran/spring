package my.spring.myspringboard.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.myspringboard.member.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession session;

	@Override
	public List<Member> getMember(Member member) {
		
		return session.selectList("myMember.login");
	}

	
	
}

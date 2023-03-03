package my.spring.myspringboard.member.dao;

import java.util.List;

import my.spring.myspringboard.member.vo.Member;

public interface MemberDao {

	List<Member> getMember(Member member);
}

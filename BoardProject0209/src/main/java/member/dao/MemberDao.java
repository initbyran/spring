package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.myBatis.MyBatisConnectionFactory;
import member.vo.Member;


public class MemberDao {

	public Member select(Member member) {
		// database 처리
		// myBatis를 이용해서 database 처리
		// SqlSessionFactory -> SqlSession 필요 ; XML(mapper)에 있는 Query를 실행할 수 있다
		// SqlSessionFactory를 만들려면 데이터베이스 연결정보와 같은 XML정보를 줘서 만들어야함.
		
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Member result = sqlSession.selectOne("myMember.login",member);
		
		sqlSession.close();
		
		return result;
	}
	
	

}

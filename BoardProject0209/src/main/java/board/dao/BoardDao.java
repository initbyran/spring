package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;

import common.myBatis.MyBatisConnectionFactory;


public class BoardDao {

	public List<Board> selectAll() {
		// 데이터베이스 처리 : MyBatis
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<Board> result = sqlSession.selectList("myBoard.allBoards");
		
		sqlSession.close();
		return result;
	}

	

	public void insert(Board board) {

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		sqlSession.insert("myBoard.newArticle",board);
		sqlSession.commit();
		sqlSession.close();
		
	}

	
}

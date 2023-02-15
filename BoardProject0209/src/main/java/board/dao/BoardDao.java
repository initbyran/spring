package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import board.vo.BoardComments;
import board.vo.BoardLike;
import common.myBatis.MyBatisConnectionFactory;


public class BoardDao {

	public List<BoardComments> selectAll() {
		// 데이터베이스 처리 : MyBatis
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<BoardComments> result = sqlSession.selectList("myBoard.allBoards");
		
		sqlSession.close();
		return result;
	}

	public void insert(BoardComments board) {

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		sqlSession.insert("myBoard.newArticle",board);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public Board selectOne(Board board) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Board result = sqlSession.selectOne("myBoard.articleDetails",board);
		
		sqlSession.close();
		return result;
	}

	public void update(Board board) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		sqlSession.update("myBoard.editArticle",board);
		sqlSession.commit();
		sqlSession.close();
	
	}

	public void delete(Board board) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		sqlSession.delete("myBoard.deleteArticle",board);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public void insertLike(BoardLike boardlike) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		sqlSession.insert("myBoard.addLike",boardlike);
		
		sqlSession.commit();
		sqlSession.close();
	}

	public List<BoardLike> selectAllLikes(BoardLike boardlike) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		List<BoardLike> likeIdList  = sqlSession.selectList("myBoard.likeInfo", boardlike);
		
		sqlSession.close();
		
		return likeIdList;
	}



	public void deleteLike(BoardLike boardlike) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		sqlSession.delete("myBoard.deleteLike",boardlike);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
}

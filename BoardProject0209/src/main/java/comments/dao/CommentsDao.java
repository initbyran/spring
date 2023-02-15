package comments.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comments.vo.Comments;
import common.myBatis.MyBatisConnectionFactory;

public class CommentsDao {

	public List<Comments> selectAllComments(int boardNum) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Comments comments = new Comments();
		comments.setCommentsArticleNum(boardNum);
		List<Comments> result = sqlSession.selectList("myComments.allComments", comments);

		sqlSession.close();
		return result;
	}

	public void insert(Comments comments) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		sqlSession.insert("myComments.newComments",comments);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public Comments selectOne(Comments comments) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		Comments result = sqlSession.selectOne("myComments.commentsDetails", comments);
		sqlSession.close();
		
		return result;
	}

	public void update(Comments comments) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		sqlSession.update("myComments.editComments",comments);
		sqlSession.commit();
		sqlSession.close();
		
		
	}

	public void delete(Comments comments) {
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
		sqlSession.update("myComments.deleteComments",comments);
		sqlSession.commit();
		sqlSession.close();
		
	}

}

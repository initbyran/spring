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
//		if (result == null) {
//			System.out.println("!!! list null");
//		} else {
//			System.out.println("!!! list is not null");
//		}
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

}

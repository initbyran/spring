package comments.service;

import java.util.List;
import comments.dao.CommentsDao;
import comments.vo.Comments;

public class CommentsService {

	public List<Comments> getAllComments(int boardNum){
		CommentsDao dao = new CommentsDao();
		List<Comments> list = dao.selectAllComments(boardNum);
		return list;
		
	}


	public void uploadComments(Comments comments) {
		
		CommentsDao dao = new CommentsDao();
		dao.insert(comments);
		
	}


	public Comments selectOne(Comments comments) {
		CommentsDao dao = new CommentsDao();
		Comments result = dao.selectOne(comments);
		
		return result;
	}


	public void update(Comments comments) {
		
		CommentsDao dao = new CommentsDao();
		dao.update(comments);
		
	}


	public void delete(Comments comments) {
		
		CommentsDao dao = new CommentsDao();
		dao.delete(comments);
		
	}
}

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
}

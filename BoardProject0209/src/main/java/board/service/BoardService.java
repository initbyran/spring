package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;
import board.vo.BoardComments;
import board.vo.BoardLike;


public class BoardService {

	public List<BoardComments> getAllBoard() {
		// 로직 처리
		// 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면 됩니다
		// DAO 필요
		
		BoardDao dao = new BoardDao();
		List<BoardComments> list = dao.selectAll();
		return list;
	}

	public void upload(BoardComments board) {
		
		BoardDao dao = new BoardDao();
		dao.insert(board);
	}

	public Board selectOne(Board board) {
		
		BoardDao dao = new BoardDao();
		Board result = dao.selectOne(board);
		
		return result;
		
		
	}

	public void update(Board board) {
	    
		BoardDao dao = new BoardDao();
		dao.update(board);
		
	}

	public void delete(Board board) {
		
		BoardDao dao = new BoardDao();
		dao.delete(board);
		
	}

	public void insertLike(BoardLike boardlike) {
		
		BoardDao dao = new BoardDao();
		dao.insertLike(boardlike);
		
	}

	public List<BoardLike> selectAllLikes(BoardLike boardlike) {
		
		BoardDao dao = new BoardDao();
		List<BoardLike> likeIdList = dao.selectAllLikes(boardlike);
		
		return likeIdList;
	}

	public void deleteLike(BoardLike boardlike) {
		
		BoardDao dao = new BoardDao();
		dao.deleteLike(boardlike);
		
	}

	
	
}

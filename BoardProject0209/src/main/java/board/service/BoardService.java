package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;



public class BoardService {

	public List<Board> getAllBoard() {
		// 로직 처리
		// 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면 됩니다
		// DAO 필요
		
		BoardDao dao = new BoardDao();
		List<Board> list = dao.selectAll();
		return list;
	}

	public void upload(Board board) {
		
		BoardDao dao = new BoardDao();
		dao.insert(board);
	}

	



	
	
}

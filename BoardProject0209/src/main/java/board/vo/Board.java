package board.vo;

public class Board {
    // boards라는 table과 연결된 VO
	// 다른 내용 추가하고 싶을 때는 VO를 새로 만든다
	
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String memberName;
	private String boardDate;
	private int boardLike;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNum, String boardTitle, String boardContent, String memberName, String boardDate,
			int boardLike) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberName = memberName;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	
	
	
	
}

package comments.vo;

public class Comments {

	private int commentsNum;
	private int commentsArticleNum;
	private String commentsId;
	private String commentsContents;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(int commentsNum, int commentsArticleNum, String commentsId, String commentsContents) {
		super();
		this.commentsNum = commentsNum;
		this.commentsArticleNum = commentsArticleNum;
		this.commentsId = commentsId;
		this.commentsContents = commentsContents;
	}

	public int getCommentsNum() {
		return commentsNum;
	}

	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}

	public int getCommentsArticleNum() {
		return commentsArticleNum;
	}

	public void setCommentsArticleNum(int commentsArticleNum) {
		this.commentsArticleNum = commentsArticleNum;
	}

	public String getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(String commentsId) {
		this.commentsId = commentsId;
	}

	public String getCommentsContents() {
		return commentsContents;
	}

	public void setCommentsContents(String commentsContents) {
		this.commentsContents = commentsContents;
	}

	


	
}

package board.vo;

public class BoardLike {

	private int articleNum;
	private String clicklikeId;
	
	public BoardLike() {
		// TODO Auto-generated constructor stub
	}

	public BoardLike(int articleNum, String clicklikeId) {
		super();
		this.articleNum = articleNum;
		this.clicklikeId = clicklikeId;
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getClicklikeId() {
		return clicklikeId;
	}

	public void setClicklikeId(String clicklikeId) {
		this.clicklikeId = clicklikeId;
	}

	@Override
	public boolean equals(Object obj) {
		BoardLike idInfo = (BoardLike)obj;
//		System.out.println("# temp " + temp.getArticleNum() + temp.getClicklikeId());
		if (this.clicklikeId.equals(idInfo.getClicklikeId())) {
//			System.out.println("@ Blike true");
			return true;
		} else {
//			System.out.println("@ Blike false");
			return false;
		}
	}

	
	
}

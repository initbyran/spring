package my.spring.springweb.sample01.vo;

// JavaBean 규약
// 1. 기본 생성자가 존재해야해요
// 2. 모든  field는 private이어야해요
// 3. 각 field를 사용하기 위해 public으로 되어 있는 setter, getter
// 이렇게 JavaBean 규약을 지켜서 만든 클래스의 객체를 생성했을떄
// field를 우리가 뭐라고 하냐면... => property라고 불러요


public class User {

	   private String userName;
	   private int userAge;
	   
	   public User() {
	      
	   }

	   public User(String userName, int userAge) {
	      super();
	      this.userName = userName;
	      this.userAge = userAge;
	   }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	   
	   
} 
	   
	   
package springIoc.sample03;

public class UserServiceImpl implements UserService{

	// stateless이므로 원래는 field값이 나오지 않음
	private User user;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 기본 생성자 호출");	}
	
	public UserServiceImpl(User user) {
		// 일반적인 Business logic 처리가 나와요
		System.out.println("UserServiceImpl 생성자 호출 - " +user);

	}
	
	@Override
	public void addUser(User user) {
		System.out.println("UserServiceImpl-addUser() 메소드 호출");
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

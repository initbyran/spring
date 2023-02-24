package springIoc.sample05;

public class User {

	private String name;
	private String birth;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String birth) {
		super();
		this.name = name;
		this.birth = birth;
	}
	
	@Override
	   public String toString() {
	      // TODO Auto-generated method stub
	      return name+ "의 생일은 :" + birth;
	   }
	
}

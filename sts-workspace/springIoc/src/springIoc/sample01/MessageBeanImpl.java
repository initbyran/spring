package springIoc.sample01;

public class MessageBeanImpl implements MessageBean {

	private String fruit;
	private int cost;
	
	// default constructor
	public MessageBeanImpl() {
         System.out.println("MessageBeanImpl 기본생성자 호출");
	}
	
	// constructor overloading
	public MessageBeanImpl(String fruit) {
		System.out.println("MessageBeanImpl 생성자 호출 - " + fruit);
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
		System.out.println("MessageBeanIml 생성자 호출 - " + fruit + " , "+ cost);
	}

	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost setter 호출");
	}

	@Override
	public void sayHello() {
	    System.out.println(fruit+ " , " +cost);
	}
}

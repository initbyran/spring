package springIoc.sample06;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String phone;
	// 해당 메시지를 어디에 출력할지 ; 어떤 구현 객체냐에 따라 
	private Output output;
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 기본 생성자 호출");
	}
	
	public MessageBeanImpl(String name) {
		super();
		this.name = name;
		System.out.println("MessageBeanImpl 생성자 호출" +name);
	}


	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("setPhone() 호출");
	}


	public void setOutput(Output output) {
		this.output = output;
		System.out.println("setOutput() 호출");
	}

	@Override
	public void sayHello() {
		String msg = name + " : " + phone;
        // 동적 binding
		try {
			output.print(msg);
			System.out.println("메시지 출력 성공 - "+msg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
}

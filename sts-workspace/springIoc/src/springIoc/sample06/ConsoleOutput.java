package springIoc.sample06;

public class ConsoleOutput implements Output{

	public ConsoleOutput() {
		System.out.println("ConsoleOuput 기본 생성자 호출");
	}
	
	@Override
	public void print(String message) throws Exception {
		System.out.println("consoleoutput override : "+ message);
	}
	
	
}

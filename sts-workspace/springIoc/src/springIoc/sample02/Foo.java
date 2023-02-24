package springIoc.sample02;

public class Foo {

	public Foo() {
		System.out.println("Foo의 기본 생성자 호출");
	}
	
	public Foo(String str) {
		System.out.println("Foo의 기본 생성자 호출 - " + str);
	}
	
    public Foo(String str, int num) {
    	System.out.println("Foo의 기본 생성자 호출 - " + str + " , " + num);
    }
    
    // dependency injection : Foo라는 클래스틑 Bar라는 클래스에 의존
    public Foo(Bar bar) {
    	System.out.println("Foo의 기본 생성자 호출 - " + bar);
    }
}

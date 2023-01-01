
public class Hello {
	// private 선언: 외부 접근 불가
	private String id = "Hello World";
	private int pw = 2023;
	
	// setter: 다른 class에서 변수 값을 설정할 수 있게 해주는 method
	public void setPw(int pw) {this.pw = pw;}
		
	// getter: 다른 class에서 변수의 값을 가져오는 method
	public String getId() {return id;}
	public int getPw() {return pw;}
	
	
}

// public class Member {}
// The public type Member must be defined in its own file
// 하나의 파일에 여러 개의 public class가 있을 때 발생

class MyMath2{
	long a, b; // instance variable
	long add() { return a+b; };
	// instance method
	// instance variable 사용 가능
	// 객체 생성 필요(MyMath2 mm = new MyMath2();)
	// 참조변수이름.method(); 호출

	static long add(long a, long b) {return a+b;};
	// static method (=class method)
	// instance variable 사용 불가
	// local variable a, b: 필요한 변수를 lv로 직접 받음 -> iv 불필요 -> 객체 불필요 -> 객체 생성없이 호출 가능
	// ClassName.MethodName(); 객체 생성없이 호출 가능
}

public class Initialization {
	// iv 명시적 초기화
	int i = 3;
	char ch = 'C';
	
	// 복잡한 초기화(초기화 블럭)
	static {System.out.println("static initialization: static{}");}
	// 코드가 실행되면 static 초기화 블럭이 가장 먼저 수행됨

	{System.out.println("instance initialization: {}");}
	// 객체가 생성되면 instance 초기화 블럭 실행 -> 객체 생성 시마다 호출
	Initialization(){System.out.println("Constructor");}
	// new 연산자: 객체 생성 후 생성자 호출
	
	public static void main(String[] args) {
		System.out.println("Create Ojbject");
		// 참조변수의 명시적 초기화
		Initialization initialization = new Initialization();
		Initialization initialization2 = new Initialization();
	}
}

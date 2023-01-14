@FunctionalInterface
interface MyFunction2 {
	void run(); // public abstract 생략
	// 함수형 인터페이스 작성 시, 람다식하고 입출력을 맞춰야 함
	// 입력값: () 없음, 반환타입-void 없음
}

public class Ex14_1 {	
	// 매개변수 타입이 MyFunction2
	static void execute(MyFunction2 f) {f.run();}
	
	// 반환타입이 MyFunction2
	static MyFunction2 getMyFunction() { 
//		MyFunction2 f = () -> System.out.println("f3.run()");
		// 입력값: (), 반환타입 X
		// 함수형 인터페이스 매개변수 f를 람다식으로 구현
		// <간결> void run() {() -> System.out.println("f3.run()");}
		// <실제> new MyFunction2() {public void run() {System.out.println("f3.run()");}};
//		return f;
		return () -> System.out.println("f3.run()");
	}
	
	public static void main(String[] args) {
		MyFunction2 f1 = () -> System.out.println("f1.run()");
		
		// 함수형 인터페이스를 직접 구현
		MyFunction2 f2 = new MyFunction2() { // 익명 class로 run 구현
			public void run() { // public 필요(Overriding)
				System.out.println("f2.run()");
			}
		};
		
		MyFunction2 f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		// f3 = getMyFunction();
		// getMyFunction = () -> System.out.println("f3.run()");
		// 해당 람다식을 호출하려면 함수형 인터페이스에 선언된 메서드 이름 사용
		
		execute(() -> System.out.println("f1.run()"));
		execute(f2);
		execute(getMyFunction());
	}
}
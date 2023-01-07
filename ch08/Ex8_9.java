
public class Ex8_9 {
	public static void main(String[] args) throws Exception {
		method1();
		// 같은 class 내 static member이므로 객체 생성 없이 직접 호출 가능
	}
	static void method1() throws Exception {
		method2();
	}
	static void method2() throws Exception {
		throw new Exception();
	}

}
//Exception in thread "main" java.lang.Exception
//at Ex8_9.method2(Ex8_9.java:11)
//at Ex8_9.method1(Ex8_9.java:8)
//at Ex8_9.main(Ex8_9.java:4)

//Exception 떠넘기기 main->method1 호출->method2 호출->Exception발생
//->method2 내 try catch문의 부재로 method2가 실행되지 못한 채 비정상 종료 및 떠넘기기(throw)
//->method2를 호출한 method1이 예외를 떠안았지만 try catch문의 부재로 실행되지 못한 채 비정상 종료 및 떠넘기기(throw)
//->method1을 호출한 main이 예외를 떠안았지만 try catch문의 부재로 실행되지 못한 채 비정상 종료 및 떠넘기기(throw)
//->main에서 예외를 JMV이 받아서 처리(JMV 기본예외처리기)
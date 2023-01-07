public class Ex8_7 {
	public static void main(String[] args) {
		try {
			method1();
		} catch(Exception e) {System.out.println("method1()->main()");}
	}
	
	static void method1() throws Exception {
		try {
			throw new Exception(); // Exception과 그 자손은 필수적 예외처리 대상
			// Error: Unresolved compilation problem
			// 빨간 줄은 compile error를 나타냄
		} catch (Exception e) {
			System.out.println("예외 처리 완료");
			throw e;
		}		
		// RuntimeException과 그 자손은 선택적 예외처리 대상
//		throw new RuntimeException();
	}
}
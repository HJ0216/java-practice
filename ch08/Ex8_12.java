public class Ex8_12 {
	public static void main(String[] args) {
		try {
			method1();
		} catch(Exception e) {
			System.out.println("main method에서 exception이 처리되었습니다.");
		}
	}
	static void method1() throws Exception { // 예외가 발생할 수도 있다는 것을 미리 선언
		try {
			throw new Exception(); // 예외 발생
		} catch(Exception e) {
			System.out.println("method1 method에서 exception이 처리되었습니다.");
			throw e;
		}
	}
}
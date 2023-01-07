public class Ex8_8 {
	static void startInstall() {}
	static void copyFiles() {}
	static void deleteFiles() {}

	public static void main(String[] args) {
		try {throw new RuntimeException();
		// compile은 가능하지만, 비정상 종료
		// compile이 되었다고 오류가 발생하지 않는게 아님
		// console창의 error 내용을 클릭하면 error 발생 위치로 이동함
		} catch (Exception e) {}

		try {
			startInstall();
			copyFiles();
//			deleteFiles();
		} catch(Exception e) {
			e.printStackTrace();
//			deleteFiles();
		} finally {deleteFiles();}
		// 예외 발생 여부와 관계없이 반드시 수행
		// try-catch 내 deleteFiles() 제거
		
		method1();
		System.out.println("Method1 종료, Main 복귀");
	}

	static void method1() {
		try {
			System.out.println("Method1 호출 완료");
			return; // 실행중인 method(method1()) 종료
		} catch(Exception e) {
			e.printStackTrace();
		} finally {System.out.println("Finally 실행");}
	}
}

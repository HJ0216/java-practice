public class Ex8_4 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				// Instanceof 형변환 가능 여부 확인 후, boolean type으로 반환
				// parent instanceof parent: true
				// child instanceof parent: true
				// child instanceof child: true
				// parent instance of child: false
				System.out.println("True");
			} System.out.println("ArithmeticException");
			// if문: 조건식이 true면 블럭 실행, false일 경우 블럭 건너 뜀
			// else 처리하고 싶으면 추가해야함
			// else {System.out.println("ArithmeticException")하면 출력X}
		} catch(Exception e) {
			System.out.println("Exception");
		}
		System.out.println(5);
	}
}
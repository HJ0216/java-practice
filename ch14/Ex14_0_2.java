public class Ex14_0_2 {
	public static void main(String[] args) {
//		Object obj = (a, b) -> a>b ? a:b
		// Error: The target type of this expression must be a functional interface
		// 람다식은 함수형 인터페이스를 구현해야 함

		// 익명 객체인 람다식을 다루기 위한 참조변수 선언
		Object obj = new Object() {
			int max(int a, int b) {
				return a>b ? a:b;
			}
		};
		
//		int value = obj.max(3, 5); // Functional Interface
		// 참조변수 obj 타입 Object는 max라는 method가 없음
		// 객체는 max를 갖고 있지만 리모컨이 갖고 있지 않아 호출할 수 X
		// 형변환을 해주려고해도 어떤것으로 할지 알 수 없음
	}
}
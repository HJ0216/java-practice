import java.util.function.Function;

public class Ex14_0 {
	public static void main(String[] args) {
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) {
		// Error: Cannot reduce the visibility of the inherited method from MyFuction
		// overriding 조건: 접근 제어자 범위를 좁힐 수 X
//				return a>b ? a:b;
//			}
//		};

		// 람다식을 다루기 위한 참조변수 타입은 함수형 인터페이스로 함
		MyFunction f = (a, b) -> a>b ? a:b;
		
		int value = f.max(3, 5);
		System.out.println(value);
		// 람다식이 객체이기때문에 사용하기 위해서는 매개변수를 받아야 함
		// 매개변수 타입은 함수형 인터페이스
		// 람다식으로 정의한 메서드를 사용하기 위해서는 해당 메서드의 이름이 필요
		// 함수형 인터페이스에서 해당 함수에 이름(추상 메서드의 이름)을 붙여주고 람다식과 연결		
	}
}

@FunctionalInterface // 함수형 인터페이스 규칙 감시(추상 메서드 1개만 선언 가능)
interface MyFunction {
	int max(int a, int b);
//	public abstract int max(int a, int b); // public abstract 생략가능
}
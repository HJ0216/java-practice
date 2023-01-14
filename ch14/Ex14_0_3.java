import java.util.function.Function;
import java.util.function.Supplier;

public class Ex14_0_3 {
	public static void main(String[] args) {
		// Supplier: 입력X, 출력O
//		Supplier<MyClass> s = () -> new MyClass(); // 람다식
		Supplier<MyClass> s = MyClass::new; // 메서드 참조
//		// 객체별 주소가 다름
		System.out.println(s.get()); // s.get(): new MyClass() 반환값
		MyClass mc = s.get(); // MyClass class type mc 참조변수
		System.out.println(mc);

		
		// 생성자가 있는(input이 있는) 객체 만들기 Function: 입력O, 출력O
//		Function<Integer, MyClass> f = (i) -> new MyClass(i);
		Function<Integer, MyClass> f = MyClass::new;
		
		MyClass mc2 = f.apply(100); // Function은 get 대신 apply
		System.out.println(mc2.iv); // Function f에서 iv 대신 mc, 100 대입
		System.out.println(f.apply(200).iv);
	
		// 배열 생성하기 Function<int 배열길이, 배열>
//		Function<Integer, int[]> f = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new;
		System.out.println("arr.length: "+f2.apply(10).length);
		int[] arr = f2.apply(20); // 배열 길이=10인 int[] 생성
		System.out.println("arr.length: "+arr.length);
	}
}

class MyClass {
	int iv;
	MyClass(){}
	MyClass(int iv){ // 생성자 = class 생성을 하는 인자 -> 출력값이 클래스
		this.iv = iv;
	}
}
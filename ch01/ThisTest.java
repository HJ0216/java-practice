import static java.lang.System.*;

public class ThisTest {
	String name;
	int age;
	
	ThisTest() {
		this("Java"); // ThisTest(String s) 생성자 호출
		System.out.println("ThisTest(String s) 생성자 호출");
	}
	ThisTest(String s) {
		this(s, 29); // ThisTest(String s, int i) 생성자 호출
		System.out.println("ThisTest(String s, int i) 생성자 호출");
	}
	ThisTest(String s, int i) {
		name = s;
		age = i;
		System.out.printf("name: %s, age: %d%n", s, i);
		System.out.println("ThisTest(String s, int i) 최종");
	}

	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		// 생성자 출력 순서
		// 1. new 연산자: 객체 생성 및 생성자 호출
		// 2. ThisTest()에서 s에 "Java"를 저장하여 ThisTest(String s) 호출
		// 3. ThisTest(String s)에서 s에 "Java"가 저장된 채로 i에 29를 저장하여 ThisTest(String s, int i) 호출
		// 4. ThisTest(String s, int i)에서 저장된 "Java", 29를 iv에 저장
		// 5. ThisTest(String s, int i) 종료
		// 6. ThisTest(String s) 종료
		// 7. ThisTest() 종료
		// 8. ThisTest type 참조변수 tt에 객체 주소 저장 후 종료
		out.println(tt);
	}
}
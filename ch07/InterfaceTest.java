//class A {
//	public void method(B b) {
//		b.Method(); // 직접 연결 시, class C로 변경할 경우 수정 부분이 많아짐
//	}
//}

class A {
	public void method(I i) { // interface I를 구현한 객체만 대입 가능
							  // -> class C에 implements 삽입 및 구현
		i.method();
	}
}

interface I {
	public void method();
}

class B implements I {
	public void method() {
		System.out.println("Class B Method");
	}
}

class C implements I {
	public void method() {
		System.out.println("Class C Method");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
		a.method(new C()); 
		// B b = new B(); A가 B를 사용(에 의존)
	}
}

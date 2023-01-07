class AAA { // Outer class
	int i = 100;
	BBB b = new BBB();

	class BBB { // Inner class
		String s = "Hello String";
		void method() {
//			AAA a = new AAA(); // 인스턴스 생성없이 class A의 멤버에 직접 접근 가능
//			System.out.println(a.i);
			System.out.println(i);
			// Inner class가 되면서 Inner method처럼 취급 됨
			// 객체 생성없이 Outer class member에 접근 가능
		}
	}
	
	class CCC {
		String str = "Hello, CCC";
		void method2() {
			System.out.println(2*i);
//			System.out.println(s);
			// 같은 outer class의 inner class간 사용X
			}
		}		
}


public class InnerTest {
	public static void main(String[] args) {
//		BBB b = new BBB(); // Inner class는 해당 외부 class에서만 사용 가능
//		b.method();
		
		AAA aaa = new AAA();
		System.out.println(aaa.i);
		System.out.println(aaa.b.s);
		// outer class에 inner class 인스턴스 생성하여 사용 가능
	}
}
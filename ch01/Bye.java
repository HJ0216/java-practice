class GoodBye {
	public static void main(String[] args) {
		Hello h2 = new Hello();
		
		h2.setPw(2020);
		System.out.println(h2.getId());
		System.out.println(h2.getPw());
	}
}

public class Bye {
	public static void main(String[] args) {
		Hello h = new Hello();
		
		System.out.println(h.getId()); // Hello World
		System.out.println(h.getPw()); // 2023

//		h.setId("Bye World");
//		Hello class에서 setId method를 구현하지 않았으므로 pw와 달리 다른 class에서 id 설정 불가
		h.setPw(2022);
		System.out.println(h.getId()); // Hello World
		System.out.println(h.getPw()); // 2022
		
		
//		private 선언으로 다른 class에서 수정 불가
//		h.id = "Hello";
//		h.pw = 2022;
	}
}

class TestClass2 {
	int iv;
	static int cv;

	void instanceMethod() { // instance method
		System.out.println(iv); // instance variable 사용 가능
		System.out.println(cv); } // class variable 사용 가능

	void instanceMethod2() { // instance method
		instanceMethod(); // instance method 사용 가능
		staticMethod(); } // class method 사용 가능

	static void staticMethod(){ // static method
//		System.out.println(iv); // instance variable 사용 불가
		// 객체 생성없이 Method를 사용할 수 있기 때문에 객체가 생성되었는지 여부가 불확실하여, 사용X
		System.out.println(cv); } // class variable 사용 가능

	static void staticMethod2() { // static method
//		instanceMethod(); // instance method 사용 불가
		staticMethod(); } // class method 사용 가능
	
}
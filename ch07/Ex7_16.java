class Outer3 {
	int value = 10; // outer class iv
	
	class Inner { // inner class iv
		int value = 20;
		void method1() {
			int value = 40; // local class iv
			System.out.println("value: "+value);
			System.out.println("this.value: "+this.value);
			System.out.println("Outer3.this.value: "+Outer3.this.value);
		}
	}
}


public class Ex7_16 {

	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		Outer3.Inner inner = outer.new Inner();
		// outer class의 instance를 먼저 생성해야 instance class의 instance를 생성 가능
		// Instance Inner Class도 outer class의 instance member 처럼 생각
		// Instance 생성 방법: 외부class.내부class 매개변수 = 외부객체.new 내부 class();

		inner.method1();
	}
}
	
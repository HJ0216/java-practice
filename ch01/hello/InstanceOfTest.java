package hello;

class Milk {
	int x;
	Milk(int x) {this.x=x;}

	public String method(String s) {return s+s;}
	public int method2(int a, int b) {return (a*b);}
}
class CoffeeMilk extends Milk {
	int x; 
	int y;
	CoffeeMilk() {super(300); y=300;}
	// 조상 class의 iv의 초기화는 자손 class에서 직접하는 것이 아니라 생성자에서 super()로 설정
	// 조상 class의 생성자가 매개변수(parameter)를 받을 때만 자손 class에서 인자(argument) 설정 가능
	public String method(String s) {return s;}
}
class BananaMilk extends Milk {
	int x;
	BananaMilk() {super(400);}
	// 생성자 작성 시, super() or this()가 가장 먼저 나와야 함
	public int method2(int a, int b) {return (a+b);}
}


public class InstanceOfTest {
	public static void main(String[] args) {
		CoffeeMilk cm = new CoffeeMilk();
		
		if(cm instanceof CoffeeMilk) {System.out.println("CoffeeMilk cm");}
		if(cm instanceof Milk) {System.out.println("Milk cm");}
		if(cm instanceof Object) {System.out.println("Object cm");}
//		if(cm instanceof BananaMilk) {System.out.println("BananaMilk cm");}
//		형제 class간의 다형성 성립X
		
		System.out.println();
		Milk m = new BananaMilk();
		BananaMilk bm = new BananaMilk();
		System.out.println(m.method2(2,3)); // BananaMilk class Overriding
		System.out.println(bm.method2(2,3));

		Milk m2 = new Milk(100); // Milk 객체는 int를 필수적으로 받게 생성자를 설정
		System.out.println(m2.x);

		Milk m3 = new CoffeeMilk();
		System.out.println("m3.x: "+m3.x); // class Milk int x 출력
		// Milk 리모컨이 int x를 사용할 수 있다는 것은 Milk에 먼저 정의되어 있다는 뜻 -> 자손 class에도 int x가 있다면 조상 class int x값과 연관이 있다는 것을 추론
//		System.out.println("m3.y: "+m3.y); // class Milk에는 변수 y가 선언되어있지 않기 때문에 호출 불가		

		Milk m4 = new BananaMilk();
		System.out.println(m4.x); // class Milk의 int x 출력
		// new 생성자: 인스턴스 생성 -> 생성자 호출
		// 생성자가 1개도 없을 경우, 자동으로 기본생성자 ClassName(){} 생성
		// 생성자에서 조상 class의 변수를 사용할 때, 반드시 super or this를 호출해야 함
		// 만일 호출하지 않을 경우, 컴파일할 경우 super();가 자동 삽입되어 조상 class의 변수 값이 그대로 이용
	}
}

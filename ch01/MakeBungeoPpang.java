class BungeoPpang {
	String taste;
	int number;
	
	public void baked() {++number;}
	public void sold() {--number;}

}

class Sample {
	long add(int a, long b) {return a+b;}
	long add(long a, int b) {return a+b;}
}

// 컴파일 시, 생성자가 1개도 없으므로 기본 생성자 자동 추가
class Date1 {
	int value;
}

// 컴파일 시, 생성자가 1개 있으므로 기보 생성자 자동 추가X
class Date2 {
	int value;
	Date2(int x) {
		value = x;
	}
}

class Car {
	String color;
	String gearType;
	int door;

	Car(){
		this("White", "Manual", 4);
	}
	
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}	
}
class Car2 {
	String color; // iv
	String gearType;
	int door;

	Car2(String c, String g, int d) { // lv
		// 같은 class 내 참조변수 this(인스턴스 자신을 가리키는 참조변수) 생략
		color = c; // this.color -> color
		gearType = g;
		door = d;
	}
}


class Car3 {
	String color;
	String gearType;
	int door;
		
	Car3(String color, String gearType, int door) {
		// this가 없는 경우, 이름이 같아서 구분이 안됨
		// this가 없을 경우, color가 선언된 가장 가까운 변수 취급(여기서는 lv)
		this.color = color; // this.color = iv / color = lv
		this.gearType = gearType;
		this.door = door;
	}
}


class MyMath {
	long a; // iv 선언 시, long this.a로 선언하지 X
	long b; 
	static long c;

	MyMath(){}
	// MyMath(int a, int b) {}가 있으면 기본 생성자 컴파일 시 자동 생성 X

	MyMath(int a, int b) {
	// 매개변수가 있는 생성자 생성 시, iv와 lv의 이름이 동일하면 this를 통해 iv와 lv 구분 필요
		this.a = a; // this.a = iv / a = lv
		this.b = b;}

	MyMath(long c) {this.c = c;}
	// The static field MyMath.c should be accessed in a static way
	// 구분 할 필요가 있을 때, 참조변수 this는 static variable과 사용 권장X (iv임을 알려주는 용도이므로)
	// ClassName.staticVariable로 선언(MyMath.c = c;)
	// MyMath(long c) {c = c;} 모든 c lv 취급(The assignment to variable c has no effect)
	
	
	 // static이라는 단어가 없으면 다 instance method
	long add() {return a+b;}
	long add2() {return this.a+this.b;}
	// this.a, this.b가 long type iv a, b의 진짜 이름
	// 생략해도 a, b가 iv인 줄 알 수 있으면 this 생략 가능	
	long substact() {return c;}
	long substact2() {return this.c;}
	// 참조변수 this는 static variable과 사용 권장X (iv임을 알려주는 용도이므로)
	// ClassName.staticVariable로 선언(MyMath.c = c;)
	// instance method에서 this 사용 가능
	// instance method: iv, lv 사용 가능

	
	 // static(class) method
//	static long add() {return a+b;}
//	static long add2() {return this.a+this.b;}
	// static method: iv 사용 불가, this 사용 불가
	static long substract() {return c;}
//	static long substract2() {return this.c;}
	// Cannot use this in a static context
	// static method: this 사용 불가(this iv임을 나타내는 변수인데, iv는 cm에서 사용 불가)
	// -> 생성자에서 경고를 받으며 cv에 this를 붙이는 것까지만 가능
	// ClassName.staticVariable로 선언(MyMath.c = c;)
}


public class MakeBungeoPpang {
	public static void main(String[] args) {
		BungeoPpang bungeo = new BungeoPpang();
		bungeo.taste = "슈크림";
		bungeo.number = 4;
		
		System.out.println(bungeo.taste);
		System.out.println(bungeo.number);
		
		bungeo.baked();
		System.out.println(bungeo.number);

		bungeo.sold();
		System.out.println(bungeo.number);
		
		Sample sample = new Sample();
		System.out.println(sample.add(3, 3L));
		
		// 기본 생성자 호출
		Car car = new Car();
		System.out.println(car.color);
		System.out.println(car.gearType);
		System.out.println(car.door);

		// 매개변수가 있는 생성자 호출
		Car car2 = new Car("Blue", "Auto", 4);
		System.out.println(car2.color);
		System.out.println(car2.gearType);
		System.out.println(car2.door);
		
		MyMath mm = new MyMath(2, 3); // 매개변수가 있는 생성자에서 이미, 인자를 받음
		System.out.println(mm.add()); // add()에 추가 인자없이 실행 가능
		
		MyMath mm2 = new MyMath(); // 매개변수가 없는 생성자 호출 long a, b값이 따로 지정되지 않아 기본 값 0으로 고정 됨
		System.out.println(mm2.add()); // add()에 인자없이 실행할 경우, 0 + 0 = 0 반환

		MyMath mm3 = new MyMath(8); // cv를 매개변수(parameter)로 받는 생성자 호출
		System.out.println(mm3.substact()); // cv를 member로 하는 method 사용 가능
		System.out.println(mm3.substact2());
		
		System.out.println(MyMath.c); // 객체 생성없이 cv 소환 가능
		System.out.println(MyMath.substract()); // 객체 생성없이 cm 사용 가능
	}
}
abstract class Coffee {
	boolean caffeine;
	int cup;
	
	Coffee(){ // Abstract class도 constructor 작성
		caffeine = true;
		cup = 0;
	}
	
	Coffee(boolean b){ // 다른 class의 constructor에서 조상 class의 iv 변경을 하기 위해 대입
		caffeine = b;
	}
	
	abstract int order(int i);
	abstract void complete();

//	같은 class에서 abstract 구현X
//	void order() {System.out.println("Ordered");}
	
	// abstract class 내에서 일반 method 사용 가능
	void change() {}
}

class Americano extends Coffee {
	Americano(){super();}
	
	int order(int i) {
		return cup += i;
	}
	void complete() {System.out.println("Here`s your Coffee.");}	
	void tmp() {System.out.println("Solution1");}
}

class DecaffeinatedLatte extends Coffee {
	DecaffeinatedLatte(){super(false);} // 조상 class에 boolean arg를 받는 constructor 작성	
	int order(int i) {
		return cup += i;
	}
	void complete() {System.out.println("Here`s your Coffee.");}
	String tmp2() {return "Solution2";}
}

class Einspanner extends Coffee {
	Einspanner(){super();}
	
	int order(int i) {
		return cup += i;
	}
	void complete() {System.out.println("Here`s your Coffee.");}
	void spoon() {System.out.println("Here`s a spoon.");}
}


public class CoffeeTest {
	public static void main(String[] args) {
		Coffee coffee = new Americano(); // 다형성
		System.out.println("Included Caffeine: "+coffee.caffeine);
		System.out.println("Ordered Coffee: "+coffee.cup);
		
		System.out.println("Order Arrived");
		coffee.order(3);
		System.out.println("Ordered Coffee: "+coffee.cup);
		
		Coffee[] coffee2 = new Coffee[3]; // 추상 class 배열 생성 가능, 배열 길이 지정 -> 배열 생성
		coffee2[0] = new Americano();
		coffee2[1] = new DecaffeinatedLatte();
		coffee2[2] = new Einspanner();
//		coffee2[3] = new DecaffeinatedLatte(); // ArrayIndexOutOfBoundsException 유의
//		coffee2[2] = new Coffee(); // 추상 class 객체 생성 불가
		
		System.out.println("Included Caffeine: "+coffee2[1].caffeine);
		System.out.println("Ordered Coffee: "+coffee2[1].cup);
		coffee2[1].complete();
		coffee2[2].complete();
//		coffee2[2].spoon(); // 다형성 사용 시, coffee 참조변수에 없는 멤버는 객체에 멤버가 존재하더라도 사용하지 못함
				
		Americano ame = new Americano();
		ame.tmp();
//		System.out.println(ame.tmp());
//		The method println(boolean) in the type PrintStream is not applicable for the arguments (void)
		
		DecaffeinatedLatte dclat = new DecaffeinatedLatte();
		System.out.println(dclat.tmp2());
	}
}
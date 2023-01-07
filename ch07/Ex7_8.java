class Product {
	int price;
	float bonusPoint;
	
	// 이 상태로 compile하면, Constructor가 1개도 없으므로 기본 생성자(className(){}) 자동 추가
	// = Product(){}
	
	Product(int price){
		// 매개변수(int price)가 있는 생성자
		// Constructor: class와 이름이 동일해야함, class당 1개 이상의 생성자 필요
		// 객체 생성 시, 1회 호출
		// Constructor Overloading 가능
		this.price = price; // this.price=iv, price=lv
		bonusPoint = price*0.001f;
	}
		// int price, float bonusPoint 값을 초기화
		// 생성자가 1개라도 있을 경우, compile하더라도 기본 생성자 Product(){} 자동 추가 X
}

class Tv1 extends Product {
	Tv1() {
		// constructor method of parent class : Product(int price) 호출
		// Parent Member는 Parent Constructor를 호출해서 사용
		// Product에서 상속받은 변수에 전달
		// 생성자의 첫 줄에 반드시 다른 생성자(super or this)를 호출해야 하며, 그렇지 않을 경우 compiler가 직접 super(); 삽입
		// super(); - Child Constructor의 첫줄에서 사용
		super(1_900_000); // _로 자리수 구분(출력X)
		// 초기화: price=1_900_000, bonusPoint=1_900
	}
	public String toString() { // public 반환타입 method
		return "Tv1";
	}
}

class Computer1 extends Product {
	// constructor method of parent class : Product(int price) 호출
	// Product에서 상속받은 변수에 전달
	// super(); - Child Constructor의 첫줄에서 사용
	Computer1() {
		super(2_300_000);
	}
	public String toString() {
		return "Computer1";
	}
}

class Audio1 extends Product {
	// constructor method of parent class : Product(int price) 호출
	// Product에서 상속받은 변수에 전달
	// super(); - Child Constructor의 첫줄에서 사용
	Audio1() {
		super(560_000);
	}
	public String toString() {
		return "Audio1";
	}
}

class Buyer {
	// 기본 생성자를 사용하지 않고, 직접 초기화(method 사용X)
	int money = 3_000_000;
	float bonusPoint = 0;
	
	void buy(Product p) {
		// 다형성(상속 관계일 경우, 아래와 같은 객체 생성 가능)
		// Proudct p = new Tv1();
		// Proudct p = new Computer1();
		// Proudct p = new Audio1();
		if(money<p.price) {
			System.out.println("한도 초과입니다ㅠ."); // if 조건문이 참일 경우 실행
			return; // 해당 method를 끝냄
		} money -= p.price;
		  bonusPoint += p.bonusPoint;
		  System.out.println(p+"을/를 구매하였습니다:)!");
	}
}

public class Ex7_8 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv1()); // class Buyer의 method buy 사용
						  // 매개변수가 product뿐만 아니라 다형성에 의해 상속관계인 Tv1도 삽입 가능
		b.buy(new Computer1());
		b.buy(new Audio1());
		
		System.out.println("잔액: "+b.money+"원");
		System.out.printf("포인트: %4.2f점",b.bonusPoint);
	}

}

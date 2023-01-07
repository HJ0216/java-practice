class Product2 {
	int price;
	int bonusPoint;
	
	Product2(int price){ // 매개변수가 있는 생성자(Constructor), class와 동일한 이름
		this.price = price; // instance value, local value
		bonusPoint = (int)(price*0.001);
	}
	
	Product2() {}; // 기본 생성자
	// variable price, bonusPoint 2개;
	// 기본 생성자를 형성해서 모든 변수를 초기화 - 매개변수가 있는 생성자도 int price만 걸리므로 안전하게 기본 생성자 작성
}

class Tv2 extends Product2 {
	Tv2() {super(1_450_000);}
	// 생성자의 첫 줄에 반드시 다른 생성자(super or this)를 호출해야 하며, 그렇지 않을 경우 compiler가 직접 super(); 삽입
	// price: 1_450_000, bounsPoint: 1_450으로 초기화
	public String toString() {return "Tv";}
	// Tv2 class의 toString method 사용 시, String type "Tv" return
}

class Computer2 extends Product2 {
	Computer2() {super(2_560_000);}
	public String toString() {return "Computer";}
}

class Audio2 extends Product2 {
	Audio2() {super(870_000);}
	public String toString() {return "Audio";}
}

class Buyer2 {
	int money = 3_000_000;
	int bonusPoint = 0;
	
	Product2[] cart = new Product2[10];
	// Product2[] 배열 매개변수 cart : 총 10칸 - 다형성으로 product와 상속관계 class 삽입 가능
	// [] 배열 초기값 null setting
	int i = 0;
	
	void buy(Product2 p) { // 다형성: Product2 p 뿐만 아니라 Tv2 t, Computer2 c, Audio2 a 모두 가능
		if(money<p.price) {
			System.out.println("앗, 잔액! 타이어보다 싸다!");
			return; // return이 들어가있는 method 탈출
		}
		
		money -= p.price;
		// money = money-p.price
		bonusPoint += p.bonusPoint;
		cart[i++] = p;
		// : i를 먼저 대입한 후, 그 다음 계산부터 1을 증가 
		// ++i: 처음 계산 시 1을 더하고 대입
		// cart[0] = p
		
		System.out.println(p+". 구매 완.");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for(int i=0; i<cart.length; i++) {
			if(cart[i]==null) {break;}
			// break가 속한 반복문 탈출
			sum += cart[i].price;
			itemList += cart[i] + ", ";
			// = cart[i].toString
			// 문자열 연산자 +를 만나 .toString이 호출되었다고 생각
		}
		System.out.println("Total Amount: "+sum);
		System.out.println("Purchases: "+itemList);		
	}
}


public class Ex7_9 {
	public static void main(String[] args) {
		Buyer2 b = new Buyer2();
		
		b.buy(new Tv2());
		// Buyer2 class의 buy method에 객체 Tv2() 대입
		// 다형성: Product2 p = new Tv2();
		// buy(): cart[0] = Product p(new Tv2());
		b.buy(new Computer2());
		b.buy(new Audio2());

		b.summary();
	}
}
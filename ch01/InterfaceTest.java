class Juice {
	int sip;
	int MAX_SIP=50;
	Juice(int sip){this.sip = sip;}
}

class Vegetable extends Juice {
	Vegetable(int sip){super(sip);}
}

class Fruit extends Juice {
	Fruit(int sip){super(sip);}
}

interface Drinkable{}

class TomatoJuice extends Vegetable {
	TomatoJuice() {super(5);} // Vegetable(5)->Juice(5)
	public String toString() {return "Awesome TomatoJuice!";} // Overriding
}

class CarrotJuice extends Vegetable implements Drinkable {
	CarrotJuice(){super(4);}
	public String toString() {return "Unbelievable CarrotJuice!";}
}

class MangoJuice extends Fruit {
	MangoJuice(){super(3);}
	public String toString() {return "Fresh MangoJuice!";}
}

class OrangeJuice extends Fruit implements Drinkable {
	OrangeJuice(){super(2);}
	public String toString() {return "Sweety OrangeJuice!";}
}

class DrinkJuice implements Drinkable {
	DrinkJuice(){}
	
	public String toString() {return "DrinkJuice!";}

	int drink(Drinkable d) {
	// Drinkable, Drinkable을 구현한 class는 모두 args로 대입 가능
		if (d instanceof Juice) {
		// interface Drinkable을 구현한 instance가 Juice type으로 형변환이 가능할 경우,
			Juice j = (Juice)d; //	형변환 생략 불가(a에 Drinkable이 올지, Drinkable을 구현한 class가 올지 모르므로)
			System.out.println("최대 몇 모금 마실 수 있나요? "+j.MAX_SIP);
			System.out.println("한 번에 몇 모금인가요? "+j.sip);
			while(j.MAX_SIP-j.sip>0) {
				System.out.println(j.MAX_SIP-=j.sip);
			} return j.MAX_SIP-=j.sip;
		} else return -1;
	}
}	


public class InterfaceTest {
	public static void main(String[] args) {
		TomatoJuice tj = new TomatoJuice();
		CarrotJuice cj = new CarrotJuice();
		MangoJuice mj = new MangoJuice();
		OrangeJuice oj = new OrangeJuice();
		DrinkJuice dj = new DrinkJuice();

//		dj.mix(tj); //Drinkable interface를 구현하지 않았으므로 drink() 사용 불가
		dj.drink(cj);
//		dj.mix(mj); //Drinkable interface를 구현하지 않았으므로 drink() 사용 불가
		dj.drink(oj);
	}
}
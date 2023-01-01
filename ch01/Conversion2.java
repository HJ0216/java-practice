class Market3 {
	String name;
	int price;
	float bonusPoint = price*0.001f;
}

class Beverage3 extends Market3 {
	public void beverage3() {System.out.println("berverage:)");}
}

class Cookie3 extends Market3 {
	public void cookie3() {System.out.println("cookie:)");}
}

class IceCream3 extends Market3 {
	public void icecream3() {System.out.println("icecream:)");}
}


public class Conversion2 {
	public static void main(String[] args) {
//		총 멤버 변수: name, price, bonuspoint, berverage2, cookie2, icecream2
		Beverage3 bvg3 = new Beverage3();
		Market3 mB = bvg3;
		Market3 mC = new Cookie3();
		Market3 mI = new IceCream3();
		
		mB.name = "Coke"; // 객체를 생성해서 Market3 리모컨으로 객체 멤버인 name에 "Coke"를 지정
		mC.price = 1_000; 
		mI.bonusPoint = 2.0f;
		
//		mB.beverage3(); // Market3에 정의되지 않은 method 사용 불가

//		Beverage3 bvg33 = new Market3(); // 자손 class로 조상 class instance 사용 X		
	}
}
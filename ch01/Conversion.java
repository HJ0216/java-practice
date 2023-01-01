class Market2 {
	String name;
	int price;
	float bonusPoint;
	Market2(int price) {
		this.price = price;
		bonusPoint = price*0.001f;
	}
}

class Beverage2 extends Market2 {
	String name = "Bvg";
	Beverage2(){super(3_000);}
	public void beverage2() {System.out.println("berverage:)");}
}

class Cookie2 extends Market2 {
	String name = "Cki";
	Cookie2(){super(1_000);}
	public void cookie2() {System.out.println("cookie:)");}

}

class IceCream2 extends Market2 {
	String name = "Icm";
	IceCream2(){super(2_000);}
	public void icecream2() {System.out.println("icecream:)");}
}


public class Conversion {
	public static void main(String[] args) {
		Beverage2 b = new Beverage2();
		Market2 m = (Market2) b; // 자손(Beverage2)->조상(Market2)
		Market2 m2 = b; // 자손(Beverage2)->조상(Market2): 형변환 생략가능

		Beverage2 b2 = (Beverage2) m; // 조상(Market2)->자손(Beverage2)
//		Beverage2 b3 = m; // 조상(Market2)->자손(Beverage2): 형변환 생략불가
		
//		Cookie2 c = (Cookie2) b; // 형제간 형변환 불가
	}
}
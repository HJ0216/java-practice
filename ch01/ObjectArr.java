class Market {
	String open;
	String close;
	int price;
	float bonusPoint;
	Market() {}
	Market(int price) {
		this.price = price;
		bonusPoint = price*0.001f;
	}
}

class Market4 {
	// OpeningHours class 재활용
	OpeningHours ohs = new OpeningHours();
	int price;
	float bonusPoint;
	Market4() {};
	Market4(int price) {
		this.price = price;
		bonusPoint = price*0.001f;
	}
}

class OpeningHours {
	String open = "9 a.m.";
	String close = "6 p.m.";
}

class Beverage extends Market {
	Beverage(){super(3_000);}
	public String toString() {return "Beverage";} // toString() overriding
}

class Snack extends Market {
	Snack(){super(1_000);}
	public String toString() {return "Snack";}
}

class IceCream extends Market {
	IceCream(){super(2_000);}
	public String toString() {return "IceCream";}
}

class ParentMath {int i = 10;}

class ChildMath extends ParentMath {
	int i = 20;
	
	void method() {
		System.out.println("i: "+i);
		System.out.println("this.i: "+this.i);
		System.out.println("super.i: "+super.i);
	}
}


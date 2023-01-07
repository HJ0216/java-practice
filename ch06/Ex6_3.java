
public class Ex6_3 {

	public static void main(String[] args) {
		//class variable은 객체를 생성하지 않더라도 바로 이용 가능
		System.out.println("Card.width = "+Card.width);
		System.out.println("Card.width = "+Card.width);
		
		//instance variable은 객체를 생성하고 사용 가능
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;

		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 3;
		
		System.out.println("c1: "+c1.kind+", "+c1.number);
		System.out.println("c2: "+c2.kind+", "+c2.number);
		
		//iv표기와 오해할 가능성이 높으므로 Card.width 형태로 기재
		//c1으로 표기되었지만, c2까지 변경됨(The static field Card.width should be accessed in a static way)
//		c1.width = 300;
//		c1.height = 400;
		
		Card.width = 300;
		Card.height = 400;
		
		System.out.println("c1.width: "+c1.width+", "+c1.height);
		System.out.println("c1.width: "+c2.width+", "+c2.height);

	}

}

class Card {
	String kind;
	int number;
	static int width = 200;
	static int height = 300;
}


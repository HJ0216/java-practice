import java.util.Objects;
// Objects class: 객체와 관련된 유용한 메서드를 제공하는 util class

class Card {
	String kind;
	int number;
	
	Card() {this("Spade", 1);}
	// Default constructor: 변수 선언과 동일한 순서로 입력
	
	 // (Overloading) 매개변수가 있는 생성(강제 입력)
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	// Overriding Object class의 toString method를 
	public String toString() {
		return "kind: "+kind+", number: "+number;
	}
	
	// Object class의 equals overriding: 선언부 일치 -> ()안에 Object obj 입력
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) {return false;}
		Card c = (Card) obj;
		// obj 매개변수는 value(버튼)가 없음 -> 형변환 필요 -> obj를 Card로 형 변환
		// return this.kind==c.kind && this.number==c.number;
		// kind는 string이므로 ==이 아닌, equals로 비교
		return this.kind.equals(kind) && this.number==c.number;
	}
	
	// equals를 overriding하면, hashcode도 overriding 해야함
	public int hashCode() {
		return Objects.hash(kind, number); // 가변인자: 매개변수 개수가 정해져있지 않은 것
		// hash(iv): iv에 입력된 값이 모두 동일(equals 기준 true)하다면 같은 hashcode 값 반환
	}
}

public class Ex9_4 {
	public static void main(String[] args) {
		Card c1 = new Card(); // Default Constructor: 해당 class의 정해져있는 값을 초기값으로 호출
		Card c2 = new Card(); // Default Constructor
		Card c3 = new Card("Heart", 3); // Parameter(매개변수) Constructor: 입력값을 초기값으로
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());

		// equals overriding 전 주소값 상이로 인한 false 발생
		System.out.println(c1.equals(c2));

		// equals가 동일하면 hashCode도 동일해야 함
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}
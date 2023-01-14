import java.util.ArrayList;

class Fruit implements Eatable { // interface 구현
	public String toString() {return "Fruit";}
}
class Mandarin extends Fruit { // heritage
	public String toString() {return "Mandarin";}
}
class Kumquat extends Mandarin { // interface는 다중, inheritance는 단일
	public String toString() {return "Kumquat";}
}
class Orange extends Fruit {
	public String toString() {return "Orange";}
}
class TeddyBear {
	public String toString() {return "TeddyBear";}
}

interface Eatable {}


public class Ex12_3 {
	public static void main(String[] args) {
		// 타입 지정 객체 만들기(class가 있어야 함)
		FruitBox<Fruit> fruitBox1 = new FruitBox<Fruit>();
		MandarinBox<Mandarin> mandarinBox1 = new MandarinBox<Mandarin>();
	
//		FruitBox<TeddyBear> teddyBearBox = new FruitBox<TeddyBear>();
//		FruitBox의 대입된 타입에 Fruit과 Eatable만 지정
		
		fruitBox1.add(new Fruit());
		fruitBox1.add(new Mandarin());
		fruitBox1.add(new Orange());
		// void add(T item): T=Box의 Generics<T>
		// <T> = <Fruit>
		// 다형성에 의해 Fruit와 자손들 가능

		mandarinBox1.add(new Mandarin());
		mandarinBox1.add(new Kumquat());
		// MandarinBox.add(new Orange());
		// Orange는 Mandarin()의 자손이 아님
		
		System.out.println("fruitBox1: "+fruitBox1); // toString method 사용
		System.out.println("madarinBox1: "+mandarinBox1);
		System.out.println(fruitBox1.get(1));
		System.out.println(fruitBox1.size());
	}
}

class FruitBox <T extends Fruit & Eatable> extends Box<T> {}
// <> 대입된 타입: 상속 및 인터페이스 extends 사용, 구분자 & 활용
// 타입변수는 임의 지정 가능

class MandarinBox <T extends Fruit & Eatable> extends Box<T> {}

class Box<T> { // class name = Box, <> generic name = T
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);} // T type의 parameter(매개변수) item 선언
	T get(int i)	 {return list.get(i);} // ArrayList.get(): list의 i번째에 있는 값 반환
	int size()		 {return list.size();}
	public String toString() {return list.toString();}
}
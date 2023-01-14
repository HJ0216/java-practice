import java.util.ArrayList;

class Fruit2 				 {public String toString() {return "Fruit";}}
class Banana2 extends Fruit2 {public String toString() {return "Banana";}}
class Mango2 extends Fruit2  {public String toString() {return "Mango";}}
class Orange2 extends Fruit2 {public String toString() {return "Orange";}}

class Juice {
	String name;

	Juice(String name)		 {this.name=name + " Juice";}
	public String toStirng() {return name;}
}

class Juicer {
	static String makeJuice(FruitBox2<? extends Fruit2> box) {
		// Generic<? extends Fruit2>: Fruit2와 그 자손들만 대입 가능
		String tmp = ""; // "" != Null
	
		for(Fruit2 f : box.getList())
			// 향상된 for문: Fruit2 f에 box.getList() element를 순서대로 대입
			{tmp += f + ", ";}
		
		return tmp;
	}
}

public class Ex12_4 {
	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Banana2> bananaBox = new FruitBox2<Banana2>();
		FruitBox2<? extends Fruit2> bananaBox2 = new FruitBox2<Banana2>();
		FruitBox2<Mango2> mangoBox = new FruitBox2<Mango2>();
		
		fruitBox.add(new Fruit2());
		fruitBox.add(new Banana2()); // 다형성
		fruitBox.add(new Mango2()); // 다형성
		bananaBox.add(new Banana2());
//		bananaBox.add(new Mango2()); // 형제간 다형성 성립X
		
		System.out.println("fruitBox: "+Juicer.makeJuice(fruitBox));
		System.out.println("bananaBox: "+Juicer.makeJuice(bananaBox));
		System.out.println("bananaBox2: "+Juicer.makeJuice(bananaBox2));
		System.out.println("mangoBox: "+Juicer.makeJuice(mangoBox));
		
		System.out.println();
		
		Juice juice = new Juice("Mango-Banana");
		// class 사용 전 객체 생성
		// Juice class에 String을 반드시 생성자로 받기로 적혀있으므로 기본 생성자 생성X, 인자 입력 필수
		
		System.out.println("Juice: "+juice.toStirng());
	}
}

class FruitBox2 <T extends Fruit2> extends Box2<T> {}

class Box2<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) 		 {list.add(item);}
	T get(int i)	 		 {return list.get(i);}
	ArrayList<T> getList()   {return list;}
	// makeJuice() for문에서 list의 요소를 하나씩 뽑기 위해 추가
	int size()		 		 {return list.size();}
	public String toString() {return list.toString();}
}
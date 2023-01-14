import java.util.ArrayList;
import java.util.List;

class Product {}
class Tv2 extends Product {}
class Audio2 extends Product {}

public class Ex12_1 {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv2>	   tvList	   = new ArrayList<Tv2>();
		List<Tv2>		   tvList2	   = new ArrayList<Tv2>();
		// class간 다형성 성립
//		ArrayList<Product> tvList = new ArrayList<Tv>();
		// Error: Type mismatch: cannot convert from ArrayList<Tv> to ArrayList<Product>
		// <> 대입된 타입이 동일해야 함(다형성 성립X)
		
		productList.add(new Tv2()); // 매개변수.add(generics type object)
		// 다형성: product의 자손 tv, audio 가능
		productList.add(new Audio2()); // 조상 리모컨, 자손 객체
		
		tvList.add(new Tv2()); // 매개변수.add(generics type object)
//		tvList.add(new Audio2()); // 조상-자손 관계X->다형성 성립X
//		tvList.add(new Product()); // 자손 리모컨, 조상 객체 추가X (자손 리모컨이 제대로 동작하지 않을 수 있으므로)
		
		printAll(productList); // new ArrayList<Product>() - 대입된 타입이 <Product>로 동일
//		printAll(tvList); // new ArrayList<Tv2>() - 대입된 타입이 <Tv2>로 상이
	}
	
	public static void printAll(ArrayList<Product> list) {
		for(Product p : list)
		// 향상된 for문: Product type p에 list element를 순서대로 대입
			System.out.println(p);
	}

}

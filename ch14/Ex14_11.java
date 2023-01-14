import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Beverage2 {
	String 	name;
	boolean recommendation;
	String 	brand;
	String 	taste;
	int 	price;
	
	Beverage2(String name, boolean recommendation, String brand, String taste, int price) {
		this.name 			= name;
		this.recommendation = recommendation;
		this.brand 			= brand;
		this.taste 			= taste;
		this.price 			= price;
	}
	
	String  getName()  {return name;}
	boolean recommendation()   {return recommendation;}
	String  getBrand() {return brand;}
	String  getTaste() {return taste;}
	int 	getPrice() {return price;}

	public String toString() {
		return String.format("[%s, %s, %s, %s, %s원]",
					name, recommendation ? "Yes":"No", brand, taste, price);
	}
	enum CtoB {Good, Soso, Bad} // groupingby()에서 사용
}

public class Ex14_11 {

	public static void main(String[] args) {
		Beverage2[] bvgArr = {
				new Beverage2("Vanilla Latte",	 	true,  "Starbucks", 	 "Bitter", 6000),
				new Beverage2("Cafe Mocha", 	 	true,  "TomNToms", 		 "Sweet",  5000),
				new Beverage2("Vanilla Latte", 		true,  "Hollys", 		 "Bitter", 5000),
				new Beverage2("Vanilla Latte", 	 	true,  "Coffee Bean", 	 "Bitter", 6000),
				new Beverage2("ToffeeNut Latte",  	true,  "Ediya", 		 "Bitter", 4000),
				new Beverage2("Pong Crush", 	 	true,  "Mega Coffee", 	 "Sweet",  3000),
				new Beverage2("Matcha Latte", 	 	true,  "GongCha", 		 "Bitter", 5000),
				new Beverage2("Peach Smoothie",  	false, "Ediya", 		 "Sour",   3000),
				new Beverage2("Cool Lime Fijio",  	true,  "Starbucks", 	 "Sour",   6000),
				new Beverage2("Americano", 		 	false, "Coffee Bean", 	 "Bitter", 5000),
				new Beverage2("Einspanner Latte", 	true,  "Compose Coffee", "Bitter", 4000),
				new Beverage2("Vanilla Latte", 	 	false, "Compose Coffee", "Bitter", 3000),
				new Beverage2("Choco Latte", 	 	false, "Mega Coffee", 	 "Sweet",  3000),
				new Beverage2("Americano", 		 	true,  "TomNToms", 		 "Bitter", 5000),
				new Beverage2("Cold Brew", 		 	true,  "Mmth", 			 "Bitter", 3000),
				new Beverage2("Cube Latte", 	 	false, "Dutch&Bean",	 "Bitter", 6000),
				new Beverage2("Mango Cube", 	 	true,  "Dalkom", 		 "Sweet",  6000),
				new Beverage2("GreenGrapes Ade",  	false, "Dutch&Bean", 	 "Sour",   5000),
				new Beverage2("EarlGray Tea", 	 	false, "Gongcha", 		 "Bitter", 3000),
				new Beverage2("Milk Tea", 			true,  "TwoSome", 		 "Sweet",  6000),
				new Beverage2("Americano", 			false, "TwoSome", 		 "Bitter", 5000),
				new Beverage2("StrawBerry Smoothie",true,  "Hollys", 		 "Sweet",  6000),
				new Beverage2("Snow Mmth", 			true,  "Mmth", 			 "Bitter", 4000),
				new Beverage2("Cube Latte", 		false, "Dalkom", 		 "Bitter", 6000)
		};
		
		System.out.println("1. 단순 그룹화(브랜드별)");
		Map<String, List<Beverage2>> bvgByBrand = Stream.of(bvgArr) // String: 브랜드
				.collect(groupingBy(Beverage2::getBrand));
		
		for(List<Beverage2> brand : bvgByBrand.values()) { // values(): List<Beverage2>
			for(Beverage2 b : brand) {
				System.out.println(b);
			}
		}
		
		System.out.println();
		System.out.println("2. 단순 그룹화(가성비별)");
		Map<Beverage2.CtoB, List<Beverage2>> bvgByCtoB = Stream.of(bvgArr)
				.collect(groupingBy(b -> {
					if(b.getPrice() >= 6000) {return Beverage2.CtoB.Bad;}
					else if(b.getPrice()>=4000) {return Beverage2.CtoB.Soso;}
					else {return Beverage2.CtoB.Good;}
				}));
		TreeSet<Beverage2.CtoB> keySet = new TreeSet<>(bvgByCtoB.keySet());
		// Good->Soso->Bad로 출력(TreeSet: 순서O, 중복X)
		
		for(Beverage2.CtoB key : keySet) {
			System.out.println("["+key+"]");
			
			for(Beverage2 b : bvgByCtoB.get(key)) { // key: Beverage2.CtoB
				System.out.println(b);
			}
			System.out.println();
		}

//		for(List<Beverage2> CtoB : bvgByCtoB.values()) { // TreeSet이 이용되지 않았으므로 원하는 순서대로 출력 X
//			System.out.println();
//			for(Beverage2 b : CtoB) {
//				System.out.println(b);
//			}
//		}	
		
		System.out.printf("%n3. 단순 그룹화 및 가성비별 제품수%n");
		Map<Beverage2.CtoB, Long> bvgCntByCtoB = Stream.of(bvgArr)
				.collect(groupingBy(b -> {
					if(b.getPrice()>=6000) {return Beverage2.CtoB.Bad;}
					else if(b.getPrice()>=4000) {return Beverage2.CtoB.Soso;}
					else {return Beverage2.CtoB.Good;}
				}, Collectors.counting()));
		for(Beverage2.CtoB key : bvgCntByCtoB.keySet()) { // keySet[enum, good-so-bad] 순서대로 출력을 위해
			System.out.printf("[%s] - %d개 ", key, bvgCntByCtoB.get(key));
		} System.out.println();
		
		System.out.printf("%n4. 다중 그룹화(추천별, 가격별)");
		Map<Boolean, Map<Integer, List<Beverage2>>> bvgByRcmdandPrice = 
				Stream.of(bvgArr).collect(groupingBy(Beverage2::recommendation,
										  groupingBy(Beverage2::getPrice)));
		
		for(Map<Integer, List<Beverage2>> recommendation : bvgByRcmdandPrice.values()) {
			for(List<Beverage2> price : recommendation.values()) { // recommendation.values(): List<Beverage2>
				System.out.println();
				for(Beverage2 b : price) {
					System.out.println(b);
				}
			}
		}
		
		System.out.printf("%n5. 다중 그룹화 및 통계(추천별, 맛별 1등)%n");
		Map<Boolean, Map<String, Beverage2>> topByRcmdandTaste = 
				Stream.of(bvgArr).collect(groupingBy(Beverage2::recommendation,
										  groupingBy(Beverage2::getTaste,
										  // 추천->맛 그룹화
												  collectingAndThen(minBy(Comparator.comparingInt(Beverage2::getPrice)) // min 계산
														  						, Optional::get)))); // min값이 null일 수 있으므로 Optional에 담아 각 요소를 꺼내서 Beverage2에 반환
		for(Map<String, Beverage2> taste : topByRcmdandTaste.values())
			for(Beverage2 b : taste.values())
				System.out.println(b);
		
		System.out.printf("%n6. 다중 그룹화 및 통계(추천별, 맛별, 가성비 그룹)%n");
		Map<String, Set<Beverage2.CtoB>> bvgByCtoBGroup = Stream.of(bvgArr)
				.collect(groupingBy(b -> b.recommendation()+", "+b.getTaste(), // Map-key(rcmd+tasete를 String 화)
				// 추천->맛 그룹화가 아닌 추천+맛 그룹화 진행
						Collectors.mapping(b -> {
							if(b.getPrice()>=6000) 		return Beverage2.CtoB.Bad;
							else if(b.getPrice()>=4000) return Beverage2.CtoB.Soso;
							else 						return Beverage2.CtoB.Good;
						}, Collectors.toSet()))); // map-value
		Set<String> keySet2 = bvgByCtoBGroup.keySet(); // 여기서의 ketSet!=treeSet의 ketSet
		
		for(String key : keySet2) { // keySet2 = String(맛+추천)
			System.out.println("["+key+"]"+bvgByCtoBGroup.get(key));
			// bvgByCtoBGroup.get(key): key는 map의 key가 아니라 for문의 지역변수 key
			// get(key): map에서 key에 맞는 value return
		    // if this map contains a mapping from a key{@code k} to a value {@code v} such that
		    // {@code Objects.equals(key, k)}, then this method returns {@code v};
		}
	}
}
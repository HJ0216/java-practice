import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class Beverage {
	String 	name;
	boolean recommendation;
	String 	brand;
	String 	taste;
	int 	price;
	
	Beverage(String name, boolean recommendation, String brand, String taste, int price) {
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
		return String.format("[%s, %s, %s, %s, %,d원]",
					// format에 recommendation 자리에 boolean type b를 작성할 경우, true가 나옴
					// yes, no가 모두 true 취급
					// 만일 string으로 출력하고 싶으면 조건식 활용
					name, recommendation ? "Yes":"No", brand, taste, price);
	}
	enum CtoB {Good, Soso, Bad} // groupingby()에서 사용
}

public class Ex14_10 {

	public static void main(String[] args) {
		Beverage[] bvgArr = {
				new Beverage("Vanilla Latte",	 	true,  "Starbucks", 	 "Bitter", 5600),
				new Beverage("Cafe Mocha", 		 	true,  "TomNToms", 		 "Sweet",  4600),
				new Beverage("Vanilla Latte", 		true,  "Hollys", 		 "Bitter", 6300),
				new Beverage("Vanilla Latte", 	 	true,  "Coffee Bean", 	 "Bitter", 6100),
				new Beverage("ToffeeNut Latte",  	true,  "Ediya", 		 "Bitter", 4100),
				new Beverage("Pong Crush", 		 	true,  "Mega Coffee", 	 "Sweet",  3800),
				new Beverage("Matcha Latte", 	 	true,  "GongCha", 		 "Bitter", 4800),
				new Beverage("Peach Smoothie", 	 	false, "Ediya", 		 "Sour",   4500),
				new Beverage("Cool Lime Fijio",  	true,  "Starbucks", 	 "Sour",   5900),
				new Beverage("Americano", 		 	false, "Coffee Bean", 	 "Bitter", 4500),
				new Beverage("Einspanner Latte", 	true,  "Compose Coffee", "Bitter", 4300),
				new Beverage("Vanilla Latte", 	 	false, "Compose Coffee", "Bitter", 3600),
				new Beverage("Choco Latte", 	 	false, "Mega Coffee", 	 "Sweet",  3900),
				new Beverage("Americano", 		 	true,  "TomNToms", 		 "Bitter", 4600),
				new Beverage("Cold Brew", 		 	true,  "Mmth", 			 "Bitter", 3500),
				new Beverage("Cube Latte", 		 	false, "Dutch&Bean",	 "Bitter", 5600),
				new Beverage("Mango Cube", 		 	true,  "Dalkom", 		 "Sweet",  6100),
				new Beverage("GreenGrapes Ade",  	false, "Dutch&Bean", 	 "Sour",   5500),
				new Beverage("EarlGray Tea", 	 	false, "Gongcha", 		 "Bitter", 4100),
				new Beverage("Milk Tea", 			true,  "TwoSome", 		 "Sweet",  6500),
				new Beverage("Americano", 			false, "TwoSome", 		 "Bitter", 5100),
				new Beverage("StrawBerry Smoothie", true,  "Hollys", 		 "Sweet",  6300),
				new Beverage("Snow Mmth", 			true,  "Mmth", 			 "Bitter", 4300),
				new Beverage("Cube Latte", 			false, "Dalkom", 		 "Bitter", 6100)
		};
		
		System.out.println("1. 단순분할(추천여부)");
		Map<Boolean, List<Beverage>> bvgByRcmd = Stream.of(bvgArr)
				.collect(partitioningBy(Beverage::recommendation));
						// Collectors import 안되어 있으면, Collectors.partitioningBy 기재
		
		List<Beverage> recommendation = bvgByRcmd.get(true); // map.get(): key와 value 중 value 값 반환
		List<Beverage> non_recommendation = bvgByRcmd.get(false);
		
		for(Beverage b : recommendation) System.out.println(b);
		for(Beverage b2 : non_recommendation) System.out.println(b2);
		// for문안의 변수는 지역변수이므로 다른 lv와 중첩되도 상관 없음
		
		
		System.out.println();
		System.out.println("2. 단순분할 및 통계(추천 개수)");
//		System.out.printf("%n2. 단순분할 및 통계(추천 개수)%n")
		Map<Boolean, Long> bvgNumByRcmd = Stream.of(bvgArr)
				.collect(partitioningBy(Beverage::recommendation, counting()));
				// partitioningBy: import static java.util.stream.Collectors.*;
				// counting: import static java.util.stream.Collectors.*;
		System.out.println("추천수: "+bvgNumByRcmd.get(true));
		System.out.println("비추천수: "+bvgNumByRcmd.get(false));
		
		
		System.out.printf("%n3. 단순분할 및 통계(가장 비싼 음료)%n");
		Map<Boolean, Optional<Beverage>> topPriceByRcmd = Stream.of(bvgArr)
		// Beverage가 null 값이 나올 수도 있으므로 Optioanl 객체로 감싸기
				.collect(partitioningBy(Beverage::recommendation,
						maxBy(Comparator.comparingInt(Beverage::getPrice))));
						// import static java.util.stream.Collectors.maxBy;
						// Comparator.comparingInt: Beverage에서 getPrice(int)해서 비교하는 comparator

		
		System.out.println("가장 비싼 추천 음료: "+topPriceByRcmd.get(true));
		System.out.println("가장 비싼 비추천 음료: "+topPriceByRcmd.get(false));

		Map<Boolean, Beverage> topPriceByRcmd2 = Stream.of(bvgArr)
		// Optional::get(java:109)을 통해 Optional의 값을 추출해서 Beverage에 넣음
				.collect(partitioningBy(Beverage::recommendation,
						collectingAndThen(maxBy(Comparator.comparingInt(Beverage::getPrice)), Optional::get)));
						// import static java.util.stream.Collectors.collectingAndThen;
						// collectingAndThen: collecting 진행 후 그 결과에 메서드 하나를 더 호출(Optioanl::get) 할 수 있게 함


		System.out.println("가장 비싼 추천 음료: "+topPriceByRcmd2.get(true));
		System.out.println("가장 비싼 비추천 음료: "+topPriceByRcmd2.get(false));

		
		System.out.printf("%n4. 단순분할 및 통계(가장 저렴한 음료)%n");
		Map<Boolean, Optional<Beverage>> bottomPriceByRcmd = Stream.of(bvgArr)
				.collect(partitioningBy(Beverage::recommendation,
						minBy(Comparator.comparingInt(Beverage::getPrice))));

		System.out.println("가장 저렴한 추천 음료: "+bottomPriceByRcmd.get(true));
		System.out.println("가장 저렴한 비추천 음료: "+bottomPriceByRcmd.get(false));
		
		
		System.out.printf("%n5. 다중분할(추천별 4000원 이하 음료)%n");
		Map<Boolean, Map<Boolean, List<Beverage>>> limitBvgByRcmd = 
				Stream.of(bvgArr).collect(partitioningBy(Beverage::recommendation,
						partitioningBy(b -> b.getPrice()<=4000)));
		
		List<Beverage> limitRcmdBvg = limitBvgByRcmd.get(true).get(true);
		List<Beverage> limitNrcmdBvg = limitBvgByRcmd.get(false).get(true);
		
		for(Beverage b : limitRcmdBvg) System.out.println(b);
		for(Beverage b2 : limitNrcmdBvg) System.out.println(b2);
	}
}
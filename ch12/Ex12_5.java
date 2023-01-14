enum Direction {east, south, west, north} // 열거형 타입의 상수에 0, 1, 2, 3 값 부여

class Direction2 {
	static String east2 = "east2";
	static String south2 = "south2";
	String west2 = "west2";
	String north2 = "north2";
}

public class Ex12_5 {
	public static void main(String[] args) {
		// 열거형 타입 변수에 저장하는 다양한 방법
		Direction d1 = Direction.east; // 열거형 타입.상수 이름
		Direction d2 = Direction.valueOf("east");
		// values(), valueOf(): 컴파일러가 자동 추가(F3 눌러도 class 설명 X)
		Direction d3 = Enum.valueOf(Direction.class, "east");
		// Enum class 사용: valueOf(Class<T> enumClass, String name)
		Direction d4 = Direction.north;

		System.out.println("d1: "+d1);
		System.out.println("d2: "+d2);
		System.out.println("d3: "+d3);
		System.out.println("d4: "+d4);

		System.out.println(Direction.east);
		Direction2 dir2 = new Direction2();
		System.out.println(dir2.east2);
		// The static field Direction2.east2 should be accessed in a static way
		// static은 class.cvName 형식으로 선언됨, iv는 객체를 생성하고 선언됨
		System.out.println(dir2.west2);
		
		System.out.println(Direction2.east2);
		System.out.println(Direction2.south2);
//		System.out.println(Direction2.west2);
//		System.out.println(Direction2.north2);		
		// Error: Cannot make a static reference to the non-static field
		// enumeration과 class의 차이: iv에 있어 객체 생성 유무		
		
		System.out.println("d1==d2? : "+ (d1==d2));
		// 객체지만, equal 대신 == 사용 가능
		System.out.println("d1==d3? : "+ (d1==d3));
		System.out.println("d1==d4? : "+ (d1==d4));
		System.out.println("d2==d3? : "+ (d2==d3));
		System.out.println("d2==d4? : "+ (d2==d4));
		System.out.println("d3==d4? : "+ (d3==d4));
		System.out.println("d1.equals(d2)? : "+d1.equals(d2));
//		System.out.println("d2 > d3? : "+ (d2>d3));
		// Error: 객체는 단순 비교 연산자 사용 불가
		System.out.println("d3.comparedTo(d4)? : "+d3.compareTo(d4));
		// compareTo(): 왼쪽이 1 더 클 경우, +1 / 같을 경우, 0 / 오른쪽이 1 더 클 경우 -1
		// 계산법: values(d3) - values(d4) = east(0) - west(3) = -3
		System.out.println("d1.comparedTo(d3)? : "+d1.compareTo(d3));
		
		switch(d1) { // case가 많을 경우 if문 대신
		case east: // switch에서는 Direction.east로 쓰지X
			System.out.println("EAST"); break;
		case south:
			System.out.println("SOUTH"); break;
		case west:
			System.out.println("WEST"); break;
		case north:
			System.out.println("NORTH"); break;
		default:
			System.out.println("INVAILD DIRECTION"); break;
		}
		
		Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환
		
		for(Direction d : dArr)
		// for(Direction d : Direction.values())
			{System.out.printf("%s=%d%n", d.name(), d.ordinal());} // 이름, 순서
			// 상수의 순서 != 상수의 값
	}
}
enum HMJW {
	Hello((int)(Math.random()*20)+1, "@"), // Hello라는 객체에서 생성자()를 호출하는 개념
	My((int)(Math.random()*20)+1, "#"),
	Java((int)(Math.random()*20)+1, "&"),
	World((int)(Math.random()*20)+1, "*");
	
	// enum에서 지정된 값이 아닌 다른 값을 지정하려고 할 때
	private static final HMJW[] HMJW_ARR = HMJW.values(); // 열거형의 값을 모두 배열에 담음
	private final int value; // 1. 관련 iv 선언
	private final String symbol;
	
	// enum에서 생성자는 늘 private로 선언되므로 private 생략 -> 해당 class 외부에서 사용 불가
	HMJW(int value, String symbol) { // 2. 생성자 작성
		this.value = value;
		this.symbol = symbol;
	}
	
	// get(): private로 선언된 값을 우회적으로 불러옴	
	public int getValue() 	  {return value;}
	public String getSymbol() {return symbol;}
	
	public static HMJW choose(int idx) {
		if(idx<1 || idx>4)
			// HMJW_ARR[idx -1]의 범위가 0~3까지로 제한
			{throw new IllegalArgumentException("Invaild value "+idx);}
			// method에 유효하지 않은 인수가 대입되었을 경우
		return HMJW_ARR[idx -1];
		// HMJW의 각 value를 배열로 하는 HMJW_ARR에 idx-1를 대입 입자로 부여
		// HMJW_ARR[idx -1] = {String enumName, int getValue, String getSymbol}
	}
		
	public HMJW rotate(int num) {
		num = num%4; // 배열의 길이가 4이므로 4로 나눈 나머지 값 구하기		
		if(num<0) {num+=4;} // 반시계방향으로 돌 경우, 나머지 값에 +4 해주기
		
		return HMJW_ARR[(num+ordinal())%4];
		// HMJW.World.rotate(4)
		// num = 0
		// HMJW_ARR[num] = HMJW_ARR[0] = "Hello" 출력
		// 위치 3에서 시작했으므로 필요한 값 HMJW_ARR[3]
		// num+3 선언하면 되는가
		// HMJW.Java.rotate(4)
		// num = 0
		// HMJW_ARR[num+3] = HMJW_ARR[3] = "World" 출력
		// 위치 2에서 시작했으므로 필요한 값 HMJW_ARR[2]
		// 시작 위치값을 지정해주는 초기값 필요
		// 입력된 인수의 ordinal() 이용
		// num + ordinal()
		// 입력받는 값이 int num 밖에 없으므로 추가적으로 ordinal 값을 받기위한 매개변수 필요
		// HMJW rotate(int ordinal, int num) -> ordinal을 알아야하는 불편함
		// enum HMJW에 rotate()를 사용하므로 추가적으로 ordinal()을 추가적인 내용 없이 이용 가능
		// HMJW.Java.rotate(3)
		// num = 3
		// HMJW_ARR[num+ordinal()] = HMJW_ARR[5]: ArrayIndexOutOfBoundsException
		// HMJW_ARR[(num+ordinal())%4] = HMJW_ARR[1] = "My" 출력
	}
	
	public String toString() {return name()+getSymbol();}
	// name()은 enum에 자체 내장되어있는 method(F3->ctrl+o 활용)
	// return name(열거형의 이름: Hello, My, Java, World)
}

public class Ex12_6 {
	public static void main(String[] args) {
		for(HMJW h : HMJW.values()) // values()는 enum 컴파일 시, 자동으로 추가되는 method로 enum과 관련된 값을 갖고 있음
			{System.out.printf("%s=%d%n", h.name(), h.ordinal());} // 순서
		System.out.println();
		
		for(HMJW h : HMJW.values())
			{System.out.printf("%s=%d%n", h.name(), h.getValue());} // 지정값
		System.out.println();
		
		for(HMJW h : HMJW.values())
			{System.out.printf("%s=%s%n", h.name(), h.getSymbol());} // 지정값
		System.out.println();
		
		// 열거형 타입 변수에 저장하는 다양한 방법
		HMJW h1 = HMJW.Hello;
		// HMJW h1 = Enum.valueOf(HMJW.class, "Hello");
		// HMJW h1 = HMJW.Hello;
		HMJW h3 = HMJW.valueOf("Java");
		HMJW h2 = HMJW.choose(4); // = HMJW h2 = HMJW.World;
		
		System.out.println();
		System.out.printf("h1=%s, %d%n", h1.name(), h1.ordinal()); // ordinal != int
		System.out.printf("h3=%s, %d, %d%n", h3.name(), h3.getValue(), h3.ordinal());
		System.out.printf("h2=%s, %d, %s, %d%n", h2.name(), h2.getValue(), h2.getSymbol(), h2.ordinal());
		
		System.out.println();
		System.out.println(HMJW.Hello.rotate(1));
		System.out.println(HMJW.My.rotate(2));
		System.out.println(HMJW.Java.rotate(3));
		System.out.println(HMJW.World.rotate(4));
		// println에 참조변수가 입력되면 자동으로 참조변수.toString()으로 컴파일됨
		// toString()을 overriding을 통해서 enum name과 symbol이 같이 나올 수 있게 함
	}
}

public class Ex2_1 {
	public static void main(String[] args) {
		// println: 입력값 + Enter
		System.out.println("Hello");
		System.out.println("Hello");
		
		// print: 입력값
		// \n: Enter
		System.out.print("\nHello, Friend");
		System.out.print("Hello,\n Friend");
		
		System.out.println("\n"+(3+5));

		int a = 22;
		int b = 23;
		// printf: to write a formatted string using the specified format string and arguments
		// printf("출력값 형태1, 출력값 형태2, ...", 입력값1, 입력값2, ...)
		// %d: 10진법 정수
		System.out.printf("a=%d, b=%d%n", a, b);
		
		a = b; // a에 b값을 저장 a = 23
		b = a; // b에 a값을 저장 b = 23
		System.out.printf("a=%d, b=%d%n", a, b);
		
		
		int x = 12;
		int y = 14;
		System.out.printf("x=%d, y=%d%n", x, y);
		
		int tmp = x; // tmp에 x 값을 저장, tmp = 12
		x = y; // x에 y값을 저장, x = 14
		y = tmp; // y에 tmp값을 저장, y = 12
		System.out.printf("x=%d, y=%d, tmp=%d%n", x, y, tmp);
		
	}
}
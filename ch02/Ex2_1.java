
public class Ex2_1 {
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		
		System.out.print("\nHello, Friend");
		System.out.print("Hello, Friend");
		System.out.print("Hello, Friend");
		
		System.out.println("\n"+(3+5));

		int a = 22;
		int b = 23;
		System.out.printf("a=%d, b=%d%n", a, b);
		
		a = b;
		b = a;
		System.out.printf("a=%d, b=%d%n", a, b);
		
		
		int x = 12;
		int y = 14;
		System.out.printf("x=%d, y=%d%n", x, y);
		
		int tmp = x;
		x = y;
		y = tmp;
		System.out.printf("x=%d, y=%d, tmp=%d%n", x, y, tmp);
		
	}

}

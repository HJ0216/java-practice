public class Ex8_5 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(5);
		} catch(ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("Error: "+ae.getMessage());
		}
		System.out.println(6);
	}
}

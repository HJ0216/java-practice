public class VarEx_3 {

	public static void main(String[] args) {

		int score = 100;
		System.out.println(score);

		boolean b = true;
//		boolean b2 = 1; Error: Type mismatch: cannot convert from int to boolean

		byte b3 = -128;
//		byte b4 = 128; Error: Type mismatch: cannot convert from int to byte

		int oct = 010; //8진수(0~7) 8
		int hex = 0x10; //16진수(0~f) 16

		System.out.println(oct); //10진수 출력
//		System.out.printf(hex, args) 10진수 이외 출력 printf 사용

		long l = 1_000_000_000; //접미사 생략 int //long>int 가능
//		long l = 10_000_000_000; //Error: type int is out of range

		char ch = 'A';
//		char ch2 = 'AB'; Error: Invalid character constant
//		char ch3 = ''; Error: Invalid character constant

		int i = 'A';
		System.out.println(i); //정수 65 출력

		System.out.println(""+7+7); //77
		System.out.println(7+7+""); //14



	}

}
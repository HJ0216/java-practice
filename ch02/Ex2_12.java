
public class Ex2_12 {
	public static void main(String[] args) {

		System.out.println(1);
		System.out.println('2');
		System.out.println('3'-'0'); // -'0': 숫자화
		System.out.println('4'+'0'); // +'0': 문자화, '0' = 48, '4' = 52
		System.out.println((char)('4'+'0')); // char 100 = d
		System.out.println(5+'0'); // +'0': 문자화
		System.out.println(6-'0'); // -'0': 숫자화
		System.out.println("6");
		System.out.println("7"+0);
		System.out.println("7"+'0');
		System.out.println("7"+"0");
		System.out.println('9'+'9'); // '숫자' < '10'
		
	}
}
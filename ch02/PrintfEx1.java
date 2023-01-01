
public class PrintfEx1 {

	public static void main(String[] args) {
		
//		System.out.println(10/3);
//		//정수 / 정수 = 정수 출력
//		System.out.println(10.0/3);
//		//실수 / 정수 = 실수 출력
//		System.out.println(10/3.0);
//		//정수 / 실수 = 실수 출력
		
		
//		float f = 123.456789f; //f type은 f 표시(표시 안할 경우, d 취급)
//		System.out.printf("%f\n", f); //float type 1234567 - 총 7자리까지만 정확
//		System.out.printf("%e\n", f); //지수 type e+02 = 10^2
//		System.out.printf("%g\n", f); //정수부, 소수점 포함 7자리
//		
//		double d = 123.456789;
//		System.out.printf("%f\n", d); //float type 1234567 - 총 15자리까지만 정확

		
		// 10진수 d / 8진수 o / 16진수 x
		System.out.printf("[%5d]\n", 100); // 오른쪽 정렬 + 공백
		System.out.printf("[%-5d]\n", 100); // 왼쪽 정렬
		System.out.printf("[%05d]\n", 100); // 공백 -> 0
		System.out.printf("[%5d]\n", 1234567); // 지시 자리수보다 넘을 경우, 원래대로 출력
		
		System.out.printf("%#o\n", 15); // 8진수 접두사
		System.out.printf("%#x\n", 15); // 16진수 접두사
		
		
		double d = 1.23456789;
		System.out.printf("%f\n", d); // 소수점 아래 6자리까지
		System.out.printf("%14.10f\n", d); // 전체 14자리 중 소수점 이하 10자리[공백, 0]
		System.out.printf("%.5f\n", d); // 정수부 전체 출력, 소수점 이하 5자리
		
		
		System.out.printf("[%s]\n", "www.naver.com");
		System.out.printf("[%20s]\n", "www.naver.com"); //공백
		System.out.printf("[%-20s]\n", "www.naver.com"); //왼쪽 정렬
		System.out.printf("[%.10s]\n", "www.naver.com"); //숫자와 차이, 작으면 원본데이터 소설 출력
		
	}

}

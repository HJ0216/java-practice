
public class Ex6_4 {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		long result1 = mm.add(1L, 2L); //long type 표시L 제거 시, int 형식으로 인식
		long result2 = mm.subtract(12L, 34L);
		//3. 변수로 받는 type이 method의 result type과 return값과 같아야 함
		//*원칙상 3개의 값은 타입이 같아야 하지만, 자동 형변환이 가능한 경우도 허용
		long result3 = mm.multiply(123L, 456L);
		float result4 = mm.divide(1234.0f, 5678.0f);
		long result5 = mm.remainder(123L, 456L);
		long result6 = mm.max(12L, 34L);
		long result7 = mm.min(1L, 2L);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.printf("%.4f%n",result4);
		System.out.println(result5);
		System.out.println(result6);
		System.out.println(result7);
		mm.printGugudan(51); //반환값 필요X
		
	}

}

class MyMath{
	long add(long a, long b) {
		long result = a+ b;
		return result;
		// return a+b;
	}
	long subtract(long a, long b) {	return a-b; }
	//1. 결과값을 long type로 선언
	//2. return값이 long type으로 나와야 함
	long multiply(long a, long b) {	return a*b; }
	float divide(float a, float b) { return a/b; }
	long remainder(long a, long b) { return a%b; }
	long max(long a, long b) { return a>b ? a:b; }
	long min(long a, long b) {
		long result = 0;
		if(a>b) { result = b;}
		else { result = a;}
		return result;}
	
	void printGugudan(int gugu) {
		if (gugu<1 || gugu>9 ) {
			return;
		} else {
			for(int i=1; i<10; i++) {
				System.out.printf("%02d * %02d = %02d%n", gugu, i, gugu*i);			
		}
		}
	}
}


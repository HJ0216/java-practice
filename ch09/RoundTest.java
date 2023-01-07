
public class RoundTest {

	public static void main(String[] args) {
		double sum = 0.0;
		double sum2 = 0.0;
		double sum3 = 0.0;
		
		// static double rint(double a): 반올림+0.5단위의 경우 짝수값 반환
		// 0.5의 경우 올림을 하다보면 총계의 과다측정이 발생할 수 있는 것을 방지
		for(double d=0.0; d<10.0; d+=0.5) {
			double d2 = Math.round(d);
			double d3 = Math.rint(d);
			System.out.printf("%5.1f %5.1f %5.1f%n", d, d2, d3);
			
			sum += d;
			sum2 += d2;
			sum3 += d3;
		}
		System.out.println("==================");
		System.out.printf("%5.1f %5.1f %5.1f%n%n", sum, sum2, sum3);
		
		// long round(): 소수점 아래 첫자리에서 반올림
		double d4 = 123.456;
		System.out.println((double)Math.round(d4));
		// 소수점 둘째자리에서 반올림(return long -> double)
		System.out.println((double)Math.round(d4*10)/10);
		// 소수점 셋째자리에서 반올림(double type 리터럴 이용)
		System.out.println(Math.round(d4*100)/100.0);
		
		// static double abs(double a)주어진 값의 절대값을 반환
		int i = Math.abs(-23);
		System.out.println(i);
		
		// static double ceil(double a): 주어진 값을 올림하여 반환
		// static double floor(double a): 주어진 값을 내림림하여 반환
		double d5 = 10.1;
		double d6 = 10.9;
		double d7 = -10.1;
		double d8 = -10.9;
		System.out.println(Math.ceil(d5)); // 11.0
		System.out.println(Math.floor(d6)); // 10.0
		System.out.println(Math.ceil(d7)); // -10.0
		System.out.println(Math.floor(d8)); // -11.0
		
		// static double max(double a, double b)
		// static double min(double a, double b)
		// static double random(): 0.0≤x<1.0 범위의 임의의 double 값 반환
		
	}
}

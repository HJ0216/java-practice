
public class Ex4_16 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		for(;;) { //while(true) - while에서 true 생략 불가
			if(sum>100) {
				break;
			} ++i;
			sum += i; // sum = sum +i
		}
		System.out.println("i = "+i);
		System.out.println("sum = "+sum);
	}

}

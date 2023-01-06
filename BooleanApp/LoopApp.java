
public class LoopApp {

	public static void main(String[] args) {
		
		
		System.out.println("=== WHILE ===");
		System.out.println(1);
		int i = 0;
		while(i<3) {
			System.out.println(2);
			System.out.println(3);
			i = i+1;
		}

				
		System.out.println("=== FOR ==="); // 일정 횟수만큼 반복할 때 for문 사용하기 좋음
		System.out.println(1);
		for (int j=0; j<3; j++) {
			System.out.println(2);
			System.out.println(3);
		}
		
		System.out.println(4);
		
		
	}

}

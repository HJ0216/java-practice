import java.util.Scanner;

public class Ex4_15 {

	public static void main(String[] args) {
		int input = 0, answer = 0; //초기화
		
		answer = (int)(Math.random()*100)+1; //1~100사이의 random 값
		System.out.println("Ans = "+answer);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1~100 중 정답은 무엇일까요?");
		input = scanner.nextInt();
		
		while (input != answer) {
			if (input > answer) {
				System.out.println("넘 큰데용!");
			} else if (input < answer) {
				System.out.println("넘 작은데용!");
		} input = scanner.nextInt(); //code 중복으로 권장X
		//-> 반드시 한 번 실행되어야하면 do-while문으로

		} System.out.println("정답입니다!");
		
		
		
//		do {
//			input = scanner.nextInt(); //입력값을 받아두기
//			if (input > answer) {
//				System.out.println("넘 큰데용!");
//			} else if (input < answer) {
//				System.out.println("넘 작은데용!");
//			}
//		} while (input != answer); //input이 answer와 다르면 다시, do로..
//			System.out.println("정답입니다!"); //input = answer

	}

}

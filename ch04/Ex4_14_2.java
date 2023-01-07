import java.util.Scanner;

public class Ex4_14_2 {

	public static void main(String[] args) {
		int num = 0, sum = 0;
		System.out.println("엣헴, 숫자를 적어보시오!");
		
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();
		// 사용자가 입력한 1행
		num = Integer.parseInt(tmp);
		// 문자열 -> 정수
		
		while (num != 0) { // num이 0이 아닐 경우,
			sum += num%10; // sum에 num을 10으로 나눈 나머지를 더함
			num = num/10; // num은 순환마다 10으로 나눠줌
		}
		
		System.out.println("각 자리수의 합 = "+sum);

	}

}


// int의 소숫점 아래 수는 버림
// num 123   12          1
// sum 3 -> 3+2 -> (3+2)+1
//
//
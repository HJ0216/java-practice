import java.util.Scanner;

public class Ex4_5 {

	public static void main(String[] args) {
		int score = 0;
		char grade = 'C', opt = '0'; // 같은 변수 type은 한 줄로 처리

		System.out.println("점수를 입력하세용.");
		
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		System.out.printf("입력하신 점수는 '%d'점입니당.\n", score);
		// %: 정수 형식으로 출력, printf에서 사용 가능
		
		if (score>=90) {
			grade = 'A';
			if(score>=95) {
				opt = '+';
			} else if (score<=91) {
				opt = '-';
			}
		} else if (score>=80) {
			grade = 'B';
			if(score>=85) {
				opt = '+';
			} else if (score<=81) {
				opt = '-';
			}
		} else {
			if(score>=85) {
				opt = '+';
			} else if (score<=81) {
				opt = '-';
			}
		}
		
		System.out.printf("학점은.. 두구두구두구.. '%c%c'입니다~!\n", grade,opt);
	}

}

import java.util.Scanner;

public class Ex4_5_2 {

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
		} else if (score>=80) {
			grade = 'B';
		}
		
		// 자리수 추출 - 나누기와 나머지 활용
		// 123 - 100의 자리수: 100 나누기(int 특성 활용)
		// 10의 자리 수: 123을 10으로 나눌 때 몫을 다시 10으로 나눌 때 나머지
		if ((score%10)>=7) { 
			opt = '+';
		} else if ((score%10)<=3) {
			opt = '-';
		}
		System.out.printf("학점은.. 두구두구두구.. '%c%c'입니다~!\n", grade,opt);
	}

}

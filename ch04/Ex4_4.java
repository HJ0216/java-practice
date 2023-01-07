import java.util.Scanner;

public class Ex4_4 {

	public static void main(String[] args) {
		
		int score = 0;
		char grade = 'C'; // 빈칸으로라도 입력값을 넣어주어서 초기화
		
		System.out.println("점수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		// Scanner Type 변수 scanner는 화면 입력값을 받음
		score = scanner.nextInt();
		// int 형식 score는 화면을 통해 입력받은 int를 저장
		
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) { //else와 if의 결합으로 80~90으로 표기하지 않아도 됨
			grade = 'B';
		}

//		else {
//			grade = 'C'; // 만일 grade를 처음으로 C로 초기화 했더라면 else 필요X
//			//간결한 코드 만들기 생각
//		}
		
		System.out.println("최종 점수는 " + grade + " 입니다.");

	}

}

import java.util.Scanner;

public class Ex5_10 {

	public static void main(String[] args) {
		String[][] words = {
				{"chair", "의자"},
				{"watch", "손목 시계"},
				{"clock", "시계"},
				{"bag", "가방"},
				{"music", "음악"}
		};

		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<words.length; i++) { // i = 0, 1, 2, 3, 4
			System.out.printf("Q%d. %s의 뜻은?%n", i+1, words[i][0]);
			
			String tmp = scanner.next(); // 띄어쓰기, Enter로 입력 종료
//			scanner.nextLine(); // 버퍼(키보드로 입력한 값이 저장된 장소)에 저장된 나머지 입력 단어+%n 사용
//			미사용 시, 버퍼에 남아있는 %n에 따른 다음 값이 자동 입력됨
//			예: 손목 시계 입력 시, Q2. 손목+Space Bar 입력, Q3. 시계+Enter 입력
//			중간에 scanner.nextLine();을 기재하여 남아있는 시계+Enter 사용
//			String tmp = scanner.nextLine(); // 띄어쓰기가 있을 경우, Enter 단위로 받아야 함
			
			if (tmp.equals(words[i][1])) {
				System.out.printf("정답입니다~%n%n");
			} else {
				System.out.printf("틀렸습니다! 정답은 %s입니다.%n%n", words[i][1]);
			}
		}
		scanner.close();
	}

}

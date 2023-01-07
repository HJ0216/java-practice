import java.util.Scanner;

public class Ex4_6 {

	public static void main(String[] args) {
		System.out.println("지금은 몇 월인가요?");
		
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		switch (month) {
			case 3: case 4: case 5: // case 모두 적어줘야 함
				System.out.println("꽃피는 봄이네요!");
				break; // break로 안끝내면 만날 때까지 다 실행됨
			case 6: case 7: case 8:
				System.out.println("시원한 물놀이의 계절이군요!");
				break; // break로 안끝내면 만날 때까지 다 실행됨
			case 9: case 10: case 11:
				System.out.println("가을가을, 지나가기 전에 즐겨요!");
				break; // break로 안끝내면 만날 때까지 다 실행됨
			case 12: case 1: case 2:
			System.out.println("눈사람 만드느라 시간이 가는 줄 몰라요!");
			break; // break로 안끝내면 만날 때까지 다 실행됨 - 마지막 case는 끝이 나므로 예외
			default:
			System.out.println("올바른 월을 입력해주시겠어요?");
			
		}

	}

}

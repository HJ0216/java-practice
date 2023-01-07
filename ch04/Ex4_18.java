import java.util.Scanner;

public class Ex4_18 {

	public static void main(String[] args) {
		int menu = 0;

		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<3; i++) { // 무한 반복
			
			System.out.println("1. 짜장면");
			System.out.println("2. 짬뽕");
			System.out.println("3. 탕수육");
			System.out.println("뭐 먹을랭ㅎ~ 다른 곳 가려면 '0'을 입력해줘ㅎ~");
			
			boolean b = scanner.hasNextInt();
			// 문자를 입력한 경우, scanner.hasNextInt가 false를 기억해버림
			
			if(b!=true) {				
				System.out.println("에이, 모양ㅎ~. 그건 보기에 업엉ㅎ~ 메뉴 다시 말해준당!");
				scanner.nextLine(); 
				continue;
			} else {	
				menu = scanner.nextInt(); 	
				if (menu == 0) {
					System.out.println("중식은 실쿠낭ㅎ! 그럼, 어디 갈지 가치 고민해보쟈~ㅎ!");
					break;
				} else if (menu<0 || menu>3) { //=!(menu>=0 && menu<=3)
					System.out.println("에이, 모양ㅎ~. 그건 보기에 업엉ㅎ~ 메뉴 다시 말해준당!");
					continue; //main의 시작으로 돌아감
				}
				System.out.println("구램ㅎ~ 우리 "+menu+" 가치 먹장ㅎ~");
				break;
			}
		}
	scanner.close();
	}
}

//String tmp = scanner.nextLine(); // next, nextLine이 String type을 입력받음
//menu = Integer.parseInt(tmp);

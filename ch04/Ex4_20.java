import java.util.Scanner;

public class Ex4_20 {

	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		outer:
		while(true) { //ultimate loop
			System.out.println("1. square");
			System.out.println("2. square root");
			System.out.println("3. log");
			System.out.println(
					"Please select the no. If u want to close the calculation enter the '0'"
					);
			
			String tmp = scanner.nextLine();
			menu = Integer.parseInt(tmp);
			
			if(menu==0) {
				System.out.println("Close the calculation");
				break;
			} else if(!(menu>=0 && menu<4)) {
				System.out.println("Please reselect the number. If u wanna close the calculation, please enter the '0'.");
				continue;
			}
			
			for(;;) {
				System.out.println("Please enter the number, to be calculated. 0. back stage / 99. close program");
				tmp = scanner.nextLine();
				num = Integer.parseInt(tmp);
			 if(num == 99) {
				System.out.println("See ya!");
				break outer; //(outer:)while까지 전체 종료
			} else if(num==0) {
				break; //for만 탈출
			} switch (menu) {
			case 1:
				System.out.println("result = "+num*num);
				break; //switch만 탈출
			case 2:
				System.out.println("result = "+(int)Math.sqrt(num));
				break;
			case 3:
				System.out.println("result = "+Math.log(num));
				break;
				
			}
		} //for
	} //while
  } //main
}//class

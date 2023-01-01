import java.util.Scanner; //1. class 소속 입력

public class ScanfEx1 {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in); //System.in = 화면 입력값
	//2. Scanner 객체 생성
	//'scanner' is never closed = 입출력 관련 객체 -> 사용 후 close 필요
	//system.in의 경우, 자동적으로 관리가 되므로 따로 close 필요X
	
	int num = scanner.nextInt(); //화면에서 입력받은 정수를 num에 저장 / 실수 Float
	System.out.println(num);
	
	String input = scanner.nextLine(); //화면에서 입력받은 한 행의 내용은 input에 저장
	System.out.println(input);
	
	int num2 = Integer.parseInt(input); //문자열 input을 정수 num2로 저장
	
//	int num3 = scanner.nextInt();
//	String input3 = scanner.nextLine();
//	int num3 = Integer.parseInt(input3);
	
	}

}

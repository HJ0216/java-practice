
public class AuthApp2 {

	public static void main(String[] args) {
		
		String id = "Hyunji";
		String InputId = args[0];
		
		String pw = "2022";
		String pw2 = "2020";
		String InputPw = args[1];
		
		System.out.println("Hello.");
		
//		if(InputId==id) { 문자열은 ==로 쓰는 게 아니라 equal로 사용
//		if(InputId.equals(id)) { // equal은 내용 자체를, ==는 주소를 비교
//			if(InputPw.equals(pw)) {
//				System.out.println("Long time no see, "+args[0]+"!");
//			} else {
//				System.out.println("It isn`t the correct PW.");
//			}
//		} else
//			System.out.println("Who are you..?");
		
		
		boolean IsRightPass = (InputPw.equals(pw) || InputPw.equals(pw2)); // code가 길어질 때는 변수 활용
		if(InputId.equals(id) && IsRightPass) { // equal은 내용 자체를, ==는 주소를 비교
				System.out.println("Long time no see, "+args[0]+"!");
		} else
			System.out.println("Who are you..?");

	}

}

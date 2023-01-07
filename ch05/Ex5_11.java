
public class Ex5_11 {

	public static void main(String[] args) {
		String str = "ABCDE";
		
		char ch = str.charAt(3); //D
		String str2 = str.substring(1, 3); //BC
		String str3 = str.substring(1); //BCDE - 생략하면 length 자동 반환
		String str4 = str.substring(1, str.length()); //BCDE
		
		System.out.println(ch);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);

	}

}

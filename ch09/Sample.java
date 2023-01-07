import java.util.Arrays;
import java.util.Date;

public class Sample {
	public static void main(String[] args) {
		// char[] -> String
		char[] cArr = {'s', 'n', 'o', 'w'};
		String s = new String(cArr);
		System.out.println(s);
		
		// String -> char
		String str = "COLDPLAY";
		char[] cArr2 = str.toCharArray();
		// int length: 문자열의 길이 반환
		System.out.println(cArr2.length);
		
		// StringBuffer: 내용 변경 가능한 문자열
		StringBuffer sb = new StringBuffer("Hello");
		String s2 = new String(sb);
		System.out.println(s2);
		sb.append(" World");
		System.out.println(sb);
		
//		String s3 = new String("Hi");
//		s3.append(" Wolrd"); // 내용 변경 불가
		
		// String concat(String str): 문자열을 뒤에 덧붙임
		String s6 = "Teddy";
		String s7 = s6.concat(" Bear");
		System.out.println(s7);
		
		// char charAt(index): 지정된 위치의 문자 반환
		String s3 = "Sweaty";
		char c = s3.charAt(4);
		System.out.println(c);
		
		// int CompareTo(String str): 문자열을 사전순서로 비교
		// 같으면 0 왼쪽이 작으면 -, 오른쪽이 작으면 +
		String s4 = "Christmas";
		String s5 = "HaapyNewYear";
		int i = s4.compareTo(s5); // C가 H보다 5만큼 더 작음
		System.out.println(i);
		
		// boolean contains(CharSequence s): 지정된 문자열이 포함되어있는지 검사
		// → Interface CharSequence: CharSequence 또는 CharSequence를 구현한 class의 instance만 가능
		String s8 = "Watch";
		boolean b = s8.contains("Clock");
		System.out.println(b);

		// boolean endwith(String suffix): 지정된 문자열(suffix)로 끝나는지 검사
		String s9 = "Sample.java";
		boolean b2 = s9.contains("java");
		System.out.println(b2);
		
		// boolean equals(Object obj): 문자열 일치 비교
		String s10 = "Winter is Coming.";
		boolean b3 = s10.equals("winter is coming.");
		boolean b4 = s10.equals("winter is coming");
		boolean b5 = s10.equals("Winter is Coming.");
		System.out.printf("%b, %b, %b%n", b3, b4, b5);
		
		// boolean equalsIgnoreCase(String str): 문자열을 대소문자 구분없이 비교
		String s11 = "IsItRight";
		boolean b6 = s11.equalsIgnoreCase("isitRight");
		System.out.println(b6);
		
		// int IndexOf(int ch): 문자가 문자열에 존재하는지 확인하여 위치 반환(없을 경우 -1, 대소문자 구분)
		String s12 = "AppleBananaCarDriveElephant";
		int idx1 = s12.indexOf('C');
		int idx2 = s12.indexOf('d');
		System.out.printf("%d, %d%n", idx1, idx2);
		
		// int indexOf(int ch, int pos):
		// 주어진 문자가 문자열이 존재하는지 지정된 위치부터 확인하여 위치 반환(index는 0부터 시작)
		String s13 = "Galaxy";
		int idx3 = s13.indexOf('a', 0); // 먼저 위치한 값 출력
		int idx4 = s13.indexOf('a', 4);
		System.out.printf("%d, %d%n", idx3, idx4);
		
		// int indexOf(String str): 주어진 문자열이 존재하는지 확인하여, 시작 위치의 index 반환
		String s14 = "Carol Song"; // ' '도 1로 인정
		int idx5 = s14.indexOf("Song");
		System.out.println(idx5);
		
		// int lastIndexOf(int ch): 지정된 문자를 오른쪽부터 찾아서 위치 반환
		String s15 = "java.lang.Object";
		int idx6 = s15.lastIndexOf('.');
		int idx7 = s15.indexOf('.');
		System.out.printf("%d, %d%n", idx6, idx7);
		
		// String[] split(String regex): 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환
		// * regex: 정규표현식(regular expression)
		String s16 = "All, You, Need, Is, Love";
		String[] strArr = s16.split(","); // '.': regex가 아니라서 구분자로 인식이 안됨
		System.out.println(strArr.toString()); // 배열 주소 반환
		// 배열값 반환
		System.out.println(Arrays.toString(strArr));
		for(int i2=0; i2<strArr.length; i2++) {
			System.out.println(strArr[i2]);
		}
		
		// String[] split(String regex, int limt)
		// 문자열을 지정된 분리자로 나누어 배열에 담아 반환, 단 문자열 전체를 지정된 수(limit)로 자름
		String s17 = "Impossible, is, noting";
		String[] strArr2 = s17.split(",", 2);
		System.out.println(Arrays.toString(strArr2));
		
		// boolean startswith(String prefix): 주어진 문자열로 시작하는지 검사
		String s18 = "How.I.Met.Your.Mother";
		boolean b7 = s18.startsWith("How");
		boolean b8 = s18.startsWith("how");
		boolean b9 = s18.startsWith("Met");
		System.out.printf("%b, %b, %b%n", b7, b8, b9);
		
		// String substring(int begin) / String substring(int begin, int end)
		// 주어진 시작부터 끝까지 포함된 문자열, 시작위치의 문자는 범위에 포함되지만 끝은 포함되지 않음
		String s19 = "Modern Family";
		String s20 = s19.substring(7);
		// int end값을 입력해주지 않으면 문자열 길이 생략으로 간주
		String s21 = s19.substring(7, 10);
		System.out.printf("%s, %s%n", s20, s21);
		
		// String toUpperCase() / String toLowerCase()
		String s22 = "BrandNewGalaxy";
		System.out.println(s22.toUpperCase());
		System.out.println(s22.toLowerCase());

		// String trim(): 문자열 양 끝의 공백 제거(중간 공백 제거X)
		// 문자열이 변화한게 아니라 새로운 문자열이 만들어진 것(문자열은 상수처럼 변화될 수X)
		String s23 = "    Hello J ava Wor ld   ";
		System.out.println(s23);
		System.out.println(s23.trim());
		
		Date date = new Date();
		// static String valueOf(Object obj): 기본형→String
		// cf. 참조변수: toString() 호출한 결과를 반환
		String s24 = String.valueOf(true); // 성능이 빠름
		System.out.println(s24); // "true"
		System.out.println(true + ""); // "true" // 가독성이 좋음

		// java.util.date
		String sDate = String.valueOf(date);
		System.out.println(sDate);
		
		// join(): 여러 문자열 사이에 구분자를 넣어서 결합
		// 문자열간의 단순 결합(+)은 새로운 문자열을 생성하여 속도 저하를 발생시킬 수 있음
		// String.join은 내부적으로 StringBuffer를 사용 -> 문자열을 새롭게 탄생시키지 않고 변경하여 속도를 높일 수 있음
		String s25 = "Sunny, Cloudy, Rainy, Snowy";
		String[] strArr3 = s25.split(",");
		String s26 = String.join("@", strArr3);
		System.out.println(s26);
		
		// 숫자→문자
		int i2 = 100;
		String s27 = i2 + "";
		String s28 = String.valueOf(i2);
		System.out.printf("%s, %s%n", s27, s28);

		// 문자열→숫자
		int i3 = Integer.parseInt("200");
		int i4 = Integer.valueOf("400");
		System.out.printf("%d, %d%n", i3, i4);		
	}
}

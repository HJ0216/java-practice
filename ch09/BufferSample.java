
public class BufferSample {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Thu");
		StringBuffer sb9 = sb.append("rs").append("day");
//		sb.append("rs");
//		sb.append("day");
		System.out.println(sb==sb9); // true
		// 새로운 인스턴스를 생성하지 않고 기존의 인스턴스를 이용하므로 주소가 동일
		
		StringBuffer sb2 = new StringBuffer("IsItSame");
		sb2.append("?");
		StringBuffer sb3 = new StringBuffer("IsItSame");
		sb3.append("?");		
		// StringBuffer: String과 달리 equals()가 overriding 되어있지 않음
		// String으로 변환 후 사용(toString())
		System.out.println(sb2.equals(sb3)); // false
		String s1 = sb2.toString();
		String s2 = sb3.toString();
		System.out.println(s1.equals(s2)); // true
		
		// StringBuffer(): 초기값으로 16문자를 담을 수 있는 버퍼를 가진 StringBuffer instance를 생성
		StringBuffer sb4 = new StringBuffer();
		System.out.println(sb4.capacity()); // 용량
		
		// StringBuffer(int length): 지정된 개수의 문자를 담을 수 있는 StringBuffer instance 생성
		StringBuffer sb5 = new StringBuffer(10);
		System.out.println(sb5.capacity()); // 용량
		
		// StringBuffer(String str): 지정된 문자열 값(str)을 갖는 StringBuffer instance 생성
		StringBuffer sb6 = new StringBuffer("Americano");
		System.out.println(sb6.capacity()); // 용량(기본용량: 16+"")
		
		// StringBuffer append(boolean b, char c, char[] str 등)
		// 매개변수에 입력된 값을 문자열로 변환하여 StringBuffer instance가 저장하고 있는 문자열의 뒤에 덧붙임
		StringBuffer sb7 = new StringBuffer("Coco");
		StringBuffer sb8 = new StringBuffer("Powder ");
//		StringBuffer sb = new StringBuffer(true); // 생성자로 boolean type X
		sb7.append('a');
		sb8.append(10.0f).append('g'); // type을 알려주는 접미사 출력X
		System.out.println(sb7.toString());
		System.out.println(sb8.toString());

		// int capacity(): StringBuffer instance의 버퍼크기를 반환
		// int length()는 버퍼에 담긴 문자열의 길이 반환
		StringBuffer sb10 = new StringBuffer(25);
		sb10.append("Christmas");
		System.out.println(sb10.capacity()); // 25
		System.out.println(sb10.length()); // 9
		// capacity가 부족하게 되면, 부족을 만든 원인 append의 문자열 길이의 2배만큼 늘려줌
		StringBuffer sb22 = new StringBuffer();
		System.out.println("sb22.capacity(): "+sb22.capacity());
		sb22.append("01234567890123456"); // 17개 입력: 자리부족
		System.out.println("sb22.capacity(): "+sb22.capacity()); // 17*2 = 34 
		
		StringBuffer sb11 = new StringBuffer(4);
		sb11.append("WinterIsComing");
		System.out.println(sb11.capacity()); // 4 + 10 = 14
		System.out.println(sb11.length()); // 14
		
		// char charAt(int index): 지정된 위치에 있는 문자를 반환
		StringBuffer sb12 = new StringBuffer("SnowPrince");
		System.out.println(sb12.charAt(4));
		
		// StringBuffer delete(int start, int end): 시작위치부터 끝위치까지 문자 제거(단, 끝위치 제외)
		StringBuffer sb13 = new StringBuffer("Sia_SnowMan");
		StringBuffer sb14 = sb13.delete(0, 4); // 기존 instance에서 변화
		System.out.println(sb14);
		System.out.println(sb13==sb14); // true
		String s3 = "Sia_SnowMan";
		String s4 = s3.substring(4); // 새로운 instance 생성
		System.out.println(s4);
		System.out.println(s3==s4); // false
		
		// StringBuffer deleteCharAt(int index): 지정된 위치의 문자 제거
		StringBuffer sb15 = new StringBuffer("012345");
		System.out.println(sb15.deleteCharAt(3));
		
		// StringBuffer insert(int pos, Object obj)
		// 두 번쨰 매개변수로 받은 값을 문자열로 변환하여 지정된 위치에 추가
		StringBuffer sb16 = new StringBuffer("012345");
		System.out.println(sb16.insert(3, "ImHere"));
		
		// StringBuffer replace(int start, int end, String str): 지정된 범위의 문자들을 주어진 문자열로 변환(end는 미포함)
		StringBuffer sb17 = new StringBuffer("ABCDEF");
		System.out.println(sb17.replace(2, 4, "anana"));
		
		// StringBuffer reverse(): StringBuffer Instance에 저장되어 있는 문자열의 순서를 거꾸로 나열
		StringBuffer sb18 = new StringBuffer("REVERSE");
		System.out.println(sb18.reverse());
		
		// void setCharAt(int index, char ch): 지정된 위치의 문자를 주어진 문자로 바꿈
		StringBuffer sb19 = new StringBuffer("JAVAWORID");
		sb19.setCharAt(7, 'L');
		System.out.println(sb19.toString());
		// void type은 println으로 출력할 수 X -> setCharAt을 출력하는 것이 아니라 그 대상을 출력
		
		// void setLength(int newLength): 지정된 길이로 문자열 길이 변경
		// 길이를 늘리는 경우 나머지 빈 공간을 Null문자 \u0000로 채움(Null공간)
		StringBuffer sb20 = new StringBuffer("LG_gram");
		sb20.setLength(2);
		System.out.println(sb20); // LG
		sb20.setLength(10);
		System.out.printf("Print: %s, Length: %d%n", sb20, sb20.length());
		
		// String substring(int start, int end): 지정된 범위 내의 문자열을 String으로 뽑아서 반환, 시작위치만 지정 시 끝까지 뽑아서 반환
		StringBuffer sb21 = new StringBuffer("012345");
		System.out.println(sb21.substring(3)); //345
		System.out.println(sb21.substring(2, 5)); //234
		
		StringBuffer sb23 = new StringBuffer(2);
		sb23.append("0123"); // 3이 발생하게 되면서 확장이 필요해짐
		System.out.println("sb23.capacity(): "+sb23.capacity()); // 3 *2 = 6
		sb23.append("0123"); // 7이 발생하게 되면서 확장이 필요해짐
		System.out.println("sb23.capacity(): "+sb23.capacity()); // 7 *2 = 14
		
		StringBuffer sb24 = new StringBuffer();
		sb24.append("01230123012301230123"); // 17이 발생하게 되면서 확장이 필요해짐
		System.out.println("sb24.capacity(): "+sb24.capacity()); // 17*2 = 34
		sb24.append("012301230123012"); // 35 발생하게 되면서 확장이 필요해짐
		System.out.println("sb24.capacity(): "+sb24.capacity()); // 35*2 = 70
		
	}
}

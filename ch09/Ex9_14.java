
public class Ex9_14 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);
		// The constructor Integer(int) is deprecated since version 9
		// 생성자 Integer(int)는 버전 9 이후 더이상 사용되지 않습니다.
		
		System.out.println("i==i2 ? "+(i==i2)); // 객체 생성으로 인한 다른 주소
		System.out.println("i.equals(i2) ? "+(i.equals(i2)));
		System.out.println("i.compareTo(i2) ? "+i.compareTo(i2));
		// 왼쪽이 더 클 경우: +1, 같을 경우:0, 오른쪽이 더 클 경우:-1
		System.out.println("i.toString() ? "+i.toString()); // "100"
		
		System.out.println("MAX_VALUE ? "+i.MAX_VALUE); // Integer의 최대값 (2^32/2(음수, 양수))=2^31
		System.out.println("MIN_VALUE ? "+i.MIN_VALUE); // Integer의 최소값
		System.out.println("SIZE(bit) ? "+i.SIZE); // Integer의 bit
		System.out.println("BYTES ? "+i.BYTES); // Integer의 bytes
		System.out.println("TYPE ? "+i.TYPE); // Integer의 기본형	
		
		int i3 = Integer.parseInt("300");
		System.out.println("i3 = "+i3);
		System.out.println("i4 = "+Integer.parseInt("100")); // 10진법 생략
		System.out.println("i4 = "+Integer.parseInt("100", 10));
		System.out.println("i4 = "+Integer.parseInt("100", 2)); // 2진법 생략
		System.out.println("i5 = "+Integer.parseInt("FF", 16)); // 16진법
//		System.out.println("i5 = "+Integer.parseInt("FF", 10));
		// Error: java.lang.NumberFormatException
		
	}
}

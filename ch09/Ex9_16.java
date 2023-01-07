
public class Ex9_16 {
	public static void main(String[] args) {
		int i = 10;
		
		// 기본형 -> 참조형 형변환(생략 가능)
		Integer intg = (Integer) i; // 컴파일 시, 자동으로 Integer intg = Integer.valueOf(i);
		Object obj = (Object) i; // (Object)Integer.valueOf(i);
		
		Long lng = 100L; // new Long(100L);
		
		int i2 = intg + 10; // 참조형과 기본형간의 연산 가능
		long l = intg + lng; // 참조형간 사칙연산도 가능
		
		Integer intg2 = new Integer(20);
		int i3 = (int) intg2;
	}
}

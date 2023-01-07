import java.util.ArrayList; // import문: ctrl + shift + o

public class Ex9_15 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100); // list에는 객체만 추가 가능-> JDK 1.5부터 AutoBoxing으로 가능
		list.add(new Integer(100));
		
		Integer i = list.get(0); // list에 저장된 첫번째 객체 꺼내기
		int i2 = list.get(0).intValue();
//		Integer itg = list.get(0);
//		int i2 = itg.intValue(); // 원래 Integer->int로 형변환 필요
		int i3 = list.get(0); // UnBoxing(Integer->Int로 컴파일 시 자동 형변환)
	}
}
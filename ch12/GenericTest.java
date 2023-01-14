import java.util.ArrayList;

public class GenericTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); // AutoBoxing: list.add(Integer.valueOf(10));
		list.add(20);
//		list.add("hi"); // Generics를 통해 type check가 강화
		
		Integer i = list.get(1);
		// 매개변수(parameter)를 i로 하는 새로운 객체 new Integer 생성
		// 만일 <>에 String 입력 시, 형변환 표시 생략 가능(int->Integer)
		System.out.println(i);
	}
}

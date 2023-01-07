import java.util.Arrays;
import java.util.Comparator;

public class Ex11_7 {
	public static void main(String[] args) {
		String[] strArr = {"Java", "hello", "world", "Crispy", "roll"};
		
		Arrays.sort(strArr); // sort에 정렬기준을 따로 제시하지 않으면 comparable에 의한 정렬
		System.out.println("strArr: "+Arrays.toString(strArr)); // 대문자 먼저 정렬
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분X
		System.out.println("strArr: "+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending()); // 역순 정렬
		System.out.println("strArr: "+Arrays.toString(strArr));

	}

}

class Descending implements Comparator<Object> {
// Comparator<Itg>가 안되는 이유: 비교 type이 Object로 선언되었기 때문..?
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) { // instanceof 형변환 가능여부 확인
			Comparable<Object> c1 = (Comparable<Object>) o1;
			// comparable class의 compareTo method를 이용할 것으므로 Comparable class type으로 형변환 가능한지 확인
			Comparable<Object> c2 = (Comparable<Object>) o2;
			return c1.compareTo(c2)*-1;
			// -1을 곱해서 기본 정렬방식을 역으로 변경
			// c2.compareTo(c1)*-1;과 동일
		} return -1;
	}
}
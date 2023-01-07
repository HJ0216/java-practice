import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {
	public static void main(String[] args) {
		Object[] objArr = {"1", Integer.valueOf(1), 1, "2", "2", "3", "3", "4", "4", "4"};
		Set<Object> set = new HashSet<>();
		// Generics 설정 시, 참조 변수 type 확인
		
		for(int i=0; i<objArr.length; i++) {
			System.out.println(objArr[i]+"="+set.add(objArr[i]));
			// boolean add(Object o): 추가 유무에 따른 T/F 반환
			set.add(objArr[i]);
			// Set: 순서X, 중복X
		} System.out.println(set);
		// String "1" 과 Integer 1 구분 O, 중복값 제거
		// Integer 1, int 1 구분 X
		// AutoBoxing: int 1 -> Integer 1
		// objArr에 들어갈 수 있는 Object type: Wrapper class
		
		// HashSet에 저장된 요소들을 출력
		Iterator<Object> it = set.iterator(); // element read
		while(it.hasNext()) { // 읽을 요소가 남아있는지 확인
			System.out.println(it.next()); // 요소 하나 꺼내오기
		}
	}
}

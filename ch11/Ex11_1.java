import java.util.ArrayList; // ctrl + shift +o
import java.util.Collection;
import java.util.Collections;

public class Ex11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		// 길이(용량, capacity)가 10인 ArrayList 작성
		
		// ArrayList에는 객채만 저장 가능: AutoBoxing(기본->참조)형으로 자동 형변환
		list1.add(2);
		list1.add(new Integer(4));
		Integer itg = new Integer(5);
		list1.add(itg);
		list1.add(Integer.valueOf(0));
		list1.add(Integer.valueOf(1));
		list1.add(Integer.valueOf(3));
		
		Collection sub = list1.subList(1,4);
		// 타입을 모를 때에는 해당 메서드의 매개변수로 올 수 있는 타입 검색(F3)
		ArrayList list2 = new ArrayList(sub);
//		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // 1, 2, 3 출력
		// subList로 추출한 ArrayList는 읽기전용이므로 수정이 필요할 경우, 새롭게 객체 생성 필요
		print(list1, list2);
		
//		Collection: Interface, Collections: Util Class
		Collections.sort(list1); // 오름차순 정렬
		Collections.reverse(list1); // 오름차순 정렬 후 reverse: 내림차순 정렬
		Collections.sort(list2);
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2): "+list1.containsAll(list2));
		System.out.println();
		
		list2.add("B"); // 위치 지정없을 경우, 가장 뒤에 추가
		list2.add("C");
		list2.add(2, "A");
		print(list1, list2);
		
//		Collections.sort(list2);
		// 문자 추가 후 sort 실행 시, 정렬할 수 없음
		
		list2.set(4, "AA");
		print(list1, list2);
		
		list1.add(0, "1");
		print(list1, list2);
		
		// indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
		System.out.println("index: "+list1.indexOf("1")); // String 1
		System.out.println("index: "+list1.indexOf(1)); // int 1
		// Array.indexOf(객체) 1->new Integer(1)로 자동 형변환
		System.out.println("index: "+list1.indexOf(9)); // 없을 경우 -1 반환
		
		list1.remove(0); // index 0 삭제
		list1.remove(new Integer(1)); // Integer 1 삭제
		print(list1, list2);
		// Integer 1을 삭제하는 것인지 Index 1인 객체를 삭제하는 것인지 조심		
		
		System.out.println("list1.retainAll(list2): "+list1.retainAll(list2));
		// list2와 겹치는 부분 제외하고는 모두 삭제
		print(list1, list2);
		
		// list2에서 list1에 포함된 객체 삭제(뒤에서부터 삭제해줘야 부담이 적음)
		for(int i=list2.size()-1; i>=0; i--) {
			if(list1.contains(list2.get(i))) {list2.remove(i);}
			// 1. get(i)로 list2에서 한개씩 추출
			// 2. contains()로 꺼낸 객체가 list1에 있는지 확인
			// 3. remove(i)로 해당 객체를 list2에서 삭제
		}
		print(list1, list2);

		// list2에서 list1에 포함된 객체 삭제(뒤에서부터 삭제해줘야 부담이 적음)
		for(int i=0; i<list2.size(); i++) {
			if(list1.contains(list2.get(i))) {list2.remove(i);}
			// 1. get(i)로 list2에서 한개씩 추출
			// 2. contains()로 꺼낸 객체가 list1에 있는지 확인
			// 3. remove(i)로 해당 객체를 list2에서 삭제
		}
		print(list1, list2);
		
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: "+list1);
		System.out.println("list2: "+list2);
		System.out.println();
	}
}
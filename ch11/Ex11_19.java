import java.util.*;
import static java.util.Collections.*;

public class Ex11_19 {
	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println("list "+list);
		
		addAll(list, 1,2,3,4,5);
		// 원칙:Collections.addAll -> static을 import할 경우, class이름 생략 가능
		System.out.println("addAll "+list);
		
		rotate(list, 1);
		// 맨뒤 -> 맨 앞으로 이동하면서 회전
		System.out.println("rotate "+list);
		
		swap(list, 0,2);
		System.out.println("swap "+list);
		
		shuffle(list);
		System.out.println("shuffle "+list);
		
		sort(list);
		System.out.println("sort "+list);
		
		sort(list, reverseOrder());
		// 역순 정렬(reverse(list); 와 동일
		System.out.println("reverseOrderSort "+list);
		
		int idx = binarySearch(list, 3);
		System.out.println("IDX of 3 is "+idx);
		
		System.out.println("Max: "+max(list));
		System.out.println("Min: "+min(list));
		System.out.println("Min: "+max(list,reverseOrder()));
		
		fill(list, 9);
		System.out.println("fill "+list);
		
		List newList = nCopies(list.size(),2);
		// list와 같은 크기의 list를 생성하고, 2로 채움, 결과는 변경 불가
		System.out.println("newList "+newList);
		
		System.out.println("disjoint: "+disjoint(list, newList));
		// 공통요소가 1개도 없으면 true
		
		copy(list, newList); // newList에 있는 것을 list에 복사
		System.out.println("newList "+newList);
		System.out.println("list "+list);
		
		replaceAll(list, 2, 1);
		System.out.println("replaceAll "+list);
		
		Enumeration e = enumeration(list);
		// iterator와 동일
		ArrayList list2 = list(e);
		System.out.println("ArrayList "+list2);		
	}
}
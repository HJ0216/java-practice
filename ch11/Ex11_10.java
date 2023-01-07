import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ex11_10 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		// set의 크기가 6보다 작은동안 1~45사이의 난수 저장
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num); // AutoBoxing: num -> new Integer(num)로 변환
		}
		
		System.out.println(set);
		// set: 기본 정렬 안되어있음
		List<Integer> list = new LinkedList<>(set); // 리스트 종류 무관
		Collections.sort(list);
		// sort의 매개변수로 올 수 있는 것이 List interface 뿐이므로, set -> list
		System.out.println(list);
	}
}
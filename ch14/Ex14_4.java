import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Ex14_4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		System.out.println(list);
		list.forEach(i -> System.out.print(i+",")); // Consumer 활용
		System.out.println();
		// 람다식을 사용하지 않을 경우,
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+",");
		}
		System.out.println();
		System.out.println();

		// list에서 2 또는 3의 배수 제거
		list.removeIf(x -> x%2==0 || x%3==0);
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		System.out.println();
		Map<String, String> map = new HashMap<>();
		map.put("1", "2");
		map.put("3", "4");
		map.put("5", "6");
		map.put("7", "8");

		// map의 모든 형식을 {k, v} 형식으로 출력
		map.forEach((k, v) -> System.out.print("{"+k+", "+v+"},"));
		System.out.println();
		// 람다식을 사용하지 않을 경우,
		Iterator<Entry<String, String>> it2 = map.entrySet().iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}	
	}
}
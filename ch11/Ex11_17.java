import java.util.*;

public class Ex11_17 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Apple", Integer.valueOf(95));
		map.put("Apple", Integer.valueOf(100));
		map.put("Banana", Integer.valueOf(40));
		map.put("Car", Integer.valueOf(75));
		map.put("Document", Integer.valueOf(60));
		
		Set set = map.entrySet();
		// Set<Map.Entry<K, V>> entrySet(); -> 차후 Set<K> keySet() 사용 X (형변환X)
		// entrySet(): key, value 참조
		// set.iterator: map에서 쓸 수 없으므로 set으로 형 변환
		Iterator it = set.iterator();
		
		//<Map.Entry<String, Integer>>
		while(it.hasNext()) { // 읽을 요소가 남아있는지 확인
			Map.Entry e = (Map.Entry) it.next(); // 읽은 요소 map type으로 반환
			// Map interface 안에 Entry interface: 
			System.out.println("Name: "+e.getKey()+", Score: "+e.getValue());
		}

		set = map.keySet(); // Set type key값 반환
		System.out.println("NameList: "+set);
		
		Collection<Integer> collection = map.values();
		if(collection instanceof Set) {System.out.println("ScoreList: "+collection);}
		// Collection type value 값 반환 -> (Set) 형변환X
		// 객체를 부모로 만들고 리모컨을 자손으로 설정 할 수 X (실행할 수 없는 method가 있을 수도 있기 때문)
		else {System.out.println("Something is Worng.");}
		
		Collection<Integer> values = map.values(); 
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			Integer i = (Integer) it.next();
			total += i.intValue(); // Integer -> int
			// int i = (int) it.next(); // AutoBoxing
			// total += i;
		}
		
		System.out.println("Total: "+total);
		System.out.println("Average: "+(float)total/set.size());
		System.out.println("Max: "+Collections.max(values));
		System.out.println("Min: "+Collections.min(values));
	}
}

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex11_18 {
	public static void main(String[] args) {
		String[] data = {"A", "B", "A", "D", "C", "B", "A", "B", "A", "D", "D", "C", "D"};
		
		HashMap map = new HashMap();
		
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				// map이 data[0](A)값을 갖고 있다면,
				int value = (int) map.get(data[i]);
				// value에 map에서 data[0]인 value를 반환
				map.put(data[i], value+1);
				// map에 data[0](key) value(value)값에 1을 추가
			} else {map.put(data[i], 1);}
			// map이 data[0]이 없다면 map에 key-data[0] value-1추가
		}
		
		Iterator it = map.entrySet().iterator();
		// Iterator: collection에 저장된 Element들을 읽어오는 방법을 표준화
		// map.entrySet() : Set type
		
		while(it.hasNext()) { // iteration이 읽어올 다음 요소가 있을 경우, true를 반환
			Map.Entry entry = (Map.Entry) it.next(); // iteration의 다음 element를 읽어옴
			int value = (int) entry.getValue(); // map에는 가용 method가 적으므로 map.entry 이용
			System.out.println(entry.getKey()+": "
							+printBar('*', value)+" "+value);
		}
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		// bar에 길이가 value(4)인 char type 배열 생성
		
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		} return new String(bar); // char[] -> String
	}
}
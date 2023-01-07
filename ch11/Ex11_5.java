import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Ex11_5 {
	public static void main(String[] args) {
		Collection<Integer> list = new ArrayList<>();
		// 다형성: list && set implements collection
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	
		// 일회용 -> 재사용 시, 객체 생성 필요
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) { // 확인
			Object obj = it.next(); // 호출 
			System.out.println(obj);
		}
		
		System.out.println();
		it = list.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
			
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			Object obj = ((ArrayList<Integer>) list).get(i);
			// get()은 Collection에 없으므로 형변환 필요: ((ArrayList<Integer>) list)
			System.out.println(obj);
		}
	}
}
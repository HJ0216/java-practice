import java.util.HashSet;
import java.util.Iterator;

public class Ex11_12 {
	public static void main(String[] args) {
		HashSet<Integer> setA	= new HashSet<>();
		HashSet<Integer> setB 	= new HashSet<>();
		HashSet<Integer> setHab = new HashSet<>();
		HashSet<Integer> setKyo = new HashSet<>();
		HashSet<Integer> setCha = new HashSet<>();
		
		setA.add(1);
		setA.add(2);
		setA.add(3);
		setA.add(4);
		setA.add(5);
		System.out.println("setA: "+setA);
		
		setB.add(4);
		setB.add(5);
		setB.add(6);
		setB.add(7);
		setB.add(8);
		System.out.println("SetB: "+setB);
		
		// 합집합
		Iterator<Integer> it = setA.iterator(); // iterator는 일회용이므로 사용시마다 생성
		while(it.hasNext()) { // 읽어올 다음 요소가 있는 동안
			setHab.add(it.next()); // 요소 하나 꺼내오기
		}
		it = setB.iterator(); // iterator는 일회용이므로 사용시마다 생성
		while(it.hasNext()) {
			setHab.add(it.next());
		}
		System.out.println("setHab: "+setHab);

		// setA와 setB를 직접 건드리는 것은 차후 계산에 영향을 미치게되므로 새로운 참조변수 생성하여 진행
//		setA.addAll(setB); // 합집합, setB 모든 요소 추가(중복 제외)
//		System.out.println("Hab: "+setA);

		
		// 교집합
		Iterator<Integer> it2 = setA.iterator(); // iterator는 사용시마다 생성
		it2 = setB.iterator();
		while(it2.hasNext()) { 
			Integer tmp = it2.next(); 
			if(setA.contains(tmp)) {setKyo.add(tmp);}
		}
		System.out.println("setKyo: "+setKyo);

//		setA.retainAll(setB); // 공통된 요소만 남기고 삭제
//		System.out.println("Kyo: "+setA);

				
		// 차집합
		Iterator<Integer> it3 = setA.iterator();
		it3 = setA.iterator();
		while(it3.hasNext()) {
			Integer tmp = it3.next();
			if(!setB.contains(tmp)) {setCha.add(tmp);}
			// 만일 setB가 tmp(setA의 각 요소)를 포함하고 있지 않다면 setCha에 추가
		}		
		
		System.out.println("setCha: "+setCha);
		
//		System.out.println(setA);
//		System.out.println(setB);
//		setA.removeAll(setB); // 차집합, 공통된 요소 모두 제거
//		System.out.println("Cha: "+setA);
	}
}
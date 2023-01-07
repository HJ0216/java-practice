import java.util.*;

public class Ex11_13 {
	public static void main(String[] args) {
		// TreeSet(): 범위 검색 유리, 자동 정렬, 중복X
		Set<Object> treeSet = new TreeSet<>(new TestComp());
		// 정렬기준으 2개일 때는, TreeSet(정렬기준)이 우선 적용됨
		Set<Object> treeSet2 = new TreeSet<>();

		// HashSet: 정렬X
		Set<Object> hashSet3 = new HashSet<>();

		treeSet2.add(1);
		treeSet2.add(2);
		treeSet2.add(3);
		treeSet2.add(3);
		
		// Test class에서는 comparable을 구현하고 있지 않으므로 set.add를 할 경우 오류 발생
		for(int i=0; treeSet.size()<6; i++) {
			int num = (int)(Math.random()*45)+1;
//			treeSet.add(num); // AutoBoxing
			treeSet.add(Integer.valueOf(num));
			treeSet.add(new Test());
			// ClassCastException(형변환 예외): class Test cannot be cast to class java.lang.Integer)
			// set.add()는 이진탐색트리를 통해서 비교하면서 add()를 수행하는데 비교 기준이 없음
			// 비교기준을 만들어 treeSet 정렬기준에 대입: new TreeSet<>(new TestComp())
			hashSet3.add(num);			
		}
		
		treeSet.add(new Test());
		treeSet.add(new Test());
		treeSet.add(new Test());
		
		System.out.println("TreeSet: "+treeSet);
		System.out.println("TreeSet2: "+treeSet2);
		System.out.println("HashSet: "+hashSet3);
	}
}

class Test implements Comparable<Object> {
// Test class와 달리 스스로 비교 기준을 마련할 경우, treeSet 사용가능(예: Integer)
// treeSet 객체 생성 시 따로 비교기준 입력 필요 X: new TreeSet<>()
	@Override
	public int compareTo(Object o) {
		return 1;
	}	
}

class Test2 {}
// 비교 기준을 따로 구현하지 않았는데 Test2를 객체로하여 treeSet을 이용할 경우, Exception 발생

class TestComp implements Comparator<Object> {
// new Test2() 객체를 treeSet으로 구현하기 위한 비교 기준 마련
	@Override
	public int compare(Object o1, Object o2) {
		return -1; // return을 0으로 했을 경우, o1, o2가 같다고 취급됨
	}
}
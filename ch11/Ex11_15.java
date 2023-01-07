import java.util.*;

public class Ex11_15 {
	public static void main(String[] args) {
		// set: 중복 X, 순서 X
		// treeSet: 중복 X, 순서 O (이진탐색트리)
		TreeSet<Integer> set = new TreeSet<>();
		int[] scope = {80, 95, 20, 45, 10, 55, 50, 30, 75, 100, 60};
		
		for(int i=0; i<scope.length; i++) {
			set.add(Integer.valueOf(scope[i]));
			// Integer는 자체적으로 Comparable을 구현하고 있으므로 따로 비교기준을 입력하지 않아도 됨
		}
		
		System.out.println("TreeSet: "+set);
		System.out.println("50보다 작은 값: "+set.headSet(50));
		// headSet: Returns a view of the portion of this set whose elements are strictly less than toElement.
		System.out.println("50보다 큰 값: "+set.tailSet(Integer.valueOf(50)));
		// from 포함, to 미포함
		// 50 -> new Integer(50) 자동 형변환
		System.out.println("From 40 to 80: "+set.subSet(40, 80));
	}
}
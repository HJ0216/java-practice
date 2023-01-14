import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1; // AutoBoxing: int->Integer
		Consumer<Integer> c = i -> System.out.print(i+", "); // 입력값만 존재
		Predicate<Integer> p = i -> i%2==0; // 조건식(i가 짝수인지 판별)
		Function<Integer, Integer> f = i -> i/10*10; // i의 일의 자리 제거
		
		List<Integer> list = new ArrayList<>();

		makeRandomList(s, list); // 난수
		System.out.println(list);
		printEvenNum(p, c, list); // 짝수
		
		List<Integer> newList = doSomething(f, list); // 10의 배수
		System.out.println(newList);
	}
	
	static<T> List<T> doSomething(Function<T, T> f, List<T> list) {
	// 반환타입: List<T>, method: doSomething, 입력값: Function<T, T> f 반환값: List<T> list
	// <T> 입력값 T의 타입
		List<T> newList = new ArrayList<T>(list.size());
		// 길이가 list 길이인 List<T>의 배열 newList 생성
		for(T i : list) { // list의 각 요소를 i에 대입
			newList.add(f.apply(i)); // f = i -> i/10*10; 실행
		}
		return newList;
	}
	
	static<T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
			// Evaluates this predicate on the given argument. - 짝수인지에 대한 boolean 반환
				c.accept(i);
				// Performs this operation on the given argument. - true 일경우 consumer로 처리
				// c = i -> System.out.print(i+", "); // 화면에 i 출력
		}
		System.out.println("]");
	}
	
	static<T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	}
}
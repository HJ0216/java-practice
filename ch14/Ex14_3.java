import java.util.function.Function;
import java.util.function.Predicate;

public class Ex14_3 {
	public static void main(String[] args) {
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // s-> 16진수로 변환
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i); // i-> 2진수로 변환
		
		Function<String, String> h = f.andThen(g); // f->g
		Function<Integer, Integer> h2 = f.compose(g); // g->f
		
		System.out.println(h.apply("FF")); // "FF"->255->"111111"
		// apply: Applies this function to the given argument.
		System.out.println(h2.apply(2)); // 2->"10"->16(16진수에서 10은 16을 의미)
		
		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = i -> i<100;
		Predicate<Integer> q = i -> i<200;
		Predicate<Integer> r = i -> i%2==0;
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));
		
//		String str1 = "abc";
//		String str2 = "abc";
//		
//		Predicate<String> p2 = Predicate.isEqual(str1); // Predicate는 입력값이 1개만 가능
//		boolean result = p2.test(str2);
//		System.out.println(result);

		// new String()시, equal()로 값 비교할 때는 동일하지만, ==로 주소비교할 때는 false
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		boolean result = Predicate.isEqual(str1).test(str2);
//		Predicate<String> p2 = Predicate.isEqual(str1);
//		boolean result = p2.test(str2);
		System.out.println(result);		
	}
}
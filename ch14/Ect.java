import java.util.function.Function;

public class Ect {
	public static void main(String[] args) {
		// 람다식
		Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
		System.out.println(f1.apply("300")+400);
		// method 참조
		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println(f2.apply("100")+200); // "100"->100으로 바뀌어 덧셈 가능
	}
}
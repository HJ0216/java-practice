import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0_4 {
	public static void main(String[] args) {
		// 배열 스트림
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		// asList() : List -> ArrayList
		// 다형성 ArrayList 객체, List 리모컨
		Stream<Integer> intStream = list.stream();
		intStream.forEach(System.out::print); // 최종연산
		
//		intStream.forEach(System.out::print);
		// Error: IllegalStateException
		// Stream 1회용, 최종 연산 후 stream 재 생성 필요(=iterator)
		
		System.out.println();
		intStream = list.stream();
		intStream.forEach(System.out::println);
		System.out.println();

		Stream<String> strStream = Stream.of("St", "re", "am");
		Stream<String> strStream2 = Stream.of(new String[] {"St", "re", "am"});
//		Stream<String> strStream4 = Stream.of({"St", "re", "am"}); - 직접 배열 입력 X
		String[] strArr = new String[] {"St", "re", "am"};
		Stream<String> strStream3 = Stream.of(strArr);
		String[] strArr2 = {"St", "re", "am"};
		Stream<String> strStream4 = Arrays.stream(strArr2);
		
		strStream.forEach(System.out::print);
		System.out.println();
		strStream2.forEach(System.out::print);
		System.out.println();
		strStream3.forEach(System.out::print);
		System.out.println();
		strStream4.forEach(System.out::print);
		
		System.out.println();
		System.out.println();

		// 기본형 스트림
		int[] intArr = {10807, 20807, 30805};
		IntStream intStream2 = Arrays.stream(intArr);
		intStream2.forEach(System.out::print);
		System.out.println();
		IntStream intStream2_2 = Arrays.stream(intArr);
		System.out.println("intStream2_2.count: "+intStream2_2.count());
		IntStream intStream2_3 = Arrays.stream(intArr);
		System.out.println("intStream2_3.sum: "+intStream2_3.sum());
		
		System.out.println();
		Integer[] itgArr = {10807, 20807, 30805}; // Stream<>과 맞추기
		// AutoBoxing: new Integer(10807)
		Stream<Integer> intStream3 = Arrays.stream(itgArr);
		intStream3.forEach(System.out::print);
		System.out.println();
		
		
		Stream<Integer> intStream3_2 = Arrays.stream(itgArr);
		System.out.println("intStream3_2.count: "+intStream3_2.count());
		Stream<Integer> intStream3_3 = Arrays.stream(itgArr);
//		System.out.println("intStream3_3.sum: "+intStream3_3.sum());
		// Error: The method sum() is undefined for the type Stream<Integer>
		// IntStream의 경우, 내장된 메서드가 추가적으로 있음
		
		// 난수 스트림
		System.out.println();
		IntStream intStream4 = new Random().ints(10, 0, 10);
		// (10깨 추출, 0<=x, x<10)
		intStream4.forEach(System.out::println);
		System.out.println();
		// (10깨 추출, 0<=x, x<10)
		IntStream intStream4_2 = new Random().ints(0, 10);
		intStream4_2.limit(10).forEach(System.out::println);
		
		System.out.println();
		// iterate(T seed, UnaryOperator f), 무한 스트림
		Stream<Integer> intStream5 = Stream.iterate(0, n -> n+2);
		intStream5.limit(10).forEach(System.out::println);
		
		System.out.println();
		// generate(Supplier s): 입력X, 출력O, 무한 스트림
		Stream<Integer> intStream6 = Stream.generate(() -> 1);
		intStream6.limit(5).forEach(System.out::println);
	}
}
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_9 {
	public static void main(String[] args) {
		String[] strArr = {
			"bonny", "jaunty", "rejoice", "bliss", "demure",
			"lissome", "kismet", "alluring", "vivacious", "cheery"
		};
		
		Stream.of(strArr).forEach(System.out::print);
		System.out.println();
		// 병렬 처리
		Stream.of(strArr).parallel().forEach(System.out::print);
		System.out.println();
		// 병렬 처리 + 순서
		Stream.of(strArr).parallel().forEachOrdered(System.out::print);
		System.out.println();
		
		System.out.println();
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
		System.out.println("noEmptyStr: "+noEmptyStr);
		boolean noEmptyStr2 = Stream.of(strArr).noneMatch(s->s.length()==6);
		System.out.println("noEmptyStr2: "+noEmptyStr2);

		
		Optional<String> StartWord = Stream.of(strArr).findFirst(); // filter x -> stream의 첫번째 요소 반환
		System.out.println("StartWord: "+StartWord.get());
		
		Optional<String> bStartWord1 = Stream.of(strArr)
				.filter(s -> s.charAt(0)=='b').findFirst();
		System.out.println("bStartWord1: "+bStartWord1.get());
		
		Optional<String> bStartWord2 = Stream.of(strArr).parallel() // 병렬
				.filter(s -> s.charAt(0)=='b').findAny(); // 아무거나 먼저 찾기
		System.out.println("bStartWord2: "+bStartWord2.get());

//		Optional<String> sStartWord = Stream.of(strArr)
//		.filter(s -> s.charAt(0)=='s').findFirst();
//		System.out.println("sStartWord: "+sStartWord.get()); // NoSuchElementException		


		// 최종 연산은 stream을 소모하므로 새로운 객체를 생성해야 함
		
		// Stream<String[]> -> Stream<Integer> (각 요소가 참조형-객체)
		Stream<Integer> itgStream1 = Stream.of(strArr).map(String::length); 
//		Stream<Integer> itgStream2 = Stream.of(strArr).map(s -> s.length()); 
		
		
		// Stream<String[]> -> IntStream (각 요소가 기본형) - 성능이 빠름
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		// {5, 6, 7, 5, 6, 7, 6, 8, 9, 6}
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
//		IntStream intStream5 = Stream.of(strArr).mapToInt(s -> s.length());
		
		
		int count1 = intStream1.reduce(0, (a, b) -> a+1);
		// int reduce(int identity, IntBinaryOperator(accumulator) op);
		// interface IntBinaryOperator {int applyAsInt(int left, int right);}
		// BinaryOperator 이항 연산자는 2개를 대입해서 1개를 리턴하는 연산자(BiFunction 자손)
		int count2 = itgStream1.reduce(0, (a, b) -> a+1); // Unboxing
		// T reduce(T identity, BinaryOperator<T> accumulator);
		// 초기값이 0으로 주어져 있으므로 emptyStream일 경우, null이 아닌 0이 반환
		// return type이 Optional이 아닌 int가 가능한 이유		
		System.out.println("intStream1.count: "+count1);
		System.out.println("itgStream.count: "+count2);
		
		int sum = intStream2.reduce(0, (a, b) -> a+b);
		System.out.println("intStream2.sum: "+sum);
		// reduce(0, (a, b) -> a+b) 작동 원리
		// int a = identity;
		// for(int b : Stream) a = a+b;
		
		OptionalInt max1 = intStream3.reduce(Integer::max);
//		OptionalInt max1 = intStream3.reduce((a, b) -> Integer.max(a, b));
		// int max = intStream.reduce(Integer.MIN_VALUE, (a, b) ->  a>b ? a: b);
		// reduce가 초기값이 주어져 있지 않으므로 emptyStream일 경우, null이 나올 수 있음 -> Optional로 받기
		OptionalInt max2 = IntStream.empty().reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		System.out.println("max: "+max1.getAsInt());
//		System.out.println("max: "+max2.getAsInt()); // NoSuchElementException
		System.out.println("max: "+max2.orElse(0)); // 결과가 없을 때, 0을 반환
		System.out.println("max: "+max2.orElseGet(()->0)); // orElseGet(Supplier-입력값X,출력값O)
		System.out.println("min: "+min.getAsInt());
	}
}
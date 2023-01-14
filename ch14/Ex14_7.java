import java.util.Arrays;
import java.util.stream.Stream;

public class Ex14_7 {
	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc","def","ghi"},
				new String[] {"Apple","Dove","Google"}
				);

		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream); // Array -> Stream
//		Stream<Stream<String>> strStrmStrm = strArrStrm.map((String[]) -> Arrays.stream(String[]));
		strStrmStrm.forEach(System.out::println); // Stream<String> 출력
		System.out.println();
		
		// Stream 재사용 불가
		// Stream<String[]> 사용 시, 지역변수 재사용 Error 발생 (Duplicate local variable strArrStrm)
		strArrStrm = Stream.of(
				new String[] {"abc","def","ghi"},
				new String[] {"Apple","Dove","Google"}
				);

		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		strStrm
			.map(String::toLowerCase) // s-> s.toLowerCase(s)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
			"Believe or not It is true",
			"Do or do not There is no try"
		};
				
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +"))) // 하나 이상의 공백 끊어주기
		// Stream<String> lineStream에 대하여 map 사용 시, of Stream 반환 -> Stream<Stream<String>>
		// Stream<String[]>이 아니고 Stream<String>
		// line = String, line.split() = String[]
		.map(String::toLowerCase)
//		.map(s->s.toLowerCase()) // String s
		.distinct()
		.sorted()
		.forEach(System.out::println);
//		.forEach(s -> System.out.println(s));

	}
}
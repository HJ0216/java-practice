import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

public class Ex14_8 {
	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("water");
		Optional<Integer> optInt = optStr.map(String::length);
//		Optional<Integer> optInt = optStr.map(s -> s.length());
		// Optional<U> map(Function<? super T, ? extends U> mapper) {return Optional.ofNullable(mapper.apply(value));}
		System.out.println("optStr: "+optStr.get());
		System.out.println("optInt: "+optInt.get());
		
		int result1 = Optional.of("12345") // of(T value): 객체가 들어가야하므로 기본형 대입X
							.filter(x->x.length()>0)
							.map(Integer::parseInt).get(); // map<Function>
//							.map(x->Integer.parseInt(x)).get();
		System.out.println("result1: "+result1);
		
		int result2 = Optional.of("")
				.filter(x->x.length()>0) // length=0; -> false -> Optional = Null;
				.map(Integer::parseInt).orElse(-1); // orElse(-1): null일 때, -1 빈환
		System.out.println("result2: "+result2);
		
		Optional.of("456").map(Integer::parseInt)
						.ifPresent(x->System.out.printf("result3: %d%n", x));
						// ifPresent 값이 null이 아니면 수행
		
		OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장
		System.out.println(optInt1.isPresent());
		System.out.println(optInt1.getAsInt()); // optional 객체에서 값 꺼내기(0)
		System.out.println("optInt1: "+optInt1);

		OptionalInt optInt2 = OptionalInt.empty(); // 빈 객체를 생성
		System.out.println(optInt2.isPresent());
		try {System.out.println(optInt2.getAsInt());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("optInt2.getAsInt() is empty.");
		}
		System.out.println("optInt2: "+optInt2);

		System.out.println("optInt1.equals(optInt2): "+optInt1.equals(optInt2));
	}
}
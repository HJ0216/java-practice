import java.util.NoSuchElementException;
import java.util.Optional;

public class Ex14_0_5 {
	public static void main(String[] args) {
		int[] intArr = {};
		int[] intArr2 = new int[0];
		int[] intArr3 = null; // NullPointerException
		
		System.out.println("intArr1.length: "+intArr.length);
		System.out.println("intArr2.length: "+intArr2.length);
		try{System.out.println(intArr3.length);
		} catch(NullPointerException e) {
			System.out.println("intArr3.length: Null");
		}
		
//		Optional<String> strOpt = null; // 가능은 하지만 Null을 직접적으로 다루는 것은 X
		Optional<String> strOpt = Optional.empty();
		System.out.println("strOpt: "+strOpt);
//		System.out.println("strOpt.get: "+strOpt.get()); // NoSuchElementException - 출력할 요소X
		
		String str = ""; // 블럭화 후 surround with try-catch 사용
		
		str = strOpt.orElse("EMPTY");
		// Optional에 저장된 값이 null(empty()): "EMPTY" 출력 !Null: 해당 값 출력
		// orElse(T other): value != null ? value : other;
		
		System.out.println("str: "+str);

		String str2 = "";

		Optional<String> strOpt2 = Optional.of("Thu");
		System.out.println("strOpt2: "+strOpt2);

		try {
			str2 = strOpt2.get();
		} catch (NoSuchElementException e) {
			// NoSuchElementException cannot be resolved to a type: import java.util.NoSuchElementException;
			str = "EMPTY"; // 예외 발생 시, "EMPTY" 빈문자열로 초기화
			e.printStackTrace(); // 예외 출력
		} System.out.println("str2: "+str2);
		
		String str3 = "";
		str3 = strOpt.orElseGet(String::new); // 메서드 참조		
		System.out.println("str3: "+str3);
		
		String str4 = "";
		str4 = strOpt.orElseGet(() -> new String()); // Supplier 람다식
		System.out.println("str4: "+str4);
		
		String str5 = "";
		str5 = strOpt.orElseGet(() -> ""); // Supplier 람다식
		System.out.println("str5: "+str5);
	}
}
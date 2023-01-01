
public class WhyMethod2 {

	public static void main(String[] args) {
		
				// method의 매개변수에 입력된 값, 인자 argument
		worldHello("안녕하세요", "*");
		worldHello("Hello", "!");
		worldHello("Nihao", "@");

	}

								// method에 들어가는 변수, 매개변수 parameter
	public static void worldHello(String text, String delimiter) {
		System.out.println(text+".");
		System.out.println(delimiter);
		System.out.println(text+", "+text);
		System.out.println("--------");
	}

}

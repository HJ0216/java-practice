import java.io.FileWriter;
import java.io.IOException;

public class WhyMethod3 {

	public static void main(String[] args) throws IOException {
		
				// method의 매개변수에 입력된 값, 인자 argument
//		worldHello("안녕하세요", "*");
		System.out.println(worldHello("안녕하세요", "!"));

		FileWriter fw = new FileWriter("out.txt");
		fw.write(worldHello("안녕하세요", "!"));
		fw.close();

	}

								// method에 들어가는 변수, 매개변수 parameter
	public static String worldHello(String text, String delimiter) {
		String out = "";
		out = out + text + "\n";
		out = out + delimiter + "\n";
		out = out + text + delimiter + "\n";
		out = out + "-------";
		return out;
		
		
//		System.out.println(text+".");
//		System.out.println(delimiter);
//		System.out.println(text+", "+text);
//		System.out.println("--------");
	}

}

import java.io.File;
import java.util.stream.Stream;

public class Ex14_6_2 {
	public static void main(String[] args) {
		File[] fileArr = {
				new File("ch01.java"),
				new File("ch02.exe"),
				new File("ch03.txt"),
				new File("ch04.png"),
				new File("ch05.jpg"),
				new File("ch06"),
				new File("ch07"),
				new File("ch08.jpg"),
				new File("ch09.hwp"),
				new File("ch10.doc"),
				new File("ch11.doc"),
				new File("ch12.java"),
				new File("ch13.txt"),
				new File("ch14.xls")
		};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		// Stream<File> -> Stream<String>
		Stream<String> filenameStream = fileStream.map(File::getName);
//		Stream<String> filenameStream = fileStream.map((f) -> f.getName());
		filenameStream.forEach(System.out::println); // 파일 이름 출력

		System.out.println();
		
		fileStream = Stream.of(fileArr); // 스트림 재사용 불가->재생성
		
		// Stream<String> -> Stream<String>
		fileStream.map(File::getName)
			.filter(s -> s.indexOf('.')!=-1) // 확장자가 없는 것은 제외
			.peek(s->System.out.printf("filename: %s%n", s)) // 결과값 과정 중 안내
			.map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
			.peek(s->System.out.printf("extension: %s%n", s))
			.map(String::toUpperCase) // 대문자 변환
			.distinct() // 중복제거
			.forEach(System.out::println);	
	}
}

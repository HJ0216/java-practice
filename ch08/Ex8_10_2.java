import java.io.File;
import java.io.IOException;

public class Ex8_10_2 {
	public static void main(String[] args) throws Exception {
			File f = createFile("abc.txt");
			System.out.println(f.getName()+" 파일이 생성되었습니다.");
	}
	static File createFile(String fileName) // throws Exception - 예외 내부에서 처리하므로 던지기 필요X
	{	
		try {
			if (fileName == null || fileName.equals("")) {
				throw new Exception("파일 이름이 유효하지 않습니다.");
			}
		} catch(Exception e) {
			fileName = "제목없음.txt";
		}
		
			File f = new File(fileName);
			// 생성된 txt가 안나오면 F5키 여러번 누르기
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 예외를 발생시킬 수 있기때문에 다시 try catch 활용
			return f;
		
	}
}
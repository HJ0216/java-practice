import java.io.File;

public class Ex8_10 {
	public static void main(String[] args) throws Exception {
		try {
			File f = createFile("");
			// 2. createFile 내 try catch문이 없으므로 createFile을 호출한 main method로 예외 처리 요청
			System.out.println(f.getName()+" 파일이 생성되었습니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage()+" 다시 입력해 주시기 바랍니다.");
		}
	} static File createFile(String fileName) throws Exception {
		if (fileName == null || fileName.equals("")) {
			throw new Exception("파일 이름이 유효하지 않습니다.");
		} // 1. 유효하지 않은 파일 이름 예외 발생
			File f = new File(fileName);
			f.createNewFile();
			return f;
		
	}
}
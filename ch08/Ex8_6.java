public class Ex8_6 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("Intended Error");
			throw e;
			// 한 문장: throw new Exception("Intended Error")
		} catch (Exception e) { // 객체 Exception, 매개변수 e
			System.out.println("Error Message: "+e.getMessage());
			// e.getMessage = new Exception("여기와 동일하게 출력")
			e.printStackTrace();
		}
		System.out.println("정상 종료");
	}
}
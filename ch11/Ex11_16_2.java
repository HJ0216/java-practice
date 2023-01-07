import java.util.*;

public class Ex11_16_2 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("abc", "1234");
		map.put("bcd", "2345");
		map.put("bcd", "3456");

		Scanner s = new Scanner(System.in);
		// class는 main에 한 번 넣고 close() 해줘야 함
		// 클래스 별로 close()를 넣으면 NosearchElementException 발생
		
		for(int i=0; i<3; i++) {
			Id id = new Id(); // class 객체 생성 후 사용 가능
			id.testid();
			String idt = s.nextLine().trim();
			
			Pw pw = new Pw();
			pw.testpw();
			String pwd = s.nextLine().trim();

			if(!map.containsKey(idt)) {
				System.out.println("There is no Identification.");
				System.out.println();
				continue;
			} else {
				System.out.println("Logined");
				break;
			}
		}
			
			
		for(int i=0; i<3; i++) {
			String idt = s.nextLine().trim();
			Pw pw = new Pw();
			pw.testpw();
			String pwd = s.nextLine().trim();
			
			if(!map.get(idt).equals(pwd)) {
				System.out.println("Incorrect Password.");
				System.out.println();
				continue;
			} else {
				System.out.println("Logined");
				break;
			}

			
		} s.close();
	}
}

class Id {
	Id() {}
	public void testid() {
		System.out.println("Enter the ID.");
		System.out.print("ID: ");
	}
}

class Pw {
	Pw() {}
	public void testpw() {
		System.out.println("Enter the PW.");
		System.out.print("PW: ");
	}
}
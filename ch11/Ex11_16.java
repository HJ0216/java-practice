import java.util.*;

public class Ex11_16 {
	public static void main(String[] args) {
		// HashMap: 순서X, key 중복X
		HashMap<Object, Object> map = new HashMap<>();
		map.put("abc", "1234"); // put: 추가
		map.put("bcd", "2345");
		map.put("bcd", "3456"); // 최종 "bcd", "3456" 저장
		
		System.out.println(map.size());
		
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			System.out.println("Enter the ID and PW.");
			System.out.print("ID: ");
			String id = s.nextLine().trim(); // enter 단위로 입력 받음
			
			System.out.print("PW: ");
			String pw = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("There is no Identification.");
				System.out.println();
				continue;
				// 반복문 + continue = 아래 반복문 내용을 더이상 수행하지 않고 반복문 첫 문장으로 올라감
			}
			
			if(!map.get(id).equals(pw)) { // get(Object o): value값 반환
				System.out.println("Incorrect Password.");
				System.out.println();
			} else {
				System.out.println("Logined");
				break; // 반복문 중단
			}
		} s.close(); // Resource leak: 's' is never closed
	}
}

import java.util.ArrayList;

class Tv{}
class Audio {}

public class GenericTest2 {
	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<Tv>();
		list.add(new Tv());
		
		Tv tv = list.get(0); // list의 1번쨰 요소 꺼냄
		// get(int index)의 최종 반환 타입은 Object
		// Generics 사용 시, 입력 객체가 Tv밖에 필요하지 않으므로 형변환 (Tv) 생략 가능
	}
}

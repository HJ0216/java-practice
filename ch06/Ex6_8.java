
public class Ex6_8 {

	public static void main(String[] args) {
		// 1. main method 호출
		Data3 d = new Data3();
		// 2. Data3의 매개변수 d(Data3와 연락하려면 d를 거쳐야 함)생성 -> Data3 객체(InsVal의 집합-int x) 생성
		d.x = 10;
		// 3. 매개변수 d가 InsVal x(의 주소)를 가르킴 -> d가 가르키는 x의 값에 10을 저장
		
		Data3 d2 = copy(d);
		// 4. Data3의 매개변수 d2(Data3와 연락하려면 d2를 거쳐야 함) 생성 -> Method copy에 매개변수 d(x의 주소)를 복수(대입)
		// -> copy(d=x의 주소)를 매개변수 d2에 복사(대입)
		// 10. copy(d) : 10으로 변경되어 매개변수 d2에 저장
		System.out.println("d.x = "+d.x);
		// 11. d가 가르키는 x 값이 10
		System.out.println("d2.x = "+d2.x);
		// 12. d2가 가르키는 x 값이 10

	}

	static Data3 copy (Data3 d) { // 5. Copy Method 호출 - 참조형 Data로 읽고 쓰기 가능
		Data3 tmp = new Data3();
		// 6. tmp 매개변수 생성 -> Data3 객체 생성(2.의 Data3와는 다른 주소)
		tmp.x = d.x;
		// 7. tmp가 가르키는 x(6. x)에 d가 가르키는 x의 값(3. x)(10) 대입
		return tmp;
		// 8. 매개변수 tmp 리턴, tmp가 갖는 것 6. x(의 주소) - Data3 type의 tmp
		// 9. copy method 호출한 자리로 돌아가기
	} // 12. Main Method 종료
}

class FishShapedBun {
	String taste;
	int number;
	
	public void bake() {
		System.out.println("Baked");
	}
	
	public void order(int i) {
		System.out.println("I'd like to eat "+i+".");
	}
}
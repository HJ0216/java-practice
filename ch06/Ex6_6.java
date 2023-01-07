
public class Ex6_6 {

	public static void main(String[] args) {
		
		Data d = new Data(); // 1. Data형 참조변수 d 생성 -> Data 객체 생성
		// 2. 객체 생성 시, class 내 instance variable 생성
		// 3. 객체 주소가 참조변수 d에 저장-> 참조변수 d가 객체를 가르킴
		d.x = 10; // 4. 참조변수 d가 가르키는 x의 값이 10으로 변경됨
		System.out.println("data(): x = "+d.x);
		
		change(d.x); // 5. change method 호출 -> d가 가르키는 x의 값=10 -> int x에 d.x값이 복사되어 10이 대입 됨
		System.out.println("After change(d.x)"); //8. println 실행
		System.out.println("main(): x = "+d.x); // 9. d.x 계산(()먼저 계산)-> println 실행
				
	}
	static void change (int x) {
		x =1000; // 6. change method에서 지역변수 x에 10이 저장되었다가, 1000으로 변경
				// d.x를 바꾸는 것이 아니라 지역변수 x의 값을 바꾸는 것(int x-기본형이므로 읽기만 가능/변경 원할 시, 참조형 변수 활용)
		System.out.println("change(): x = "+x); // 7. 지역변수 x -> 출력 후 호출한 곳으로 돌아감
	}

} //10. main method 종료 -> stack이 완전히 비어짐

class Data {int x;}

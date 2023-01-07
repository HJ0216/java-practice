
public class Ex6_7 {

	public static void main(String[] args) { // 1. Stack에 main method 호출
		Data2 d = new Data2();
		// 2. Data2의 매개변수 d(Data2와 연락하려면 d를 거쳐야 함)생성 -> Data2 객체(InsVal의 집합-int x) 생성
		d.x = 10;
		// 3. 매개변수 d가 InsVal x(의 주소)를 가르킴 -> d가 가르키는 x의 값에 10을 저장
		System.out.println("main(): x = "+d.x);
		// 4. Method println 호출
		
		change(d);
		// 5. 매개변수 d(x의 주소를 가르키고 있음or x의 주소를 갖고 있음)를 change Method 호출하여 복수(대입)
		System.out.println("After change(d)");
		// 10. stack상 change+println 삭제 후, println 실행
		System.out.println("main(): x = "+d.x);
		// 11. d.x값을 갖고, println 실행
		
	}

	static void change(Data2 d) {
		// 6. change method에 놀러감 -> 변수Type이 Data2, 참조형이므로 읽기, '쓰기' 가능 
		d.x = 1000;
		// 7. change method에 복사(대입)된 d값(x의 주소): d가 가르키는 x의 값을 1000으로 변환
		System.out.println("change(): x = "+d.x);
		// 8. d.x값 갖고 println을 stack 상 main-change위에 쌓고 출력
		// 9. change method 호출이 있던 change(d)로 이동
	} // 11. main method 종료
	
}
class Data2 {int x;}
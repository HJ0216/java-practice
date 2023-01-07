public class Ex7_7 {
	public static void main(String[] args) {
		Car car = new Car(); // Class Car 객체 생성
		FireEngine fe = new FireEngine();
//		Car car = fe; // 자손->조상 형변환(Car) 생략 가능
//		FireEngine fe2 = (FireEngine) car;
		// Error: class Car cannot be cast to class FireEngine
		//		  (Car and FireEngine are in unnamed module of loader 'app')
//		fe2.water();
		// 1. Car 객체 생성(color, door, drive, stop)
		// 2. 매개변수 car 선언 및 Car 주소 저장
		// 3. FireEngine Type의 매개변수 fe에 car 객체 주소 저장
		// 4. FireEngine에는 water IV는 있지만, 객체 생성이 없어서 오류 발생
		// 5. Solution: FireEngine 객체를 생성
		
		
//		Car car = null; // 매개변수 car 선언, 객체 생성X
//		FireEngine fe = null; // 매개변수 fe 선언, 객체 생성X
//		
		FireEngine fe2 = (FireEngine) car; // 조상->자손 생략X
		Car car2 = (Car) fe; // 자손->조상 생략O
//		car2.drive(); // Error: Cannot invoke "Car.drive()" because "car2" is null
//		// 생성된 객체가 없으므로 쓸 수 있는 instance variableX
		
		
//		Car car = null; // 매개변수 car 선언 -> car: 객체 주소 대신 null값 입력, 객체 생성X
//		FireEngine fe = new FireEngine(); // 매개변수 fe 선언 -> instance = FireEngine(5개 IV), 객체 생성
//		FireEngine fe2 = null;  // 매개변수 fe2 선언 -> fe2: 객체 주소 대신 null값 입력, 객체 생성X
//		
//		fe.water();
//		car = fe; // fe->car: 자손->조상 형변환, (car) 생략 가능
//		// fe가 가리키는 FireEngine 주소값 입력
////		car.water(); Error: The method water() is undefined for the type Car
//		fe2 = (FireEngine) car; // car->fe: 조상->자손 형변환, (FireEngine) 생략 불가
//		// car가 가리키는 FireEngine 주소값 입력
//		fe2.water();
		
	}

}

class Car {
	String color;
	int door;
	
	void drive() {System.out.println("Drive, Br~~~");}
	void stop() {System.out.println("Stop, it!");}
}

class FireEngine extends Car {
	void water() {System.out.println("Water, please@");}
}
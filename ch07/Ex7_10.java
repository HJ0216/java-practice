public class Ex7_10 {
	public static void main(String[] args) {
		
//		Unit[] group = {new Marine(), new Tank(), new Dropship()};
//		객체배열: 참조변수의 묶음
		Unit[] group = new Unit[3];
//		Object[] group = new Object[3];
//		으로 변경 시, 리모컨(참조변수) 타입이 object로 변화하면서 move() 사용 시, 단추가 없어 오류

//		다형성: Unit[] -> Unit 대신, new Marine(), new Tank(), new Dropship()
//		group[0] = new Marine();
		Unit uM = new Marine();
		group[0] = uM;
		
//		group[1] = new Tank();
		Tank t = new Tank();
		// 참조변수간 형변환 전 instanceof로 확인 필수
		if(t instanceof Unit) {
			Unit unit = t; // 자손->조상 형변환: 생략 가능
			group[1] = unit;
		} else {System.out.println("Cannot convert from Tank to Unit.");};
		
//		group[2] = new Dropship();
		Dropship ds = new Dropship();
		if(ds instanceof Unit) {
			group[2] = ds; // 자손->조상 형변환: 생략 가능
		} else {System.out.println("Cannot convert from Dropship to Unit.");}
		
		for(int i=0; i<group.length; i++) {
			group[i].move(100, 200);
			// unit type의 Marine, Tank, Dropship 리모컨(참조변수)으로 move 버튼 누르기
			// group[0].move(100, 200): Marine 객체의 move()를 호출
		}
	}
}

abstract class Unit {
	int x, y; // iv
	abstract void move(int x, int y); // lv: 변수 타입이 다르므로 variable type 선언 필요
	void stop() {}
}

class Marine extends Unit {
	void move(int x, int y) {System.out.printf("Marine: [%d, %d]%n", x, y);}
	void stimPack() {}
}

class Tank extends Unit {
	void move(int x, int y) {System.out.printf("Tank: [%d, %d]%n", x, y);}
	void changeMode() {}	
}

class Dropship extends Unit {
	void move(int x, int y) {System.out.printf("Dropship: [%d, %d]%n", x, y);}
	void load() {}		
	void unload() {}		
}
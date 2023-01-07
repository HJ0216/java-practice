abstract class Unit2 {
	int x, y; // interface와 abstract class의 차이: iv 사용이 가능한가
	abstract void move(int x, int y); // int x, y는 지역변수
	void stop () {System.out.println("정지!");}
}

interface Fightable { // interface에서는 public abstract이므로, 생략 가능
	void move(int x, int y); // public abstract가 생략됨
	void attack(Fightable f); // public abstract가 생략됨
}

class Fighter extends Unit2 implements Fightable {
	public void move(int x, int y) {System.out.printf("[%d, %d]로 이동%n", x, y);}
	// Cannot reduce the visibility of the inherited method from Fightable
	// Overriding 규칙: 조상보다 접근제어자의 범위가 좁으면 안됨 -> 생략=default, public 추가
	public void attack(Fightable f) {System.out.println(f+"를 공격");}
	// 매개변수: Fightable type의 f
	
	Fightable getFightable() { // 반환 type Fightable
		// 반환타입이 인터페이스 = 인터페이스를 구현한 객체를 반환
		Fighter f = new Fighter(); // Fighter를 생성해서 반환
//		Fightable f = (Fightable) new Fighter(); 도 가능-(Fightable) 생략 가능
		return (Fightable)f;
		//Fightable getFightabl()의 반환 타입: Fightable과 return type이 같아야 함
	}
}

public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		// Fighter type 매개변수 f 생성, Fighter 객체 생성(move, attack, stop)
		// 다형성: Fighter의 조상=Unit2, Fightable 대체 가능
		Fightable f3 = f.getFightable();
		// f3 앞의 Fightable과 getFightable()의 반환타입 Fightable이 일치해야 함

		Unit2 u = new Fighter();
		u.move(100, 200);
		u.stop();
//		u.attack(new Fighter()); // 단, Unit2의 경우, attack method(버튼)이 없으므로 사용 불가

		Fightable f2 = new Fighter();
		f2.move(100, 200);
//		f2.stop(); // 단, Fightable의 경우, stop method(버튼)이 없으므로 사용 불가
		f2.attack(new Fighter());

		// Fightable f = new Fighter();
		// Fightable f = (Fightable) new Fighter(); 조상일 경우, 맞춰주기 위한 Type 생략 가능
	}

}

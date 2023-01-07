abstract class Player { // abstract method 존재 시 class에 abstract 선언
	abstract void play(int pos); // abstract method: 구현부 {}가 없는 method
	abstract void stop(); // 상속을 통한 몸통 구현을 필요적으로 만들 때, 사용
}

class AudioPlayer extends Player {
	void play(int pos) {System.out.println(pos+"부터 작동됩니다.");}
	void stop() {System.out.println("정지되었습니다.");}
}

abstract class MultiPlayer extends Player {
// abstract class의 method 일부만 구현할 경우, abstract 기재
	void play(int pos) {System.out.println(pos+"부터 작동됩니다.");}
}

public class PlayerTest {
	public static void main(String[] args) {
//		Player p = new Player();
//		Cannot instantiate the type Player: abstract method는 객체 생성 불가
		AudioPlayer ap = new AudioPlayer();
		ap.play(100);
		ap.stop();
		
		// 객체가 완전하면, abstact 참조변수 활용 가능
		Player p = new AudioPlayer();
		p.play(50);
		p.stop();
		
//		Player p2 = new MultiPlayer();
//		Cannot instantiate the type Player: abstract method는 객체 생성 불가

//		MultiPlayer mp = new AudioPlayer();
//		형제간 다형성 성립 X
	}
}
class Tv {
	boolean power;
	int channel;
	
	void power() {power = !power;}
	void channel1up() {++channel;}
	void channel1down() {--channel;}
}

class SmartTv extends Tv {
	boolean caption; // 기본이 false
	void displayCaption(String text) {
		if (caption) { // caption이 on일 때, if 실행
			System.out.println(text);
		}
	}
}


public class Ex7_1 {

	public static void main(String[] args) {
		SmartTv stv = new SmartTv();
		stv.channel = 10;
		stv.channel1up();
		System.out.println(stv.channel);
		stv.displayCaption("Hello, World");
		stv.caption = true;
		stv.displayCaption("Hello, World");

	}

}

package hello;

class Aloha {
	private String s;
	

	public void extracted(String s) {
		if(!s.equals("aloha")) return; // 구역을 설정하여 alt + shift + m : 조건식->method로 변
	}
	
	public String getS() {return s;}
}

public class HelloWorld {	
	static int width = 200; // 클래스 변수
	static int height = 120;
	static {} // 클래스 초기화 블럭 - static 변수의 복잡한 초기화 수행
	static int max(int a, int b) { // 클래스 매서드(static 매서드 - iv, im 사용 불가)
	return a> b ? a : b;
	}	
	public static void main(String[] args) {
		System.out.println(max(1,3));
		
		Aloha a = new Aloha();
		a.extracted("aloha");
		System.out.println(a.getS());
		
		a.extracted("Olla");
		System.out.println(a.getS());
	}
}

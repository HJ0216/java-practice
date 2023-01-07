class MyPoint extends Object {
	int x, y;
	public String toString() {
		// Overriding 할 때, public 부분을 조상 method보다 좁힐 수 없음
		return "x: "+x+", y: "+y;
	}
}


public class OverrideTest {

	public static void main(String[] args) {
		MyPoint p = new MyPoint();
		p.x = 3;
		p.y = 5;
		
//		System.out.println("p.x: "+p.x);
//		System.out.println("p.y: "+p.y);
//		System.out.println(p.toString());
		System.out.println(p); // println은 매개변수-> 매개변수.toString으로 자동 인식
		
	}
}



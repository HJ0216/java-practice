class Point {
	int x, y;
	Point() {} // 생성자가 있으므로 기본 생성자는 수동으로 입력해줘야 함
	Point (int x, int y) { 
		// 모든 생성자는 첫 줄에 다른 생성자(super or this)를 호출해야 함
		// 없을 경우, 자동 super(); 삽입
		this.x = x;   
		this.y = y;
	}
	String getLocation() {
			return "x : "+x+", y : "+y;
	}
}

class Point3D extends Point {
	int z;
	
	Point3D(int i) {
		super();
	}
	
	Point3D(){this(7);} // Point3D(int i) 호출
	
	
	Point3D(int x, int y, int z) {
		// Implicit super constructor Point() is undefined.
		// Must explicitly invoke another constructor
		// 해결방안: class Point에 point(){} 추가 또는 super(x,y)를 추가하여 부모클래스의 매개변수가 있는 생성자 직접 호출
		super(x,y);
		// Point의 기본 생성자: point() 호출
		// -> class Point에 point(){}가 없음
		// -> 자동 추가되지 않는 이유: 이미 this.x = x라는 생성자가 있으므로 기본 생성자 point(){}를 넣어주지 않음
		this.x = x;
		this.y = y;
		this.z = z;
	}
	String getLocation() {
		return "x : "+x+", y : "+y+", z : "+z;
	}
}

public class Ex7_2 {

	public static void main(String[] args) {
		Point3D p3 = new Point3D(1, 2, 3);
		System.out.println(p3);
		System.out.println(p3.getLocation());
	}

}

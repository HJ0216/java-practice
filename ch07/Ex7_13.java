public class Ex7_13 {
	class InstanceInner {}
	static class StaticInner {}
	// * Instance member는 Static member에 접근 가능
	//	 Static member는 Instance member에 접근 불가
	
	InstanceInner iv = new InstanceInner();
	// Instance member끼리는 직접 접근 가능
	static StaticInner cv = new StaticInner();
	// Static member끼리는 직접 접근 가능
//	InstanceInner iv2 = new StaticInner(); // Error: Type mismatch
//	static StaticInner cv2 = new InstanceInner(); // Error: Type mismatch
	
	
	static void staticMethod() {
//		InstanceInner obj1 = new InstanceInner();
		// * 같은 class 내라도 static member는 instance member에 직접 접근 불가
		
		Ex7_13 outer = new Ex7_13();
		InstanceInner obj1 = outer.new InstanceInner();
		// Static Method에서 Instance member에 접근 시, outer class를 먼저 생성
		
		StaticInner obj2 = new StaticInner();
	}
	
	void instanceMethod() {
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		// * Instance Method에서 Instance member와 Static member 모두 접근 가능
//		LocalInner obj3 = new LocalInner();
		// 지역 내부 클래스는 외부에서 접근 할 수 없음
	}
	
	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
	
	public static void main(String[] args) {
			
	}
}
public class Ex7_12 {
	class InstanceInner {
		int iv = 100;
//		static int cv = 100;
		// Error : The field cv cannot be declared static in a non-static inner type,
		//		   unless initialized with a constant expression.
		// Instance class: iv만 선언 가능
		final static int fcv = 100;
		// final static은 상수이므로 허용
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
		// static class: cv, iv 모두 선언 가능		
	}
	
	void myMethod () {
		class LocalInner {
			int iv = 300;
//			static int cv = 300;
			// Error: The field cv cannot be declared static in a non-static inner type,
			//		  unless initialized with a constant expression
			// * static member를 사용하려면 static class만 가능 (단, final static=상수 제외)
			final static int fcv = 300;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(InstanceInner.iv);
//		System.out.println(StaticInner.iv);
		// Error: Cannot make a static reference to the non-static field InstanceInner.iv
		// 		  Static으로 선언된 Main Method에서 Instance Method를 호출하거나 참조할 경우 발생
		// Static Method는 Instance Member에 접근 할 수 X
		System.out.println(InstanceInner.fcv);
		System.out.println(StaticInner.cv);
		// Instance Method는 Static Member에 접근 할 수 O		
		
//		System.out.println(LocalInner.fcv);
		// Error : LocalInner cannot be resolved to a variable
		// Method 내부 LocalInner class의 변수는 method 내에서만 사용 가능
	}
}
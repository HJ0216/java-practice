class Outer {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv;
		// * outer class의 private member도 접근 가능
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
//		int siv = outerIv;
		// Error: Cannot make a static reference to the non-static field outerIv
		// Static class는 outer class의 Instance member에 접근할 수 없음
		int siv2 = outerCv;
	}
	
	void myMethod() {
		int lv = 0; // (변수)
		final int lv2 = 0; // (상수: final 생략 가능, 혼란 방지를 위해 붙이기)
//		lv = 3;
		// Error: Local variable lv defined in an enclosing scope must be final or effectively final
		
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			
			int liv3 = lv;
			int liv4 = lv2;
			// outer class의 local variable은 final이 붙은 상수만 접근 가능
			// final이 생략가능하게 되면서 final이 붙지 않은 변하지 않는 변수에도 접근 가능
			// 단, 변수 lv 값 변화 시 변수화되어 오류 발생
		}
	}
}

public class Ex7_14 {
	public static void main(String[] args) {}
}

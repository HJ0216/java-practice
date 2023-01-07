public class Ex7_15 {
	public static void main(String[] args) {
		Outer2 oc = new Outer2();
		Outer2.InstanceInner ii = oc.new InstanceInner();
		// outer class의 instance를 먼저 생성해야 instance class의 instance를 생성 가능
		// Instance Inner Class도 outer class의 instance member 처럼 생각
		System.out.println("ii.iv: "+ii.iv);

		
		System.out.println("Outer2.StaticInner.cv: "+Outer2.StaticInner.cv);
		// outer class의 instance 생성없이 cv(상수) 접근 가능
		
		Outer2.StaticInner si = new Outer2.StaticInner();
		// Static Inner Class의 Instance는 outer class를 먼저 생성하지 않아도 됨
		// 단, Static Inner Class의 이름 앞에 외부 Class 이름을 붙여줘야 함
		
		System.out.println("si.iv: "+si.iv);
	}
}

class Outer2 {
	class InstanceInner {int iv = 100;}
	static class StaticInner {
		int iv = 200;
		static int cv = 400;
	}
	void myMethod() {
		String str = "AYNIL";
		class LocalInner {
			int iv = 800;
			String s = str;
		}
	}
}


// Compile 시, class 생성
// 1. Ex7_15
// 2. Outer2
// 3. Outer2$InstanceInner
// 4. Outer2$StaticInner
// 5. Outer21LocalInner - LocalInner의 경우, 숫자가 추가적으로 붙음(Method가 여러 개 있을 수 있으므로)
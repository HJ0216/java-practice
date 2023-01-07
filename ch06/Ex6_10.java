
public class Ex6_10 {

	public static void main(String[] args) {
		MyMath3 mm = new MyMath3();
		System.out.println("mm.add(3, 3) result: "+ mm.add(3, 3));
		// class MyMath3.add(int, int)가 존재할 경우, 문제가 되지 않지만,
		// 만일 없을 경우, (long, int)와 (int, long) ambiguous 문제 발생
		System.out.println("mm.add(3, 3L) result: "+ mm.add(3, 3L));
		System.out.println("mm.add(3L, 3) result: "+ mm.add(3L, 3));
		System.out.println("mm.add(3L, 3L) result: "+ mm.add(3L, 3L));
	}

}

class MyMath3 {
	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a + b;
	}
	long add(int a, long b) {
		System.out.print("int add(int a, long b) - ");
		return a + b;		
	}
	long add(long a, int b) {
		System.out.print("int add(long a, int b) - ");
		return a + b;
	}
	long add(long a, long b) {
		System.out.print("int add(long a, long b) - ");
		return a + b;
	}
	
}
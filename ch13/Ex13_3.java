public class Ex13_3 {
	static long startTime = 0;

	public static void main(String[] args) {
		// Multi Thread(Thread 상속과 Runnable 구현을 다르게 객체 생성해줘야 함)		
//		ThreadEx3_1 th1 = new ThreadEx3_1();
//		th1.start();

		Thread th1 = new Thread(new ThreadEx3_1());
		// Runnable 인터페이스 구현시 thread를 상속받지 못했으므로 thread를 이용한 객체 생성 필요
		th1.start();
		
		startTime = System.currentTimeMillis();
		// 같은 class 이므로 class 명칭 필요X
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("O"));
		}
		System.out.println("소요시간2: "+(System.currentTimeMillis()-startTime));
		// main method가 먼저 실행되므로 번호도 1을 붙여주기
	}

}

class ThreadEx3_1 implements Runnable {
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("X"));
		}
		System.out.println("소요시간1: "+(System.currentTimeMillis()-Ex13_3.startTime));
		// 외부 class의 cv 사용: ClassName.cvName
		// 외부 class의 iv 사용: 객체 생성 필요
	}
}
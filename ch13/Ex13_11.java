public class Ex13_11 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx11_1 th1 = new ThreadEx11_1();
		Thread th2 = new Thread(new ThreadEx11_2());
//		Runnable r = new ThreadEx11_2();
//		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();
		
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(2); // main thread가 th1의 작업을 0.002초 기다림
			th2.join(); // main thread가 th2도 끝날 때까지 기다림
		} catch(InterruptedException e) {}
		// join()을 사용하지 않으면 main thread가 먼저 종료됨
		// join() 사용 시, main thread가 종료되어도 작업이 끝나지 않은 thread가 있으면 프로그램은 종료되지 않음
		
		System.out.println("소요시간: "+(System.currentTimeMillis()-startTime));
		// 소스 실행 후 시간-소스 실행 전 시간
	}
}

class ThreadEx11_1 extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(new String("O"));
		}
	}
}

class ThreadEx11_2 implements Runnable {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(new String("X"));
		}
	}
}
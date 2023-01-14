public class Ex13_10 {
	@SuppressWarnings({ "deprecation", "removal" })
	// 1개 "", 2개이상 {}
	// Warnings issued at the point of use of a terminally deprecated API: "removal warnings".
	public static void main(String[] args) {
		RunImpEx10 r = new RunImpEx10();
		Thread th1 = new Thread(r, "*");
		// public Thread(Runnable target, String name)
		// 해당 Thread class를 통해서 thread의 이름을 부여
		Thread th2 = new Thread(r, "@");
		Thread th3 = new Thread(new RunImpEx10(), "&");
		
		System.out.println(th1);
		System.out.println(th2);
		System.out.println(th3);
		
		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(1000);
			// main thread내 thread 재우기 - th1, 2, 3이랑은 무관
			// static method는 본인 thread만 적용 가능
			th1.suspend(); // th1 일시정지
			Thread.sleep(300);
			th2.suspend(); // th2 일시정지
			Thread.sleep(500);
			th1.resume(); // th1 재개
			Thread.sleep(300);
			th1.stop(); // th1 강제 종료
			th2.stop();
			Thread.sleep(100);
			th3.stop();
			
		} catch(InterruptedException e) {}
	}
}

class RunImpEx10 implements Runnable {
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(100);} // 0.1초동안 잠시 중단
			catch(InterruptedException e) {}
		}
	}
}
public class Ex13_10_2 {
	public static void main(String[] args) {
		MyThread th1 = new MyThread("*");
		// public Thread(Runnable target(Thread), String name)
		// public MyThread(String name) 생성자에서 이름만 받음
		MyThread th2 = new MyThread("@");
		MyThread th3 = new MyThread("&");
		
		th1.start(); // run() 자동 호출
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(1000); // main thread 재우기 - th1, 2, 3이랑은 무관
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

class MyThread implements Runnable {
	// volatile: 변수값이 자주 바뀌므로 복사본 쓰지말고 원본 써라
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	// 매개변수가 th인 thread 생성
	Thread th;
	
	// 생성자에서 thread 이름을 받기
	MyThread(String name) {	th = new Thread(this, name);}
	 // Thread(Runnable r, string name)
	
	void start() { // start 선언하면
		th.start(); // Thread 내부 method 호출
	}
	
	void stop() { // stop을 호출하면
		stopped = true;
		th.interrupt(); // interrupt의 상태를 false->true 변경(작업하다 중단)
	}
	
	void suspend() {
		suspended = true;
		th.interrupt();
	}
	
	void resume() {
		suspended = false;
	}
	
	public void run() {
		while(!stopped) { // not stopped
			if(!suspended) { // not suspended
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(100);} // 0.1초동안 잠시 중단
				catch(InterruptedException e) {}				
			} else {Thread.yield();}
			// not stopped + suspended 상황에서 busy waiting 방지
			// th1.suspend(); 이 선언되었을 때,
			// 더이상 while문을 실행하지 않고 다음 thread에게 순서를 넘기고 running 상태로 돌아감
			// 다음 thread: 동일 또는 우선 순위가 높은 스레드
		}
	}
}
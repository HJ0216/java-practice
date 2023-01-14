public class Ex13_7 implements Runnable {
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new Ex13_7());
//		Runnable r = new Ex13_7() : Runnable type의 매개변수 r에 Runnable interface를 구현한 객체 주소를 부여
//		Thread t = new Thread(r) : Thread 객체는 Runnable을 구현한 매개변수 r값이 꼭 들어가야 함
		
		t.setDaemon(true); // start()전 Daemon thread(보조 쓰레드) 선언
		t.start();
		
		for(int i=1; i<=10; i++) {
			try {Thread.sleep(1000);} // 1초마다
			catch(InterruptedException e) {}
			System.out.println(i);
		
			if(i==5) autoSave = true; // i==5부터 autoSave가 true가 됨
		}
		System.out.println("System terminated.");
		// main thread가 종료되면서 daemon thread도 종료됨
	}
	
	// Daemon Thread: Non-Daemon가 하나도 없을 때 자동 종료
	// Daemon으로 지정하지 않으면 무한 루프
	public void run() {
		while(true) { // Thread t는 autoSave가 true일 때, 즉 i==5부터 3초마다 autoSave() 실행
			try {Thread.sleep(3*1000);} // 3초마다
			catch(InterruptedException e) {}
			if(autoSave) {autoSave();} // if(autoSave = true) = if(i==5);
		}
	}
	
	public void autoSave() {
		System.out.println("Save the file:-)");
	}
}
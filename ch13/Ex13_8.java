public class Ex13_8 {
	public static void main(String[] args) { // main thread
		ThreadEx8_1 th1 = new ThreadEx8_1();
		Thread th2 = new Thread(new ThreadEx8_2());
//		Runnable r = new ThreadEx8_2();
//		Thread th2 = new Thread(r);
		
		// thread는 순서가 OS Scheduler에 의해 결정->어떤게 먼저 끝날지 알 수 X
		th1.start();
		th2.start();
		
//		try {Thread.sleep(10);} // main thread 0.01초동안 재우기
		// th1.sleep() Caution: The static method sleep(long) from the type Thread should be accessed in a static way
		// static method인 sleep의 경우, 다른 thread에는 사용하지 못하고 해당 thread에서만 사용 가능
//		catch(InterruptedException e) {}
		
		delay(5);
		System.out.println("<<main thread>> terminated");
	}
	// Thread.sleep(millis) 사용 시, 필수 예외처리인 Exception 자손인 InterruptedException try-catch를 해줘야 함
	// sleep 자주 사용 시, delay method(millis)를 만들어서 delay()로 간결하게 호출
	static void delay(long millis) {
		try {Thread.sleep(millis);}
		catch(InterruptedException e) {}
	}
}

class ThreadEx8_1 extends Thread { // thread1
	public void run() {
		for(int i=0; i<100; i++) {System.out.println("O");}
		System.out.println("<<th1>> terminated");
	}
}

class ThreadEx8_2 implements Runnable {
	public void run() {
		for(int i=0; i<100; i++) {System.out.println("X");}
		System.out.println("<<th2>> terminated");
	}
}
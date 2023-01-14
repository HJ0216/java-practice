
public class Ex13_1 {
	public static void main(String[] args) {
		ThreadEx1_1 th1 = new ThreadEx1_1();
		Thread th2 = new Thread(new ThreadEx1_2());
//		Runnable r = new ThreadEx1_2();
//		Thread th2 = new Thread(r); // 생성자 Thread(Runnable)
		
		System.out.println("th1: "+th1);
		// th1: Thread[Thread-0,5,main]
		// Thread name: Thread-0, Thread Priority: 5, Thread group: Main
		System.out.println("th2: "+th2);
		
		th1.start();
		th2.start();
		
		// Single-thread
//		for(int i=0; i<50; i++) {
//			System.out.println(0);
//		}
//		for(int i=0; i<50; i++) {
//			System.out.println(1);
//		}
	}

}

// Multi-thread
class ThreadEx1_1 extends Thread { // 1. thread를 상속해서 구현
	public void run() { // thread가 수행할 작업 작성
		for(int i=0; i<50; i++) {
			System.out.println(this.getName()); // 조상인 Thread의 method 호출
		}
	}
}

class ThreadEx1_2 implements Runnable { // 2. runnable interface를 구현
	public void run() {
		for(int i=0; i<50; i++) {
			System.out.println(Thread.currentThread().getName());
			// Thread.currentThread(): 실행 중인 thread 반환
		}
	}
}
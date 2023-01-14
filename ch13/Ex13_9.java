import javax.swing.JOptionPane;

public class Ex13_9 {
	public static void main(String[] args) { // main thread
		ThreadEx9_1 th1 = new ThreadEx9_1();
		Thread th2 = new Thread(new ThreadEx9_2());
		
		th1.start();
		th2.start();
		
		String input = JOptionPane.showInputDialog("Please Enter the value.");
		System.out.println("You entered \""+input+"\".");
		// "" 출력 1. \"\" 2. char quotes='""'; 선언
		
		th1.interrupt(); // th1의 interrupt 상태를 false(기본)->true
		System.out.println("th1.isInterrupted: "+th1.isInterrupted()); // thread의 interrupt 상태 반환		
		System.out.println("Thread.currentThread.isInterrupted: "+Thread.currentThread().isInterrupted());
		
		Thread.currentThread().interrupt();
		// main - static / interrupt - non-static
		// static에서 non-static(instance)을 선언하려면 currentThread()을 통해서 객체를 생성
		// Thread class를 상속받지 않아 interrupt()를 사용하려면
		// Thread.currentThread()를 통해 thread 객체를 참조(해당 메서드가 현재 실행중인 thread 객체 반환)
		System.out.println("Thread.current.interrupted: "+Thread.currentThread().isInterrupted());

		Thread.interrupted(); // 현재 thread() 상태 안내 및 false로 초기화
//		th1.interrupted();
		// Caution: The static method interrupted() from the type Thread should be accessed in a static way(객체 생성 후 접근)
		// static method interrupted -> 본인 thread에서만 적용 가능
		// th1.interrupted라고 적었지만 실제로는 실행되고 있는 main_thread.interrupted가 됨
		// 만일 th1을 interrupted 하고 싶다면, 해당 thread가서 선언해야 함
		System.out.println("Thread.interrupted: "+Thread.currentThread().isInterrupted());

	}
}

class ThreadEx9_1 extends Thread { // th1
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) { // i가 0이 아니고, isInterrputed()가 선언되지 않을 경우 실행
			// th1에 대한 interrupt 호출->isInterrupted를 통해 확인
			System.out.println(i--);
			for(long x=0; x<2_500_000_000L; x++) {}; // 카운트 다운이 끝나고 기다리는 시간 부여 목적
		}
		System.out.println("<<1>> Time Over.");
	}
}

class ThreadEx9_2 implements Runnable { // th2
	public void run() {
		int i = 10;
		
		while(i!=0 && !Thread.currentThread().isInterrupted()) {
			// Error: Cannot make a static reference to the non-static method isInterrupted() from the type Thread
			// static method에서는 non-static method를 불러오지 못함
			// Thread.currentThread(): 현재 사용중인 thread() 이름 반환
			// Runnable을 구현 시, Thread.currentThread()를 호출하여 thread()에 대한 참조를 얻어야 함
			System.out.println(i--);
			for(long x=0; x<2_500_000_000L; x++) {};
		}
		System.out.println("<<2>> Time Over.");
	}
}
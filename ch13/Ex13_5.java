import javax.swing.JOptionPane;

public class Ex13_5 {
	public static void main(String[] args) throws Exception {
		Thread th1 = new Thread(new ThreadEx5_1()); // Runnable interface 구현
		th1.start();
		
		String input1 = JOptionPane.showInputDialog("Hey, Bro~ What`s Ur Name~!");
		System.out.println(input1+", Is itright~?");		

		// 현재 Thread: Main, th1, th2
		// Main: println, println, th1: countdown(0.1s), th2: countdown(0.2s)
		// input1이 출력되고나서 th2 start
		ThreadEx5_2 th2 = new ThreadEx5_2(); // Thread class 상속
		th2.start();

		String input2 = JOptionPane.showInputDialog("Hey, Bro~ What`s Ur Num~!");
		System.out.println(input2+", Is itright~?");

	}
}

class ThreadEx5_1 implements Runnable {
	public void run() {
		for(int i=30; i>0; i--) {
			System.out.println("th1");			
			try {Thread.sleep(100);
				// 외부 클래스 method를 불러올 때는 class.method();
			} catch(Exception e) {}
		}
	}
}

class ThreadEx5_2 extends Thread {
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println("th2");
			try {sleep(200);}
			catch (Exception e) {}
		}
	}
}
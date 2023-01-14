import java.util.ArrayList;

class Customer2 implements Runnable {
	private Tray tray;
	private String food;
	
	Customer2(Tray tray, String food) {
		this.tray = tray;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(100);}
			catch(InterruptedException e) {}
			
			String name = Thread.currentThread().getName();
			tray.remove(food);
			System.out.println(name+" picked up the "+food);
		}
	}
}

class Staff implements Runnable {
	private Tray tray;
	
	Staff(Tray tray) {
		this.tray = tray;
	}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*tray.burgerNum());
			// burgerNames.length대신 burgerNum()을 사용하면 코드의 가독성이 좋아짐
			tray.add(tray.burgerNames[idx]);
			try {Thread.sleep(10);}
			catch(InterruptedException e) {}
		}
	}
}

class Tray {
	String[] burgerNames = {"Bulgogi", "Shrimp", "Chicken", "Beef", "Cheeze"};
	final int 햄최몇 = 5;
	private ArrayList<String> burgers = new ArrayList<>();
	
	public synchronized void add(String burger) {
		while(burgers.size()>=햄최몇) {
			String name = Thread.currentThread().getName(); // add를 수행하는 thread의 이름
			System.out.println(name+" is ready to refill the food.");
			try {
				wait(); // staff를 기다리게 함(lock 반납)
				Thread.sleep(500);
			} catch(InterruptedException e) {}
		} // while
		burgers.add(burger);
		notifyAll(); // 기다리는 cusmoter 깨우기 -> 누굴 재우고 깨우는지에 대한 지정의 어려움
		System.out.println("Burgers: "+burgers.toString());
	} // add
	
	public void remove(String burgerName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();
			
			while(burgers.size()==0) {
				System.out.println(name+"is waiting for the food.");
				try {
					wait(); // customer2를 기다리게 함(lock 반납)
					Thread.sleep(500);}
				catch(InterruptedException e) {}
			} // while
			
			while(true) {
				for(int i=0; i<burgers.size(); i++) {
					if(burgerName.equals(burgers.get(i))) {
						burgers.remove(i);
						notifyAll(); // staff 깨우기 -> 버거 채우기
						return;
					} // if
				} // for
				
				try {
					System.out.println(name+" is waiting."); // 버거가 없는 것도 아닌데 기다림
					wait(); // 원하는 음식이 없는 손님이 기다리는 중(lock 우선 반납)
					Thread.sleep(500);
				}
				catch(InterruptedException e) {}
			} // while
		} // Synchronized block
	} // remove
	
	public int burgerNum() {
		return burgerNames.length;
	}
}

public class Ex13_15 {
	public static void main(String[] args) throws Exception {
		Tray tray = new Tray();
		
		new Thread(new Staff(tray), "STAFF").start();
		new Thread(new Customer2(tray, "Bulgogi"), "CUS1").start();
		new Thread(new Customer2(tray, "Beef"), "CUS2").start();
		new Thread(new Customer2(tray, "Shrimp"), "CUS3").start();
		new Thread(new Customer2(tray, "Chicken"), "CUS4").start();
		new Thread(new Customer2(tray, "Cheezs"), "CUS5").start();
		
		Thread.sleep(2000);
		System.exit(0);
	}
}
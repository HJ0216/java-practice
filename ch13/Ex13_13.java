public class Ex13_13 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx12_2();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		// thread 동기화가 안될 경우, balance<0를 확인하는 것이므로 2개 이상 돌리기
	}
}

class Account2 {
	private int balance = 3000; // private로 선언해서 다른 thread가 잔고를 바꾸는 것을 건드리지 못하게 해야 함
	
	// 읽을 때도 동기화를 통해 잘못 읽지 않도록
	public synchronized int getBalance() {
		return balance;
	}
	
	// 동기화를 통해서 withdraw에 한명씩만 접근이 가능하도록 함
	public synchronized void withdraw(int money) {
		if(balance>=money) {
			try {Thread.sleep(100);}
			catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class RunnableEx12_2 implements Runnable {
	Account2 acc2 = new Account2();
	
	public void run() {
		while(acc2.getBalance()>0) {
			int money = (int)(Math.random()*3+1)*100;
			acc2.withdraw(money);
			System.out.println("balance: "+acc2.getBalance());
		}
	}
}
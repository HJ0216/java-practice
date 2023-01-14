public class Ex13_12 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx12();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		// thread 동기화가 안될 경우, balance<0를 확인하는 것이므로 2개 이상 돌리기
	}
}

class Account {
	private int balance = 3000; // private로 선언해서 다른 thread가 잔고를 바꾸는 것을 건드리지 못하게 해야 함
	
	public int getBalance() { // 외부 class에서 Balance에 간접적으로 접근할 수 있게 해주는 get()
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance>=money) {
			try {Thread.sleep(100);}
			catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class RunnableEx12 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance()>0) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println("balance: "+acc.getBalance());
		}
	}
}
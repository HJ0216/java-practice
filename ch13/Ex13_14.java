import java.util.ArrayList;

class Customer implements Runnable {
	private Table table;
	// 요리사: Table 음식 추가, 손님: Table 음식 소비
	// 요리사와 손님이 같은 객체(Table)을 공유하므로 동기화가 필요
	private String food; // 다른 thread가 작업한다고 음식에 손대지 못하게 하기
	
	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(50);} // 손님이 음식 먹으로 오는 주기
			catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			// Thread class를 상속받지 않았으므로 getName()을 사용하기 위해서 Thread class의 객체 생성
			
			if(eatFood()) {
				System.out.println(name+" ate a "+food);
			} else {
				System.out.println(name+" failed to eat:(");
				}
		} // while
	}
	
	boolean eatFood() {
		return table.remove(food);
		// eatFood일 경우, table에서 food remove
	}
}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {
		this.table = table;
	}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum()); // 준비할 수 있는 음식 개수
			table.add(table.dishNames[idx]);
			// table에 String 배열 dishNames 랜덤으로 추가
			try {Thread.sleep(20);} // 음식 추가하는 시간
			catch (InterruptedException e) {}
		}
	}
}

class Table {
	String[] dishNames = {"Appetizer", "MainCourse", "Dessert"};
	final int MAX_FOOD = 5;
	
	private ArrayList<String> dishes = new ArrayList<>(); // table에 추가된 dish 배열
	public synchronized void add(String dish) {
		// Not Syn Error1: ConcurrentModificationException: ArrayList 읽기 수행 중 add(), remove() 등 arrayList 변경 시 발생하는 예외
		// Not Syn Error2: IndexOutOfBoundsException: 손님1이 먹으려던 음식(length=1)을 손님2가 먹음(length=0)
		// 다시 손님1이 먹을 경우 발생
		if(dishes.size()>=MAX_FOOD)
			{return;}
		dishes.add(dish); // ArrayList dishes에 dish(add의 입력값)를 add
		System.out.println("dishes: "+dishes.toString());
	}
	
	// 손님이 table에서 음식이 없다고 lock을 걸어두면, 직원이 food를 추가하지 못함
	// lock을 반납하고 잠깐 대기실로 보내기
	public boolean remove(String dishName) {
		synchronized(this) { // 동기화 블럭 생성
			while(dishes.size()==0) {
				String name = Thread.currentThread().getName();
				// Remove method를 이용하는 Thread name 호출
				System.out.println(name+" is waiting for the food.");
				
				try {Thread.sleep(100);} // 음식 기다리고 있다고 말하는 시간
				catch(InterruptedException e) {}
			}
			
			for(int i=0; i<dishes.size(); i++) { // table에 놓은 음식 개수보다는 적게
				if(dishName.equals(dishes.get(i))) { // remove 대상과 ArrayList dishes의 element가 같다면
					dishes.remove(i); // ArrayList dishes의 element 제거
					return true; // remove() 성공
				}
			}
		} // synchronized
		return false; // remove() 실패
	}
	public int dishNum() {return dishNames.length;}
}

public class Ex13_14 {
	public static void main(String[] args) throws Exception { // InterruptedException 발생 안내
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK").start();
		// Thread 객체 생성, thread는 runnable을 구현한 cook(table) 받고 이름은 "COOK"
		new Thread(new Customer(table, "Appetizer"),"CUS1_1").start();
		new Thread(new Customer(table, "Appetizer"),"CUS1_2").start();
//		new Thread(new Customer(table, "Appetizer"),"CUS1_3").start();
		new Thread(new Customer(table, "MainCourse"),"CUS2").start();
		new Thread(new Customer(table, "Dessert"),"CUS3").start();
		// thread 작동은 start() 필요
		
		Thread.sleep(2000); // main thread가 완전히 끝나기까지 2초 대기
		System.exit(0);
	}
}
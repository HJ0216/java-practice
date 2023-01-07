import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex11_4 {
	static Queue<String> q = new LinkedList<String>();
//	static Queue<String> q = new LinkedList<>();
//	객체가 들어오더라도 데이터 타입이 일정하다면 지정해줄 때 안정적인 프로그래밍 가능
	static final int MAX_SIZE = 5; // Queue에 최대 5개만 저장
	
		public static void main(String[] args) {	
			System.out.println("Enter the 'help'");
			
			while(true) {
				System.out.println(">>");
				try {
					Scanner s = new Scanner(System.in);
					String input = s.nextLine().trim();
					// Scanner.next(): Space bar 단위 입력
					// Scanner.nextLine(): Enter 단위 입력
				
					if("".equals(input)) continue;
					// if continue : 반복문 내용을 수행하지 않고, 다시 반복문 시작으로 이동
					
					else if (input.equalsIgnoreCase("q")) {System.exit(0);}
					
					else if (input.equalsIgnoreCase("help")) {
						System.out.println("help: 도움말 제공");
						System.out.println("q or Q: 프로그램 종료");
						System.out.println("history: 최근 입력한 명령어를 "+MAX_SIZE+"개 보여줍니다.");

					} else if (input.equalsIgnoreCase("history")) {
						LinkedList<String> list = (LinkedList<String>) q;
						// Queue F3->ctrl + o = 사용할 수 있는 method 확인 가능
						// Queue에 method가 별로 없어서 Linkedlist로 형변환해서 사용
					
						final int SIZE = list.size();					
						for(int i=0; i<SIZE; i++)
						// list.size()가 반복될 때마다 list리모컨을 눌러서 객체 내 size를 호출이 되는데,
						// 상수값으로 고정되어있으면 상수로 넣어두기
						{System.out.println((i+1)+"."+list.get(i));}
						// LinkedList.get(): Returns the element at the specified position in this list.

					} else {
						save(input);
						System.out.println(input);
					}
					s.close(); // scanner leakage close
				}
				catch(Exception e) {System.out.println("입력 오류입니다.");}
			}
		}
	
	public static void save(String input) {
		if(!"".equals(input)) {q.offer(input);} // queue에 offer 저장(추가)
		// if(input != null && !input.equals(""))
		// input값이 null이 아니고, ""빈문자열이 아니라면(빈문자열 != null)
		// input = null -> NullpointException
		// equal(null): 자동 처리 가능
		if(q.size()>MAX_SIZE) {q.remove();} // queue에서 제거(=poll)
	}
}
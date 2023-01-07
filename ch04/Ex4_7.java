
public class Ex4_7 {

	public static void main(String[] args) {
		
		for (int i = 0; i<10; i++) {
//			System.out.println(Math.random());
//			System.out.println((int)Math.random()*5);
			// (int)값 ()필요, 아니면 가장 근처 값 먼저 정수화 됨
//			System.out.println((int)(Math.random()*5));
			// random 값 개수만큼 곱하기
			System.out.println((int)(Math.random()*6)+1); //주사위
		}

	}

}


public class Ex4_11_2 {

	public static void main(String[] args) {
		for (int i=0; i<5; i++) { //0. 1, 2, 3, 4
			for (int j=0; j<=i; j++) {
				System.out.print("*");
				//i=0일 때, j=0 * 1개, j 구문 끝
				//i=1일 때, j=0, 1 *2개, j 구문 끝
				//i=2일 때, j=0, 1, 2 *3개, j 구문 끝
			}
			System.out.println();			
		}

	}

}

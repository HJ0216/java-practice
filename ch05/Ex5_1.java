
public class Ex5_1 {

	public static void main(String[] args) {
		
//		int[] score; //배열 score 선언
//		score = new int[5]; //배열 크기 지정
		
		int[] score = new int[6]; //통합
		score[0] = 100;
		score[1] = 101;
		score[2] = 102;
		score[3] = 103;
		score[4] = 104;
		
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		
		int value = score[3];
		System.out.println("Value is "+value+".");
		System.out.printf("Value is %d.\n", value);
		

	}

}

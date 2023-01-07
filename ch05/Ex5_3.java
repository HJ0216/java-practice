import java.util.Arrays;

public class Ex5_3 {

	public static void main(String[] args) {
		int sum = 0;
		float avg = 0.0f;
		
		int[] score = new int[5];
		
		for (int i=0; i<score.length; i++) {
			score[i] = (int)(Math.random()*50)+1;
			sum += score[i];
		}

		avg = sum/(float)score.length;
		
		System.out.println("Score: "+Arrays.toString(score));
		System.out.printf("총점: %03d\n",sum);
		System.out.printf("평균: %06.2f\n", avg);
		//소수점 포함 6자리, 소수점 2째자리까지

	}

}

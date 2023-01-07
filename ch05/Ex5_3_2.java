import java.util.Arrays;

public class Ex5_3_2 {

	public static void main(String[] args) {
		int[] score = new int[5];
		outter: for (int i=0; i<score.length; i++) {
			score[i] = (int)(Math.random()*10)+1;
			inner: for (int k=0; k<i; k++) {
				if (score[i]==score[k]) {
					i--;
// 4번째 배열값이 3번째와 동일할 때,
// i=3 일 때, k=0, 1까지 동일하지 않으므로 돌다가
// k=2일 때, i=3과 동일하다는 걸 알게되어 i-1을 해주고
// i=2가 되고 for2문은 종료되고 i=2로 다시 random이 돌음
				}
			} // inner 종료
		} System.out.println(Arrays.toString(score)); // outter 종료

		int max = score[0];
		int min = score[0];
		
		for (int j=0; j<score.length; j++) {
			if(score[j]>max) {
				max = score[j];
			} else if (score[j]<min) {
				min = score[j];
			}
		} System.out.println("M: "+max);
		  System.out.println("m: "+min);
		  
		  
	}

}

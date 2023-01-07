
public class Ex5_9_2 {

	public static void main(String[] args) {
		
		System.out.println("번호	언어	수리	외국어	총점	평균");
		int[][] score = new int[5][3];

		for (int i=0; i<score.length; i++) {
			int sum = 0; //값의 초기화가 중요하므로 위치 확인 필요
			float avg = 0.0f;

			System.out.printf("%03d\t",i+1);
			for (int j=0; j<score[i].length; j++) { // j = 0, 1, 2
				
				score[i][j] = (int)(Math.random()*100);
				System.out.printf("%03d\t",score[i][j]);
				sum += score[i][j];
				
			} // for:j 
			  avg = sum/(float)score[i].length;
			  System.out.printf("%03d     %06.2f%n",sum,avg);
		} // for:i
	}
}



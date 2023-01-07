
public class Ex5_9 {

	public static void main(String[] args) {

//		int[][] grade = new int[5][3];
//		Random generator = new Random();
//
//		for (int i=0; i<grade.length; i++) {
//			for (int j=0; j<grade[i].length; j++) {
//				grade[i][j] = generator.nextInt(10)+1;
//				System.out.print(grade[i][j]+" ");
//			} System.out.println();
//		}
		int[][] grade = new int[5][3];
//		{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14,15}}
//		Array: 행*열
		int sum = 0;
				
		int i=0, j=0;
		for (i=0; i<grade.length; i++) {
			for(j=0; j<grade[i].length; j++) {
				grade[i][j] = (int)(Math.random()*10);
				System.out.print(grade[i][j]+"\t");
				
				sum += grade[i][j];
			} System.out.println();
		}System.out.println("TOTAL : "+sum);

		
//		int sum = 0;
//		
//		for (i=0; i<grade.length; i++) {
//			for (j=0; j<grade[i].length; j++) {
//				System.out.printf("grade[%d][%d]=%d%n", i, j, grade[i][j]);
//				
//				sum += grade[i][j];
//			}
//		} System.out.println("TOTAL: "+sum);

	}
}

		

		
		
//		System.out.println();
//		int[][] score = {
//						{40, 50, 60},
//						{40, 50, 60},
//						{40, 50, 60},
//						};




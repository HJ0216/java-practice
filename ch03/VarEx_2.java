public class VarEx_2 {

	public static void main(String[] args) {

		int score = 100;
		score = 200;

		System.out.println(score);

//		상수는 값 변환이 안됨
//		final int score2 = 300;
//		score2 = 400;
//		
//		System.out.println(score2);
//		
//		실행은 되지만, 지역변수의 경우 선언과 동시에 초기화 해두기		
		int score3;
		score3 = 300;

		System.out.println(score3);
	}

}
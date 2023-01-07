import java.util.Arrays;

public class Ex5_5 {

	public static void main(String[] args) {
		int[] ball = new int[10];
		
		for (int i=0; i<ball.length; i++) {
			ball[i] = i + 1; //ball[0]=1
		}
		
		int tmp = 0;
		int j = 0;
		
		for(int i=0; i<ball.length; i++) { //i<ball.length만큼 반복
			j = (int)(Math.random()*10); //0~9
			tmp = ball[i]; //ball[0]의 값을 tmp에 대입
			ball[i] = ball[j]; //ball[0]에 랜덤 ball[j]을 대입
			ball[j] = tmp; //랜덤 ball[j]에 ball[0] 대입
			System.out.println(Arrays.toString(ball));
		} for (int i=0; i<3; i++) {
			System.out.printf("ball[%d]=%d%n",i,ball[i]); // 0,1,2값 추출
	} 
		
	}

}

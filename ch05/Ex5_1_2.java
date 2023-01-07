import java.util.Arrays;

public class Ex5_1_2 {

	public static void main(String[] args) {
		
		String[] strArr = {"가위", "바위", "보"};
		System.out.println(Arrays.toString(strArr));
		
		for (int i=0; i<5; i++) {
			
			int n =(int)(Math.random()*strArr.length); //0,1,2
			System.out.println(strArr[n]);
		}

	}

}

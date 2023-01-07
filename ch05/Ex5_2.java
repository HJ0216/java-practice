import java.util.Arrays;

public class Ex5_2 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 0;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 8;
		arr[4] = 16;
		
		System.out.println("arr.length = "+arr.length);
		
//		for(int i = 0; i<5; i++) { //숫자로 작성할 경우, out of bound 유의
		for(int i = 0; i<arr.length; i++) { //length 활용
			System.out.println("arr."+i+" = "+arr[i]);
		} System.out.println(Arrays.toString(arr));

	}

}

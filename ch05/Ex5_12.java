import java.util.Arrays;

public class Ex5_12 {

	public static void main(String[] args) {
		int[] intArr = {3, 4, 1, 2, 0};
		Arrays.sort(intArr); // 오름차순 정렬 [0, 1, 2, 3, 4]
		System.out.println(Arrays.toString(intArr));
		
		int[][] intArr2D = {{10, 20}, {11, 12}};
		System.out.println(Arrays.deepToString(intArr2D)); // n차원 배열은 deep method 활용
		
		String[][] strArr2D = {{"aaa", "bbb"}, {"AAA", "BBB"}};
		String[][] strArr2D2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
		
		System.out.println(Arrays.equals(strArr2D, strArr2D2)); // n차원 배열 비교 시, equal 사용 시 부정확한 결과 도출
		System.out.println(Arrays.deepEquals(strArr2D, strArr2D2));
	}

}

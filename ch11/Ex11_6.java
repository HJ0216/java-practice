import java.util.Arrays;

public class Ex11_6 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4};
		int[][] arr2D = {{11, 22, 33},{91, 92, 93}};
		
		System.out.println("arr.toString(): "+Arrays.toString(arr));
		System.out.println("arr2D.toString(): "+Arrays.toString(arr2D));
		System.out.println("arr2D.deepToString(): "+Arrays.deepToString(arr2D));
		System.out.println();
		
		int[] arr2 = Arrays.copyOf(arr, 3);
		int[] arr3 = Arrays.copyOf(arr, 5);
		int[] arr4 = Arrays.copyOf(arr, 7); // 배열 추가가 많이 된 경우, 0으로 채움
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4); // 2, 3 포함
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
		
		System.out.println("arr2: "+Arrays.toString(arr2));
		System.out.println("arr3: "+Arrays.toString(arr3));
		System.out.println("arr4: "+Arrays.toString(arr4));
		System.out.println("arr5: "+Arrays.toString(arr5));
		System.out.println("arr6: "+Arrays.toString(arr6));
		
		int[] arr7 = new int[5]; // int로 이뤄진 배열 5칸 생성
		Arrays.fill(arr7, 3);
		System.out.println("arr7: "+Arrays.toString(arr7));
		
		int[] arr8 = new int[5];
		Arrays.setAll(arr8, i -> (int)(Math.random()*10)+1);
		System.out.println("arr8: "+Arrays.toString(arr8));
		System.out.println();
		
		for(int i : arr8) {
			char[] graph = new char[i];
			// new char[arr8[0]] = char 배열의 길이가 arr8[0]만큼 생성
			Arrays.fill(graph, '*');
			System.out.println(i+": "+new String(graph));
			// String->char[]: toCharArray()
			// char[]->String: String(char[])
		} System.out.println();

//		for(int x=0; x<arr8.length; x++) {
//			int i = arr8[x];
//			char[] graph = new char[i];
//		System.out.println(i+": "+new String(graph));
//		}
		
		String[][] str2D1 = new String[][] {{"aa", "bb"}, {"AA","BB"}};
		String[][] str2D2 = new String[][] {{"aa", "bb"}, {"AA","BB"}};
		
		System.out.println("Equals: "+Arrays.equals(str2D1, str2D2));
		System.out.println("deepEquals: "+Arrays.deepEquals(str2D1, str2D2));
		System.out.println();
		
		char[] chArr = {'A', 'F', 'D', 'B', 'E', 'C'};
		
		System.out.println("chArr: "+Arrays.toString(chArr));
		System.out.println("index of B: "+Arrays.binarySearch(chArr, 'B'));
		System.out.println("After Sorting...");
		Arrays.sort(chArr);
		System.out.println("chArr: "+Arrays.toString(chArr));
		System.out.println("index of B: "+Arrays.binarySearch(chArr, 'B'));
		// binarySearch 하기 전 반드시 정렬 먼저
	}
}
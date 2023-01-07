import java.util.Arrays; //import 단축키: ctrl + shift = o

public class Ex5_2_2 {

	public static void main(String[] args) {
		
		int[] iArr1 = new int[5];
		int[] iArr2 = new int[5];
		int[] iArr3 = new int[] {5, 10, 15, 20, 25, 30};
		int[] iArr4 = new int[] {100, 95, 90, 85, 80, 75, 70};
		char[] cArr5 = {'a', 'b', 'c', 'd','f'};
		String[] sArr6 = {"K", "O", "R", "E","A"};
		
		for (int i=0; i<iArr1.length; i++) {
			iArr1[i] = (i*3)+1;
		}
		for (int i=0; i<iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10)+1;
		}
		for (int i=0; i<iArr3.length; i++) {
			System.out.printf("Hello Arr3: %d\n", iArr3[i]);
		}
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		
		System.out.println();
		System.out.println(iArr4);
		System.out.println(cArr5); //char은 println에서 자동 처리
		System.out.println(sArr6); //string은 안됨
		
	}

}

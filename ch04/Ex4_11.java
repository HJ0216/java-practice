
public class Ex4_11 {

	public static void main(String[] args) {
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.printf("%d*%d=%02d\n",i,j,i*j);
				//printf %02d-2자리 공백을 0으로 표시, %-2d-2자리 공백을 왼쪽 정렬
				//printf("%표현식",계산할 %수만큼 조건식 작성)
			}
			System.out.println();
		}

	}

}

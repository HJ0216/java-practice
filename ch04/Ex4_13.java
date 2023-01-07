
public class Ex4_13 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		while (sum<=100) {
//			i++;
//			sum = sum + i; //i=13일 때, sum=91이 되어 i=14가 될 때까지 출력
//			System.out.printf("i=%03d sum=%03d\n",i,sum);
			//printf("%d",변수)
			System.out.printf("i=%03d sum=%03d\n",i,sum);
			i++;
			sum = sum + i; //sum += ++i;			
			// while 작성 시, 순서 주의
			// i   = 0 1 2 3 ... 13 14 
			// sum = 0 1 3 6 ... 91 105<-계산은 됐으나, 출력이 안됨
		}

	}

}

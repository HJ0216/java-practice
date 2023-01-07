
public class Ex4_19 {

	public static void main(String[] args) {
		
		Loop1: for(int i=2; i<9; i++) {
				for(int j=1; j<9; j++) {
				if(j==5) {
//					break Loop1;
//					break;
					continue Loop1; //Loop1으로 돌아감
//					continue; //j=5일 때, 출력을 안하고 j=6으로
					
				} System.out.println("i: "+i+", j: "+j);
			} System.out.println();
		}
		
	}

}

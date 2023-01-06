
public class LoopArray {

	public static void main(String[] args) {
		
		String[] DoW = new String[7];
		DoW[0] = "Mon";
		DoW[1] = "Tue";
		DoW[2] = "Wed";
		DoW[3] = "Thu";
		DoW[4] = "Fri";
		DoW[5] = "Sat";
		DoW[6] = "Sun";
		
//		for(int i=0; i<7; i=i+1) {
//			System.out.println(DoW[i]+", ");
//		}
		
		for(int i=0; i<DoW.length; i++) {
			System.out.println(DoW[i]+"!");
		}
		
	}

}

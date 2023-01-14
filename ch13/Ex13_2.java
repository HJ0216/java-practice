public class Ex13_2 {
	public static void main(String[] args) {
		// Single Thread
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("O"));
		}
		System.out.println();
		System.out.println("소요시간1: "+(System.currentTimeMillis()-startTime));

		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("X"));
		}
		System.out.println();
		System.out.println("소요시간2: "+(System.currentTimeMillis()-startTime));

	}
}

public class ArrayApp {

	public static void main(String[] args) {
		
		// Mon Tue Wed Thu Fri Sat Sun
		// String DayoftheWeek = "Mon Tue Wed Thu Fri Sat Sun";
		
		String[] DoW = new String[7];
		DoW[0] = "Mon";
		DoW[1] = "Tue";
		DoW[2] = "Wed";
		DoW[3] = "Thu";
		DoW[4] = "Fri";
		DoW[5] = "Sat";
		DoW[6] = "Sun";
		
		System.out.println("Today is "+DoW[2]+".");
		System.out.println(DoW.length);
		
		int[] FoW = {20, 21, 22, 23, 24, 25, 26};
		System.out.println("Today is "+FoW[3]+"th.");
		System.out.println(DoW.length);
		
		
	}

}


public class VarEx4 {

	public static void main(String[] args) {
		int x = 10, y = 20;
		x = y;
		y = x;
		
		System.out.println(x); //20
		System.out.println(y); //20
		
		int x2 = 30, y2 = 40;
		int tmp;
		
		tmp = x2;
		x2 = y2;
		y2 = tmp;

		System.out.println(x2); //40
		System.out.println(y2); //30

	}

}

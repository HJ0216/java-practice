import java.util.Calendar;

public class Ex10_4 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2022, 12-1, 31); // 0~11월: -1 추가
		
		System.out.println("add");
		System.out.println(toString(date));
		System.out.println("1day later");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));

		System.out.println();
		System.out.println(toString(date));
		System.out.println("6months ago");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		// roll - field 영향X
		System.out.println();
		System.out.println("roll");
		System.out.println(toString(date));
		System.out.println("31days later");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));

		System.out.println();
		System.out.println(toString(date));
		System.out.println("8months ago");
		date.roll(Calendar.MONTH, -8);
		System.out.println(toString(date));	
	}
	
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+". "
			  +(date.get(Calendar.MONTH)+1)+". " // +1월 조정
			  +date.get(Calendar.DATE);
	}
}
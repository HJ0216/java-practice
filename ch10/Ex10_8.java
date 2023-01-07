import java.text.SimpleDateFormat;
import java.util.*;

public class Ex10_8 {
	public static void main(String[] args) {
		Date today = new Date();
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf5, sdf6, sdf7, sdf8, sdf9;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일"); // '22년 12월(=MM월) 05일 월요일
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"); // 01:52:22 오후

		sdf5 = new SimpleDateFormat("오늘이 벌써,, 올해의 D번째 날이군요,,@");
		sdf6 = new SimpleDateFormat("오늘이 벌써,, 이 달의 d번째 날이군요,,@");
		sdf7 = new SimpleDateFormat("오늘이 벌써,, 올해의 w번째 주군요,,@");
		sdf8 = new SimpleDateFormat("오늘이 벌써,, 이 달의 W번째 주군요,,@");
		sdf9 = new SimpleDateFormat("오늘이 벌써,, 이 달의 F번째 E요일이군요,,@");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
	}
}

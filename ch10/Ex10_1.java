import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class Ex10_1 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); // Default: 현재
		System.out.println("연도: "+today.get(Calendar.YEAR));
		int month = today.get(Calendar.MONTH); // 0부터 시작
		System.out.println("월: "+(month+1));
		System.out.println("일: "+today.get(Calendar.DATE));
		
		System.out.println();
		System.out.println("올해의 몇번째 주: "+today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇번째 주: "+today.get(Calendar.WEEK_OF_MONTH));
		
		System.out.println();
		System.out.println("올해의 몇일: "+today.get(Calendar.DAY_OF_YEAR));
		System.out.println("이 달의 몇일: "+today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 달의 몇일: "+today.get(Calendar.DATE));
		
		System.out.println();
		System.out.println("요일: "+today.get(Calendar.DAY_OF_WEEK)); // 0: 일요일
		System.out.println("이 달의 몇째 요일: "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		System.out.println();
		int y = today.get(Calendar.YEAR);
		int m = (today.get(Calendar.MONTH))+1;
		int d = today.get(Calendar.DATE);
		LocalDate date = LocalDate.of(y, m, d);
		System.out.println(date);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());
		
		System.out.println();
		int ampm = today.get(Calendar.AM_PM);
		if (ampm==0) {System.out.println("오전");}
		else {System.out.println("오후");} // 1: 오후
		System.out.println("12시간제: "+today.get(Calendar.HOUR));
		System.out.println("24시간제: "+today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분: "+today.get(Calendar.MINUTE));
		System.out.println("초: "+today.get(Calendar.SECOND));
		System.out.println("1/1000초: "+today.get(Calendar.MILLISECOND));
		
		System.out.println();
		System.out.println("Time Zone(GMT=0 기준): "+today.get(Calendar.ZONE_OFFSET)/3600000);
		// GMT 단위: 1000분의 1 -> '시'로 표시하기 위해, 1시간=60분*60초*1000으로 나눠줌
		System.out.println("이 달의 마지막날: "+today.getActualMaximum(Calendar.DATE));
	}
}

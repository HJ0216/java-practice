import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_9 {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2022년 12월 25일"); // parse: 문자열->날짜
			System.out.println(df2.format(d)); // format: 날짜->문자열
		} catch (Exception e) {}
	}
}
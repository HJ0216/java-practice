import java.util.Calendar; // ctrl + shift + o

public class Ex10_2 {
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		// SUN = 1이므로, 배열[0]값을 "", 공란으로 기재

		Calendar christmas = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		
		christmas.clear();
		// today 제외 Calendar instance 생성 후, clear() 처리 필수
		
		christmas.set(2022, 11, 25);
		// 월은 0부터 시작하므로 11=12월
		// date1.set(2022, Calendar.DECEMBER, 25)
		
		System.out.println("Christmas: "+toString(christmas)+DAY_OF_WEEK[christmas.get(Calendar.DAY_OF_WEEK)]);
		// Error: The method toString() in the type Object is not applicable for the arguments (Calendar)
		// toString(): overriding 필요
		System.out.println("Today: "+toString(today)+DAY_OF_WEEK[today.get(Calendar.DAY_OF_WEEK)]);

		long difference = (christmas.getTimeInMillis() - today.getTimeInMillis())/1000;
		// 두 날짜간의 차이를 구하려면 1000분의 1초 단위로 변환하여 구한 후, 재변환
		// difference가 초단위로 계속 반영되려면 clear() 필요
		System.out.printf("크리스마스까지 %d초 남았습니다.%n", difference);
		System.out.println("크리스마스까지 남은 시간(초): "+difference);
		System.out.println("크리스마스까지 남은 시간(일): "+difference/(24*60*60));
	}
	
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+". "
				+(date.get(Calendar.MONTH)+1)+". " // 12월로 조정
				+date.get(Calendar.DATE)+". ";
	}
}
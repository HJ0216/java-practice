import java.util.Calendar;

public class Ex10_3 {
	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"hr. ", "min. ", "sec"};
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// time1을 10시 20분 30초로 설정
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		// time2을 20시 30분 40초로 설정
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 40);
		
		System.out.println("Time1: "+time1.get(Calendar.HOUR_OF_DAY)
								+". "+time1.get(Calendar.MINUTE)
								+". "+time1.get(Calendar.SECOND));
		System.out.println("Time2: "+time2.get(Calendar.HOUR_OF_DAY)
								+". "+time2.get(Calendar.MINUTE)
								+". "+time2.get(Calendar.SECOND));
		
		long difference = 
				Math.abs(time2.getTimeInMillis()-time1.getTimeInMillis())/1000;
		System.out.println("Difference(sec): "+difference);
		
		String tmp = "";
		for(int i = 0; i<TIME_UNIT.length; i++) {
			tmp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i]; // tmp에 몫+이름 반환
			difference %= TIME_UNIT[i]; // 나머지를 difference에 반환
		}
		System.out.println("Hr. Min. Sec.: "+tmp);
	}
}
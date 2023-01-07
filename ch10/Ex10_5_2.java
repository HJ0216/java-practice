import java.util.Calendar;

public class Ex10_5_2 {
	public static void main(String[] args) {
		if(args.length !=2) {
			System.out.println("Usage: java Ex10_5_2 2022 12");
			return; // 해당 method 빠져나오기
		}
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 마지막일
		
		sDay.set(year, month-1, 1); // 현재 12월 -> sDay.set(2022, 12-1, 1)
		// 월: 0~11월
		eDay.set(year, month, 1); // 현재 12월 -> eDay(2022, 12(실제로는 0 취급), 1)
		eDay.add(Calendar.DATE, -1); // eDay(2022, 11, 31)
		// 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날

		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		// 첫 날의 요일 확인
		
		END_DAY = eDay.get(Calendar.DATE);

		System.out.printf("[%4d, %02d]%n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		
		for(int i=1; i<START_DAY_OF_WEEK; i++) {
			System.out.print("   ");
			// 일요일=1이므로 i=1부터 시작
			// 해당 월의 1일이 어느 요일인지에 따라 공백을 출력
			// 만일 1일이 수요일이라면 공백을 3번(일, 월, 화)
		} for (int i=1, n=START_DAY_OF_WEEK; i<=END_DAY; i++, n++) {
			System.out.print((i<10)? "  "+i : " "+i);
			// 일자를 찍어내는데, 간격 맞추기
			// i<10일 경우, "  "공란 2칸+i
			// :i>=10일 경우, " "공란 1칸+i
			if(n%7==0) System.out.println();
			// n이 7의 배수일 경우, 줄바꿈(일~토)
		}
	}
}
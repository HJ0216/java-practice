
class Time {
	private int hour; // 0~23 사이의 값
	private int minute;
	private int second;
	
	// setHour
	public void setHour(int hour) { // 다른 class에서도 접근이 가능하게
		if(isNotValidHour(hour)) {return;}; // hour 조건이 true일 경우, return
		// alt + shift + m = Method 생성 : 코드의 의미 해석 용이
		// 매개변수 hour의 값이 유효한지 확인하는 메서드
		
		this.hour = hour; // this.hour = iv, hour = lv
		
	}
	private boolean isNotValidHour(int hour) {
		// 코드 변경 시, private로 할 경우 해당 클래스 내만 확인해볼 수 있는 장점
		return hour<0 || hour>24;
	}
	// getHour
	public int getHour() {return hour;}; // 다른 class에서도 접근이 가능하게
}

public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time();
//		t.hour = 20; Error: private 직접 접근 X
		t.setHour(22);
		System.out.println(t.getHour());
		t.setHour(26);
		System.out.println(t.getHour());
		// setHour에 접근 했을 때, if문을 true로 만들어 this.hour = hour를 실행시키지 못하고 method 종료
		// 그러므로 기존에 저장되었던 int hour값 그대로 출력

	}

}

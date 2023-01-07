
public class Ex6_11 {
	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
//		Data_2 d2 = new Data_2();
		// Compile Error: The constructor Data_2() is undefined
		Data_2 d3 = new Data_2(3);
		// 매개변수가 있는 생성자는 만들었으므로 error 발생 X
	}
}

class Data_1 {
	int value;
//	Data_1(){} 생성자가 1개도 없을 때는 compiler가 자동으로 기본 생성자 생성
	}

class Data_2 {
	int value;
	
//	Data_2(){} // Compile Error 해결 - 기본 생성자 작성
	Data_2(int x){ // 매개변수가 있는 생성자
		value = x;
	}
	
}

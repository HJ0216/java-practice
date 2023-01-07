
public class Ex9_1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2)) {
			System.out.println("같다,,");
		} else {
			System.out.println("다르다,,");
		}
	}

}

class Value {
	int value;
	
	Value(int value) { // class와 동일한 이름의 매개변수가 있는 생성자
		this.value = value;
	}
//	기존 object 소속 equal method
//	public boolean equals(Object obj) {
//		return this==obj;
//	}
	
	// Object의 equals()를 overriding해서 주소가 아닌 value를 비교
	public boolean equals(Object obj) {
		if (!(obj instanceof Value)) return false;
		// 참조변수 형변환 전 반드시 instanceof로 형변환 가능여부 확인
		Value v = (Value) obj;
		return this.value==v.value; // v2가 입력받은 값: v.value, v1이 입력받은 값: this.value
	// obj 매개변수는 value(버튼)가 없음->형변환 필요
	}
}
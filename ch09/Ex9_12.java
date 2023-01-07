
public class Ex9_12 {
	public static void main(String[] args) {
		// 생성자를 통해 적절한 크기를 지정
//		public void StringBuffer(int length) {
//			value = new char[length];
//			shared = false;}
//		public StringBuffer(){this(16);}
//		버퍼의 크기를 지정하지 않으면 16이 Default
//		public StringBuffer(String str) {
//			this(str.length() + 16);
//			append(str);}
//		지정한 문자열 길이보다 16이 더 크게 버퍼 생성
		
		StringBuffer sb = new StringBuffer("01");
		// 기본 Buffer가 16, 01이 추가되어 총 18
		// StringBuffer(String str) 참조 
		StringBuffer sb2 = sb.append(23);
		// StringBuufer 자체의 변화
		sb.append('4').append(56);
				
		StringBuffer sb3 = sb.append(78);
		sb.append(9.0);
		
		System.out.println("sb: "+sb);
		System.out.println("sb2: "+sb2);
		System.out.println("sb3: "+sb3);

		System.out.println("sb: "+sb.deleteCharAt(10));
		// sb의 객체 내 수치가 실제로 변화, 삭제된 부분은 뒷 문자로 채움
		System.out.println("sb: "+sb.delete(3,6));
		// 3, 4, 5 삭제
		System.out.println("sb: "+sb.insert(3, "abc"));
		System.out.println("sb: "+sb.replace(6, sb.length(), "END"));
		
		System.out.println("capacity: "+sb.capacity());
		System.out.println("length: "+sb.length());
		
		sb.append("0123456789");
		System.out.println("capacity: "+sb.capacity());
		// capacity가 부족하게 되면, 부족을 만든 원인 append의 문자열 길이의 2배만큼 늘려줌
		
		StringBuffer sb4 = new StringBuffer();
		sb4.append(123456789);
		// '0123456789' Error: The literal 0123456789 of type int is out of range
		// 정수형 리터럴 앞에 0이 붙으면 8진수가 되어 89를 표시할 수 없음
		System.out.println("sb4: "+sb4);
	}
}

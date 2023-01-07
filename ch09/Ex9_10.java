
public class Ex9_10 {

	public static void main(String[] args) {
		int iVal = 100;
		String strVal = String.valueOf(iVal); // int -> string 변환
		
		double dVal = 200.0;
		String strVal2 = dVal+""; // double -> string 변환
		
		double sum = Integer.parseInt("+"+strVal) + Double.parseDouble(strVal2); // string -> int 변환
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2); // string -> int 변환
		
		System.out.println(String.join("", strVal, "+", strVal2, "=")+sum);
		// 구분자 빈 문자열"" - 객체의 변경 -> 속도 유지
		System.out.println(strVal+"+"+strVal2+"="+sum2);
		// 객체를 새로 생성 -> 속도 저하
	}

}

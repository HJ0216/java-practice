import java.util.EmptyStackException;
import java.util.Stack;

public class Ex11_3 {
	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("Usage: java Ex11_3 \"EXPRESION\"");
			// \"EXPRESION\" \\->""의 앞에 쓰여서 문자로 인식하게 도와줌
			System.out.println("Example: java Ex11_3 \"((2+3)*4)+5\"");
			System.exit(0);
			// JVM 강제종료(0: 정상 종료), return-메소드 강제종료, break-반복문 강제종료
		}
		
		Stack st = new Stack();
		String expression = args[0];
		System.out.println("expression: "+expression);
		
		try {
			for (int i=0; i<expression.length(); i++) {
				char ch = expression.charAt(i);
				// charAt(): 특정 위치의 문자 반환
				if(ch=='(') {st.push(ch+"");} // stack-push: 저장, ch+"": 문자화
				else if (ch==')') {st.pop();} // stack-pop: 제거
			}
			if(st.isEmpty()) {System.out.println("괄호가 일치합니다.");}
			else {System.out.println("닫는 괄호가 부족합니다.");}
		} catch(EmptyStackException e) {System.out.println(
				"여는 괄호가 부족합니다.");}		
	}
}
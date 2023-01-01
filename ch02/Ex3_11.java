
public class Ex3_11 {

	public static void main(String[] args) {
		double d = 3.141592;
		
		System.out.println(d);
		System.out.println(d*1000);
		System.out.println(Math.round(d*1000));
		System.out.println(Math.round(d*1000)/1000); //3
		System.out.println(Math.round(d*1000)/1000.0); //3.142
		System.out.println((double)Math.round(d*1000)/1000); //3.142

		System.out.println("\n"+d*1000);
		System.out.println((int)(d*1000));
		System.out.println((int)d*1000); //int d가 먼저 일어나서 3*1000이 됨
		System.out.println((int)(d*1000)/1000.0);
		System.out.println((int)(d*1000)/1000);//int/int->int
		
		System.out.println("\n"+10/8); //int/int->int(몫)
		System.out.println(10/-8);
		System.out.println(10%8); //%-나머지 값
		System.out.println(10%-8); //%-나머지 값 찾을 떄 부호 무시
		
		
		String str1 = "abc";
		String str2 = "abc";

		System.out.println(str1 == str2); //true
		System.out.println(str1.equals(str2)); //true

		String str3 = new String("abc");
		String str4 = new String("abc");

		System.out.println(str3 == str4); //false
		System.out.println(str3.equals(str4)); //true

	}

}

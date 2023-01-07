import java.util.*;

public class Ex11_14 {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		
		String from = "b";
		String to	= "d";
		String to2  = "e";
		
		set.add("abc");
		set.add("apple");
		set.add("bcd");
		set.add("banana");
		set.add("cde");
		set.add("Car"); // 대문자가 가장 먼저 정렬
		set.add("car");
		set.add("document");
		set.add("drop");
		set.add("department");
		set.add("element");
		set.add("eating");
		set.add("frequence");
		set.add("flower");
		set.add("generic");
		set.add("grow");
		
		System.out.println("set: "+set);
		System.out.println("range search: "+set.subSet(from, to));
		// 대문자 미포함, to 미포함
		System.out.println("range search2: "+set.subSet(from, to2));		
		System.out.println("range search2: "+set.subSet(from, to+"zzz"));
		// to+"zzz"="dzzz"		
	}
}

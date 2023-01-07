import java.util.HashSet;
import java.util.Objects;

public class Ex11_11 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add("abc"); // true
		set.add("abc"); // false
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		// 중복이 허용되지 않는 Set에서는 abc는 1번만 저장되지만 Person class는 2번 저장됨
		// equal과 hashcode overriding이 필요
		
		System.out.println(set);

	}

}

class Person {
	String name;
	int age;
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
		// Objects.hash(가변인자): 
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {return false;}
		Person p = (Person) obj; // Object class 내에서는 name, age member가 없음
		return this.name.equals(p.name) && this.age==p.age;
	}
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name+": "+age;
	}
}
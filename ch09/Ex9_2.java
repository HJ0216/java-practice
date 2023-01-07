public class Ex9_2 {

	public static void main(String[] args) {
		Person p1 = new Person(20221202L); // long type 변수는 끝에 L 표시-> 생략 시, integer 취급
		Person p2 = new Person(20221202L);
		
		if(p1.equals(p2))
		{System.out.println("같당,,");}
		else
		{System.out.println("다르당,,");}
	}
	
}

class Person {
	long id;
	Person(long id){this.id=id;}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		Person p = (Person) obj;		
		return this.id == p.id;
	}
}
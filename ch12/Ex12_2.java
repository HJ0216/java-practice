import java.util.ArrayList;
import java.util.Iterator;

public class Ex12_2 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("Hello", 1, 1));
		list.add(new Student("Java", 2, 1));
		list.add(new Student("World", 3, 1));
		
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) { // 읽을 다음 인자가 있다면 true
			Student s = it.next(); // <-형변환을 위해 만든 코드
			// <> 미지정 시, 형변환 필요 Student s = (Student) it.next
			System.out.println(s.name);
			// 합치면 System.out.println(it.next().name);
		}		
	}
}

class Student {
	String name = "";
	int classNo;
	int studentNo;
	
	Student(String name, int classNo, int studentNo) {
		this.name = name;
		this.classNo = classNo;
		this.studentNo = studentNo;
	}
}
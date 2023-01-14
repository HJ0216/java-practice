import java.util.HashMap;

public class Ex12_2_2 {
	public static void main(String[] args) {
		HashMap<String, Student2> map = new HashMap<>();
		// HashMap<K, V>, new HashMap<> 생성자 타입 입력 생략시, 선언부와 동일하게 적용
		map.put("Hello", new Student2("kim", 1, 1, 78, 53, 86));
		map.put("Java", new Student2("gong", 2, 1, 87, 97, 72));
		map.put("World", new Student2("bu", 3, 1, 98, 62, 49));
		
		// HashMap class의 get method는 Object type의 변수를 갖음
		// <>를 통해서 Object->Student2 변수 type 고정->형변환 필요X
		Student2 s = (Student2) map.get("Hello");
		System.out.println(s.name); // "kim"
		System.out.println(map.get("Java").korScore); // 87, 위 2문장을 한문장으로 바꿈
	}
}

class Student2 {
	String name = "";
	int classNo;
	int studentNo;
	int korScore;
	int engScore;
	int mathScore;
	
	Student2(String name, int classNo, int studentNo, int korScore, int engScore, int mathScore) {
		this.name = name;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
}
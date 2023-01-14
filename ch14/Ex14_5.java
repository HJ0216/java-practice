import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {
	public static void main(String[] args) {
		Stream<Produce_101> produce_101Stream = Stream.of(
			new Produce_101("PickMe", 1, 200),
			new Produce_101("김세정", 2, 500),
			new Produce_101("PickMeUp", 1, 100),
			new Produce_101("정채연", 1, 300),
			new Produce_101("주걸경", 3, 400),
			new Produce_101("전소미", 1, 600),
			new Produce_101("기희현", 3, 100),
			new Produce_101("정은우", 2, 200)
				);
		
		produce_101Stream.sorted(Comparator.comparing(Produce_101::getGrade)
//		produce_101Stream.sorted(Comparator.comparing((Produce_101 p) -> p.getGrade())
		.thenComparing(Comparator.naturalOrder())) // thenComparing 비교 기준 리턴
		.forEach(System.out::println);
	}
}

class Produce_101 implements Comparable<Produce_101> {
	// The type Produce_101 must implement the inherited abstract method Comparable<Produce_101>.compareTo(Produce_101)
	String name;
	int grade;
	int totalVotes;
	
	Produce_101(String name, int grade, int totalVotes) {
		this.name = name;
		this.grade = grade;
		this.totalVotes = totalVotes;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, grade, totalVotes);
	}
	
	String getName() {return name;}
	int getGrade() {return grade;}
	int getTotalVotes() {return totalVotes;}
	
	// Comparable을 구현한다는 것은 기본 정렬을 int CompareTo를 통해 제공한다는 의미
	// 그러므로 naturalOrder()가 구현된 compareTo 기준이 됨, 총점 내림 차순
	public int compareTo(Produce_101 p) {
		return p.totalVotes - this.totalVotes;
	} // compareTo에서 왼쪽이 작으면 음수, 같으면 0, 오른쪽이 작으면 양수 반환
	  // 1차 정렬된 기준으로 1반끼리, 2반끼리 element 비교
}
package pkg1;

public class MyParent {
	private   int pri; // 같은 class
			  int def; // 같은 pkg
	protected int pro; // (default) 같은 pkg + 다른 pkg 내 자손 class
	public	  int pub; // 제한 X
	
	public void printMembers() {
		System.out.println(pri); // O
		System.out.println(def); // O
		System.out.println(pro); // O
		System.out.println(pub); // O
	}
}

class MyParentTest {

	public static void main(String[] args) {
		MyParent p = new MyParent();
//		System.out.println(p.pri); Error
		System.out.println(p.def); // O
		System.out.println(p.pro); // O
		System.out.println(p.pub); // O

	}

}

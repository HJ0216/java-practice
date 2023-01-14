class Parent {void parentMethod(){}}

class Child extends Parent {
	@Deprecated
	void parentMethod() {}
}


public class Ex12_7 {
	public static void main(String[] args) {
		Child c = new Child();
		c.parentMethod();

	}
}
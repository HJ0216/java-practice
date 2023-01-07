package pkg2;

import pkg1.MyParent;

class MyChild extends MyParent {
	// MyParent type = default : 다른 pkg에서 접근X
	// -> class를 public으로 변경
	// -> 1개의 source file에 public class는 1개
	// -> 기존 public class -> class로 변경
	// public class name과 java file명이 동일해야 하므로 refactor->nename 변경(Update references 해제하고 finish)
	// ctrl + shift + O = class import or pkg1.MyParent로 pkg name 추가
	public void printMembers() {
//		System.out.println(pri);
//		System.out.println(def);
		System.out.println(pro); // O
		System.out.println(pub); // O
	}
}

public class MyParentTest2 {

	public static void main(String[] args) {
		MyParent p = new MyParent();
//		System.out.println(p.pri); Error
//		System.out.println(p.def); Error
//		System.out.println(p.pro); Error
		System.out.println(p.pub); // O

	}

}

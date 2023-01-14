import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 Annotation은 무시됨
@TestInfo(testDate=@DateTime(yyMMdd="20221225", hhmmss="123456"), testedBy="aaa", testTools={"JUnit", "JUnit5"})
// 입력 순서 상관없음
// default 값이 있을 경우, 기재하지 않아도 되지만 default값이 아닌 다른 값을 부여하고 싶다면, 적어주기
// 배열값 입력: 0개: {}, 1개: {"1개"} 또는 "1개", 2개이상: {"1개", "2개"}

public class Ex12_8 {
	public static void main(String[] args) {
//	 getAnnotation을 사용하기위한 객체 생성식
	Class<Ex12_8> cls = Ex12_8.class;
	// Class<T> class가 getAnnotation()를 소유하고 있음
	// class Ex12_8에는 getAnnotation()가 없어서 사용 불가
	// 일반 객체 생성하듯 Class<EX12_8>(): The constructor Class<Ex12_8>() is undefined
	// 일반 변수 선언하듯이 참조변수 type이 Class<T(Ex12_8)>타입
	// Class type이 와야하므로 Ex12_8.class를 리터럴로 대입
//	Ex12_8 cls = new Ex12_8();
	// The method getAnnotation(Class<TestInfo>) is undefined for the type Ex12_8
	
	TestInfo anno = cls.getAnnotation(TestInfo.class);
	// cls.getAnnotation(TestInfo.class): cls의 TestInfo Annotation info를 anno에 저장
	// Annotation을 하나의 class로 취급
	// getAnnotation의 return type: (A) annotationData().annotations.get(annotationClass);
	// (A): A extends Annotation, getAnnotation안의 annotation class 강제 형변환
	System.out.println("anno testedBy()="+anno.testedBy());
	// Annotation의 Annotation 불러오기
	System.out.println("anno testDate().yyMMdd()="+anno.testDate().yyMMdd());
	System.out.println("anno testDate().hhmmss()="+anno.testDate().hhmmss());

	for(String str : anno.testTools())
		{System.out.println("testTools: "+str);}
	System.out.println();
		
	Annotation[] annoArr = cls.getAnnotations();
	// Ex12_8 class 객체의 모든 Annotation 불러오기
	for(Annotation a : annoArr)
		{System.out.println(a);}
	// Ex12_8 class의 모든 Annotation을 배열로 받아 a에 저장하여 하나씩 출력
	// 유효하지 않은 Annotation 출력되지 않음
	}
}

@Retention(RetentionPolicy.RUNTIME) // 실행시에도 사용 가능하도록 지정
@interface TestInfo { // Annotation 선언
	int 	 count() 	 default 1;
	// 상수는 default로 선언 가능
//	default void tototo() {};
	// Invalid type void for the annotation attribute TestInfo.tototo;
	// only primitive type, String, Class, annotation, 
	// enumeration are permitted or 1-dimensional arrays thereof
	// default method는 선언 불가
	String 	 testedBy();
	// Annotation-추상 매서드 선언
	String[] testTools() default "JUnit";
	// 배열 0개: {}, 배열 1개: {"1개"} 또는 "1개", 배열 2개이상: {"1개", "2개"}
	TestType testType()  default TestType.FIRST;
	DateTime testDate();
}


enum TestType {FIRST, FINAL}
// Annotation 적용 선언 가능

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
	String yyMMdd();
	String hhmmss();
}
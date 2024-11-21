package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		// 같은 클래스 내부 static 변수 -> 클래스 이름 생략 가능 
		// StaticMethod.m = 20;
		m = 20;
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		// StaticMethod.s1();
		s1();
	}
	
	static void s1() {
		// 오류 : static 메서에서는 instance  접근 불가 
		// n = 10;
	}
	
	static void s2() {
		// 오류 : static method에서는 instance 메서드 호출 불가
		// f1();
	}
	
	static void s3() {
		// StaticMethod.m = 20;
		m = 10;
	}
	
	static void s4() {
		// StaticMethod.s1();
		s1();
	}

}

package chapter03;

public class StudentTest01 {
	public static void main(String[] args) {
		// 자식 생성자에서 부모 생성자 명시적 호출이 생략이 된 것, Person -> Student
		// super();
		new Student();
	}
}

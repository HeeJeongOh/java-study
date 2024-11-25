package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {

		// p1과 p2는 같은내용을 가짐
		// p1과 p3는 같은 레퍼런스(주소 별칭)를 가짐
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p1;

		// == : 레퍼런스 비교
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);

		// equals : 내용 비교 (단, 부모 클래스의 기본 구현은 동일성(==)과 같음)
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));

	}

}

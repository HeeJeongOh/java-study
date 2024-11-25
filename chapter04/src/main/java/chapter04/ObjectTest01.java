package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();

		// reflection
		Class klass = point.getClass();
		// println :: 자동으로 레퍼런스변수.toString()
		System.out.println(klass);

		// hash : 다양한 값들을 integer로 변환하는 것 => 성능
		// hashCode : address기반의 해싱값
		// 10진수
		System.out.println(point.hashCode());

		// getClass() + @ + hashCode
		// 16진수
		System.out.println(point.toString());
		System.out.println(point);
	}

}

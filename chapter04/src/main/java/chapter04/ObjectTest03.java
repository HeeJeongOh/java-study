package chapter04;

public class ObjectTest03 {
	public static void main(String[] args) {

		String s1 = new String("hello");
		String s2 = new String("hello");

		System.out.println("== : " + (s1 == s2)); // false
		System.out.println("equals : " + s1.equals(s2)); // true
		System.out.println("hashCode : " + (s1.hashCode() == s2.hashCode())); // true

		// new를 사용하면 바로 heap 영역 추가됨
		System.out.println("heap addresss : " + (System.identityHashCode(s1) == System.identityHashCode(s2))); // false

		System.out.println("=======================");

		String s3 = "hello";
		String s4 = "hello";

		// 해싱 과정에서 동일한 리터럴 값이 이미 존재하면, 새로 생성하지 않고 기존 리터럴을 재사용
		System.out.println("== : " + (s3 == s4)); // false
		System.out.println("equals : " + s3.equals(s4)); // true
		System.out.println("hashCode : " + (s3.hashCode() == s4.hashCode())); // true
		System.out.println("heap addresss : " + (System.identityHashCode(s3) == System.identityHashCode(s4))); // true

	}
}

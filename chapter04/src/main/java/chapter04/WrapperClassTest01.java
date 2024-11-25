package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {

		// 직접 생성 시, heap 상에 객체 존재
		// 리터럴로 생성 시, JVM 안의 Constant Pool에서 관리
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);

		Integer j1 = 10;
		Integer j2 = 20;

		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));

	}
}

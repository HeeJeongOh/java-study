package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {

		// string -> int
		String s1 = "12345";
		int i = Integer.parseInt(s1);

		// int -> string
		String s2 = String.valueOf(i);
		String s3 = "" + i;

		System.out.println(s1 + " : " + s2 + " : " + s3);

		System.out.println("=================");

		// char -> 아스키코드
		char c = 'A';
		System.out.println((int) c);

		// char -> 16진수.
		int a = Character.getNumericValue('A');
		System.out.println(a);

		// int -> 2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);

		// int -> 16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	}

}

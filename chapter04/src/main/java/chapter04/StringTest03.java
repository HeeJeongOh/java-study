package chapter04;

import java.util.Arrays;

public class StringTest03 {

	public static void main(String[] args) {
//		 String s1 = "Hello" + "World" + "Java" + 21;

//		String s1 = new StringBuilder("Hello ").append("World ").append("Java ").append(21).toString();
//		System.out.println(s1);

		String s1 = new StringBuffer("Hello ").append("World ").append("Java ").append(21).toString();
		System.out.println(s1);

//		String s2 = "";
//		for (int i = 0; i < 1000000; i++) {
//			// new(메모리 할당)을 100만번 수행해서 느려지는 것.
//			// s2 = s2 + "h";
//			s2 = new StringBuffer(s2).append("h").toString();
//		}

		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			// 메소드 호출은 별 거 아님.
			sb.append("h");
		}
		String s3 = sb.toString();
		System.out.println("==================");

		////// String method
		String s4 = "abcABCabcAbc";
		System.out.println(s4);
		System.out.println("길이: " + s4.length());
		System.out.println("2번째 문자 : " + s4.charAt(2));
		System.out.println("'abc' 위치 : " + s4.indexOf("abc"));
		System.out.println("'abc' 위치 : " + s4.indexOf("abc", 7));
		System.out.println("s4[:3] : " + s4.substring(3));
		System.out.println("s4[3:5] : " + s4.substring(3, 5));

		System.out.println("==================");

		String s5 = "        ab         cd  ";
		System.out.println("-" + s5.trim() + "-");
		System.out.println(s5.replaceAll(" ", ""));

		System.out.println("==================");

		String s6 = "abc/def/ghi";
		String s7 = s5.concat(s6);

		System.out.println(s7);

		String[] tokens = s6.split("/");
		System.out.println(Arrays.toString(tokens));

		String[] tokens2 = s6.split(" ");
		System.out.println(Arrays.toString(tokens2));

	}

}

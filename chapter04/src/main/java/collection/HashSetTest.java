package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();

		String str = new String("마이콜");

		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");

		s.add(str);

		System.out.println(s);

		System.out.println("=============");

		System.out.println("크기 : " + s.size());
		// hashCode, equals : 값으로 비교되기 때문에 둘 다 true로 반
		System.out.println("\"마이콜\" 있어? " + s.contains("마이콜"));
		System.out.println("String(\"마이콜\") 있어? " + s.contains(str));

		System.out.println("=============");

		for (String str2 : s) {
			System.out.println(str2);
		}

	}

}

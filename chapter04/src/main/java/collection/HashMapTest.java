package collection;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();

		m.put("one", 1); // auto boxing - m.put(new String("one"), new Integer(1))
		m.put("two", 2);
		m.put("three", 3);

		int i = m.get("one"); // auto unboxing
		int j = m.get(new String("one"));

		System.out.println(i + " : " + j);

		// 순회
		Set<String> kSet = m.keySet();
		for (String key : kSet) {
			System.out.println(key + ": " + m.get(key));
		}

		// 이미 존재하는 키 값 삽입 시, 덮어 쓰여진다.
		m.put("three", 3333);
		System.out.println(m.get("three"));

	}

}

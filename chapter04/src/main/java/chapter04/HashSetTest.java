package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>();

		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		Rect r3 = new Rect(4, 50);

		set.add(r1);
		set.add(r2);
		set.add(r3);

		// @Override한 equals에 의해, r2는 동일한 값으로 취급받아 add가 수행되지 않음
		// hashCode를 내용에 의한 해싱값으로 오버라이드하지 않으면 다른 값으로 취급 받음

		for (Rect r : set) {
			System.out.println(r);
		}

	}

}

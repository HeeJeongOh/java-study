package collection;

import java.util.*;

public class VectorTest02 {

	public static void main(String[] args) {
		// Vector, List - - > Vector
		List<String> list = new Vector<>();

		list.add("둘리");
		list.add("마이콜");
		list.add("또치");

		// 순회1
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}

		// 삭제 - 오버로드
		list.remove(2);

		System.out.println("=======");

		// 순회2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

		// 순회3
		for (String s : list) {
			System.out.println(s);
		}

	}

}
package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// Vector로 구현되어 있음
		Stack<String> stk = new Stack<>();

		stk.push("둘리");
		stk.push("마이콜");
		stk.push("또치");

		while (!stk.isEmpty()) {
			String str = stk.pop();
			System.out.println(str);
		}

		stk.pop();

	}

}

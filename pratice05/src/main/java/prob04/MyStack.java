package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public int getTop() {
		return top;
	}

	public String[] getBuffer() {
		return buffer;
	}

	public MyStack(int capacity) {
		/* 구현하기 */
		this.top = 0;
		this.buffer = new String[capacity];
	}

	public void push(String s) {
		/* 구현하기 */
		if (top >= buffer.length) {
			resize();
		}
		buffer[top++] = s;
	}

	public String pop() throws MyStackException {
		/* 구현하기 */
		if (top == 0) {
			throw new MyStackException();
		}

		return buffer[--top];

	}

	public boolean isEmpty() {
		/* 구현하기 */
		if (top == 0) {
			return true;
		}
		return false;
	}

	private void resize() {
		/* 구현하기 */
		String[] tmp = buffer;
		buffer = new String[buffer.length + 1];

		for (int i = 0; i < tmp.length; i++) {
			buffer[i] = tmp[i];
		}
	}
}
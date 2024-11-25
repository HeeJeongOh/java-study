package prob01;

public class Printer {

//	public void println(int i) {
//		System.out.println(i);
//	}
//
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//
//	public void println(double d) {
//		System.out.println(d);
//	}
//
//	public void println(String string) {
//		System.out.println(string);
//	}

	// 제네릭 메소드
	public <T> void println(T type) {
		System.out.println(type);
	}

	// 가변 파라미터
	public int sum(Integer... nums) {
		int s = 0;
		for (Integer n : nums) {
			s += n;
		}
		return s;
	}

	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
}

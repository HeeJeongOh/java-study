package creational.singleton;

public class Singleton {
	private static Singleton instance = null;

	// 외부 생성 불가
	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}

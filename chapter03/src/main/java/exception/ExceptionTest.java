package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// aritmatic exeption
		// int a = 9;	// 정상 
		int a = 10;		// 오류 
		int b = 10 - a;

		System.out.println("some code 1");

		try {
			System.out.println("some code 2");
			System.out.println("some code 3");

			int result = (1 + 2 + 3) / b;

			System.out.println("some code 4");
			System.out.println("some code 5");
		}
		// (필수) 예외 처리 영역
		catch (ArithmeticException e) {
			// 1. 로깅
			System.out.println("ERROR : " + e);
			// 2. 사과
			System.out.println("미안합니다...");
			// 3. 정상 종료
			// system.exit(0);
			return;
		}
		// (옵션)
		finally {
			// 자원 정리 
			System.out.println("청소 중... file.. socket .. db...");
		}

		System.out.println("some code 6");
		System.out.println("some code 7");
	}

}

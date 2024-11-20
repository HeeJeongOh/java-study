package prob02;

import java.util.Scanner;

public class Sol02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;
		
		System.out.println("5개의 숫자를 입력하세요.");

		/* 코드 작성 */
		for(int i = 0; i < 5; i++) {
			int n = scanner.nextInt();
			intArray[i] = n;
			sum += intArray[i];
		}
		
		System.out.format("평균은 %.1f 입니다.", (sum/5));
		
		scanner.close();
	}
}

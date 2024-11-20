package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		/* 코드 작성 */
		System.out.print("금액: ");
		int input = scanner.nextInt();
		
		for(int m : MONEYS) {
			System.out.format("%d원 : %d개\n", m, (input / m));
			input = input % m;
		}
		
		scanner.close();
	}
}
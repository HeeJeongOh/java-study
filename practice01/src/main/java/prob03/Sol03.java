package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
//		while(true) {
		System.out.print("수를 입력 하세요: ");
		int n = scanner.nextInt();
		int sum = n;
		int i = 1;
		if(n % 2 == 0) {
			i = 2;
		}
		for(i = 1; i < n; i += 2) {
			sum += i;
		}
		System.out.println("결과값: " + sum);
//		}
		
		scanner.close();
	}
}

package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("수를 결정였습니다. 맞추어보세요:");

		// 정답 램덤하게 만들기
		Random random = new Random();
		int correctNumber = random.nextInt(100) + 1;
		// System.out.println(correctNumber);
		
		int i = 1;
		int min = 1, max = 100;
		
		while(true) {
			System.out.format("%d-%d\n", min, max);

			/* 게임 작성 */
			System.out.format("%d >> ", i++);
			int n = scanner.nextInt();
			
			if(n > correctNumber) {
				System.out.println("더 낮게");
				max = n;				
			}
			else if(n < correctNumber) {
				System.out.println("더 높게");
				min = n;
			}
			else if(n == correctNumber) {
				//새 게임 여부 확인하기
				System.out.println("맞췄습니다.");
				System.out.print("다시 하겠습니까(y/n) >> ");
				
				String answer = scanner.next();
				if("y".equals(answer) == false) {
					break;
				}
			}
		}
		
		scanner.close();
	}
}
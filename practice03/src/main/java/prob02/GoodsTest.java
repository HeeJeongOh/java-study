package prob02;

import java.util.Scanner;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			goods[i] = new Goods(sc.next(), sc.nextInt(), sc.nextInt());
		}

		// 상품 출력
		for(Goods g : goods) {
			g.printInfo();
		}
		
		sc.close();
	}
}
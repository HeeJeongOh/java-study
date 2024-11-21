package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		// 기본 생성
		Goods2 goods2 = new Goods2();

		goods2.name = "camera";	// public
//		goods2.price = 10000; 	// protected -> 같은 패키지, 자식 접
//		goods2.countStock = 10;	// default -> 같은 패키
		
//		goods2.countSold = 20;	// private -> 같은 클래


		System.out.println(
				"상품 이름: " + goods2.name
//				+ ", 가격: " + goods2.price
//				+ ", 판매량: " + goods2.countSold
//				+ ", 재고량: " + goods2.countStock
				);


	}

}

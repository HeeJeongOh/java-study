package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// 기본 생성
		Goods goods = new Goods();

		goods.name = "nikon";
		goods.price = 400000;
		goods.countSold = 10;
		goods.countStock = 20;

		System.out.println(
				"상품 이름: " + goods.name 
				+ ", 가격: " + goods.price 
				+ ", 판매량: " + goods.countSold 
				+ ", 재고량: " + goods.countStock);

	}

}
